package com.tallerwebi.dominio;

import javax.persistence.*;

@Entity
public class Combustible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoCombustible tipoCombustible;
    private double precio;

    public Combustible(TipoCombustible tipoCombustible, double precio) {
        this.tipoCombustible = tipoCombustible;
        this.precio = precio;
    }

    public Combustible() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(TipoCombustible tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}