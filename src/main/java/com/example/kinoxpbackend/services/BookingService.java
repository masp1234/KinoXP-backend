package com.example.kinoxpbackend.services;


import com.example.kinoxpbackend.models.Booking;
import com.example.kinoxpbackend.models.Customer;
import com.example.kinoxpbackend.models.FilmShowing;
import com.example.kinoxpbackend.models.Seat;
import com.example.kinoxpbackend.repositories.BookingRepository;
import com.example.kinoxpbackend.repositories.FilmShowingRepository;
import com.example.kinoxpbackend.repositories.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    private BookingRepository bookingRepository;

    private FilmShowingRepository filmShowingRepository;

    private SeatRepository seatRepository;

    private CustomerService customerService;

    public BookingService(BookingRepository bookingRepository, FilmShowingRepository filmShowingRepository, SeatRepository seatRepository, CustomerService customerService) {
        this.bookingRepository = bookingRepository;
        this.filmShowingRepository = filmShowingRepository;
        this.seatRepository = seatRepository;
        this.customerService = customerService;
    }

    public Booking addBooking(Booking booking, Long filmShowingId, List<Long> seatIds, String customerEmail) {
        FilmShowing filmShowing = filmShowingRepository.findById(filmShowingId).get();
        Customer customer = customerService.getCustomerByEmail(customerEmail);

        List<Seat> resservedSeat = new ArrayList<>();

        for (Long seatid: seatIds) {
            resservedSeat.add(seatRepository.findById(seatid).get());
        }

        booking.setSeats(resservedSeat);
        booking.setFilmShowing(filmShowing);
        customer.addBooking(booking);
        customerService.addCustomer(customer);

        return booking;
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).get();

    }

    public List<Booking> getAllBookingsByFilmShowingId(Long filmShowingId) {
        return bookingRepository.findAllByFilmShowing_FilmShowingId(filmShowingId);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking deleteBooking(Long id){
        Booking booking= bookingRepository.findById(id).get();

         bookingRepository.deleteById(id);
         return booking;
    }
}
