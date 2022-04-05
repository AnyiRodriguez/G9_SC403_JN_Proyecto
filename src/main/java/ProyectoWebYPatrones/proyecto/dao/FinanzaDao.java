package ProyectoWebYPatrones.proyecto.dao;

import ProyectoWebYPatrones.proyecto.domain.Finanza;
import org.springframework.data.repository.CrudRepository;

public interface FinanzaDao extends CrudRepository<Finanza, Long>{
    
}
