package com.example.kinoxpbackend.controllers;

import com.example.kinoxpbackend.models.FilmShowing;
import com.example.kinoxpbackend.services.FilmShowingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilmShowController {
    private FilmShowingService filmShowingService;

    public FilmShowController(FilmShowingService filmShowingService) {
        this.filmShowingService = filmShowingService;
    }

    @GetMapping("/allFilmShowing")
    ResponseEntity<List<FilmShowing>> allFilmShowing(){
        List<FilmShowing> findAll= (List<FilmShowing>) filmShowingService.showAll();
        return new ResponseEntity<>(findAll, HttpStatus.OK);
    }

}
