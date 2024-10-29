package com.example.arecobusbackend.Models;

import jakarta.persistence.*;

@Entity
public class Mediosdepago {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idmediosdepago")
    private int idmediosdepago;
    @Basic
    @Column(name = "tipo")
    private String tipo;

    public int getIdmediosdepago() {
        return idmediosdepago;
    }

    public void setIdmediosdepago(int idmediosdepago) {
        this.idmediosdepago = idmediosdepago;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mediosdepago that = (Mediosdepago) o;

        if (idmediosdepago != that.idmediosdepago) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idmediosdepago;
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        return result;
    }
}
