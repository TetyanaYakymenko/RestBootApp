package com.epam.producing.testProject.web;

import com.epam.producing.testProject.exception.AddressNotFoundException;
import com.epam.producing.testProject.exception.CustomerNotFoundException;
import com.epam.producing.testProject.model.Address;
import com.epam.producing.testProject.model.Customer;
import com.epam.producing.testProject.repository.AddressRepository;
import com.epam.producing.testProject.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AddressRepository addressRepository ;

    public void setCustomerRepository(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public  void setAddressRepository(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerByID(@PathVariable Long id){
        return customerRepository.findById(id)
                .orElseThrow(()-> new CustomerNotFoundException(id));
    }

    @GetMapping("/customers/{customerId}/addresses")
    public List<Address> getAddressesOfCustomer(@PathVariable Long customerId){
        return customerRepository.findById(customerId)
                .orElseThrow(()-> new CustomerNotFoundException(customerId)).getAddressList();

    }
    @GetMapping("/customers/{customerId}/addresses/{addressId}")
    public Address getAddressesOfCustomer(@PathVariable Long customerId,@PathVariable Long addressId){
        return customerRepository.findById(customerId)
                .orElseThrow(()-> new CustomerNotFoundException(customerId))
                .getAddressList()
                .stream()
                .filter(address -> address.getId().equals(addressId))
                .findFirst().get();

    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> newCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerRepository.save(customer), HttpStatus.OK);
    }

    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@RequestBody Customer newCustomer, @PathVariable Long id){
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setName(newCustomer.getName());
                    customer.setSurname(newCustomer.getSurname());
                    customer.setLogin(newCustomer.getLogin());
                    customer.setPassword(newCustomer.getPassword());
                    customer.setAddressList(newCustomer.getAddressList());
                    return customer;
                }).orElseGet(()->{
                    newCustomer.setId(id);
                    return customerRepository.save(newCustomer);
                });
    }

    @DeleteMapping("/customers/{id}")
    public void DeleteCustomerById(@PathVariable Long id){
        customerRepository.deleteById(id);
    }

}
