package com.example.kinoxpbackend.services;

import com.example.kinoxpbackend.models.Film;
import com.example.kinoxpbackend.models.FilmShowing;
import com.example.kinoxpbackend.repositories.FilmRepository;
import com.example.kinoxpbackend.repositories.FilmShowingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmShowingService {

    private FilmShowingRepository filmShowingRepository;
    private FilmRepository filmRepository;

    public FilmShowingService(FilmShowingRepository filmShowingRepository, FilmRepository filmRepository) {
        this.filmShowingRepository = filmShowingRepository;
        this.filmRepository = filmRepository;
    }

    public Iterable<FilmShowing> findAll() {
        return filmShowingRepository.findAll();
    }

    public Optional<FilmShowing> find(Long id) {
        return filmShowingRepository.findById(id);
    }

    public FilmShowing update(Long id, FilmShowing filmShowing) {

        return filmShowingRepository.save(filmShowing);
    }

    //add filmShowing
    public FilmShowing addFilmShowing(FilmShowing filmShowing, Long filmId) {
        Film foundFilm = filmRepository.findById(filmId).get();
        filmShowing.setFilm(foundFilm);
        return filmShowingRepository.save(filmShowing);
    }
    public List<FilmShowing> findByDate(String date){
        return (List<FilmShowing>) filmShowingRepository.findAllByDate(date);
    }
}
