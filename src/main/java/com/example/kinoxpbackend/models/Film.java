package com.example.kinoxpbackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Long id;


    @Column(name = "film_title", unique = true)
    private String title;

    @Column(name = "film_genre")
    private String genre;

    @Column(name = "film_rated")
    private String rated;

    @Column(name = "film_length_in_minutes")
    private int lengthInMinutes;

    @Column(name = "film_description")
    private String description;


    @Column(name = "film_poster")
    private String poster;


    @Column(name = "film_actors")
    private String actors;

    @JsonBackReference
    @OneToMany(mappedBy = "film")
    @ToString.Exclude
    private List<FilmShowing> filmShowing;

    public boolean equals(Object o) {
        Film otherFilm = (Film) o;
        return
                this.id == otherFilm.getId()
                && this.title.equals(otherFilm.getTitle())
                && this.genre.equals(otherFilm.genre)
                && this.rated.equals(otherFilm.rated)
                && this.lengthInMinutes == otherFilm.getLengthInMinutes()
                && this.description.equals(otherFilm.getDescription())
                && this.poster.equals(otherFilm.getPoster())
                && this.actors.equals(otherFilm.getActors());

    }



}
