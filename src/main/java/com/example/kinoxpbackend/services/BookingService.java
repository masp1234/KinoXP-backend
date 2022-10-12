package com.example.kinoxpbackend.services;


import com.example.kinoxpbackend.models.Booking;
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

    public BookingService(BookingRepository bookingRepository,
                          FilmShowingRepository filmShowingRepository,
                          SeatRepository seatRepository) {

        this.bookingRepository = bookingRepository;
        this.filmShowingRepository = filmShowingRepository;
        this.seatRepository = seatRepository;
    }

    public Booking addBooking(Booking booking, Long filmShowingId, List<Long> seatIds) {
        FilmShowing filmShowing = filmShowingRepository.findById(filmShowingId).get();

        List<Seat> resservedSeat = new ArrayList<>();

        for (Long seatid: seatIds) {
            resservedSeat.add(seatRepository.findById(seatid).get());
        }

        booking.setSeats(resservedSeat);
        booking.setFilmShowing(filmShowing);
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
}
