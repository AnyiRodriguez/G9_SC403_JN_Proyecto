package ProyectoWebYPatrones.proyecto.dao;

import ProyectoWebYPatrones.proyecto.domain.Orden;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface OrdenDao extends CrudRepository<Orden, Long>{
    public List<Orden> findByCedula(String cedula);
}
