package uts.edu.java.corte2.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import uts.edu.java.corte2.modelo.Libro;

public interface LibroRepositorio extends JpaRepository<Libro, Integer> {
}
