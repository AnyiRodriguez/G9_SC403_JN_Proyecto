package ProyectoWebYPatrones.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FinanzasController {
    @Autowired
    private FinanzaService finanzaService;
    
    @GetMapping("/finanza/nuevo")
    public String Reservar(Finanza finanza){
        return "/finanza/nuevo";
    }
    @PostMapping("/finanza/guardar")
    public String guardarFinanza(Finanza finanza){
        finanzaService.save(finanza);
        return "redirect:/";
    }
    @GetMapping("/finanza/ver")
    public String verFinanza(Model model){
        var finanzaes = finanzaService.getFinanzaes();
        model.addAttribute("finanzas", finanzaes);
        return "/VerFinanza";
    }
    @GetMapping("/finanza/modificar/{idFinanza}")
    public String modificarFinanza(Finanza finanza, Model model){
        var respuesta = finanzaService.getFinanza(finanza);
        model.addAttribute("finanza", respuesta);
        return "Reservar";
    }
    @GetMapping("/finanza/eliminar/{idFinanza}")
    public String eliminarFinanza(Finanza finanza){
        finanzaService.delete(finanza);
        return "redirect:/VerFinanza";
    }
    
}
