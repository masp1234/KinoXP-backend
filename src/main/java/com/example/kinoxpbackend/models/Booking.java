package com.example.kinoxpbackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.naming.Name;
import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "BOOKING")
public class Booking {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "BOOKING_ID")
        private Long bookingId;

        @Column(name = "LENGTH")
        private int length;

        @ManyToOne()
        @JoinColumn(name = "FILM_SHOWING_ID", nullable = false)
        private FilmShowing filmShowing;

        //tid
        @Column(name = "TIME")
        private String time;
        //seat

        @ManyToMany()
        @JoinTable(name = "BOOKED_SEATS",
        joinColumns = @JoinColumn(name = "BOOKING_ID"),
        inverseJoinColumns = @JoinColumn(name = "SEAT_ID"))
        private List<Seat> seats;

        @OneToOne
        @JoinColumn(name = "ROOM_ID")
        private Room room;

        @JsonBackReference
        @ManyToOne()
        @JoinColumn(name = "CUSTOMER_ID")
        private Customer customer;



}
