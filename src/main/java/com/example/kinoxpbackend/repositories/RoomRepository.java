package com.example.kinoxpbackend.repositories;

import com.example.kinoxpbackend.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
