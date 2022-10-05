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
@Table(name = "BOOKING")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "LENGTH")
    private int length;
    @JsonManagedReference
    @ManyToOne()

    @JoinColumn(name = "film_showing_id", nullable = false)
    private FilmShowing filmShowing;
    //tid
    @Column(name = "TIME")
    private String time;
    //seat
    @Column(name = "SEAT")
    private String seat;
    //room
    @Column(name = "ROOM")
    private String room;



}
