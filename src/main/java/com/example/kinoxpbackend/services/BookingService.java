package com.example.kinoxpbackend.services;

import com.example.kinoxpbackend.models.Booking;
import com.example.kinoxpbackend.repositories.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    BookingRepository bookingRepository;

    private BookingService(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    public Booking getBookingById(Long id){
        return bookingRepository.findById(id).get();
    }

    public List<Booking> findAllBookings(){
        return bookingRepository.findAll();
    }
}
