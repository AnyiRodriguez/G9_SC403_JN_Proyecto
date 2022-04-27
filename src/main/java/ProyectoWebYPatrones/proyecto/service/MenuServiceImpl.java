package ProyectoWebYPatrones.proyecto.service;

import ProyectoWebYPatrones.proyecto.dao.MenuDao;
import ProyectoWebYPatrones.proyecto.dao.PlatilloDao;
import ProyectoWebYPatrones.proyecto.domain.Menu;
import ProyectoWebYPatrones.proyecto.domain.Platillo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private PlatilloDao platilloDao;
    
    @Override
    @Transactional (readOnly = true)
    public List<Menu> getMenus() {
        return (List<Menu>) menuDao.findAll();
    }

    @Override
    @Transactional
    public void save(Menu menu) {
        Platillo platillo = menu.getPlatillo();
        platillo = platilloDao.save(platillo);
        menu.setPlatillo(platillo);
        menuDao.save(menu);
    }

    @Override
    @Transactional
    public void delete(Menu menu) {
        menuDao.delete(menu);
    }

    @Override
    @Transactional (readOnly = true)
    public Menu getMenu(Menu menu) {
        return menuDao.findById(menu.getIdMenu()).orElse(null);
    }
}