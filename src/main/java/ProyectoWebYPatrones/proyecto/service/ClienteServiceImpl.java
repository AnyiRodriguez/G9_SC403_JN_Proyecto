package ProyectoWebYPatrones.proyecto.service;

import ProyectoWebYPatrones.proyecto.dao.ClienteDao;
import ProyectoWebYPatrones.proyecto.dao.FacturaDao;
import ProyectoWebYPatrones.proyecto.domain.Cliente;
import ProyectoWebYPatrones.proyecto.domain.Factura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;
    @Autowired
    private FacturaDao facturaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        Factura factura = cliente.getFactura();
        factura = facturaDao.save(factura);
        cliente.setFactura(factura);
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    @Transactional (readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }
    @Override
    @Transactional
    public void deleteAll() {
        for (var fact : clienteDao.findAll()) {
            delete(fact);
        }
    }

    @Override
    public List<Cliente> findByCedula(String cedula) {
        return clienteDao.findByCedula(cedula);
    }
}
