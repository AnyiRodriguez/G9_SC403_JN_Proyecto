package ProyectoWebYPatrones.proyecto.service;

import ProyectoWebYPatrones.proyecto.dao.FinanzaDao;
import ProyectoWebYPatrones.proyecto.domain.Finanza;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class FinanzaServiceImpl implements FinanzaService {
    @Autowired
    private FinanzaDao finanzaDao;
    
    @Override
    @Transactional (readOnly = true)
    public List<Finanza> getFinanzas() {
        return (List<Finanza>) finanzaDao.findAll();
    }

    @Override
    @Transactional
    public void save(Finanza finanza) {
        finanzaDao.save(finanza);
    }

    @Override
    @Transactional
    public void delete(Finanza finanza) {
        finanzaDao.delete(finanza);
    }

    @Override
    @Transactional (readOnly = true)
    public Finanza getFinanza(Finanza finanza) {
        return finanzaDao.findById(finanza.getIdFinanza()).orElse(null);
    }
}