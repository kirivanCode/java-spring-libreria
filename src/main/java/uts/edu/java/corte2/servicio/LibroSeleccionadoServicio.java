package uts.edu.java.corte2.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uts.edu.java.corte2.modelo.LibroSeleccionado;
import uts.edu.java.corte2.repositorio.LibroSeleccionadoRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class LibroSeleccionadoServicio {

    @Autowired
    private LibroSeleccionadoRepositorio libroSeleccionadoRepositorio;

    public List<LibroSeleccionado> listarTodos() {
        return libroSeleccionadoRepositorio.findAll();
    }

    public Optional<LibroSeleccionado> obtenerPorId(Long id) {
        return libroSeleccionadoRepositorio.findById(id);
    }

    public LibroSeleccionado guardar(LibroSeleccionado libroSeleccionado) {
        return libroSeleccionadoRepositorio.save(libroSeleccionado);
    }

    public void eliminar(Long id) {
        libroSeleccionadoRepositorio.deleteById(id);
    }
}
