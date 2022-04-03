package ProyectoWebYPatrones.proyecto.dao;

import ProyectoWebYPatrones.proyecto.domain.Reservacion;
import org.springframework.data.repository.CrudRepository;


public interface ReservacionDao extends CrudRepository<Reservacion, Long>{
    
}
