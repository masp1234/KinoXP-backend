package com.example.kinoxpbackend.repositories;

import com.example.kinoxpbackend.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
