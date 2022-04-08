package ProyectoWebYPatrones.proyecto.controller;

import ProyectoWebYPatrones.proyecto.domain.Reservacion;
import ProyectoWebYPatrones.proyecto.service.ReservacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservacionController {
    @Autowired
    private ReservacionService reservacionService;
    
    @GetMapping("/reservacion/modificar")
    public String Reservar(Reservacion reservacion){
        return "/reservacion/modificar";
    }
    @PostMapping("/reservacion/guardar")
    public String guardarReservacion(Reservacion reservacion){
        reservacionService.save(reservacion);
        return "redirect:/";
    }
    @GetMapping("/reservacion/busqueda")
    public String busquedaMiReservacion(){
        return "/reservacion/busqueda";
    }
    @GetMapping("/reservacion/modificar/{idReservacion}")
    public String modificarReservacion(Reservacion reservacion, Model model){
        var respuesta = reservacionService.getReservacion(reservacion);
        model.addAttribute("reservacion", respuesta);
        return "redirect:/reservacion/ver";
    }
    @GetMapping("/reservacion/eliminar/{idReservacion}")
    public String eliminarReservacion(Reservacion reservacion){
        reservacionService.delete(reservacion);
        return "redirect:/reservacion/ver";
    }
    @GetMapping("/reservacion/todo")
    public String verTodasReservacion(Model model){
        var reservaciones = reservacionService.getReservaciones();
        model.addAttribute("reservaciones", reservaciones);
        return "/reservacion/todo";
    }
    @GetMapping("/reservacion/buscar/")
    public String buscarReservacion(String cedula, Model model){
        var busqueda = reservacionService.findByCedula(cedula);
        model.addAttribute("misReservaciones", busqueda);
        return "/reservacion/ver";
    }
}
