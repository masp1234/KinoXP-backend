package com.example.kinoxpbackend;

import com.example.kinoxpbackend.models.*;
import com.example.kinoxpbackend.repositories.UserRepository;
import com.example.kinoxpbackend.models.Film;
import com.example.kinoxpbackend.models.FilmShowing;
import com.example.kinoxpbackend.repositories.FilmRepository;
import com.example.kinoxpbackend.repositories.FilmShowingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KinoXpBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(KinoXpBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner importData( //repositories
                                         UserRepository userRepository,
                                         FilmRepository filmRepository,
                                         FilmShowingRepository filmShowingRepository

            ) {

        return (args) -> {

            User user = new User("123", "123","123","admin");
            userRepository.save(user);
            // whatever du har lyst til

            Film film1 = new Film();
            film1.setTitle("Titatic");
            film1.setGenre("Drama");
            film1.setRated("Pg-13");
            film1.setDescription("En film om en båd");
            film1.setPoster("https://img.fruugo.com/product/6/31/14366316_max.jpg");
            film1.setLengthInMinutes(140);

            Film film2 = new Film();
            film2.setTitle("Avatar");
            film2.setGenre("Eventyr");
            film2.setRated("Pg-13");
            film2.setDescription("En film om en anden planet");
            film2.setPoster("https://prod.cdn.bbaws.net/TDC_Blockbuster_-_Production/1016/604/FO-0371_po-reg-medium_orig.jpg");
            film2.setLengthInMinutes(160);








            filmRepository.save(film1);
            filmRepository.save(film2);

            FilmShowing filmShowing= new FilmShowing();
            filmShowing.setDate("01-01-2020");
            filmShowing.setTime("12.00");
            //filmShowing.setRoom(new Room());
            filmShowing.setPrice(80);
            filmShowing.setFilm(film1);
            filmShowingRepository.save(filmShowing);


            filmRepository.save(film2);
            FilmShowing filmShowing2 = new FilmShowing();
            filmShowing2.setFilm(film2);
            filmShowing2.setDate("01-02-2020");
            filmShowing2.setTime("13.00");
            filmShowing2.setPrice(80);
            //filmShowing2.setRoom(new Room());

            filmShowingRepository.save(filmShowing2);




        };
    }

}
