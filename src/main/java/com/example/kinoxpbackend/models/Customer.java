package com.example.kinoxpbackend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "customer_first_name")
    private String ferstName;

    @Column(name = "customer_last_name")
    private String lastName;

    @Column(name = "customer_email")
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Booking> bookings;

    @Column(name = "customer_phone_number")
    private String phoneNumber;


    public Booking addBooking(Booking booking) {
        bookings.add(booking);
        return booking;

    }
}
