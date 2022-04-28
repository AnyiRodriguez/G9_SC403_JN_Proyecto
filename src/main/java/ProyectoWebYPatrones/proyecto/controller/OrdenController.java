package ProyectoWebYPatrones.proyecto.controller;

import ProyectoWebYPatrones.proyecto.domain.Orden;
import ProyectoWebYPatrones.proyecto.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrdenController {
    @Autowired
    private OrdenService ordenService;
    
    @GetMapping("/orden/nuevo")
    public String Ordenar(Orden orden){
        return "/orden/nuevo";
    }
    @PostMapping("/orden/guardar")
    public String guardarOrden(Orden orden){
        ordenService.save(orden);
        return "redirect:/";
    }
    @GetMapping("/orden/busqueda")
    public String BusquedaMiOrden(){
        return "/orden/busqueda";
    }
    @GetMapping("/orden/modificar/{idOrden}")
    public String modificarOrden(Orden orden, Model model){
        var respuesta = ordenService.getOrden(orden);
        model.addAttribute("orden", respuesta);
        return "/orden/modificar";
    }
    @GetMapping("/orden/eliminar/{idOrden}")
    public String eliminarOrden(Orden orden){
        ordenService.delete(orden);
        return "redirect:/";
    }
    @GetMapping("/orden/buscar/{cedula}")
    public String buscarOrden(String cedula, Model model){
        var busqueda = ordenService.findByCedula(cedula);
        model.addAttribute("misOrdenes", busqueda);
        return "/orden/ver";
    }
    @GetMapping("/orden/todo")
    public String verTodasReservacion(Model model){
        var ordenes = ordenService.getOrdenes();
        model.addAttribute("ordenes", ordenes);
        return "/orden/todo";
    }
}
