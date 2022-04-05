package ProyectoWebYPatrones.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpleadosController {
    @Autowired
    private EmpleadoService empleadoService;
    
    @GetMapping("/empleados/nuevo")
    public String Reservar(Empleado empleado){
        return "/empleados/nuevo";
    }
    @PostMapping("/empleados/guardar")
    public String guardarEmpleado(Empleado empleado){
        empleadoService.save(empleado);
        return "redirect:/";
    }
    @GetMapping("/empleados/ver")
    public String verEmpleado(Model model){
        var empleadoes = empleadoService.getEmpleadoes();
        model.addAttribute("empleados", empleadoes);
        return "/VerEmpleado";
    }
    @GetMapping("/empleados/modificar/{idEmpleado}")
    public String modificarEmpleado(Empleado empleado, Model model){
        var respuesta = empleadoService.getEmpleado(empleado);
        model.addAttribute("empleado", respuesta);
        return "Reservar";
    }
    @GetMapping("/empleados/eliminar/{idEmpleado}")
    public String eliminarEmpleado(Empleado empleado){
        empleadoService.delete(empleado);
        return "redirect:/VerEmpleado";
    }
}
