package com.epam.producing.testProject.configuration;

import com.epam.producing.testProject.model.Address;
import com.epam.producing.testProject.model.Customer;
import com.epam.producing.testProject.repository.AddressRepository;
import com.epam.producing.testProject.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
@Slf4j
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CustomerRepository customerRepository, AddressRepository addressRepository){
        return args -> {
            Address address1 = new Address("Ukraine", "Kuiv", "Kuiv","Kudriashova", 18);
            Address address2 = new Address("Ukraine", "Kuiv", "Kuiv","Vokzalna", 1);
            Address address3 = new Address("Ukraine", "Kuiv", "Kuiv","Nezaleghnosti", 7);

            log.info("Preloading " + addressRepository.save(address1));
            log.info("Preloading " + addressRepository.save(address2));
            log.info("Preloading " + addressRepository.save(address3));

            log.info("Preloading " + customerRepository.save(new Customer("Ivan", "Ivanov", "ivan","vvv", addressRepository.findAll())));

            ArrayList<Address> sidorovAddresses = new ArrayList<>();
            sidorovAddresses.add(address1);
            log.info("Preloading " + customerRepository.save(new Customer("Mykola", "Sidorov", "mmm","123", sidorovAddresses)));

            ArrayList<Address> petrenkoAddresses = new ArrayList<>();
            petrenkoAddresses.add(address2);
            petrenkoAddresses.add(address2);
            log.info("Preloading " + customerRepository.save(new Customer("Petro", "Petrenko", "petr","qwe", addressRepository.findAll())));


        };
    }
}