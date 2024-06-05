package uts.edu.java.corte2.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uts.edu.java.corte2.modelo.Libro;
import uts.edu.java.corte2.repositorio.LibroRepositorio;


@Service
public class LibroService implements ILibroService {

    @Autowired
    private LibroRepositorio librorepositorio;

    @Override
    public List<Libro> listadoxd() {
        return librorepositorio.findAll();
    }

    @Override
    public Libro listarId(int id_libro) {
    	 return librorepositorio.findById(id_libro).orElse(null);
    }

    @Override
    public void save(Libro libro) {
        librorepositorio.save(libro);
    }

    @Override
    public void delete(int id_libro) {
        librorepositorio.deleteById(id_libro);;
    }

	
}
