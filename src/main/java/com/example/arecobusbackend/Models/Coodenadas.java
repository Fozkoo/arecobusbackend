package com.example.arecobusbackend.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Coodenadas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcoodenadas")
    private int idcoodenadas;
    @Basic
    @Column(name = "latitud")
    private Double latitud;
    @Basic
    @Column(name = "longitud")
    private Double longitud;
    @Basic
    @Column(name = "referencia")
    private String referencia;

    @ManyToOne
    @JoinColumn(name = "recorrido_idrecorrido", referencedColumnName = "idrecorrido", nullable = false)
    @JsonBackReference
    private Recorrido recorridoByRecorridoIdrecorrido;




    public int getIdcoodenadas() {
        return idcoodenadas;
    }

    public void setIdcoodenadas(int idcoodenadas) {
        this.idcoodenadas = idcoodenadas;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }




    public Recorrido getRecorridoByRecorridoIdrecorrido() {
        return recorridoByRecorridoIdrecorrido;
    }

    public void setRecorridoByRecorridoIdrecorrido(Recorrido recorridoByRecorridoIdrecorrido) {
        this.recorridoByRecorridoIdrecorrido = recorridoByRecorridoIdrecorrido;
    }
}
