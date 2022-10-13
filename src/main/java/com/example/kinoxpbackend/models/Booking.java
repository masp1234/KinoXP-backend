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
@Table(name = "booking")
public class Booking {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "booking_id")
        private Long bookingId;

        @ManyToOne()
        @JoinColumn(name = "film_showing_id")
        private FilmShowing filmShowing;

        //tid
        @Column(name = "booking_time")
        private String time;
        //seat

        @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH})
        @JoinTable(name = "booked_seats",
        joinColumns = @JoinColumn(name = "booking_id"),
        inverseJoinColumns = @JoinColumn(name = "seat_id"))
        private List<Seat> seats;

        @JsonBackReference
        @ManyToOne()
        @JoinColumn(name = "customer_id")
        private Customer customer;



}
