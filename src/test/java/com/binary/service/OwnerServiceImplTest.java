package com.binary.service;

import com.binary.entity.Owner;
import com.binary.repository.OwnerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class OwnerServiceImplTest {

    @InjectMocks
    private OwnerServiceImpl ownerService;

    @Mock
    private OwnerRepository ownerRepository;

    @Test
    @DisplayName("Get all owners success")
    public void testGetAllOwners() {
        List<Owner> expectedOwners = new ArrayList<>();
        Owner owner = new Owner();
        owner.setOwnerId(1L);
        owner.setFirstName("John");
        owner.setLastName("Doe");
        expectedOwners.add(owner);

        Mockito.when(ownerRepository.findAll()).thenReturn(expectedOwners);

        List<Owner> actualOwners = ownerService.getAllOwners();

        Assertions.assertEquals(expectedOwners.size(), actualOwners.size());
        Assertions.assertEquals(expectedOwners.get(0).getFirstName(), actualOwners.get(0).getFirstName());
    }

    @Test
    @DisplayName("Create owner success")
    public void testCreateOwner() {
        Owner owner = new Owner();
        owner.setOwnerId(1L);
        owner.setFirstName("John");
        owner.setLastName("Doe");

        Mockito.when(ownerRepository.save(owner)).thenReturn(owner);

        Owner createdOwner = ownerService.createOwner(owner);
        Assertions.assertNotNull(createdOwner);
        Assertions.assertEquals(owner.getFirstName(), createdOwner.getFirstName());
        Assertions.assertEquals(owner.getLastName(), createdOwner.getLastName());
    }

    @Test
    @DisplayName("Update owner success")
    public void testUpdateOwner() {
        Owner existingOwner = new Owner();
        existingOwner.setOwnerId(1L);
        existingOwner.setFirstName("John");
        existingOwner.setLastName("Doe");

        Owner updatedOwner = new Owner();
        updatedOwner.setFirstName("Jane");
        updatedOwner.setLastName("Smith");

        Mockito.when(ownerRepository.findById(1L)).thenReturn(Optional.of(existingOwner));
        Mockito.when(ownerRepository.save(existingOwner)).thenReturn(existingOwner);

        Owner result = ownerService.updateOwner(1L, updatedOwner);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("Jane", result.getFirstName());
        Assertions.assertEquals("Smith", result.getLastName());
    }

    @Test
    @DisplayName("Delete owner success")
    public void testDeleteOwner() {
        Owner owner = new Owner();
        owner.setOwnerId(1L);
        owner.setFirstName("John");
        owner.setLastName("Doe");

        Mockito.when(ownerRepository.findById(1L)).thenReturn(Optional.of(owner));
        Mockito.doNothing().when(ownerRepository).deleteById(1L);

        long deletedOwnerId = ownerService.deleteOwner(1L);

        Assertions.assertEquals(1L, deletedOwnerId);
    }

    @Test
    @DisplayName("Get owner by ID success")
    public void testGetOwnerById() {
        Owner owner = new Owner();
        owner.setOwnerId(1L);
        owner.setFirstName("John");
        owner.setLastName("Doe");

        Mockito.when(ownerRepository.findById(1L)).thenReturn(Optional.of(owner));

        Owner foundOwner = ownerService.getOwnerById(1L);

        Assertions.assertNotNull(foundOwner);
        Assertions.assertEquals(owner.getFirstName(), foundOwner.getFirstName());
    }
}
