package com.example.kinoxpbackend.services;

import com.example.kinoxpbackend.models.Customer;
import com.example.kinoxpbackend.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);

    }

    public Customer getCustomerByEmail(String email){
        return customerRepository.findCustomerByEmail(email);
    }


}
