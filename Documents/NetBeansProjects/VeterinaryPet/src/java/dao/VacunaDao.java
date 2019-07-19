
package dao;

import entidades.Vacunas;
import interfaces.IVacunas;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilitarios.HibernateUtil;


public class VacunaDao implements IVacunas{
    
     private String hql;
    private Query query;
    private Session session;
    private Transaction transaccion;

    @Override
    public ArrayList<Vacunas> listarVacuna() {
        session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Vacunas> list;
        hql = " from Vacunas";

        query = session.createQuery(hql);
        list = (ArrayList<Vacunas>) query.list();

        session.close();
        return list;
    }

    @Override
    public boolean InsertarVacuna(Vacunas vacunas){
         boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.save(vacunas);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en VacunaDao.InsertarVacuna");
        }

        session.close();
        return respuesta;
    }

    @Override
    public boolean GuardarVacuna(Vacunas vacunas) {
        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.update(vacunas);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en VacunaDao.GuardarVacuna");
        }

        session.close();
        return respuesta;
    }

    @Override
    public boolean EliminarVacuna(Vacunas vacunas) {
         boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.delete(vacunas);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en VacunaDao.EliminarVacuna");
        }

        session.close();
        return respuesta;
    }


}
