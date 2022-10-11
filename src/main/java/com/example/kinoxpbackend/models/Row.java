package com.example.kinoxpbackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "\"row\"")
public class Row {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "row_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "row")
    private List<Seat> seats;


}
