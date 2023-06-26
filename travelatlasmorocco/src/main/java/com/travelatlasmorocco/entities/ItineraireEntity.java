package com.travelatlasmorocco.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "itineraire")
public class ItineraireEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String iteneraireId;
    private int jour;
    private String ville;
    private String description;
    @ManyToOne
    @JoinColumn(name="Tour_id")
    private TourEntity tour;
}
