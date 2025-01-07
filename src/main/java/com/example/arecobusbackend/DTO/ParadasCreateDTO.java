package com.example.arecobusbackend.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ParadasCreateDTO {
    private String longitud;
    private String latitud;
    private String descripcion;
    private String url;
    private int idRecorrido;

    public ParadasCreateDTO(String longitud, String latitud, String descripcion, String url, int idRecorrido) {
        this.longitud = longitud;
        this.latitud = latitud;
        this.descripcion = descripcion;
        this.url = url;
        this.idRecorrido = idRecorrido;
    }
}

