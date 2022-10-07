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
    private Long roomId;

    @Column(name = "name")
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "room")
//    @JoinColumn(name = "film_showing_id", nullable = false)
    private List<FilmShowing> filmShowing;

    @JsonManagedReference
    @OneToMany(mappedBy = "room")
    private List<Row> rows;


}
