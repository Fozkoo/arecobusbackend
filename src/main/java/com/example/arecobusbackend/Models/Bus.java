package com.example.arecobusbackend.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table(name = "bus")
@Getter
@Setter
public class Bus {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idbus")
    private int idbus;
    @Basic
    @Column(name = "numero_linea", nullable = false)
    private Integer numeroLinea;
    @Basic
    @Column(name = "destino", length = 45)
    private String destino;

    @ManyToOne
    @JoinColumn(name = "empresa_idempresa", referencedColumnName = "idempresa",nullable = false)
    private Empresa empresaIdempresa;
    @Basic
    @Column(name = "precio")
    private Integer precio;
    @Basic
    @Column(name = "origen", length = 45)
    private String origen;
    @Basic
    @Column(name = "punto_partida", length = 45)
    private String puntoPartida;
    @Basic
    @Column(name = "image")
    private String image;
    @Basic
    @Column(name = "path")
    private String path;
    @Basic
    @Column(name = "mediosdepago_idmediosdepago")
    private int mediosdepagoIdmediosdepago;
    @OneToMany(mappedBy = "busByBusIdbus")
    private Collection<Recorrido> recorridosByIdbus;

    public Bus() {

    }

    public int getIdbus() {
        return idbus;
    }

    public void setIdbus(int idbus) {
        this.idbus = idbus;
    }

    public Integer getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(int numeroLinea) {
        this.numeroLinea = numeroLinea;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getMediosdepagoIdmediosdepago() {
        return mediosdepagoIdmediosdepago;
    }

    public void setMediosdepagoIdmediosdepago(int mediosdepagoIdmediosdepago) {
        this.mediosdepagoIdmediosdepago = mediosdepagoIdmediosdepago;
    }

    public Collection<Recorrido> getRecorridosByIdbus() {
        return recorridosByIdbus;
    }

    public void setRecorridosByIdbus(Collection<Recorrido> recorridosByIdbus) {
        this.recorridosByIdbus = recorridosByIdbus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bus bus = (Bus) o;

        if (idbus != bus.idbus) return false;
        if (mediosdepagoIdmediosdepago != bus.mediosdepagoIdmediosdepago) return false;
        if (numeroLinea != null ? !numeroLinea.equals(bus.numeroLinea) : bus.numeroLinea != null) return false;
        if (destino != null ? !destino.equals(bus.destino) : bus.destino != null) return false;
        if (empresaIdempresa != null ? !empresaIdempresa.equals(bus.empresaIdempresa) : bus.empresaIdempresa != null)
            return false;
        if (precio != null ? !precio.equals(bus.precio) : bus.precio != null) return false;
        if (origen != null ? !origen.equals(bus.origen) : bus.origen != null) return false;
        if (puntoPartida != null ? !puntoPartida.equals(bus.puntoPartida) : bus.puntoPartida != null) return false;
        if (image != null ? !image.equals(bus.image) : bus.image != null) return false;
        if (path != null ? !path.equals(bus.path) : bus.path != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idbus;
        result = 31 * result + (numeroLinea != null ? numeroLinea.hashCode() : 0);
        result = 31 * result + (destino != null ? destino.hashCode() : 0);
        result = 31 * result + (empresaIdempresa != null ? empresaIdempresa.hashCode() : 0);
        result = 31 * result + (precio != null ? precio.hashCode() : 0);
        result = 31 * result + (origen != null ? origen.hashCode() : 0);
        result = 31 * result + (puntoPartida != null ? puntoPartida.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + mediosdepagoIdmediosdepago;
        return result;
    }

    public Integer getId() {
        return  idbus;
    }
}
