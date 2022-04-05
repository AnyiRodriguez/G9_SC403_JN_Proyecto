package ProyectoWebYPatrones.proyecto.service;

import ProyectoWebYPatrones.proyecto.domain.Puesto;
import java.util.List;

public interface PuestoService {
    public List<Puesto> getPuestos();
    public void save(Puesto puesto);
    public void delete(Puesto puesto);
    public Puesto getPuesto(Puesto puesto);
}
