package com.example.kinoxpbackend.controllers;

import com.example.kinoxpbackend.models.Booking;
import com.example.kinoxpbackend.models.Customer;
import com.example.kinoxpbackend.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/customer")
public class CustomerController {
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {

        Customer addedCustomer= customerService.addCustomer(customer);
        return  new ResponseEntity<>(addedCustomer, HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable("email") String email){
        Customer foudedCustomer= customerService.getCustomerByEmail(email);
        return new ResponseEntity<>(foudedCustomer, HttpStatus.OK);
    }

    @PostMapping("/assign-booking/{customerId}")
    public ResponseEntity<Customer> assignBookingToCustomerById(@RequestBody Booking booking,
                                                                @PathVariable("customerId") Long customerId) {
        Customer customer = customerService.addBookingToCustomer(booking, customerId);

        return new ResponseEntity<>(customer, HttpStatus.OK);

    }
}
