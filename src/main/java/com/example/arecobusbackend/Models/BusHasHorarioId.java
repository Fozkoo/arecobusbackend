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
public class BusHasHorarioId implements java.io.Serializable {
    private static final long serialVersionUID = -865170125572780486L;
    @Column(name = "bus_idbus", nullable = false)
    private Integer busIdbus;

    @Column(name = "horarios_idhorarios", nullable = false)
    private Integer horariosIdhorarios;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BusHasHorarioId entity = (BusHasHorarioId) o;
        return Objects.equals(this.busIdbus, entity.busIdbus) &&
                Objects.equals(this.horariosIdhorarios, entity.horariosIdhorarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(busIdbus, horariosIdhorarios);
    }

}