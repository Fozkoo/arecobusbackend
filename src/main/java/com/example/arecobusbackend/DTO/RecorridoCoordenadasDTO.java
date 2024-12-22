package com.example.arecobusbackend.DTO;

import java.util.List;

public class RecorridoCoordenadasDTO {
    private int idrecorrido;
    private List<List<Double>> coordenadas;

    // Getters y Setters

    public int getIdrecorrido() {
        return idrecorrido;
    }

    public void setIdrecorrido(int idrecorrido) {
        this.idrecorrido = idrecorrido;
    }

    public List<List<Double>> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(List<List<Double>> coordenadas) {
        this.coordenadas = coordenadas;
    }
}
