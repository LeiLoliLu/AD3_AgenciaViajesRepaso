package org.jesuitas.repositories;

import org.jesuitas.dao.ClienteDaoImp;
import org.jesuitas.dao.ReservaDaoImp;
import org.jesuitas.dao.ViajeDaoImp;
import org.jesuitas.idao.iReservaRepo;
import org.jesuitas.models.Cliente;
import org.jesuitas.models.Reserva;
import org.jesuitas.utils.HibernateUtils;

public class ReservaRepoImp implements iReservaRepo {

    public Boolean nuevaReserva(Integer codViaje, Integer codCliente) {
        try {
            Reserva r = new Reserva();

            ViajeDaoImp vdi = new ViajeDaoImp();
            r.setViaje(vdi.getViaje(codViaje));

            ClienteDaoImp cdi = new ClienteDaoImp();
            r.setCliente(cdi.getCliente(codCliente));

            r.setEstado("No Confirmada");

            HibernateUtils.initSession();
            HibernateUtils.session.beginTransaction();
            HibernateUtils.session.persist(r);
            HibernateUtils.session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            HibernateUtils.closeSession();
        }
    }
}
