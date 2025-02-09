package org.jesuitas.repositories;

import org.jesuitas.dao.CatalogoDaoImp;
import org.jesuitas.dao.ClienteDaoImp;
import org.jesuitas.dao.ViajeDaoImp;
import org.jesuitas.idao.iReservaRepo;
import org.jesuitas.idao.iViajeRepo;
import org.jesuitas.models.Reserva;
import org.jesuitas.models.Viaje;
import org.jesuitas.utils.HibernateUtils;

public class ViajeRepoImp implements iViajeRepo {

    @Override
    public Boolean nuevoViaje(Viaje v, Integer idCatalogo) {
        try {
            CatalogoDaoImp cdi = new CatalogoDaoImp();
            v.setCatalogo(cdi.getCatalogo(idCatalogo));
            HibernateUtils.initSession();
            HibernateUtils.session.beginTransaction();
            HibernateUtils.session.persist(v);
            HibernateUtils.session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            HibernateUtils.closeSession();
        }
    }
}
