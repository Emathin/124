package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.TipoCombustible;

import java.time.LocalDateTime;

public class CargaDTO {


     private Double litrosCargados;
     private TipoCombustible tipoCombustible;
     private Double precioPagado;
     private LocalDateTime fechaCarga;
    private Double presupuesto;

    public CargaDTO(Double litrosCargados, TipoCombustible tipoCombustible, Double precioPagado){

        this.litrosCargados = litrosCargados;
        this.tipoCombustible = tipoCombustible;
        this.precioPagado = precioPagado;
        this.fechaCarga = LocalDateTime.now();
    }

    public CargaDTO() {

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

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }


}
