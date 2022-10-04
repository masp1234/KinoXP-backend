package com.example.kinoxpbackend.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "genre")
    private String genre;

    @Column(name = "minimum_age")
    private int minimumAge;

    @Column(name = "length_in_minutes")
    private int lengthInMinutes;

    @Column(name = "description")
    private String description;

    @ManyToMany
    private List<Actor> actors;
}
