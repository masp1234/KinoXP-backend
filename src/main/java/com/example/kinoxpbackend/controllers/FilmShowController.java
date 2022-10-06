package com.example.kinoxpbackend.controllers;

import com.example.kinoxpbackend.models.Film;
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

    // Virker hvis vi ændre på alle værdier
    @PatchMapping("/oneFilmShowing/{id}")
    public ResponseEntity<FilmShowing> update(@PathVariable("id") Long id, @RequestParam("LENGTH") int length,
                                              @RequestParam("film_id") Film film,
                                              @RequestParam("ROOM") String room, @RequestParam("PRICE") double price){
        FilmShowing filmShowing = new FilmShowing();
        filmShowing.setFilm(film);
        filmShowing.setLength(length);
        filmShowing.setRoom(room);
        filmShowing.setPrice(price);
        return ResponseEntity.ok().body(filmShowingService.update(id,filmShowing));
    }

    @PostMapping(value = "/addFilmShowing")
    public void addFilmShowing(@RequestBody FilmShowing filmShowing) {
        filmShowingService.add(filmShowing);
    }

    /*
    @PutMapping("/oneFilmShowing/{id}")
    public ResponseEntity<FilmShowing> update(@PathVariable("id") Long id,@Valid @RequestParam("LENGTH") int length,
                                              @RequestParam("film_id")Film film,
                                              @RequestParam("ROOM") String room, @RequestParam("PRICE") double price){
        FilmShowing filmShowing = new FilmShowing();
        filmShowing.setFilm(film);
        filmShowing.setLength(length);
        filmShowing.setRoom(room);
        filmShowing.setPrice(price);

        return ResponseEntity.ok().body(filmShowingService.update(id, filmShowing));
    }
*/
}
