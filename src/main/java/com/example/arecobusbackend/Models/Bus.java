package com.example.arecobusbackend.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bus")
@Getter
@Setter
public class Bus {
    @Id
    @Column(name = "idbus", nullable = false)
    private Integer id;

    @Column(name = "numero_linea", nullable = false)
    private Integer numeroLinea;

    @Column(name = "destino", length = 45)
    private String destino;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empresa_idempresa", nullable = false)
    private Empresa empresaIdempresa;

    @Column(name = "precio")
    private Integer precio;

    @Column(name = "origen", length = 45)
    private String origen;

    @Column(name = "punto_partida", length = 45)
    private String puntoPartida;

    @Column(name = "image")
    private String image;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(Integer numeroLinea) {
        this.numeroLinea = numeroLinea;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Empresa getEmpresaIdempresa() {
        return empresaIdempresa;
    }

    public void setEmpresaIdempresa(Empresa empresaIdempresa) {
        this.empresaIdempresa = empresaIdempresa;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getPuntoPartida() {
        return puntoPartida;
    }

    public void setPuntoPartida(String puntoPartida) {
        this.puntoPartida = puntoPartida;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
