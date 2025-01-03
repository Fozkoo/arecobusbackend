package com.example.arecobusbackend.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoordenadasDTO {
    private int id;
    private double latitud;
    private double longitud;
    private String referencia;
    private int recorridoId;
}
