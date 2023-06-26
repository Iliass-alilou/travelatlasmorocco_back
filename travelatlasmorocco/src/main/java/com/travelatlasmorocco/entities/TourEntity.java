package com.travelatlasmorocco.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity(name = "tour")
public class TourEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tourId;
    private int rating;
    private String nom;
    private String description;
    @Column(name = "long_description")
    private String desc;
    private float prix;
    private int duree;
    @OneToMany(mappedBy = "tour", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ItineraireEntity> itineraire;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TourEntity)) return false;
        TourEntity that = (TourEntity) o;
        return getId() == that.getId() && getRating() == that.getRating() && Float.compare(that.getPrix(), getPrix()) == 0 && getDuree() == that.getDuree() && Objects.equals(getTourId(), that.getTourId()) && Objects.equals(getNom(), that.getNom()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getDesc(), that.getDesc()) && Objects.equals(getItineraire(), that.getItineraire());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTourId(), getRating(), getNom(), getDescription(), getDesc(), getPrix(), getDuree(), getItineraire());
    }

    @Override
    public String toString() {
        return "TourEntity{" +
                "id=" + id +
                ", tourId='" + tourId + '\'' +
                ", rating=" + rating +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", desc='" + desc + '\'' +
                ", prix=" + prix +
                ", duree=" + duree +
                ", itineraire=" + itineraire +
                '}';
    }
}
