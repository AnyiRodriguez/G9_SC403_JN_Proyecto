package ProyectoWebYPatrones.proyecto.domain;

import java.io.Serializable;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_Cliente")
    Long idCliente;
    String nombre;
    String apellidos;
    String cedula;
    
    @JoinColumn(name="id_Factura", referencedColumnName="id_Factura")
    @ManyToOne
    public Factura factura;
    
    public Cliente(){}

    public Cliente(String nombre, String apellidos, String cedula, Factura factura) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.factura = factura;
    }
}
