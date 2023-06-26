package com.travelatlasmorocco.responses;

import com.travelatlasmorocco.entities.ItineraireEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Setter
@Getter
public class TourResponse {
    private String tourId;
    private String nom;
    private int rating;
    private String description;
    private String desc;
    private float prix;
    private int duree;
    private List<ItineraireResponse> itineraire;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TourResponse)) return false;
        TourResponse that = (TourResponse) o;
        return getRating() == that.getRating() && Float.compare(that.getPrix(), getPrix()) == 0 && getDuree() == that.getDuree() && Objects.equals(getTourId(), that.getTourId()) && Objects.equals(getNom(), that.getNom()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getDesc(), that.getDesc()) && Objects.equals(getItineraire(), that.getItineraire());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTourId(), getNom(), getRating(), getDescription(), getDesc(), getPrix(), getDuree(), getItineraire());
    }

    @Override
    public String toString() {
        return "TourResponse{" +
                "tourId='" + tourId + '\'' +
                ", nom='" + nom + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", desc='" + desc + '\'' +
                ", prix=" + prix +
                ", duree=" + duree +
                ", itineraire=" + itineraire +
                '}';
    }
}
