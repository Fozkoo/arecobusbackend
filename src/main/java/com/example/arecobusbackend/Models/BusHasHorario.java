package com.example.arecobusbackend.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bus_has_horarios")
public class BusHasHorario {
    @EmbeddedId
    private BusHasHorarioId id;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bus_idbus", nullable = false,insertable=false, updatable=false)
    private Bus busIdbus;

    @MapsId("horariosIdhorarios")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "horarios_idhorarios", nullable = false,insertable=false, updatable=false)
    private Horario horariosIdhorarios;

}