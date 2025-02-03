package org.jesuitas.dao;

import org.jesuitas.idao.iReservaDao;
import org.jesuitas.models.Cliente;
import org.jesuitas.models.Reserva;
import org.jesuitas.utils.HibernateUtils;

public class ReservaDaoImp implements iReservaDao {
    public Boolean confirmarReserva(Integer idReserva) {
        try {
            ReservaDaoImp rdi = new ReservaDaoImp();
            Reserva r = HibernateUtils.session.get(Reserva.class,idReserva);
            r.setEstado("Confirmada");

            HibernateUtils.initSession();
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
            HibernateUtils.session.getTransaction().commit();
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
