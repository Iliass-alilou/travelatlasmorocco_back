package com.travelatlasmorocco.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItineraireResponse {
    private String iteneraireId;
    private int jour;
    private String ville;
    private String description;
}
