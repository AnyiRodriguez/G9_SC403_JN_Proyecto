package ProyectoWebYPatrones.proyecto.domain;

import java.io.Serializable;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="orden")
public class Orden {
    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long idorden;
    
    String nombre;
    String apellidos;
    String cedula;
    String telefono;
    String platillos;
    String notas;
    String precio;
    String ubicaion;
    String tipo;
    
    public Orden(){}

    public Orden(String nombre, String apellidos, String cedula, String telefono, String platillos, String notas, String precio, String ubicaion, String tipo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.telefono = telefono;
        this.platillos = platillos;
        this.notas = notas;
        this.precio = precio;
        this.ubicaion = ubicaion;
        this.tipo = tipo;
    }
    
    
    
}
