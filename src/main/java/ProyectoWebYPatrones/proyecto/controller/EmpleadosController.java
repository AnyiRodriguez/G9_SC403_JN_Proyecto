package ProyectoWebYPatrones.proyecto.controller;

import ProyectoWebYPatrones.proyecto.domain.Empleado;
import ProyectoWebYPatrones.proyecto.service.EmpleadoService;
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
    public String NuevoEmpleado(Empleado empleado){
        return "/empleados/modificar";
    }
    @PostMapping("/empleados/guardar")
    public String guardarEmpleado(Empleado empleado){
        empleadoService.save(empleado);
        return "redirect:/empleados/ver";
    }
    @GetMapping("/empleados/ver")
    public String verEmpleado(Model model){
        var empleados = empleadoService.getEmpleados();
        model.addAttribute("empleados", empleados);
        return "/empleados/ver";
    }
    @GetMapping("/empleados/modificar/{idEmpleado}")
    public String modificarEmpleado(Empleado empleado, Model model){
        var respuesta = empleadoService.getEmpleado(empleado);
        model.addAttribute("empleado", respuesta);
        return "/empleados/modificar";
    }
    @GetMapping("/empleados/eliminar/{idEmpleado}")
    public String eliminarEmpleado(Empleado empleado){
        empleadoService.delete(empleado);
        return "redirect:/empleados/ver";
    }
    @GetMapping("/empleados/buscar/{cedula}")
    public String buscarEmpleados(String cedula, Model model){
        var busqueda = empleadoService.findByCedula(cedula);
        model.addAttribute("EmpleadoEsp", busqueda);
        return "/empleados/resultado";
    }
}
