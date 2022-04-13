package ProyectoWebYPatrones.proyecto.controller;

import ProyectoWebYPatrones.proyecto.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;
    
    @GetMapping("/menu/ver")
    public String verMenu(){
        return "/menu/ver";
    }
    @GetMapping("/menu/tabla")
    public String verTablaMenu(Model model){
        var menus = menuService.getMenus();
        model.addAttribute("menus", menus);
        return "/menu/tabla";
    }
}
