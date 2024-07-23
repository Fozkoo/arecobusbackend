package com.example.arecobusbackend.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "dias_semana_has_horarios")
public class DiasSemanaHasHorario {
    @EmbeddedId
    private DiasSemanaHasHorarioId id;

    @MapsId("diasSemanaIddiasSemana")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dias_semana_iddias_semana", nullable = false)
    private DiasSemana diasSemanaIddiasSemana;

    @MapsId("horariosIdhorarios")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "horarios_idhorarios", nullable = false)
    private Horario horariosIdhorarios;

}