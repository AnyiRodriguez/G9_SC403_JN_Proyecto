package ProyectoWebYPatrones.proyecto.domain;

import java.io.Serializable;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="empleado")
public class Empleado implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_Empleado")
    Long idEmpleado;
    Long idPuesto;
    String nombre;
    String apellidos;
    String cedula;
    String horario;
    
    public Empleado(){}

    public Empleado(String nombre, String apellidos, String cedula, String horario, Long idpuesto) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.horario = horario;
        this.idPuesto = idpuesto;
    }
    
    
}
