package com.example.kinoxpbackend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@SuppressWarnings("JpaAttributeTypeInspection")
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
