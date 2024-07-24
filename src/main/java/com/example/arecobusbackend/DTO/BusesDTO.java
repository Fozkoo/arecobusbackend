package com.example.arecobusbackend.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusesDTO {
    private Integer id;
    private Integer numeroLinea;
    private String destino;
    private String empresaNombre;
    private Integer precio;
    private String origen;
    private String puntoPartida;
    private String image;
}
