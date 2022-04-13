package ProyectoWebYPatrones.proyecto.domain;

import java.io.Serializable;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="finanza")
public class Finanza implements Serializable{
    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_Fianza")
    Long idFinanza;
    Long idFactura;
    String fecha;
    String hora;
    
    public Finanza(){}

    public Finanza(Long idFactura, String fecha, String hora) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.hora = hora;
    }
}
