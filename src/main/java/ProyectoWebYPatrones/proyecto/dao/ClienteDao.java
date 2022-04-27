package ProyectoWebYPatrones.proyecto.dao;

import ProyectoWebYPatrones.proyecto.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Long>{
    
}
