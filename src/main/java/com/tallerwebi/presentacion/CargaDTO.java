package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.TipoCombustible;

import java.time.LocalDateTime;

public class CargaDTO {


     private double LitrosCargados;
     private TipoCombustible tipoCombustible;
     private double precioPagado;
     private LocalDateTime fechaCarga;
    private Double presupuesto;

    public CargaDTO(double LitrosCargados, TipoCombustible tipoCombustible, double precioPagado, LocalDateTime fechaCarga){

        this.LitrosCargados = LitrosCargados;
        this.tipoCombustible = tipoCombustible;
        this.precioPagado = precioPagado;
        this.fechaCarga = fechaCarga;
    }

    public CargaDTO() {

    }

    public double getLitrosCargados() {
        return LitrosCargados;
    }

    public void setLitrosCargados(double litrosCargados) {
        this.LitrosCargados = litrosCargados;
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

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }


}
