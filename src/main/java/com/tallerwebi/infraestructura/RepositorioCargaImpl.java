package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Carga;
import com.tallerwebi.dominio.RepositorioCarga;
import com.tallerwebi.dominio.TipoCombustible;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCargaImpl implements RepositorioCarga {

    private final SessionFactory sessionFactory;

    @Autowired
    public RepositorioCargaImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Carga guardarCarga(Carga carga) {
        Session session = sessionFactory.getCurrentSession();
        session.save(carga);
        return carga;
    }

    @Override
    public Double obtenerValorCombustible(TipoCombustible tipoCombustible) {
        System.out.println("Buscando combustible: " + tipoCombustible.name()); // Debería imprimir NAFTA
        Session session = sessionFactory.getCurrentSession();
        return (Double) session.createQuery("SELECT c.precio FROM Combustible c WHERE TRIM(c.tipoCombustible) = :tipo")
                .setParameter("tipo", tipoCombustible.name()) // Usamos .name() para asegurar el envío del String
                .uniqueResult();
    }

}
