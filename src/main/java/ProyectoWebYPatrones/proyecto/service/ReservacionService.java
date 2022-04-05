package ProyectoWebYPatrones.proyecto.service;

import ProyectoWebYPatrones.proyecto.domain.Reservacion;
import java.util.List;

public interface ReservacionService {
    public List<Reservacion> getReservaciones();
    public void save(Reservacion reservacion);
    public void delete(Reservacion reservacion);
    public Reservacion getReservacion(Reservacion reservacion);
    public List<Reservacion> findByCedula(String cedula);
}
