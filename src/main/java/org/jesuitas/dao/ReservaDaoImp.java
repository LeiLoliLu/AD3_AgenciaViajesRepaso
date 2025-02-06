package org.jesuitas.dao;

import org.jesuitas.idao.iReservaDao;
import org.jesuitas.models.Reserva;
import org.jesuitas.utils.HibernateUtils;

public class ReservaDaoImp implements iReservaDao {
    public Boolean confirmarReserva(Integer idReserva) {
        try {
            HibernateUtils.initSession();
            Reserva r = HibernateUtils.session.get(Reserva.class,idReserva);
            r.setEstado("Confirmada");
            HibernateUtils.session.beginTransaction();
            HibernateUtils.session.merge(r);
            HibernateUtils.session.getTransaction().commit();
            return true;
        }catch(Exception e){
            return false;
        }finally {
            HibernateUtils.closeSession();
        }
    }

    public Boolean eliminarReserva(Integer codigoReserva) {
        try {
            HibernateUtils.initSession();
            HibernateUtils.session.beginTransaction();
            Reserva r = HibernateUtils.session.get(Reserva.class,codigoReserva);
            HibernateUtils.session.remove(r);
            HibernateUtils.session.getTransaction().commit();
            return true;
        }catch(Exception e){
            return false;
        }finally {
            HibernateUtils.closeSession();
        }
    }
}
