package ProyectoWebYPatrones.proyecto.dao;

import ProyectoWebYPatrones.proyecto.domain.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuDao extends CrudRepository<Menu, Long>{
    
}
