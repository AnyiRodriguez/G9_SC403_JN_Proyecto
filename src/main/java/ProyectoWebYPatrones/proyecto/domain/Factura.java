package ProyectoWebYPatrones.proyecto.domain;

import java.io.Serializable;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="Factura")
public class Factura implements Serializable{
    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_Factura")
    Long idFactura;
    Long idPlatillo;
    String nombre;
    String apellidos;
    String total;
    
    public Factura(){}

    public Factura(Long idPlatillo, String nombre, String apellidos, String total) {
        this.idPlatillo = idPlatillo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.total = total;
    }

}
