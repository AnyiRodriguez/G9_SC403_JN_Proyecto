package ProyectoWebYPatrones.proyecto.service;

import ProyectoWebYPatrones.proyecto.dao.PlatilloDao;
import ProyectoWebYPatrones.proyecto.domain.Platillo;
import ProyectoWebYPatrones.proyecto.domain.Platillo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlatilloServiceImpl implements PlatilloService {

    @Autowired
    private PlatilloDao platilloDao;
    
    @Override
    @Transactional (readOnly = true)
    public List<Platillo> getPlatillos() {
        return (List<Platillo>) platilloDao.findAll();
    }

    @Override
    @Transactional
    public void save(Platillo platillo) {
        platilloDao.save(platillo);
    }

    @Override
    @Transactional
    public void delete(Platillo platillo) {
        platilloDao.delete(platillo);
    }

    @Override
    @Transactional (readOnly = true)
    public Platillo getPlatillo(Platillo platillo) {
        return platilloDao.findById(platillo.getIdPlatillo()).orElse(null);
    }
    
}
