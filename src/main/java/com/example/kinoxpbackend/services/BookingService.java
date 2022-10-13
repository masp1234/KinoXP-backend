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

        List<Seat> reservedSeats = new ArrayList<>();

        for (Long seatid: seatIds) {
            reservedSeats.add(seatRepository.findById(seatid).get());
        }

        booking.setSeats(reservedSeats);
        booking.setFilmShowing(filmShowing);
        customer.addBooking(booking);
        booking.setCustomer(customer);
        customerService.addCustomer(customer);

        return bookingRepository.save(booking);
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

    public void deleteBooking(Long id){
         bookingRepository.deleteById(id);

    }
}
