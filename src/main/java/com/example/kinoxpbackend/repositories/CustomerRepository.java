package com.example.kinoxpbackend.repositories;

import com.example.kinoxpbackend.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    public Customer findCustomerByEmail(String email);


}
