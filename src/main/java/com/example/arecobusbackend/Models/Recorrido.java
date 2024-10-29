package com.example.arecobusbackend.Models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Recorrido {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idrecorrido")
    private int idrecorrido;
    @Basic
    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "recorridoByRecorridoIdrecorrido")
    private Collection<Coodenadas> coodenadasByIdrecorrido;
    @OneToMany(mappedBy = "recorridoByRecorridoIdrecorrido")
    private Collection<Paradas> paradasByIdrecorrido;
    @ManyToOne
    @JoinColumn(name = "bus_idbus", referencedColumnName = "idbus", nullable = false)
    private Bus busByBusIdbus;

    public int getIdrecorrido() {
        return idrecorrido;
    }

    public void setIdrecorrido(int idrecorrido) {
        this.idrecorrido = idrecorrido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }









    public Collection<Coodenadas> getCoodenadasByIdrecorrido() {
        return coodenadasByIdrecorrido;
    }

    public void setCoodenadasByIdrecorrido(Collection<Coodenadas> coodenadasByIdrecorrido) {
        this.coodenadasByIdrecorrido = coodenadasByIdrecorrido;
    }

    public Collection<Paradas> getParadasByIdrecorrido() {
        return paradasByIdrecorrido;
    }

    public void setParadasByIdrecorrido(Collection<Paradas> paradasByIdrecorrido) {
        this.paradasByIdrecorrido = paradasByIdrecorrido;
    }

    public Bus getBusByBusIdbus() {
        return busByBusIdbus;
    }

    public void setBusByBusIdbus(Bus busByBusIdbus) {
        this.busByBusIdbus = busByBusIdbus;
    }
}
