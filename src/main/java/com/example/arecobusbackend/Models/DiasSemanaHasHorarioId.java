package com.example.arecobusbackend.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class DiasSemanaHasHorarioId implements java.io.Serializable {
    private static final long serialVersionUID = 8279019669864315033L;
    @Column(name = "dias_semana_iddias_semana", nullable = false)
    private Integer diasSemanaIddiasSemana;

    @Column(name = "horarios_idhorarios", nullable = false)
    private Integer horariosIdhorarios;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DiasSemanaHasHorarioId entity = (DiasSemanaHasHorarioId) o;
        return Objects.equals(this.diasSemanaIddiasSemana, entity.diasSemanaIddiasSemana) &&
                Objects.equals(this.horariosIdhorarios, entity.horariosIdhorarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(diasSemanaIddiasSemana, horariosIdhorarios);
    }

}