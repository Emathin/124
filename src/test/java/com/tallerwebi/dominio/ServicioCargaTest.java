package com.tallerwebi.dominio;

import com.tallerwebi.presentacion.CargaDTO;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
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
        CargaDTO cargaDTO=new CargaDTO(10.00, TipoCombustible.nafta,10.00, LocalDateTime.now());

        Carga carga2=new Carga(10.00, TipoCombustible.nafta,10.00, LocalDateTime.now());
        carga2.setId(1L);

        when(repositorioCarga.guardarCarga(any(Carga.class))).thenReturn(carga2);

        Boolean resultado=servicioCarga.guardarCarga(cargaDTO);
        assertThat(resultado, Matchers.is(true));
        verify(repositorioCarga,times(1)).guardarCarga(any(Carga.class));
    }

    @Test
    public void queNoGuardeUnaCarga(){
        CargaDTO cargaDTO=new CargaDTO(10.00, TipoCombustible.nafta,10.00, LocalDateTime.now());

        Carga carga2=new Carga(10.00, TipoCombustible.nafta,10.00, LocalDateTime.now());

        when(repositorioCarga.guardarCarga(any(Carga.class))).thenReturn(carga2);

        Boolean resultado=servicioCarga.guardarCarga(cargaDTO);
        assertThat(resultado, Matchers.is(false));
        verify(repositorioCarga,times(1)).guardarCarga(any(Carga.class));
    }


}
