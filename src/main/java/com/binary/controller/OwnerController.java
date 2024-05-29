package com.binary.controller;

import com.binary.dto.OwnerDto;
import com.binary.entity.Owner;
import com.binary.exceptions.OwnerNotFoundException;
import com.binary.service.OwnerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/list")
    public ResponseEntity<List<Owner>> ownerList() {
        return new ResponseEntity<>(ownerService.getAllOwners(), HttpStatus.OK);
    }

    @PostMapping("/createOwner")
    public ResponseEntity<Owner> createOwner(@RequestBody @Valid OwnerDto ownerDto) {
        Owner createdOwner = ownerService.createOwner(ownerDto);
        return new ResponseEntity<>(createdOwner, HttpStatus.CREATED);
    }

    @PutMapping("/updateOwner/{id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable long id, @RequestBody @Valid OwnerDto ownerDto) throws OwnerNotFoundException {
        return new ResponseEntity<>(ownerService.updateOwner(id, ownerDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteOwner(@PathVariable long id) throws OwnerNotFoundException {
        ownerService.deleteOwner(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable long id) throws OwnerNotFoundException {
        return new ResponseEntity<>(ownerService.getOwnerById(id), HttpStatus.OK);
    }
}
