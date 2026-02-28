package com.tallerwebi.dominio;

import com.tallerwebi.presentacion.CargaDTO;

import java.util.List;

public interface RepositorioCarga {

    Carga guardarCarga(Carga carga);

    Double obtenerValorCombustible(TipoCombustible tipoCombustible);

    List<Carga> obtenerHistorialDeCargas();
}
