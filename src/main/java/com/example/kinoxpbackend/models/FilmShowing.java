package com.example.kinoxpbackend.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "film_showing_id")
    private Long filmShowingId;


    @Column(name = "film_showing_time")
    private String time;

    @Column(name = "film_showing_date")
    private String date;

    //@JsonManagedReference
    @ManyToOne()
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Room room;



    @Column(name = "film_showing_price")
    private double price;





}
