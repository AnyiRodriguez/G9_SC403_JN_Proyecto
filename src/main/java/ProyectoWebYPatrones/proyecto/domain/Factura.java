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
    public int total;
    String platillos;
    String precios;
    
    public Factura(){}

    public Factura(int total, String platillos, String precios) {
        this.total = total;
        this.platillos = platillos;
        this.precios = precios;
    }
}
