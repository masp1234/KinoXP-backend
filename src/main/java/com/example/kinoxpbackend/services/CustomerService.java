package com.example.kinoxpbackend.services;

import com.example.kinoxpbackend.models.Booking;
import com.example.kinoxpbackend.models.Customer;
import com.example.kinoxpbackend.repositories.BookingRepository;
import com.example.kinoxpbackend.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    private BookingRepository bookingRepository;

    public CustomerService(CustomerRepository customerRepository, BookingRepository bookingRepository) {
        this.customerRepository = customerRepository;
        this.bookingRepository = bookingRepository;
    }

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);

    }

    public Customer getCustomerByEmail(String email){
        return customerRepository.findCustomerByEmail(email);
    }


    public Customer findById(Long customerId) {
        return customerRepository.findById(customerId).get();
    }

    public Customer addBookingToCustomer(Booking booking, Long customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        customer.addBooking(booking);
        booking.setCustomer(customer);

        customerRepository.save(customer);
        bookingRepository.save(booking);

        return customer;
    }
}
