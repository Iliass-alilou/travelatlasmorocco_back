package com.travelatlasmorocco.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
@Getter
@Setter
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tourId;
    private int rating;
    private String nom;
    private String description;
    @Column(name = "long_description")
    private String desc;
    private int prix;
    @OneToMany
    private List<Itineraire> itineraire;
}
