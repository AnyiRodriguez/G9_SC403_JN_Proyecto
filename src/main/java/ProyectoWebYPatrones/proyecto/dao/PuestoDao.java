package ProyectoWebYPatrones.proyecto.dao;

import ProyectoWebYPatrones.proyecto.domain.Puesto;
import org.springframework.data.repository.CrudRepository;

public interface PuestoDao extends CrudRepository<Puesto, Long>{
    
}
