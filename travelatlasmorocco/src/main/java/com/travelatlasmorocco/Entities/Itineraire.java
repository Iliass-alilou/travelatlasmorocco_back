package com.travelatlasmorocco.Entities;

import javax.persistence.*;

@Table
@Entity
public class Itineraire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String iteneraireId;
    private int jour;
    private String ville;
    private String descreption;

//    @ManyToOne
//    @JoinColumn(name = "tourId",referencedColumnName = "tourId")
//    private TourEntity tour;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIteneraireId() {
        return iteneraireId;
    }

    public void setIteneraireId(String iteneraireId) {
        this.iteneraireId = iteneraireId;
    }

    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

}
