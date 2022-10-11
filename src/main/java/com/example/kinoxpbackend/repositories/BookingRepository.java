package com.example.kinoxpbackend.repositories;

import com.example.kinoxpbackend.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    public List<Booking> findAllByFilmShowing_FilmShowingId(Long id);

}

