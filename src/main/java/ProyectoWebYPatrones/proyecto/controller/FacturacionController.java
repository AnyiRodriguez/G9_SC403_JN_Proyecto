package ProyectoWebYPatrones.proyecto.controller;

import ProyectoWebYPatrones.proyecto.domain.Factura;
import ProyectoWebYPatrones.proyecto.service.FacturaService;
import ProyectoWebYPatrones.proyecto.service.PlatilloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FacturacionController {
    @Autowired
    private FacturaService facturaService;
    @Autowired
    private PlatilloService platilloService;
    
    @GetMapping("/factura/nuevo")
    public String Reservar(Factura factura, Model model){
        var platillos = platilloService.getPlatillos();
        model.addAttribute("platillos", platillos);
        return "/factura/nuevo";
    }
    @PostMapping("/factura/guardar")
    public String guardarFactura(Factura factura){
        facturaService.save(factura);
        return "redirect:/";
    }
    @GetMapping("/factura/ver")
    public String verFactura(Model model){
        var facturas = facturaService.getFacturas();
        model.addAttribute("facturas", facturas);
        return "/factura/ver";
    }
    @GetMapping("/factura/modificar/{idFactura}")
    public String modificarFactura(Factura factura, Model model){
        var respuesta = facturaService.getFactura(factura);
        model.addAttribute("factura", respuesta);
        var platillos = platilloService.getPlatillos();
        model.addAttribute("platillos", platillos);
        return "factura/modificar";
    }
    @GetMapping("/factura/eliminar/{idFactura}")
    public String eliminarFactura(Factura factura){
        facturaService.delete(factura);
        return "redirect:/VerFactura";
    }
    
}
