package ProyectoWebYPatrones.proyecto.service;

import ProyectoWebYPatrones.proyecto.dao.ReservacionesDao;
import ProyectoWebYPatrones.proyecto.domain.Reservaciones;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservacionesServiceImpl implements ReservacionesService {
    @Autowired
    private ReservacionesDao reservacionesDao;

    @Override
    @Transactional (readOnly = true)
    public List<Reservaciones> getReservacioness() {
        return (List<Reservaciones>) reservacionesDao.findAll();
    }

    @Override
    @Transactional
    public void save(Reservaciones reservaciones) {
        reservacionesDao.save(reservaciones);
    }

    @Override
    @Transactional
    public void delete(Reservaciones reservaciones) {
        reservacionesDao.delete(reservaciones);
    }

    @Override
    @Transactional (readOnly = true)
    public Reservaciones getReservacion(Reservaciones reservaciones) {
        return reservacionesDao.findById(reservaciones.getIdreservaciones()).orElse(null);
    }
    
}
