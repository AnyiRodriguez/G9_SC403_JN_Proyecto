package ProyectoWebYPatrones.proyecto.service;

import ProyectoWebYPatrones.proyecto.domain.Orden;
import java.util.List;

public interface OrdenService {
    public List<Orden> getOrdenes();
    public void save(Orden orden);
    public void delete(Orden orden);
    public Orden getOrden(Orden orden);
}
