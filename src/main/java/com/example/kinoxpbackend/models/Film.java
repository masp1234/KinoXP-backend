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

@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Long id;

    @Column(name = "film_title")
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


    @Column(name = "actors")
    private String actors;

    /*
>>>>>>> testafpost
    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "film_actors",
            joinColumns = {@JoinColumn(name = "film_id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id")}
    )
    private List<Actor> actors;

     */


    @JsonBackReference
    //@JsonManagedReference
    @OneToMany(mappedBy = "film")
    private List<FilmShowing> filmShowing;


}
