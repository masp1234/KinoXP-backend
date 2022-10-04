package com.example.kinoxpbackend.repositories;

import com.example.kinoxpbackend.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
