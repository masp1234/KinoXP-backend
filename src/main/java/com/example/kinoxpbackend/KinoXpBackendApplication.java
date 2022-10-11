package com.example.kinoxpbackend;

import com.example.kinoxpbackend.models.*;
import com.example.kinoxpbackend.repositories.*;
import com.example.kinoxpbackend.models.Film;
import com.example.kinoxpbackend.models.FilmShowing;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class KinoXpBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(KinoXpBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner importData( //repositories
                                         UserRepository userRepository,
                                         FilmRepository filmRepository,
                                         FilmShowingRepository filmShowingRepository,
                                         CustomerRepository customerRepository,
                                         RoomRepository roomRepository,
                                         RowRepository rowRepository,
                                         SeatRepository seatRepository,
                                         BookingRepository bookingRepository

            ) {

        return (args) -> {
            Seat seat = new Seat();
            seat.setSeatNumber(10);

            Room room1 = new Room();
            room1.setName("rum1");


            Row row = new Row();
            row.setName("A");
            row.setRoom(room1);
            row.setSeats(Arrays.asList(seat));

            seat.setRow(row);







            room1.setRows(Arrays.asList(row));

            roomRepository.save(room1);

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
            filmShowing.setDate("11-10-2022");
            filmShowing.setTime("12.00");
            //filmShowing.setRoom(new Room());
            filmShowing.setPrice(80);
            filmShowing.setFilm(film1);
            filmShowingRepository.save(filmShowing);


            filmRepository.save(film2);
            FilmShowing filmShowing2 = new FilmShowing();
            filmShowing2.setFilm(film2);
            filmShowing2.setDate("11-10-2022");
            filmShowing2.setTime("13.00");
            filmShowing2.setPrice(80);
            filmShowing2.setRoom(room1);


            filmRepository.save(film2);
            FilmShowing filmShowing3 = new FilmShowing();
            filmShowing3.setFilm(film2);
            filmShowing3.setDate("11-10-2022");
            filmShowing3.setTime("12.00");
            filmShowing3.setPrice(80);
            filmShowingRepository.save((filmShowing3));

           // filmShowing2.setRoom(room1);



            filmShowingRepository.save(filmShowing2);


           // room1.setFilmShowing(Arrays.asList(filmShowing2));
            roomRepository.save(room1);


            FilmShowing filmShowing4 = new FilmShowing();
            filmShowing4.setFilm(film2);
            filmShowing4.setDate("11-10-2022");
            filmShowing4.setTime("12.00");
            filmShowing4.setPrice(80);
            filmShowingRepository.save((filmShowing4));

            FilmShowing filmShowing5 = new FilmShowing();
            filmShowing5.setFilm(film2);
            filmShowing5.setDate("12-10-2022");
            filmShowing5.setTime("12.00");
            filmShowing5.setPrice(80);
            filmShowingRepository.save((filmShowing5));

            FilmShowing filmShowing6 = new FilmShowing();
            filmShowing6.setFilm(film2);
            filmShowing6.setDate("12-10-2022");
            filmShowing6.setTime("15.00");
            filmShowing6.setPrice(80);
            filmShowingRepository.save((filmShowing6));





            Customer customer= new Customer();
            customer.setFerstName("Renas");
            customer.setLastName("Ali");
            customer.setEmail("ex@kinoXP.dk");
            customer.setBookings(null);
            customer.setPhoneNumber("45454545");
            customerRepository.save(customer);




            Booking booking = new Booking();
            booking.setFilmShowing(filmShowing2);
            booking.setRoom(filmShowing2.getRoom());
            List<Seat> seats = new ArrayList<>();
            bookingRepository.save(booking);
            booking.getRoom().getRows().forEach(r -> seats.addAll(row.getSeats()));
            booking.setSeat(seats);
            seats.forEach(s -> s.setBooking(booking));
            seatRepository.saveAll(seats);
            bookingRepository.save(booking);













        };
    }

}
