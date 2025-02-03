package org.jesuitas.idao;

import org.jesuitas.models.Reserva;

public interface iReservaDao {
    public Boolean confirmarReserva(Integer idReserva);
    public Boolean eliminarReserva(Integer codigoReserva);
}

