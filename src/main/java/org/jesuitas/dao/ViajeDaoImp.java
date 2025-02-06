package org.jesuitas.dao;

import org.jesuitas.idao.iViajeDao;
import org.jesuitas.models.Viaje;
import org.jesuitas.utils.HibernateUtils;

public class ViajeDaoImp implements iViajeDao {
    @Override
    public Viaje getViaje(Integer idViaje) {
        HibernateUtils.initSession();
        HibernateUtils.session.beginTransaction();
        Viaje v = HibernateUtils.session.get(Viaje.class,idViaje);
        HibernateUtils.session.getTransaction().commit();
        HibernateUtils.closeSession();
        return v;
    }

    @Override
    public Boolean eliminarViaje(Viaje v) {
        try {
            HibernateUtils.initSession();
            HibernateUtils.session.beginTransaction();
            HibernateUtils.session.remove(v);
            HibernateUtils.session.getTransaction().commit();
            return true;
        }catch(Exception e){
            return false;
        }finally {
            HibernateUtils.closeSession();
        }
    }
}
