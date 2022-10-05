package com.example.kinoxpbackend.controllers;

import com.example.kinoxpbackend.models.FilmShowing;
import com.example.kinoxpbackend.services.FilmShowingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FilmShowController {
    private FilmShowingService filmShowingService;

    public FilmShowController(FilmShowingService filmShowingService) {
        this.filmShowingService = filmShowingService;
    }

    @GetMapping("/allFilmShowing")
    ResponseEntity<List<FilmShowing>> allFilmShowing(){
        List<FilmShowing> findAll= (List<FilmShowing>) filmShowingService.findAll();
        return new ResponseEntity<>(findAll, HttpStatus.OK);
    }

    @GetMapping("/oneFilmShowing/{id}")
    ResponseEntity<FilmShowing> oneFilmShowing(@PathVariable("id") Long id){
        FilmShowing filmShowing = filmShowingService.find(id).get();
        return new ResponseEntity<>(filmShowing, HttpStatus.OK);
    }

    @PostMapping("/filmShowing/{id}")
    public void editFilmShowing(@PathVariable @RequestParam("film_showing_id") Long filmShowingId,
                                  @RequestParam("LENGTH") int length,
                                  @RequestParam("ROOM") String room,
                                  @RequestParam("PRICE") double price){
        FilmShowing filmShowing = new FilmShowing();
        filmShowing.setFilmShowingId(filmShowingId);
        filmShowing.setLength(length);
        filmShowing.setRoom(room);
        filmShowing.setPrice(price);
    }
}
