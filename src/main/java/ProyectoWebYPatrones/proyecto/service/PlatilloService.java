package ProyectoWebYPatrones.proyecto.service;

import ProyectoWebYPatrones.proyecto.domain.Platillo;
import java.util.List;

public interface PlatilloService {
    public List<Platillo> getPlatillos();
    public void save(Platillo platillo);
    public void delete(Platillo platillo);
    public Platillo getPlatillo(Platillo platillo);
}
