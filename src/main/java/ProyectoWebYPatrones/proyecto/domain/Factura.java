package ProyectoWebYPatrones.proyecto.domain;

import java.io.Serializable;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="factura")
public class Factura implements Serializable{
    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_Factura")
    Long idFactura;
    String nombre;
    String apellidos;
    String total;
    String platillos;
    String precios;
    
    public Factura(){}

    public Factura(String nombre, String apellidos, String total, String platillos, String precios) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.total = total;
        this.platillos = platillos;
        this.precios = precios;
    }
}
