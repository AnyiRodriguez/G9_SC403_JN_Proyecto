package ProyectoWebYPatrones.proyecto.domain;

import java.io.Serializable;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="reservaciones")
public class Reservaciones {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long idreservaciones;
    String dia;
    String hora;
    String cantpersonas;
    String platillos;
    
    public Reservaciones (){}

    public Reservaciones(String dia, String hora, String cantPersonas, String platillos) {
        this.dia = dia;
        this.hora = hora;
        this.cantpersonas = cantpersonas;
        this.platillos = platillos;
    }
    
}
