package com.example.kinoxpbackend.services;

import com.example.kinoxpbackend.models.Film;
import com.example.kinoxpbackend.models.FilmShowing;
import com.example.kinoxpbackend.repositories.FilmShowingRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmShowingService {

    private CrudRepository<FilmShowing, Long> filmShowingRepository;

    public FilmShowingService(CrudRepository<FilmShowing, Long> filmRepository) {
        this.filmShowingRepository = filmRepository;
    }

    public Optional<FilmShowing> findAll() {
        List<FilmShowing> list = new ArrayList<>();
        return filmShowingRepository;
    }
}
