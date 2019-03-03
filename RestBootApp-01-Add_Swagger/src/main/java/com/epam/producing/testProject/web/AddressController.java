package com.epam.producing.testProject.web;

import com.epam.producing.testProject.exception.AddressNotFoundException;
import com.epam.producing.testProject.model.Address;
import com.epam.producing.testProject.repository.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressRepository repository;

    @GetMapping("/addresses")
    public List<Address> getAll() {
        return repository.findAll();
    }

    @GetMapping("/addresses/{id}")
    public Address getOneAddress(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new AddressNotFoundException(id));
    }

    @PostMapping
    public ResponseEntity<Address> newAddress(@RequestBody Address newAddress) {
        return new ResponseEntity<>(repository.save(newAddress), HttpStatus.OK);
    }

    @PutMapping("/addresses/{id}")
    public Address updateAddress(@RequestBody Address address, @PathVariable Long id) {
        return repository.findById(id)
                .map(address1 -> {
                    address1.setCountry(address.getCountry());
                    address1.setRegion(address.getRegion());
                    address1.setStreet(address.getStreet());
                    address1.setApartment(address.getApartment());
                    return repository.save(address1);
                }).orElseGet(() -> {
                    address.setId(id);
                    return repository.save(address);
                });
    }

    @DeleteMapping("/address/{id}")
    public void deleteAddressById(@PathVariable Long id) {
        repository.deleteById(id);
    }

    public void setRepository(AddressRepository repository) {
        this.repository = repository;
    }

}
