package com.example.arecobusbackend.Models;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
public class Puntosube {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpuntosube")
    private int idpuntosube;
    @Basic
    @Column(name = "longitud")
    private Double longitud;
    @Basic
    @Column(name = "latitud")
    private Double latitud;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @Basic
    @Column(name = "urlimagen")
    private String urlimagen;
    @Basic
    @Column(name = "horariosapertura")
    private Time horariosapertura;
    @Basic
    @Column(name = "horariocierre")
    private Time horariocierre;

    public int getIdpuntosube() {
        return idpuntosube;
    }

    public void setIdpuntosube(int idpuntosube) {
        this.idpuntosube = idpuntosube;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlimagen() {
        return urlimagen;
    }

    public void setUrlimagen(String urlimagen) {
        this.urlimagen = urlimagen;
    }

    public Time getHorariosapertura() {
        return horariosapertura;
    }

    public void setHorariosapertura(Time horariosapertura) {
        this.horariosapertura = horariosapertura;
    }

    public Time getHorariocierre() {
        return horariocierre;
    }

    public void setHorariocierre(Time horariocierre) {
        this.horariocierre = horariocierre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Puntosube puntosube = (Puntosube) o;

        if (idpuntosube != puntosube.idpuntosube) return false;
        if (longitud != null ? !longitud.equals(puntosube.longitud) : puntosube.longitud != null) return false;
        if (latitud != null ? !latitud.equals(puntosube.latitud) : puntosube.latitud != null) return false;
        if (descripcion != null ? !descripcion.equals(puntosube.descripcion) : puntosube.descripcion != null)
            return false;
        if (urlimagen != null ? !urlimagen.equals(puntosube.urlimagen) : puntosube.urlimagen != null) return false;
        if (horariosapertura != null ? !horariosapertura.equals(puntosube.horariosapertura) : puntosube.horariosapertura != null)
            return false;
        if (horariocierre != null ? !horariocierre.equals(puntosube.horariocierre) : puntosube.horariocierre != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpuntosube;
        result = 31 * result + (longitud != null ? longitud.hashCode() : 0);
        result = 31 * result + (latitud != null ? latitud.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (urlimagen != null ? urlimagen.hashCode() : 0);
        result = 31 * result + (horariosapertura != null ? horariosapertura.hashCode() : 0);
        result = 31 * result + (horariocierre != null ? horariocierre.hashCode() : 0);
        return result;
    }
}
