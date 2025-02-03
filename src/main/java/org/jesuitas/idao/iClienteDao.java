package org.jesuitas.idao;
import org.jesuitas.models.Cliente;

public interface iClienteDao {
    public Boolean aniadirCliente(Cliente clienteNuevo);
    public Boolean modificarCliente(Cliente clienteModificado);
    public Boolean eliminarCliente(Integer codigoCliente);
    public Cliente getCliente(Integer codigoCliente);
}
