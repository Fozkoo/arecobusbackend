package com.example.arecobusbackend.Models;

import jakarta.persistence.*;

@Entity
public class Paradas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idparadas")
    private int idparadas;
    @Basic
    @Column(name = "logitud")
    private String logitud;
    @Basic
    @Column(name = "latitud")
    private String latitud;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @Basic
    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "recorrido_idrecorrido", referencedColumnName = "idrecorrido", nullable = false)
    private Recorrido recorridoByRecorridoIdrecorrido;

    public int getIdparadas() {
        return idparadas;
    }

    public void setIdparadas(int idparadas) {
        this.idparadas = idparadas;
    }

    public String getLogitud() {
        return logitud;
    }

    public void setLogitud(String logitud) {
        this.logitud = logitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }







    public Recorrido getRecorridoByRecorridoIdrecorrido() {
        return recorridoByRecorridoIdrecorrido;
    }

    public void setRecorridoByRecorridoIdrecorrido(Recorrido recorridoByRecorridoIdrecorrido) {
        this.recorridoByRecorridoIdrecorrido = recorridoByRecorridoIdrecorrido;
    }
}
