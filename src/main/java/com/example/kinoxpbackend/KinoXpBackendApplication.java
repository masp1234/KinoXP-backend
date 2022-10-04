package com.example.kinoxpbackend;

import com.example.kinoxpbackend.models.Actor;
import com.example.kinoxpbackend.models.Film;
import com.example.kinoxpbackend.repositories.ActorRepository;
import com.example.kinoxpbackend.repositories.FilmRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class KinoXpBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(KinoXpBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner importData( //repositories
                                         FilmRepository filmRepository,
                                         ActorRepository actorRepository

            ) {

        return (args) -> {
            // whatever du har lyst til

            Film film1 = new Film();
            film1.setTitle("Titatic");
            film1.setGenre("Drama");
            film1.setMinimumAge(12);
            film1.setDescription("En film om en båd");
            film1.setLengthInMinutes(140);

            Film film2 = new Film();
            film2.setTitle("Avatar");
            film2.setGenre("Eventyr");
            film2.setMinimumAge(12);
            film2.setDescription("En film om en anden planet");
            film2.setLengthInMinutes(160);





            Actor actor = new Actor();
            actor.setFirstName("dsfdsf");
            actor.setLastName("fdsdfsdf");
            actor.setAge(20);
            actorRepository.save(actor);

            film1.setActors(Arrays.asList(actor));
            film2.setActors(Arrays.asList(actor));
            filmRepository.save(film1);

            filmRepository.save(film2);




        };
    }

}
