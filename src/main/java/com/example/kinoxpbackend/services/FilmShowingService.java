package com.example.kinoxpbackend.services;

import com.example.kinoxpbackend.models.FilmShowing;
import com.example.kinoxpbackend.repositories.FilmShowingRepository;
import org.springframework.stereotype.Service;

@Service
public class FilmShowingService {

    private FilmShowingRepository filmShowingRepository;

    public FilmShowingService(FilmShowingRepository filmShowingRepository) {
        this.filmShowingRepository = filmShowingRepository;
    }

    public Iterable<FilmShowing> findAll() {
        return filmShowingRepository.findAll();
    }
}
