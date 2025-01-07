package com.example.arecobusbackend.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParadasDTO {
    private int idparadas;
    private String logitud;
    private String latitud;
    private String descripcion;
    private String url;
    private int idRecorrido;

    public ParadasDTO(int idparadas, String logitud, String latitud, String descripcion, String url, int idRecorrido) {
        this.idparadas = idparadas;
        this.logitud = logitud;
        this.latitud = latitud;
        this.descripcion = descripcion;
        this.url = url;
        this.idRecorrido = idRecorrido;
    }

}