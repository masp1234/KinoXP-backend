package com.example.kinoxpbackend.services;


import com.example.kinoxpbackend.models.Film;
import com.example.kinoxpbackend.repositories.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    private FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public Film getFilmById(Long id) {
        return filmRepository.findById(id).get();
    }

    public List<Film> findAllFilms() {
        return filmRepository.findAll();
    }
}
