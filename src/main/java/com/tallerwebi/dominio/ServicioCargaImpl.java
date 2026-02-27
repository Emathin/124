package com.tallerwebi.dominio;

import com.tallerwebi.presentacion.CargaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicioCargaImpl implements ServicioCarga{

    private final RepositorioCarga repositorioCarga;

    @Autowired
    public ServicioCargaImpl(RepositorioCarga repositorioCarga) {
        this.repositorioCarga = repositorioCarga;
    }


    @Override

    public Boolean guardarCarga(CargaDTO cargaDTO) {

        Carga carga=new Carga(cargaDTO.getLitrosCargados(),cargaDTO.getTipoCombustible(),cargaDTO.getPrecioPagado(),cargaDTO.getFechaCarga());
        Carga carga2=repositorioCarga.guardarCarga(carga);
        if(carga2.getId()!=null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public CargaDTO calcularPresupuesto(CargaDTO cargaDTO) {
        Double valorCombustible=repositorioCarga.obtenerValorCombustible(cargaDTO.getTipoCombustible());
        Double precioPresupuestado=valorCombustible*cargaDTO.getLitrosCargados();
        cargaDTO.setPresupuesto(precioPresupuestado);
        return cargaDTO;
    }


}
