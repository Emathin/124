package com.tallerwebi.dominio;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Carga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     private double litrosCargados;
    @Enumerated(EnumType.STRING)
     private TipoCombustible tipoCombustible;
     private double precioPagado;
     private LocalDateTime fechaCarga;

    public Carga(double litrosCargados, TipoCombustible tipoCombustible, double precioPagado, LocalDateTime fechaCarga) {
        this.litrosCargados = litrosCargados;
        this.tipoCombustible = tipoCombustible;
        this.precioPagado = precioPagado;
        this.fechaCarga = fechaCarga;
    }

    public Carga() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLitrosCargados() {
        return litrosCargados;
    }

    public void setLitrosCargados(double litrosCargados) {
        this.litrosCargados = litrosCargados;
    }

    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(TipoCombustible tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public double getPrecioPagado() {
        return precioPagado;
    }

    public void setPrecioPagado(double precioPagado) {
        this.precioPagado = precioPagado;
    }

    public LocalDateTime getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(LocalDateTime fechaCarga) {
        this.fechaCarga = fechaCarga;
    }
}
