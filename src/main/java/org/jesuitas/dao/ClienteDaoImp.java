package org.jesuitas.dao;

import org.jesuitas.idao.iClienteDao;
import org.jesuitas.models.Cliente;
import org.jesuitas.utils.HibernateUtils;

public class ClienteDaoImp implements iClienteDao {
    @Override
    public Boolean aniadirCliente(Cliente clienteNuevo) {
        try {
            HibernateUtils.initSession();
            HibernateUtils.session.beginTransaction();
            HibernateUtils.session.persist(clienteNuevo);
            HibernateUtils.session.getTransaction().commit();
            return true;
        }catch(Exception e){
            return false;
        }finally {
            HibernateUtils.closeSession();
        }
    }

    @Override
    public Boolean modificarCliente(Cliente clienteModificado) {
        try {
            HibernateUtils.initSession();
            HibernateUtils.session.beginTransaction();
            HibernateUtils.session.merge(clienteModificado);
            HibernateUtils.session.getTransaction().commit();
            return true;
        }catch(Exception e){
            return false;
        }finally {
            HibernateUtils.closeSession();
        }
    }

    @Override
    public Boolean eliminarCliente(Integer codigoCliente) {
        try {
            HibernateUtils.initSession();
            HibernateUtils.session.beginTransaction();
            Cliente c = HibernateUtils.session.get(Cliente.class,codigoCliente);
            HibernateUtils.session.getTransaction().commit();
            HibernateUtils.session.remove(c);
            HibernateUtils.session.getTransaction().commit();
            return true;
        }catch(Exception e){
            return false;
        }finally {
            HibernateUtils.closeSession();
        }
    }

    @Override
    public Cliente getCliente(Integer codigoCliente) {
        HibernateUtils.initSession();
        HibernateUtils.session.beginTransaction();
        Cliente c = HibernateUtils.session.get(Cliente.class,codigoCliente);
        HibernateUtils.session.getTransaction().commit();
        HibernateUtils.closeSession();
        return c;
    }
}
