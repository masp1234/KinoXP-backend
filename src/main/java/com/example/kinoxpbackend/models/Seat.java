package com.example.kinoxpbackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("JpaAttributeTypeInspection")
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "SEAT")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="seat_id")
    int id;

    @Column (name = "seatRow", nullable = false)
    private String seatRow;

    @Column (name = "seatNumber", nullable = false)
    private int seatNumber;

    @JsonManagedReference
    @ManyToMany
    @JoinColumn(name= "room_id")
    private Room room;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name= "booking_id")
    private Booking booking;

    public Seat(String seatRow, int seatNumber, Room room) {
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
        this.room = room;
    }

}



