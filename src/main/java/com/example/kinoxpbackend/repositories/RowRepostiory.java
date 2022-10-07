package com.example.kinoxpbackend.repositories;

import com.example.kinoxpbackend.models.Row;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RowRepostiory extends JpaRepository<Row, Long> {
}
