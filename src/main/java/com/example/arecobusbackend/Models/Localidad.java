package com.example.arecobusbackend.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "localidad")
public class Localidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlocalidad", nullable = false)
    private Integer idlocalidad;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "latitud")
    private String latitud;

    @Column(name = "longitud")
    private String longitud;

    @Column(name = "acronimo", length = 45)
    private String acronimo;

    @Column(name = "provincia", length = 45)
    private String provincia;

}