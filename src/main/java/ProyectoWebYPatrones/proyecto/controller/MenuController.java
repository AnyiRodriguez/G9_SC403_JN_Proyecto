package ProyectoWebYPatrones.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
    
    @GetMapping("/menu/ver")
    public String verMenu(){
        return "/menu/ver";
    }
    
}
