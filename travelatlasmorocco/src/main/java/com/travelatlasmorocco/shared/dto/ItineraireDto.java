package com.travelatlasmorocco.shared.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class ItineraireDto {
    private long id;
    private String iteneraireId;
    private int jour;
    private String ville;
    private String description;
    private TourDto tour;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItineraireDto)) return false;
        ItineraireDto that = (ItineraireDto) o;
        return getId() == that.getId() && getJour() == that.getJour() && Objects.equals(getIteneraireId(), that.getIteneraireId()) && Objects.equals(getVille(), that.getVille()) && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIteneraireId(), getJour(), getVille(), getDescription());
    }

    @Override
    public String toString() {
        return "ItineraireDto{" +
                "id=" + id +
                ", iteneraireId='" + iteneraireId + '\'' +
                ", jour=" + jour +
                ", ville='" + ville + '\'' +
                ", descreption='" + description + '\'' +
                '}';
    }
}
