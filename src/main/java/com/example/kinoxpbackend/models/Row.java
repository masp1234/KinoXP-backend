package com.example.kinoxpbackend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "rows")
public class Row {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rows_id")
    private Long id;

    @Column(name = "name")
    private String name;


    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToMany
    private List<Seat> seats;


}
