package com.tallerwebi.dominio;

import com.tallerwebi.presentacion.CargaDTO;

public interface ServicioCarga {

    Boolean guardarCarga(CargaDTO cargaDTO);

    CargaDTO calcularPresupuesto(CargaDTO cargaDTO);
}
