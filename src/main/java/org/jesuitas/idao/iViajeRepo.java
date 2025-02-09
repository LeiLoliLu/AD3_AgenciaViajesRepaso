package org.jesuitas.idao;

import org.jesuitas.models.Viaje;

public interface iViajeRepo {
    public Boolean nuevoViaje(Viaje v, Integer idCatalogo);
}
