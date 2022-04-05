package ProyectoWebYPatrones.proyecto.service;

import ProyectoWebYPatrones.proyecto.domain.Finanza;
import java.util.List;

public interface FinanzaService {
    public List<Finanza> getFinanzas();
    public void save(Finanza finanza);
    public void delete(Finanza finanza);
    public Finanza getFinanza(Finanza finanza);
}
