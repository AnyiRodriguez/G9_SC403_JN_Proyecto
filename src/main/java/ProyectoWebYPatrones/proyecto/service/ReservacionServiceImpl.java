package ProyectoWebYPatrones.proyecto.service;

import ProyectoWebYPatrones.proyecto.dao.ReservacionDao;
import ProyectoWebYPatrones.proyecto.domain.Reservacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservacionServiceImpl implements ReservacionService {
    @Autowired
    private ReservacionDao reservacionDao;

    @Override
    @Transactional (readOnly = true)
    public List<Reservacion> getReservaciones() {
        return (List<Reservacion>) reservacionDao.findAll();
    }

    @Override
    @Transactional
    public void save(Reservacion reservacion) {
        reservacionDao.save(reservacion);
    }

    @Override
    @Transactional
    public void delete(Reservacion reservacion) {
        reservacionDao.delete(reservacion);
    }

    @Override
    @Transactional (readOnly = true)
    public Reservacion getReservacion(Reservacion reservacion) {
        return reservacionDao.findById(reservacion.getIdReservacion()).orElse(null);
    }

    @Override
    public List<Reservacion> findByCedula(String cedula) {
        var lista = (List<Reservacion>) reservacionDao.findByCedula(cedula);
        return lista;
    }
    
}
