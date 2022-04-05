package ProyectoWebYPatrones.proyecto.service;

import ProyectoWebYPatrones.proyecto.dao.PuestoDao;
import ProyectoWebYPatrones.proyecto.domain.Puesto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class PuestoServiceImpl implements PuestoService {

    @Autowired
    private PuestoDao puestoDao;
    
    @Override
    @Transactional (readOnly = true)
    public List<Puesto> getPuestos() {
        return (List<Puesto>) puestoDao.findAll();
    }

    @Override
    @Transactional
    public void save(Puesto puesto) {
        puestoDao.save(puesto);
    }

    @Override
    @Transactional
    public void delete(Puesto puesto) {
        puestoDao.delete(puesto);
    }

    @Override
    @Transactional (readOnly = true)
    public Puesto getPuesto(Puesto puesto) {
        return puestoDao.findById(puesto.getIdPuesto()).orElse(null);
    }
    
}
