package ProyectoWebYPatrones.proyecto.service;

import ProyectoWebYPatrones.proyecto.domain.Factura;
import java.util.List;

public interface FacturaService {
    public List<Factura> getFacturas();
    public void save(Factura factura);
    public void delete(Factura factura);
    public Factura getFactura(Factura factura);
}
