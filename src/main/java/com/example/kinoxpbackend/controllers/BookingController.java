package com.example.kinoxpbackend.controllers;

import com.example.kinoxpbackend.models.Booking;
import com.example.kinoxpbackend.services.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/booking")
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking,
                                              @PathVariable("id") Long filmShowingId) {
        return new ResponseEntity<>(bookingService.addBooking(booking, filmShowingId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(bookingService.getBookingById(id), HttpStatus.OK);
    }

    @GetMapping("/byFilmShowingId/{id}")
    public ResponseEntity<List<Booking>> getAllBookingsByFilmShowingId(@PathVariable("id") Long filmShowingId) {
        return new ResponseEntity<>(bookingService.getAllBookingsByFilmShowingId(filmShowingId), HttpStatus.OK);
    }

}
