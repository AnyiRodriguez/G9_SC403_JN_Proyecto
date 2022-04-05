package ProyectoWebYPatrones.proyecto.domain;

import java.io.Serializable;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="menu")
public class Menu implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_Menu")
    Long idMenu;
    Long idPlatillo;
    String tipo;
    
    public Menu(){}

    public Menu(Long idPlatillo, String tipo) {
        this.idPlatillo = idPlatillo;
        this.tipo = tipo;
    }
}
