package com.example.kinoxpbackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
        @Column(name = "booking_id")
        private Long bookingId;

        @Column(name = "LENGTH")
        private int length;

        @ManyToOne()
        @JoinColumn(name = "film_showing_id", nullable = false)
        private FilmShowing filmShowing;


        //tid
        @Column(name = "TIME")
        private String time;
        //seat
        /*
        @JsonBackReference
        @OneToMany(mappedBy = "booking")
        private List<Seat> seat;

         */
        //room
        @OneToOne
        @JoinColumn(name = "room_id")
        private Room room;


        @ManyToOne()
        @JoinColumn(name = "customer_id")
        private Customer customer;



}
