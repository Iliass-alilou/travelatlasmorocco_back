package com.travelatlasmorocco.shared.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class TourDto {
    private long id;
    private String tourId;
    private int rating;
    private String nom;
    private String description;
    private String desc;
    private float prix;
    private int duree;
    private List<ItineraireDto> itineraire;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TourDto)) return false;
        TourDto tourDto = (TourDto) o;
        return getId() == tourDto.getId() && getRating() == tourDto.getRating() && Float.compare(tourDto.getPrix(), getPrix()) == 0 && getDuree() == tourDto.getDuree() && Objects.equals(getTourId(), tourDto.getTourId()) && Objects.equals(getNom(), tourDto.getNom()) && Objects.equals(getDescription(), tourDto.getDescription()) && Objects.equals(getDesc(), tourDto.getDesc()) && Objects.equals(getItineraire(), tourDto.getItineraire());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTourId(), getRating(), getNom(), getDescription(), getDesc(), getPrix(), getDuree(), getItineraire());
    }

    @Override
    public String toString() {
        return "TourDto{" +
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
