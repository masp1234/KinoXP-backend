package com.example.kinoxpbackend.models;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;


@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="FILMSHOWING")
public class FilmShowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long filmShowingId;

    @Column(name="LENGTH")
    private int length;

    @Column(name = "FILM_ID")
    private int filmId;

    @Column(name = "ROOM")
    private String room;

    @Column(name = "PRICE")
    private double price;

}
