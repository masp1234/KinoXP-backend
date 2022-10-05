package com.example.kinoxpbackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Long id;

    @Column(name = "actor_first_name")
    private String firstName;

    @Column(name = "actor_last_name")
    private String lastName;

    @Column(name = "actor_age")
    private int age;

/*
    @JsonBackReference
    @ManyToMany(mappedBy = "actors")
    private List<Film> films;

 */



}
