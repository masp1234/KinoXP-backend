package com.example.kinoxpbackend.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "SEAT")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column (name = "seatRow", nullable = false)
    private String seatRow;

    @Column (name = "seatNumber", nullable = false)
    private int seatNumber;

    @ManyToOne
    Room room;

    @ManyToOne
    Booking booking;

    public Seat(String seatRow, int seatNumber, Room room) {
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
        this.room = room;
    }

}



