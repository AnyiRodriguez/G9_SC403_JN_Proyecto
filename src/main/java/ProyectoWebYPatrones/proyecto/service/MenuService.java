package ProyectoWebYPatrones.proyecto.service;

import ProyectoWebYPatrones.proyecto.domain.Menu;
import java.util.List;

public interface MenuService {
    public List<Menu> getMenus();
    public void save(Menu menu);
    public void delete(Menu menu);
    public Menu getMenu(Menu menu);
}
