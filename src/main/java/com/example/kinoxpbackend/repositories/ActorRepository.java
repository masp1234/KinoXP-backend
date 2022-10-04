package com.example.kinoxpbackend.repositories;

import com.example.kinoxpbackend.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long > {
}
