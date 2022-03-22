package ProyectoWebYPatrones.proyecto.dao;

import ProyectoWebYPatrones.proyecto.domain.Reservaciones;
import org.springframework.data.repository.CrudRepository;


public interface ReservacionesDao extends CrudRepository<Reservaciones, Long>{
    
}
