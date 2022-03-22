package ProyectoWebYPatrones.proyecto.service;

import ProyectoWebYPatrones.proyecto.domain.Reservaciones;
import java.util.List;

public interface ReservacionesService {
    public List<Reservaciones> getReservacioness();
    public void save(Reservaciones reservaciones);
    public void delete(Reservaciones reservaciones);
    public Reservaciones getReservacion(Reservaciones reservaciones);
}
