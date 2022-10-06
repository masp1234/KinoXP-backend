package com.example.kinoxpbackend.repositories;

import com.example.kinoxpbackend.models.Film;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class FilmRepositoryTest {

    @Autowired
    private FilmRepository filmRepository;

    @Test
    public void getFilmById() {
        Film film1 = new Film();
        film1.setTitle("Titatic");
        film1.setGenre("Drama");
        film1.setRated("Pg-13");
        film1.setDescription("En film om en båd");
        film1.setPoster("https://img.fruugo.com/product/6/31/14366316_max.jpg");
        film1.setLengthInMinutes(140);

        filmRepository.save(film1);

        Film foundFilm = filmRepository.findById(2L).get();

        assertEquals(foundFilm, film1, "De skulle meget gerne være ens");
    }

}