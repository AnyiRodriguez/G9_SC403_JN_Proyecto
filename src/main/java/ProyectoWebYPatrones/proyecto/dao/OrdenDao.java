package ProyectoWebYPatrones.proyecto.dao;

import ProyectoWebYPatrones.proyecto.domain.Orden;
import org.springframework.data.repository.CrudRepository;

public interface OrdenDao extends CrudRepository<Orden, Long>{
    
}
