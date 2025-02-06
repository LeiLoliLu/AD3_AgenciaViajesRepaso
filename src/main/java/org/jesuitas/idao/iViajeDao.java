package org.jesuitas.idao;

import org.jesuitas.models.Viaje;

public interface iViajeDao {
    public Viaje getViaje(Integer idViaje);
    public Boolean eliminarViaje(Viaje v);

}
