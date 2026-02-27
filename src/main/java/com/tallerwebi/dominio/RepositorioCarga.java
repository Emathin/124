package com.tallerwebi.dominio;

import com.tallerwebi.presentacion.CargaDTO;

public interface RepositorioCarga {

    Carga guardarCarga(Carga carga);

    Double obtenerValorCombustible(TipoCombustible tipoCombustible);
}
