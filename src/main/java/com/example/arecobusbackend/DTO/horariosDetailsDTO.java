package com.example.arecobusbackend.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class horariosDetailsDTO {
    private int id;
    private int numeroLinea;
    private List<String> horarios;


    public horariosDetailsDTO(int id, int numeroLinea, List<String> horarios) {
        this.id = id;
        this.numeroLinea = numeroLinea;
        this.horarios = horarios;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(int numeroLinea) {
        this.numeroLinea = numeroLinea;
    }

    public List<String> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<String> horarios) {
        this.horarios = horarios;
    }
}



