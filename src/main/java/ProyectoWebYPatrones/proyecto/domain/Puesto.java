package ProyectoWebYPatrones.proyecto.domain;

import java.io.Serializable;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="Puesto")
public class Puesto implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_Puesto")
    Long idPuesto;
    String rango;
    String salario;
    
    public Puesto(){}

    public Puesto(String rango, String salario) {
        this.rango = rango;
        this.salario = salario;
    }
    /*
        Rangos:
        1. Maitre
        2. Chef
        3. Bartender
        4. Cocinerx
        5. Meserx
        6. Recepcionista
        7. Limpieza
    */
}
