package ProyectoWebYPatrones.proyecto.controller;

import ProyectoWebYPatrones.proyecto.domain.Factura;
import ProyectoWebYPatrones.proyecto.service.FacturaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class FacturacionController {
    @Autowired
    private FacturaService facturaService;
    
    @GetMapping("/facturacion/modificar")
    public String Reservar(Factura factura, Model model){
        return "/facturacion/modificar";
    }
    @PostMapping("/facturacion/guardar")
    public String guardarFactura(Factura factura){
        facturaService.save(factura);
        return "redirect:/";
    }
    @GetMapping("/facturacion/ver")
    public String verFactura(Model model){
        var facturas = facturaService.getFacturas();
        model.addAttribute("facturas", facturas);
        return "/facturacion/ver";
    }
    @GetMapping("/facturacion/modificar/{idFactura}")
    public String modificarFactura(Factura factura, Model model){
        var respuesta = facturaService.getFactura(factura);
        model.addAttribute("factura", respuesta);
        return "facturacion/modificar";
    }
    @GetMapping("/facturacion/eliminar/{idFactura}")
    public String eliminarFactura(Factura factura){
        facturaService.delete(factura);
        return "redirect:/facturacion/ver";
    }
}
