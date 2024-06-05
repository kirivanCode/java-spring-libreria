package uts.edu.java.corte2.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uts.edu.java.corte2.modelo.Rol;
import uts.edu.java.corte2.repositorio.RolRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class RolServicio {

    @Autowired
    private RolRepositorio rolRepositorio;

    public List<Rol> listarTodos() {
        return rolRepositorio.findAll();
    }

    public Optional<Rol> obtenerPorId(Long id) {
        return rolRepositorio.findById(id);
    }

    public Rol guardar(Rol rol) {
        return rolRepositorio.save(rol);
    }

    public void eliminar(Long id) {
        rolRepositorio.deleteById(id);
    }
}
