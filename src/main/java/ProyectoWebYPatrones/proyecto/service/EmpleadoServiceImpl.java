package ProyectoWebYPatrones.proyecto.service;

import ProyectoWebYPatrones.proyecto.dao.EmpleadoDao;
import ProyectoWebYPatrones.proyecto.dao.PuestoDao;
import ProyectoWebYPatrones.proyecto.domain.Empleado;
import ProyectoWebYPatrones.proyecto.domain.Puesto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class EmpleadoServiceImpl implements EmpleadoService {
    @Autowired
    private EmpleadoDao empleadoDao;
    @Autowired
    private PuestoDao puestoDao;
    
    @Override
    @Transactional (readOnly = true)
    public List<Empleado> getEmpleados() {
        return (List<Empleado>) empleadoDao.findAll();
    }

    @Override
    @Transactional
    public void save(Empleado empleado) {
        Puesto puesto = empleado.getPuesto();
        puesto = puestoDao.save(puesto);
        empleado.setPuesto(puesto);
        empleadoDao.save(empleado);
    }

    @Override
    @Transactional
    public void delete(Empleado empleado) {
        empleadoDao.delete(empleado);
    }

    @Override
    @Transactional (readOnly = true)
    public Empleado getEmpleado(Empleado empleado) {
        return empleadoDao.findById(empleado.getIdEmpleado()).orElse(null);
    }
}
