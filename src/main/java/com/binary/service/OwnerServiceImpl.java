package com.binary.service;

import com.binary.dto.OwnerDto;
import com.binary.entity.Owner;
import com.binary.exceptions.OwnerNotFoundException;
import com.binary.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public List<Owner> getAllOwners() {
        return (List<Owner>) ownerRepository.findAll();
    }

    @Override
    public Owner createOwner(OwnerDto ownerDto) {
        if (ownerDto == null) {
            throw new IllegalArgumentException("OwnerDto cannot be null");
        }

        Owner owner = new Owner();
        owner.setFirstName(ownerDto.getFirstName());
        owner.setLastName(ownerDto.getLastName());

        return ownerRepository.save(owner);
    }

    @Override
    public Owner updateOwner(long id, OwnerDto ownerDto) throws OwnerNotFoundException {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new OwnerNotFoundException("Owner not found with id: " + id));

        if (ownerDto.getFirstName() != null) {
            owner.setFirstName(ownerDto.getFirstName());
        }
        if (ownerDto.getLastName() != null) {
            owner.setLastName(ownerDto.getLastName());
        }

        return ownerRepository.save(owner);
    }

    @Override
    public void deleteOwner(long id) throws OwnerNotFoundException {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new OwnerNotFoundException("Owner not found with id: " + id));
        ownerRepository.delete(owner);
    }

    @Override
    public Owner getOwnerById(long id) throws OwnerNotFoundException {
        return ownerRepository.findById(id)
                .orElseThrow(() -> new OwnerNotFoundException("Owner not found with id: " + id));
    }
}
