//package com.binary.controllers;
//
//import com.binary.controller.OwnerController;
//import com.binary.entity.Owner;
//import com.binary.service.OwnerService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@ExtendWith(MockitoExtension.class)
//public class OwnerControllerTest {
//
//    @InjectMocks
//    private OwnerController ownerController;
//
//    @Mock
//    private OwnerService ownerService;
//
//    @Test
//    @DisplayName("owner controller get all success")
//    public void ownerController_getAllOwners_success() {
//        List<Owner> expectedOwners = new ArrayList<>();
//        Owner owner = new Owner();
//        owner.setOwnerId(1L);
//        owner.setFirstName("John");
//        owner.setLastName("Doe");
//        expectedOwners.add(owner);
//
//        Mockito.when(ownerService.getAllOwners()).thenReturn(expectedOwners);
//
//        ResponseEntity<List<Owner>> result = ownerController.ownerList();
//
//        Assertions.assertEquals(1, result.getBody().size());
//        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
//    }
//
//    @Test
//    @DisplayName("owner controller get by ID success case")
//    public void ownerController_getOwnerById_success() {
//        Owner owner = new Owner();
//        owner.setOwnerId(2L);
//        owner.setFirstName("Jane");
//        owner.setLastName("Doe");
//        long expectedId = 2L;
//
//        Mockito.when(ownerService.getOwnerById(expectedId)).thenReturn(owner);
//
//        ResponseEntity<Owner> result = ownerController.getOwnerById(expectedId);
//
//        Assertions.assertEquals(expectedId, result.getBody().getOwnerId());
//        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
//    }
//
//    @Test
//    @DisplayName("owner controller create owner success case")
//    public void ownerController_createOwner_success() {
//        Owner ownerBeforeCreated = new Owner();
//        ownerBeforeCreated.setFirstName("Alice");
//        ownerBeforeCreated.setLastName("Smith");
//
//        Owner ownerCreated = new Owner();
//        ownerCreated.setOwnerId(3L);
//        ownerCreated.setFirstName("Alice");
//        ownerCreated.setLastName("Smith");
//
//        Mockito.when(ownerService.createOwner(ownerBeforeCreated)).thenReturn(ownerCreated);
//
//        ResponseEntity<Owner> result = ownerController.createOwner(ownerBeforeCreated);
//
//        Assertions.assertEquals(ownerCreated.getFirstName(), result.getBody().getFirstName());
//        Assertions.assertEquals(ownerCreated.getLastName(), result.getBody().getLastName());
//        Assertions.assertNotNull(result.getBody().getOwnerId());
//        Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());
//    }
//
//    @Test
//    @DisplayName("owner controller update owner success test case")
//    public void ownerController_updateOwner_success() {
//        Owner ownerBeforeUpdated = new Owner();
//        ownerBeforeUpdated.setFirstName("Bob");
//        ownerBeforeUpdated.setLastName("Marley");
//
//        long ownerIdThatNeedsToBeUpdated = 45L;
//
//        Owner ownerUpdated = new Owner();
//        ownerUpdated.setOwnerId(45L);
//        ownerUpdated.setFirstName("Robert");
//        ownerUpdated.setLastName("Marley");
//
//        Mockito.when(ownerService.updateOwner(Mockito.eq(ownerIdThatNeedsToBeUpdated), Mockito.any(Owner.class))).thenReturn(ownerUpdated);
//
//        ResponseEntity<Owner> result = ownerController.updateOwner(ownerIdThatNeedsToBeUpdated, ownerBeforeUpdated);
//
//        Assertions.assertEquals(ownerUpdated.getFirstName(), result.getBody().getFirstName());
//        Assertions.assertEquals(ownerUpdated.getLastName(), result.getBody().getLastName());
//        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
//    }
//
//    @Test
//    @DisplayName("owner controller delete owner success test case")
//    public void ownerController_deleteOwner_success() {
//        long ownerIdThatNeedsToBeDeleted = 45L;
//
//        Mockito.when(ownerService.deleteOwner(ownerIdThatNeedsToBeDeleted)).thenReturn(ownerIdThatNeedsToBeDeleted);
//
//        ResponseEntity<Long> result = ownerController.deleteOwner(ownerIdThatNeedsToBeDeleted);
//
//        Assertions.assertEquals(ownerIdThatNeedsToBeDeleted, result.getBody());
//        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
//    }
//}
