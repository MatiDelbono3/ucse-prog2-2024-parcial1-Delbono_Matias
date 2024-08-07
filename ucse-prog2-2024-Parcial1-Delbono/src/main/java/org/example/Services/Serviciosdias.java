package org.example.Services;

import jakarta.persistence.Query;
import org.example.DTO.diaferiado;
import org.example.DTO.feriado;
import org.example.connections.HibernateUtil;
import org.hibernate.Session;
import org.example.DTO.dia;
import java.util.ArrayList;
import java.util.List;

public class Serviciosdias {
    public int AltaFeriados(int dia, int mes, int anio){
        Session session= HibernateUtil.getSession();
        int diaId = 0;
        List<feriado> AltaFeriados=new ArrayList<>();
        List<diaferiado>R1=new ArrayList<>();
        try{
            session.beginTransaction();
            String sql=("SELECT d.id FROM dias d WHERE d.dia >= :dia AND d.mes >= :mes AND d.año >= :año");
            Query consulta1=session.createQuery(sql)
                    .setParameter("dia", dia)
                    .setParameter("mes", mes)
                    .setParameter("anio", anio);

            diaId = (int) consulta1.getSingleResult();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }


        return diaId;
    };
    public List<dia> DiasFeriadosEntre2Fechas(int diaInicio, int mesInicio , int anioInicio, int diaFin, int mesFin, int anioFin){
        Session session=HibernateUtil.getSession();
        try {
            session.beginTransaction();

            String sql = "SELECT COUNT(f) FROM Feriado f WHERE f.dia.dia = :dia AND f.dia.mes = :mes AND f.dia.año = :año";
        Query query = session.createQuery(sql);
        query.setParameter("dia", diaInicio);
        query.setParameter("mes", mesInicio);
        query.setParameter("año", anioInicio);


        Long count = (Long) query.getSingleResult();
        

        session.getTransaction().commit();
    } catch (Exception e) {
        e.printStackTrace();
        session.getTransaction().rollback();
    } finally {
        session.close();
    }

        return true;
}
    }

        }
