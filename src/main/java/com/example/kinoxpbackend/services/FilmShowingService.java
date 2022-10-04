package com.example.kinoxpbackend.services;

import com.example.kinoxpbackend.models.FilmShowing;
import com.example.kinoxpbackend.repositories.FilmShowingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmShowingService {

    private final FilmShowingRepository filmShowingRepository;

    public FilmShowingService(FilmShowingRepository filmShowingRepository) {
        this.filmShowingRepository = filmShowingRepository;
    }
    public Iterable<FilmShowing> showAll(){
        List<FilmShowing> showinglist= new ArrayList<>();
        Iterable<FilmShowing> showingsIteam= filmShowingRepository.findAll();
        showingsIteam.forEach(showinglist::add);
        return showinglist;
    }
}
