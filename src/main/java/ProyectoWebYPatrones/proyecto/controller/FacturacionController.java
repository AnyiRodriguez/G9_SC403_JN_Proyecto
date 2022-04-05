package ProyectoWebYPatrones.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FacturacionController {
    @Autowired
    private FacturaService facturaService;
    
    @GetMapping("/factura/nuevo")
    public String Reservar(Factura factura){
        return "/factura/nuevo";
    }
    @PostMapping("/factura/guardar")
    public String guardarFactura(Factura factura){
        facturaService.save(factura);
        return "redirect:/";
    }
    @GetMapping("/factura/ver")
    public String verFactura(Model model){
        var facturaes = facturaService.getFacturaes();
        model.addAttribute("facturas", facturaes);
        return "/VerFactura";
    }
    @GetMapping("/factura/modificar/{idFactura}")
    public String modificarFactura(Factura factura, Model model){
        var respuesta = facturaService.getFactura(factura);
        model.addAttribute("factura", respuesta);
        return "Reservar";
    }
    @GetMapping("/factura/eliminar/{idFactura}")
    public String eliminarFactura(Factura factura){
        facturaService.delete(factura);
        return "redirect:/VerFactura";
    }
    
}
