package ProyectoWebYPatrones.proyecto.domain;

import java.io.Serializable;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="orden")
public class Orden implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_Orden")
    Long idOrden;
    
    String nombre;
    String apellidos;
    String cedula;
    String telefono;
    String tipo;
    String platillos;
    String notas;
    String precio;
    String ubicacion;
    
    public Orden(){}

    public Orden(String nombre, String apellidos, String cedula, String telefono, String platillos, String notas, String precio, String ubicacion, String tipo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.telefono = telefono;
        this.platillos = platillos;
        this.notas = notas;
        this.precio = precio;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
    }
    
    
    
}
