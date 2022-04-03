package ProyectoWebYPatrones.proyecto.domain;

import java.io.Serializable;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="reservacion")
public class Reservacion {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long idreservacion;
    String dia;
    String hora;
    String cantpersonas;
    String platillos;
    String nombre;
    String apellidos;
    String cedula;
    String notas;
    
    public Reservacion (){}

    public Reservacion(String dia, String hora, String cantpersonas, String platillos, String nombre, String apellidos, String cedula, String notas) {
        this.dia = dia;
        this.hora = hora;
        this.cantpersonas = cantpersonas;
        this.platillos = platillos;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.notas = notas;
    }
}
