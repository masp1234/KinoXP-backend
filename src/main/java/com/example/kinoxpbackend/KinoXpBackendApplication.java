package com.example.kinoxpbackend;

import com.example.kinoxpbackend.models.User;
import com.example.kinoxpbackend.repositories.UserRepository;
import com.example.kinoxpbackend.models.Actor;
import com.example.kinoxpbackend.models.Film;
import com.example.kinoxpbackend.models.FilmShowing;
import com.example.kinoxpbackend.repositories.ActorRepository;
import com.example.kinoxpbackend.repositories.FilmRepository;
import com.example.kinoxpbackend.repositories.FilmShowingRepository;
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
                                         UserRepository userRepository,
                                         FilmRepository filmRepository,
                                         ActorRepository actorRepository,
                                         FilmShowingRepository filmShowingRepository

            ) {

        return (args) -> {

            User user = new User("Daniel", "Danieluser","Danielersej123","admin");
            userRepository.save(user);
            // whatever du har lyst til

            Film film1 = new Film();
            film1.setTitle("Titatic");
            film1.setGenre("Drama");
            film1.setMinimumAge(12);
            film1.setDescription("En film om en båd");
            film1.setPoster("https://img.fruugo.com/product/6/31/14366316_max.jpg");
            film1.setLengthInMinutes(140);

            Film film2 = new Film();
            film2.setTitle("Avatar");
            film2.setGenre("Eventyr");
            film2.setMinimumAge(12);
            film2.setDescription("En film om en anden planet");
            film2.setPoster("https://prod.cdn.bbaws.net/TDC_Blockbuster_-_Production/1016/604/FO-0371_po-reg-medium_orig.jpg");
            film2.setLengthInMinutes(160);





            Actor actor = new Actor();
            actor.setFirstName("dsfdsf");
            actor.setLastName("fdsdfsdf");
            actor.setAge(20);
            actorRepository.save(actor);

            film1.setActors(Arrays.asList(actor));
            film2.setActors(Arrays.asList(actor));
            filmRepository.save(film1);

            FilmShowing filmShowing= new FilmShowing();
            filmShowing.setLength(59);
            filmShowing.setRoom("12");
            filmShowing.setPrice(80);
            filmShowing.setFilm(film1);
            filmShowingRepository.save(filmShowing);


            filmRepository.save(film2);




        };
    }

}
