package com.tallerwebi.dominio;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Carga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     private Double litrosCargados;
    @Enumerated(EnumType.STRING)
     private TipoCombustible tipoCombustible;
     private Double precioPagado;
     private LocalDateTime fechaCarga;

    public Carga(Double litrosCargados, TipoCombustible tipoCombustible, Double precioPagado, LocalDateTime fechaCarga) {
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

    public Double getlitrosCargados() {
        return litrosCargados;
    }

    public void setlitrosCargados(Double litrosCargados) {
        this.litrosCargados = litrosCargados;
    }

    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(TipoCombustible tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public Double getPrecioPagado() {
        return precioPagado;
    }

    public void setPrecioPagado(Double precioPagado) {
        this.precioPagado = precioPagado;
    }

    public LocalDateTime getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(LocalDateTime fechaCarga) {
        this.fechaCarga = fechaCarga;
    }
}
