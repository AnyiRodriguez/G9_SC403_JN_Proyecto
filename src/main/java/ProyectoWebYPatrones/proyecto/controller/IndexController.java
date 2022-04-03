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
    @Autowired
    private ReservacionService reservacionService;
    @Autowired
    private OrdenService ordenService;
    
    @RequestMapping("/")
    public String inicio(Model model) {
        log.info("Pagina para un restaurante");
        return "index";
    }
    @GetMapping("/Reservar")
    public String Reservar(Reservacion reservacion){
        return "Reservar";
    }
    @PostMapping("/guardarReservacion")
    public String guardarReservacion(Reservacion reservacion){
        reservacionService.save(reservacion);
        return "redirect:/";
    }
    @GetMapping("/VerReservacion")
    public String verReservacion(Model model){
        var reservaciones = reservacionService.getReservaciones();
        model.addAttribute("reservaciones", reservaciones);
        return "/VerReservacion";
    }
    @GetMapping("/ModificarReservacion/{idreservacion}")
    public String modificarReservacion(Reservacion reservacion, Model model){
        var respuesta = reservacionService.getReservacion(reservacion);
        model.addAttribute("reservacion", respuesta);
        return "Reservar";
    }
    @GetMapping("/EliminarReservacion/{idreservacion}")
    public String eliminarreservacon(Reservacion reservacion){
        reservacionService.delete(reservacion);
        return "redirect:/VerReservacion";
    }
    
    
    @GetMapping("/Ordenar")
    public String Ordenar(Orden orden){
        return "/Ordenar";
    }
    @PostMapping("/guardarOrden")
    public String guardarOrden(Orden orden){
        ordenService.save(orden);
        return "redirect:/";
    }
    @GetMapping("/VerOrdenes")
    public String verOrdenes(Model model){
        var ordenes = ordenService.getOrdenes();
        model.addAttribute("ordenes", ordenes);
        return "/VerOrdenes";
    }
    @GetMapping("/ModificarOrden/{idorden}")
    public String modificarOrden(Orden orden, Model model){
        var respuesta = ordenService.getOrden(orden);
        model.addAttribute("orden", respuesta);
        return "ModificarOrden";
    }
    @GetMapping("/EliminarOrden/{idorden}")
    public String eliminarOrden(Orden orden){
        ordenService.delete(orden);
        return "redirect:/";
    }
    
    
    @GetMapping("/VerMenu")
    public String verMenu(){
        return "/VerMenu";
    }
}
