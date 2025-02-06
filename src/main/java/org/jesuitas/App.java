package org.jesuitas;

import org.jesuitas.dao.CatalogoDaoImp;
import org.jesuitas.dao.ClienteDaoImp;
import org.jesuitas.dao.ReservaDaoImp;
import org.jesuitas.dao.ViajeDaoImp;
import org.jesuitas.models.Catalogo;
import org.jesuitas.models.Cliente;
import org.jesuitas.models.Viaje;
import org.jesuitas.repositories.ReservaRepoImp;
import org.jesuitas.repositories.ViajeRepoImp;
import org.jesuitas.utils.HibernateUtils;

import java.sql.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //HibernateUtils.initSession();
        //HibernateUtils.closeSession();

        ClienteDaoImp clienteDao = new ClienteDaoImp();

        Cliente c = new Cliente();
        c.setCodigo(1);
        c.setNombre("Pepito");
        c.setTlf("PepitoPhone");
        c.setDireccion("PepitoHome");

        clienteDao.aniadirCliente(c);
        Cliente clienteObtenido = clienteDao.getCliente(1);
        System.out.println(clienteObtenido);

        c.setNombre("Pepito Grillo");
        clienteDao.modificarCliente(c);
        clienteObtenido = clienteDao.getCliente(1);
        System.out.println(clienteObtenido);

        CatalogoDaoImp catalogoDao = new CatalogoDaoImp();
        Catalogo cat = new Catalogo();
        cat.setCodigo(1);
        cat.setPrecio(100);
        cat.setTemporada("Primavera");
        cat.setDestino("Alemania");
        cat.setProcedencia("España");
        catalogoDao.nuevoCatalogo(cat);

        ViajeDaoImp viajeDao = new ViajeDaoImp();
        ViajeRepoImp viajeRepo = new ViajeRepoImp();
        Viaje v = new Viaje();
        v.setNombre("Viaje1");
        v.setPrecio(50F);
        v.setPlazas(10);
        v.setFechaInicio(new Date(System.currentTimeMillis()));
        v.setFechaFin(new Date(System.currentTimeMillis()));
        v.setCodigo(1);


        viajeRepo.nuevoViaje(v, 1);

        ReservaDaoImp reservaDao = new ReservaDaoImp();
        ReservaRepoImp reservaRepo = new ReservaRepoImp();

        reservaRepo.nuevaReserva(1,1);
        reservaDao.confirmarReserva(1);


        //Eliminar
        reservaDao.eliminarReserva(1);
        viajeDao.eliminarViaje(v);
        clienteDao.eliminarCliente(1);
    }
}
