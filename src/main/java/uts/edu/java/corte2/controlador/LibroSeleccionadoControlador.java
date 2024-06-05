package uts.edu.java.corte2.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uts.edu.java.corte2.modelo.Libro;
import uts.edu.java.corte2.modelo.LibroSeleccionado;
import uts.edu.java.corte2.servicio.LibroSeleccionadoServicio;
import uts.edu.java.corte2.servicio.LibroService;
import uts.edu.java.corte2.servicio.UsuarioServicio;
import uts.edu.java.corte2.servicio.FacturaServicio;

import java.util.List;

@Controller
@RequestMapping("/views/libroSeleccionado")
public class LibroSeleccionadoControlador {

    @Autowired
    private LibroSeleccionadoServicio libroSeleccionadoServicio;

    @Autowired
    private LibroService libroServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private FacturaServicio facturaServicio;

    @GetMapping("/")
    public String listarLibrosSeleccionados(Model model) {
        List<LibroSeleccionado> librosSeleccionados_lista = libroSeleccionadoServicio.listarTodos();
        System.out.println("Lista de libros" + librosSeleccionados_lista);
        model.addAttribute("librosSeleccionado", librosSeleccionados_lista);
        return "/views/libroSeleccionado/libroSeleccionado";
    }


    @GetMapping("/new")
    public String mostrarFormularioDeNuevoLibroSeleccionado(Model model) {
        LibroSeleccionado libroSeleccionado = new LibroSeleccionado();
        model.addAttribute("libroSeleccionado", libroSeleccionado );
        model.addAttribute("libros", libroServicio.listadoxd());
        model.addAttribute("usuarios", usuarioServicio.listarUsuarios());
        model.addAttribute("facturas", facturaServicio.listarTodas());
        return "/views/libroSeleccionado/nuevo_carrito";
    }

    @GetMapping("/listar/{id}")
    public String mostrarFormularioDeEditarLibroSeleccionado(@PathVariable Long id, Model model) {
        LibroSeleccionado libroSeleccionado = libroSeleccionadoServicio.obtenerPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Libro Seleccionado inválido Id:" + id));
        model.addAttribute("libroSeleccionado", libroSeleccionado);
        model.addAttribute("libros", libroServicio.listadoxd());
        model.addAttribute("usuarios", usuarioServicio.listarUsuarios());
        model.addAttribute("facturas", facturaServicio.listarTodas());
        return "/views/libroSeleccionado/editar";
    }

    @PostMapping("/save")
    public String guardarLibroSeleccionado(@ModelAttribute("libroSeleccionado") LibroSeleccionado libroSeleccionado) {
        libroSeleccionadoServicio.guardar(libroSeleccionado);
        return "redirect:/views/libroSeleccionado";
    }

    @GetMapping("/delete/{id}")
    public String eliminarLibroSeleccionado(@PathVariable Long id) {
        libroSeleccionadoServicio.eliminar(id);
        return "redirect:/views/libroSeleccionado";
    }
}
