
package com.example.kinoxpbackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;



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

    @Column (name = "seatNumber", nullable = false)
    private int seatNumber;

    @ManyToMany(mappedBy = "seats")
    @JsonBackReference(value = "bookings")
    private List<Booking> bookings;

    @ManyToOne()
    @JoinColumn(name = "rows_id")
    @JsonBackReference(value = "row")
    private Row row;

}





