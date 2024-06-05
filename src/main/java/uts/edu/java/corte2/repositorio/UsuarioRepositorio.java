package uts.edu.java.corte2.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import uts.edu.java.corte2.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
