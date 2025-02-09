package org.jesuitas.dao;

import org.jesuitas.idao.iCatalogoDao;
import org.jesuitas.models.Catalogo;
import org.jesuitas.utils.HibernateUtils;

public class CatalogoDaoImp implements iCatalogoDao {
    @Override
    public Boolean nuevoCatalogo(Catalogo c) {
        try {
            HibernateUtils.initSession();
            HibernateUtils.session.beginTransaction();
            HibernateUtils.session.persist(c);
            HibernateUtils.session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            HibernateUtils.closeSession();
        }
    }

    @Override
    public Catalogo getCatalogo(Integer idCatalogo) {
        HibernateUtils.initSession();
        HibernateUtils.session.beginTransaction();
        Catalogo c = HibernateUtils.session.get(Catalogo.class,idCatalogo);
        HibernateUtils.session.getTransaction().commit();
        HibernateUtils.closeSession();
        return c;
    }
}
