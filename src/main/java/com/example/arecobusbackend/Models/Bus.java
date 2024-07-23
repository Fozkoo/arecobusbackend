package com.example.arecobusbackend.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "bus")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}