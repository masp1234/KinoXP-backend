
package com.example.kinoxpbackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="seat_id")
    int id;

    @Column (name = "seat_number", nullable = false)
    private int seatNumber;

    @ManyToMany(mappedBy = "seats")
    @JsonBackReference(value = "bookings")
    private List<Booking> bookings;

    @ManyToOne()
    @JoinColumn(name = "row_id")
    @JsonBackReference(value = "row")
    private Row row;

}





