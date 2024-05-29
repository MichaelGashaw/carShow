package com.binary.service;

import com.binary.dto.OwnerDto;
import com.binary.entity.Owner;
import com.binary.exceptions.OwnerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OwnerService {
    List<Owner> getAllOwners();
    Owner createOwner(OwnerDto ownerDto);
    Owner updateOwner(long id, OwnerDto ownerDto) throws OwnerNotFoundException;
    void deleteOwner(long id) throws OwnerNotFoundException;
    Owner getOwnerById(long id) throws OwnerNotFoundException;
}
