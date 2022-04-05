package ProyectoWebYPatrones.proyecto.controller;

import ProyectoWebYPatrones.proyecto.domain.Reservacion;
import ProyectoWebYPatrones.proyecto.service.ReservacionService;
import ProyectoWebYPatrones.proyecto.service.OrdenService;
import ProyectoWebYPatrones.proyecto.domain.Orden;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class IndexController {
    @RequestMapping("/")
    public String inicio(Model model) {
        log.info("Pagina para un restaurante");
        return "index";
    }
}
