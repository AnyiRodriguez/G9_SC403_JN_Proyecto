package ProyectoWebYPatrones.proyecto.dao;

import ProyectoWebYPatrones.proyecto.domain.Platillo;
import org.springframework.data.repository.CrudRepository;

public interface PlatilloDao extends CrudRepository<Platillo, Long>{
    
}
