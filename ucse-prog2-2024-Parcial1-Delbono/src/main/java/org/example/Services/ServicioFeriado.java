package org.example.Services;
import jakarta.persistence.Query;
import org.example.DTO.*;
import org.example.entities.*;
import org.example.connections.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ServicioFeriado {
    public boolean guardarFeriado(feriado feriado) {
        Session session = HibernateUtil.getSession();
        boolean guardado= false;

        try {
            session.beginTransaction();
            session.save(feriado);
            session.getTransaction().commit();
            guardado = true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return guardado;
    }
    public boolean esFeriado(int dia, int mes, int año) {
        Session session = HibernateUtil.getSession();
        boolean esFeriado = false;

        try {
            session.beginTransaction();

            String hql = "SELECT COUNT(f) FROM Feriado f WHERE f.dia.dia = :dia AND f.dia.mes = :mes AND f.dia.año = :año";
            Query consulta2 = session.createQuery(hql);
            consulta2.setParameter("dia", dia);
            consulta2.setParameter("mes", mes);
            consulta2.setParameter("año", año);

            Long count = (Long) consulta2.getSingleResult();
            esFeriado = (count != null && count > 0);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return esFeriado;
    }
}
