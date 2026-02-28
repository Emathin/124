package com.tallerwebi.dominio;

import com.tallerwebi.presentacion.CargaDTO;

import java.util.List;

public interface ServicioCarga {

    Boolean guardarCarga(CargaDTO cargaDTO);

    CargaDTO calcularPresupuesto(CargaDTO cargaDTO);

    List<CargaDTO> obtenerHistorialDeCargas();
}
