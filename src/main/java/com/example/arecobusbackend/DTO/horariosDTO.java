package com.example.arecobusbackend.DTO;

import java.util.List;

public class horariosDTO {
    private int id;
    private int numeroLinea;
    private String destino;
    private String puntoPartida;
    private String empresaNombre;
    private int precio;
    private String image;
    private String path;
    private String origen; // Si está presente
    private List<String> horarios;

    // Constructor que acepta la lista de horarios
    public horariosDTO(int id, int numeroLinea, String destino, String puntoPartida, String empresaNombre,
                       int precio, String image, String path, String origen, List<String> horarios) {
        this.id = id;
        this.numeroLinea = numeroLinea;
        this.destino = destino;
        this.puntoPartida = puntoPartida;
        this.empresaNombre = empresaNombre;
        this.precio = precio;
        this.image = image;
        this.path = path;
        this.origen = origen; // Si está presente
        this.horarios = horarios;
    }

    // Getters y setters...


    // Getters y Setters

    public String getOrigen(){ return origen;}

    public void setOrigen(String origen){ this.origen = origen;}


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

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getPuntoPartida() {
        return puntoPartida;
    }

    public void setPuntoPartida(String puntoPartida) {
        this.puntoPartida = puntoPartida;
    }

    public String getEmpresaNombre() {
        return empresaNombre;
    }

    public void setEmpresaNombre(String empresaNombre) {
        this.empresaNombre = empresaNombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<String> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<String> horarios) {
        this.horarios = horarios;
    }
}
