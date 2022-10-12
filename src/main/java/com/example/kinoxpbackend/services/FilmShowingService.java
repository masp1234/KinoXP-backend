package com.example.kinoxpbackend.services;

import com.example.kinoxpbackend.models.Film;
import com.example.kinoxpbackend.models.FilmShowing;
import com.example.kinoxpbackend.models.Room;
import com.example.kinoxpbackend.repositories.FilmRepository;
import com.example.kinoxpbackend.repositories.FilmShowingRepository;
import com.example.kinoxpbackend.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmShowingService {

    private FilmShowingRepository filmShowingRepository;
    private FilmRepository filmRepository;
    private RoomRepository roomRepository;

    public FilmShowingService(FilmShowingRepository filmShowingRepository, FilmRepository filmRepository, RoomRepository roomRepository) {
        this.filmShowingRepository = filmShowingRepository;
        this.filmRepository = filmRepository;
        this.roomRepository = roomRepository;
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
    public FilmShowing addFilmShowing(FilmShowing filmShowing, Long filmId, Long roomId) {
        Film foundFilm = filmRepository.findById(filmId).get();
        Room room = roomRepository.findById(roomId).get();
        filmShowing.setRoom(room);
        filmShowing.setFilm(foundFilm);
        return filmShowingRepository.save(filmShowing);
    }
    public List<FilmShowing> findByDate(String date){
        return (List<FilmShowing>) filmShowingRepository.findAllByDate(date);
    }
}
