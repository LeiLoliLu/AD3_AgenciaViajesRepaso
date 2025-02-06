package org.jesuitas.idao;

import org.jesuitas.models.Catalogo;

public interface iCatalogoDao {
    public Boolean nuevoCatalogo(Catalogo c);
    public Catalogo getCatalogo(Integer idCatalogo);
}
