package com.example.kinoxpbackend.repositories;

import com.example.kinoxpbackend.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
