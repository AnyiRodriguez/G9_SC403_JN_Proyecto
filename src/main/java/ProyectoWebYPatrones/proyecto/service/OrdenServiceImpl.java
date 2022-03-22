package ProyectoWebYPatrones.proyecto.service;

import ProyectoWebYPatrones.proyecto.dao.OrdenDao;
import ProyectoWebYPatrones.proyecto.domain.Orden;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrdenServiceImpl implements OrdenService {
    @Autowired
    private OrdenDao ordenDao;

    @Override
    @Transactional (readOnly = true)
    public List<Orden> getOrdenes() {
        return (List<Orden>) ordenDao.findAll();
    }

    @Override
    @Transactional
    public void save(Orden orden) {
        ordenDao.save(orden);
    }

    @Override
    @Transactional
    public void delete(Orden orden) {
        ordenDao.delete(orden);
    }

    @Override
    @Transactional (readOnly = true)
    public Orden getOrden(Orden orden) {
        return ordenDao.findById(orden.getIdorden()).orElse(null);
    }
    
}
