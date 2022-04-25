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
    String tipo;
    
    @JoinColumn(name="id_Platillo", referencedColumnName="id_Platillo")
    @ManyToOne
    private Platillo platillo;
    
    public Menu(){}

    public Menu(String tipo, Platillo platillo) {
        this.platillo = platillo;
        this.tipo = tipo;
    }
}
