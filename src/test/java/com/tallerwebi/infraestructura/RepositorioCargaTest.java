package com.tallerwebi.infraestructura;

import com.tallerwebi.config.HibernateConfig;
import com.tallerwebi.config.SpringWebConfig;
import com.tallerwebi.dominio.Carga;
import com.tallerwebi.dominio.RepositorioCarga;
import com.tallerwebi.dominio.TipoCombustible;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

@ExtendWith(SpringExtension.class)
@Transactional
@ContextConfiguration(classes = {HibernateConfig.class,SpringWebConfig.class})
@WebAppConfiguration
public class RepositorioCargaTest {

    @Autowired
    private RepositorioCarga repositorioCarga;

    @Test
    public void queGuardeUnaCarga(){
        Carga carga=new Carga(10.00, TipoCombustible.nafta,10.00, LocalDateTime.now());
        Carga cargaRecibida = repositorioCarga.guardarCarga(carga);
        assertThat(cargaRecibida.getId(),notNullValue());
    }




}
