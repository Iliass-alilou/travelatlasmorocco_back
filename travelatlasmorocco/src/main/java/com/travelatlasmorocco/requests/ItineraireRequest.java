package com.travelatlasmorocco.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public class ItineraireRequest {

    private int jour;
    private String ville;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItineraireRequest)) return false;
        ItineraireRequest that = (ItineraireRequest) o;
        return getJour() == that.getJour() && Objects.equals(getVille(), that.getVille()) && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getJour(), getVille(), getDescription());
    }

    @Override
    public String toString() {
        return "ItineraireRequest{" +
                "jour=" + jour +
                ", ville='" + ville + '\'' +
                ", descreption='" + description + '\'' +
                '}';
    }
}
