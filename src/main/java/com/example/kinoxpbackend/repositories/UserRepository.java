package com.example.kinoxpbackend.repositories;

import com.example.kinoxpbackend.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {

    User findByUsername(String username);
}
