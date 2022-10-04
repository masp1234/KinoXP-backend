package com.example.kinoxpbackend.models;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import com.example.kinoxpbackend.models.Film;

import java.util.List;


@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="FILMSHOWING")
public class FilmShowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="film_showing_id")
    private Long filmShowingId;



    @Column(name="LENGTH")
    private int length;

    @JsonManagedReference
    @ManyToOne()
    @JoinColumn(name= "film_id", nullable = false)
    private Film film;


    @Column(name = "ROOM")
    private String room;

    @Column(name = "PRICE")
    private double price;





}
