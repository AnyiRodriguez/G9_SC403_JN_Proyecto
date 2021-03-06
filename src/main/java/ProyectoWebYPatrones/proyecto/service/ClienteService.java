package ProyectoWebYPatrones.proyecto.service;

import ProyectoWebYPatrones.proyecto.domain.Cliente;
import java.util.List;

public interface ClienteService {
    public List<Cliente> getClientes();
    public void save(Cliente cliente);
    public void delete(Cliente cliente);
    public Cliente getCliente(Cliente cliente);
    public void deleteAll();
    public List<Cliente> findByCedula(String cedula);
}
