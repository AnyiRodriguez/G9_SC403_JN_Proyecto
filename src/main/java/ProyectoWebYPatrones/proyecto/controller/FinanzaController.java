package ProyectoWebYPatrones.proyecto.controller;

import ProyectoWebYPatrones.proyecto.domain.Finanza;
import ProyectoWebYPatrones.proyecto.service.ClienteService;
import ProyectoWebYPatrones.proyecto.service.FinanzaService;
import ProyectoWebYPatrones.proyecto.service.FacturaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class FinanzaController {
    @Autowired
    private FinanzaService finanzaService;
    @Autowired
    private ClienteService clienteService;
    
    @PostMapping("/finanzas/guardar")
    public String Corte(Finanza finanza){
        var clientes=clienteService.getClientes();
        
        var CorteTotal=0;
        for (var c: clientes) {
            CorteTotal+=c.factura.total;
        }
        finanza.setCorteTotal(CorteTotal);
        finanzaService.save(finanza);
        clienteService.deleteAll();
        return "redirect:/finanzas/ver";
    }
    
    @GetMapping("/finanzas/modificar")
    public String verFinanza(Finanza finanza){
        return "/finanzas/modificar";
    }
    @GetMapping("/finanzas/ver")
    public String verFinanza(Model model){
        var finanzas = finanzaService.getFinanzas();
        model.addAttribute("finanzas", finanzas);
        return "/finanzas/ver";
    }
    @GetMapping("/finanzas/eliminar/{idFinanza}")
    public String eliminarFinanza(Finanza finanza){
        finanzaService.delete(finanza);
        return "redirect:/finanzas/ver";
    }
}
