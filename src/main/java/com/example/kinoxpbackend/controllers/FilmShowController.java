package com.example.kinoxpbackend.controllers;

import com.example.kinoxpbackend.models.Film;
import com.example.kinoxpbackend.models.FilmShowing;
import com.example.kinoxpbackend.models.Room;
import com.example.kinoxpbackend.services.FilmShowingService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
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

    /*@PostMapping("/filmShowing/{id}")
    public void editFilmShowing(@PathVariable("id") Long filmShowingId,
                                  @RequestParam("LENGTH") int length,
                                  @RequestParam("ROOM") String room,
                                  @RequestParam("PRICE") double price){
        FilmShowing filmShowing = new FilmShowing();
        filmShowing.setFilmShowingId(filmShowingId);
        filmShowing.setLength(length);
        filmShowing.setRoom(room);
        filmShowing.setPrice(price);
    }

     */
   /* @PatchMapping("/filmShowing/{id}")
     ResponseEntity<FilmShowing> editFilmShowing(
            @PathVariable(value = "id") Long filmShowingId,
            @Valid @RequestBody FilmShowing filmShowings) throws ResourceNotFoundException {
        FilmShowing filmShowing = filmShowingService.find(filmShowingId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ filmShowingId));

        filmShowing.setLength(filmShowings.getLength());
        filmShowing.setFilm(filmShowings.getFilm());
        filmShowing.setRoom(filmShowings.getRoom());
        filmShowing.setPrice(filmShowings.getPrice());

        final FilmShowing updateFilShowing = filmShowingService.update(filmShowing);
        return ResponseEntity.ok(updateFilShowing);
    }
    */


    @PatchMapping("/oneFileShowing/{id}")
    public ResponseEntity<FilmShowing> update(@PathVariable("id") Long id, @Valid @RequestParam("LENGTH") int length,
                                              @RequestParam("film_id")Film film,
                                              @RequestParam("ROOM") Room room, @RequestParam("PRICE") double price){
        FilmShowing filmShowing = new FilmShowing();
        filmShowing.setFilm(film);
        filmShowing.setLength(length);
        filmShowing.setRoom(room);
        filmShowing.setPrice(price);
        return ResponseEntity.ok().body(filmShowingService.update(id,filmShowing));
    }

}
