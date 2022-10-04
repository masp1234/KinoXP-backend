package com.example.kinoxpbackend;

import com.example.kinoxpbackend.models.User;
import com.example.kinoxpbackend.repositories.UserRepository;
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
                                         UserRepository userRepository

            ) {

        return (args) -> {

            User user = new User("Daniel", "Danieluser","Danielersej123","admin");
            userRepository.save(user);
            // whatever du har lyst til

        };
    }

}
