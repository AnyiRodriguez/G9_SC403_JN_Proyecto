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
    @Column(name="id_Finanza")
    Long idFinanza;
    String fecha;
    String hora;
    int cortetotal;
    
    @JoinColumn(name="id_Cliente", referencedColumnName="id_Cliente")
    @ManyToOne
    public Cliente cliente;
    
    public Finanza(){}

    public Finanza(String fecha, String hora, Cliente cliente, int corteTotal) {
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.cortetotal = corteTotal;
    }
    public void setCorteTotal(int corteTotal){
        this.cortetotal = corteTotal;
    }
}
