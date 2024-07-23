package com.example.arecobusbackend.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;


@Entity
@Table(name = "horarios")
public class Horario {
    @Id
    @Column(name = "idhorarios", nullable = false)
    private Integer id;

    @Column(name = "horario", nullable = false)
    private LocalTime horario;

    @Column(name = "destino", nullable = false, length = 45)
    private String destino;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}