package com.travelatlasmorocco.requests;

import com.travelatlasmorocco.entities.ItineraireEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Setter
@Getter
public class TourRequest {
    private int rating;
    private String nom;
    private String description;
    private String desc;
    private float prix;
    private int duree;
    private List<ItineraireRequest> itineraire;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TourRequest)) return false;
        TourRequest that = (TourRequest) o;
        return getRating() == that.getRating() && Float.compare(that.getPrix(), getPrix()) == 0 && getDuree() == that.getDuree() && Objects.equals(getNom(), that.getNom()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getDesc(), that.getDesc()) && Objects.equals(getItineraire(), that.getItineraire());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom(), getRating(), getDescription(), getDesc(), getPrix(), getDuree(), getItineraire());
    }

    @Override
    public String toString() {
        return "TourRequest{" +
                "nom='" + nom + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", desc='" + desc + '\'' +
                ", prix=" + prix +
                ", duree=" + duree +
                ", itineraire=" + itineraire +
                '}';
    }
}
