package ProyectoWebYPatrones.proyecto.controller;

import ProyectoWebYPatrones.proyecto.domain.Cliente;
import ProyectoWebYPatrones.proyecto.domain.Factura;
import ProyectoWebYPatrones.proyecto.service.ClienteService;
import ProyectoWebYPatrones.proyecto.service.FacturaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private FacturaService facturaService;
    
    @GetMapping("/facturacion/modificar")
    public String NuevoCliente(Cliente cliente){
        return "/facturacion/modificar";
    }
    @PostMapping("/facturacion/guardar")
    public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/";
    }
    @GetMapping("/facturacion/modificar/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model){
        var respuesta = clienteService.getCliente(cliente);
        model.addAttribute("cliente", respuesta);
        return "/facturacion/modificar";
    }
    @GetMapping("/facturacion/eliminar/{idCliente}")
    public String eliminarCliente(Cliente cliente){
        clienteService.delete(cliente);
        return "redirect:/";
    }
    @GetMapping("/facturacion/ver")
    public String verCliente(Model model){
        var facturacion = clienteService.getClientes();
        model.addAttribute("facturas", facturacion);
        return "/facturacion/ver";
    }
    @GetMapping("/facturacion/busqueda")
    public String BusquedaFactura(){
        return "/facturacion/busqueda";
    }
    @GetMapping("/facturacion/buscar/{cedula}")
    public String buscarEmpleados(String cedula, Model model){
        var busqueda = clienteService.findByCedula(cedula);
        model.addAttribute("FactEsp", busqueda);
        return "/facturacion/resultado";
    }
}
