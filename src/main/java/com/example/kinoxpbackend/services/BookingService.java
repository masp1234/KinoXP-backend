package com.example.kinoxpbackend.services;


import com.example.kinoxpbackend.models.Booking;
import com.example.kinoxpbackend.models.FilmShowing;
import com.example.kinoxpbackend.repositories.BookingRepository;
import com.example.kinoxpbackend.repositories.FilmShowingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private BookingRepository bookingRepository;

    private FilmShowingRepository filmShowingRepository;

    public BookingService(BookingRepository bookingRepository, FilmShowingRepository filmShowingRepository) {
        this.bookingRepository = bookingRepository;
        this.filmShowingRepository = filmShowingRepository;
    }

    public Booking addBooking(Booking booking, Long filmShowingId) {
        FilmShowing filmShowing = filmShowingRepository.findById(filmShowingId).get();

        booking.setFilmShowing(filmShowing);
        return bookingRepository.save(booking);
    }
}
