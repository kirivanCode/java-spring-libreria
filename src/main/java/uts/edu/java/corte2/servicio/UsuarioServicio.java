package uts.edu.java.corte2.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import uts.edu.java.corte2.controlador.dto.UsuarioRegistroDTO;
import uts.edu.java.corte2.modelo.Usuario;




public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();
	
}
