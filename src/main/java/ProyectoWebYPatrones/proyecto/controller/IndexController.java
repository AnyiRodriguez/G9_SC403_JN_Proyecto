package ProyectoWebYPatrones.proyecto.controller;

import ProyectoWebYPatrones.proyecto.domain.Reservaciones;
import ProyectoWebYPatrones.proyecto.service.ReservacionesService;
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
    private ReservacionesService reservacionesService;
    @Autowired
    private OrdenService ordenService;
    
    @RequestMapping("/")
    public String inicio(Model model) {
        log.info("Pagina para un restaurante");
        return "index";
    }
    @GetMapping("/Reservar")
    public String Reservar(Reservaciones reservaciones){
        return "Reservar";
    }
    @PostMapping("/guardarReservacion")
    public String guardarReservacion(Reservaciones reservaciones){
        reservacionesService.save(reservaciones);
        return "redirect:/";
    }
    @GetMapping("/VerReservaciones")
    public String verReservaciones(){
        return "/VerReservaciones";
    }
    @GetMapping("/ModificarReservacion/{idreservaciones}")
    public String modificarReservacion(Reservaciones reservaciones, Model model){
        var respuesta = reservacionesService.getReservacion(reservaciones);
        model.addAttribute("reservaciones", respuesta);
        return "Reservar";
    }
    @GetMapping("/EliminarReservacion/{idreservaciones}")
    public String eliminarreservacon(Reservaciones reservaciones){
        reservacionesService.delete(reservaciones);
        return "redirect:/VerReservaciones";
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
    public String verOrdenes(){
        return "/VerOrdenes";
    }
    @GetMapping("/ModificarOrden/{idorden}")
    public String modificarOrden(Orden orden, Model model){
        var respuesta = ordenService.getOrden(orden);
        model.addAttribute("ordenes", respuesta);
        return "redirect:/VerOrdenes";
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
