package com.example.kinoxpbackend.controllers;


import com.example.kinoxpbackend.models.Film;
import com.example.kinoxpbackend.services.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/film")
@CrossOrigin
public class FilmController {

    private FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable("id") Long id) {
        Film film = filmService.getFilmById(id);
        return new ResponseEntity<>(film, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Film>> getAllFilms() {
        List<Film> films = filmService.findAllFilms();

        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    @PostMapping(value = "/add-film")
    public void addFilm(@RequestBody Film film) {
        filmService.add(film);
    }
}
