package ProyectoWebYPatrones.proyecto.controller;

import ProyectoWebYPatrones.proyecto.domain.Finanza;
import ProyectoWebYPatrones.proyecto.service.FacturaService;
import ProyectoWebYPatrones.proyecto.service.FinanzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FinanzasController {
    @Autowired
    private FinanzaService finanzaService;
    @Autowired
    private FacturaService facturaService;
    
    //Corte incompleto
    @GetMapping("/finanza/corte")
    public String Reservar(Finanza finanza, Model model){
        var facturas = facturaService.getFacturas();
        model.addAttribute("facturas", facturas);
        return "/finanza/corte";
    }
    @PostMapping("/finanza/guardar")
    public String guardarFinanza(Finanza finanza){
        finanzaService.save(finanza);
        return "redirect:/";
    }
    @GetMapping("/finanza/ver")
    public String verFinanza(Model model){
        var finanzas = finanzaService.getFinanzas();
        model.addAttribute("finanzas", finanzas);
        return "/VerFinanza";
    }
    @GetMapping("/finanza/eliminar/{idFinanza}")
    public String eliminarFinanza(Finanza finanza){
        finanzaService.delete(finanza);
        return "redirect:/VerFinanza";
    }
}
