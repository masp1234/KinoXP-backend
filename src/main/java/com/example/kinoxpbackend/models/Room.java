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
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "room_id")
    private Long Id;

    @Column(name = "name")
    private String name;


    @JsonBackReference(value = "filmShowing")
    @OneToMany(mappedBy = "room")
    private List<FilmShowing> filmShowing;



    @OneToMany(mappedBy = "room", cascade = CascadeType.PERSIST)
    private List<Row> rows;

    @JsonBackReference(value = "booking")
    @OneToOne(mappedBy = "room")
    private Booking booking;


}
