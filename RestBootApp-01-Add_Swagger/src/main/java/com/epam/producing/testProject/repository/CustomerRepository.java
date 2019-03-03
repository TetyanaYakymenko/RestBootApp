package com.epam.producing.testProject.repository;

import com.epam.producing.testProject.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
