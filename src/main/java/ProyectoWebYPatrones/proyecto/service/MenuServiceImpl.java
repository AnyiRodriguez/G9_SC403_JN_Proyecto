package ProyectoWebYPatrones.proyecto.service;

import ProyectoWebYPatrones.proyecto.dao.MenuDao;
import ProyectoWebYPatrones.proyecto.domain.Menu;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;
    
    @Override
    @Transactional (readOnly = true)
    public List<Menu> getMenus() {
        return (List<Menu>) menuDao.findAll();
    }

    @Override
    @Transactional
    public void save(Menu menu) {
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
