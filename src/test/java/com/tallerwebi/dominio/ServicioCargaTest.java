package com.tallerwebi.dominio;

import com.tallerwebi.presentacion.CargaDTO;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
public class ServicioCargaTest {

    @Mock
    private RepositorioCarga repositorioCarga;

    @InjectMocks
    private ServicioCargaImpl servicioCarga;


    @Test
    public void queGuardeUnaCarga(){
        CargaDTO cargaDTO=new CargaDTO(10.00, TipoCombustible.NAFTA,10.00);

        Carga carga2=new Carga(10.00, TipoCombustible.NAFTA,10.00, LocalDateTime.now());
        carga2.setId(1L);

        when(repositorioCarga.guardarCarga(any(Carga.class))).thenReturn(carga2);

        Boolean resultado=servicioCarga.guardarCarga(cargaDTO);
        assertThat(resultado, Matchers.is(true));
        verify(repositorioCarga,times(1)).guardarCarga(any(Carga.class));
    }

    @Test
    public void queNoGuardeUnaCarga(){
        CargaDTO cargaDTO=new CargaDTO(10.00, TipoCombustible.NAFTA,10.00);

        Carga carga2=new Carga(10.00, TipoCombustible.NAFTA,10.00, LocalDateTime.now());

        when(repositorioCarga.guardarCarga(any(Carga.class))).thenReturn(carga2);

        Boolean resultado=servicioCarga.guardarCarga(cargaDTO);
        assertThat(resultado, Matchers.is(false));
        verify(repositorioCarga,times(1)).guardarCarga(any(Carga.class));
    }


    @Test
    public void queSePuedaCalcularUnPresupuesto(){
        CargaDTO cargaDTO=new CargaDTO(10.00, TipoCombustible.NAFTA,10.00);

        when(repositorioCarga.obtenerValorCombustible(any(TipoCombustible.class))).thenReturn(100.00);

        CargaDTO resultado=servicioCarga.calcularPresupuesto(cargaDTO);

        assertThat(resultado.getPresupuesto(), Matchers.is(1000.00));
        verify(repositorioCarga,times(1)).obtenerValorCombustible(any(TipoCombustible.class));
    }

    @Test
    public void queSePuedaObtenerElHistorialDeCargas(){

        Carga carga=new Carga(10.00, TipoCombustible.NAFTA,10.00,LocalDateTime.now());
        List<Carga> listaDeCargas=new ArrayList<>();
        listaDeCargas.add(carga);

        when(repositorioCarga.obtenerHistorialDeCargas()).thenReturn(listaDeCargas);

        List<CargaDTO> historial=servicioCarga.obtenerHistorialDeCargas();


        MatcherAssert.assertThat(historial.size(),is(1));
        assertThat(historial.get(0),is(instanceOf(Carga.class)));
        assertThat(historial.get(0),is(notNullValue()));
        verify(repositorioCarga,times(1)).obtenerHistorialDeCargas();




    }
}
