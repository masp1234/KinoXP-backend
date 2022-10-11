package com.example.kinoxpbackend.controllers;

import com.example.kinoxpbackend.models.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/customer")
public class CustomerController {

    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {

    }
}
