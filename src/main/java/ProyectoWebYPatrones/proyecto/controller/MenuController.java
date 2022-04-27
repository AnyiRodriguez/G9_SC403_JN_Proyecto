package ProyectoWebYPatrones.proyecto.controller;

import ProyectoWebYPatrones.proyecto.domain.Menu;
import ProyectoWebYPatrones.proyecto.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    @GetMapping("/menu/modificar")
    public String Reservar(Menu menu){
        return "/menu/modificar";
    }
    @GetMapping("/menu/modificar/{idMenu}")
    public String modificarMenu(Menu menu, Model model){
        var respuesta = menuService.getMenu(menu);
        model.addAttribute("menu", respuesta);
        return "/menu/modificar";
    }
    @GetMapping("/menu/eliminar/{idMenu}")
    public String eliminarMenu(Menu menu){
        menuService.delete(menu);
        return "redirect:/";
    }
    @PostMapping("/menu/guardar")
    public String guardarMenu(Menu menu){
        menuService.save(menu);
        return "redirect:/";
    }
}
