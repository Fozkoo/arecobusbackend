package com.example.arecobusbackend.DTO;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PuntosubeDTO {
    private int idpuntosube;
    private List<String> geocode; // Usamos String para las coordenadas
    private String descripcion;
    private String urlimagen;
    private Time horariosapertura;
    private Time horariocierre;
    private String nombre;

    // Constructor, getters y setters

    public PuntosubeDTO(int idpuntosube, String longitud, String latitud, String descripcion, String urlimagen, Time horariosapertura, Time horariocierre, String nombre) {
        this.idpuntosube = idpuntosube;
        this.geocode = new ArrayList<>();
        this.geocode.add(longitud);  // Guardamos como String
        this.geocode.add(latitud);   // Guardamos como String
        this.descripcion = descripcion;
        this.urlimagen = urlimagen;
        this.horariosapertura = horariosapertura;
        this.horariocierre = horariocierre;
        this.nombre = nombre;
    }

    // Getters y setters
}

