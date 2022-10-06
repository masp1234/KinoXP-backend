package com.example.kinoxpbackend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name= "ROOM")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "room_id")
    private Long roomId;

    @Column(name = "bigRoom")
    private String bigRoom;


    @Column(name = "smallRoom")
    private String smallRoom;

    @JsonManagedReference
    @ManyToOne()
    @JoinColumn(name = "film_showing_id", nullable = false)
    private FilmShowing filmShowing;

    @JsonManagedReference
    @ManyToMany
    @JoinColumn(name= "seat_id")
    private Seat seat;
}
