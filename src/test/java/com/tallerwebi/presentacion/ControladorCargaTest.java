package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioCarga;
import com.tallerwebi.dominio.TipoCombustible;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ControladorCargaTest {


    @Mock
    private ServicioCarga servicioCarga;

    @InjectMocks
    private ControladorCarga controladorCarga;

    @Test
    public void queObtenaMensajeExitosoSiLaCargaFueExitosa(){

        CargaDTO cargaDTO=new CargaDTO(10.00, TipoCombustible.NAFTA,500.00);

        when(servicioCarga.guardarCarga(any(CargaDTO.class))).thenReturn(true);

        ModelAndView mav=controladorCarga.guardarCarga(cargaDTO);

        assertThat(mav.getViewName(),is("respuestaDeCarga"));
        assertThat(mav.getModel().get("mensaje"),is("Carga exitosa"));

    }

    @Test
    public void queObtenaMensajeFallidoSiLaCargaFueExitosa(){

        CargaDTO cargaDTO=new CargaDTO(10.00, null,10.00);

        when(servicioCarga.guardarCarga(any(CargaDTO.class))).thenReturn(false);

        ModelAndView mav=controladorCarga.guardarCarga(cargaDTO);

        assertThat(mav.getViewName(),is("respuestaDeCarga"));

        assertThat(mav.getModel().get("mensaje"),is("Carga fallida"));

    }

    @Test
    public void queSePuedaCalcularUnPresupuesto(){
        CargaDTO cargaDTO=new CargaDTO(10.00, TipoCombustible.NAFTA,10.00);
        CargaDTO cargaDTOPresupuestada=new CargaDTO(cargaDTO.getlitrosCargados(),
                cargaDTO.getTipoCombustible(),cargaDTO.getPrecioPagado());
        cargaDTOPresupuestada.setPresupuesto(100.00);

        when(servicioCarga.calcularPresupuesto(any(CargaDTO.class))).thenReturn(cargaDTOPresupuestada);

        ModelAndView mav=controladorCarga.calcularPresupuesto(cargaDTO);

        assertThat(mav.getViewName(),is("cargarCombustible"));

    }


}
