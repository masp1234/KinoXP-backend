package com.example.kinoxpbackend;

import com.example.kinoxpbackend.models.Film;
import com.example.kinoxpbackend.repositories.FilmRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class KinoXpBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(KinoXpBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner importData( //repositories
                                         FilmRepository filmRepository

            ) {

        return (args) -> {
            // whatever du har lyst til

            Film film1 = new Film();
            film1.setTitle("Titatic");
            film1.setGenre("Drama");
            film1.setMinimumAge(12);
            film1.setDescription("En film om en båd");
            film1.setLengthInMinutes(140);

            filmRepository.save(film1);

        };
    }

}
