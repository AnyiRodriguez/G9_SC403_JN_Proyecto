package ProyectoWebYPatrones.proyecto.dao;

import ProyectoWebYPatrones.proyecto.domain.Reservacion;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface ReservacionDao extends CrudRepository<Reservacion, Long>{
    public List<Reservacion> findByCedula(String cedula);
}
