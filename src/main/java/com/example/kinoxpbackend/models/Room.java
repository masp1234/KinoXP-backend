package com.example.kinoxpbackend.models;

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
@Table(name= "ROOM")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "room_id")
    private Long roomId;

    @Column(name = "bigRoom")
    private String bigRoom;


    @Column(name = "smallRoom")
    private String smallRoom;

    @JsonManagedReference
    @OneToMany(mappedBy = "room")
//    @JoinColumn(name = "film_showing_id", nullable = false)
    private List<FilmShowing> filmShowing;

    @JsonManagedReference
    @OneToMany
    @JoinColumn(name= "seat_id")
    private List<Seat> seat;
}
