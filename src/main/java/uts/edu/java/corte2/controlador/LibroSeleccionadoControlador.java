package uts.edu.java.corte2.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uts.edu.java.corte2.modelo.Factura;
import uts.edu.java.corte2.modelo.Libro;
import uts.edu.java.corte2.modelo.LibroSeleccionado;
import uts.edu.java.corte2.modelo.Usuario;
import uts.edu.java.corte2.servicio.FacturaServicio;
import uts.edu.java.corte2.servicio.LibroSeleccionadoServicio;
import uts.edu.java.corte2.servicio.LibroService;
import uts.edu.java.corte2.servicio.UsuarioServicio;

import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public String listarTodos(Model model) {
        List<LibroSeleccionado> librosSeleccionados = libroSeleccionadoServicio.listarTodos();
        model.addAttribute("librosSeleccionados", librosSeleccionados);
        return "views/libroSeleccionado/libroSeleccionado";
    }

    @GetMapping("/new")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("libroSeleccionado", new LibroSeleccionado());

        List<Libro> listaLibros = libroServicio.listadoxd();
        List<Usuario> listaUsuarios = usuarioServicio.listarUsuarios();
        List<Factura> listaFacturas = facturaServicio.listarTodas();

        model.addAttribute("listaLibros", listaLibros);
        model.addAttribute("listaUsuarios", listaUsuarios);
        model.addAttribute("listaFacturas", listaFacturas);

        return "views/libroSeleccionado/new_libroSeleccionado";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute LibroSeleccionado libroSeleccionado) {
        libroSeleccionadoServicio.guardar(libroSeleccionado);
        return "redirect:/views/libroSeleccionado";
    }
    
    

    @GetMapping("/edit/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Optional<LibroSeleccionado> libroSeleccionado = libroSeleccionadoServicio.obtenerPorId(id);
        if (libroSeleccionado.isPresent()) {
            model.addAttribute("libroSeleccionado", libroSeleccionado.get());

            List<Libro> listaLibros = libroServicio.listadoxd();
            List<Usuario> listaUsuarios = usuarioServicio.listarUsuarios();
            List<Factura> listaFacturas = facturaServicio.listarTodas();

            model.addAttribute("listaLibros", listaLibros);
            model.addAttribute("listaUsuarios", listaUsuarios);
            model.addAttribute("listaFacturas", listaFacturas);

            return "views/libroSeleccionado/editar";
        } else {
            return "redirect:/views/libroSeleccionado";
        }
    }

    @PostMapping("/update/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute LibroSeleccionado detallesLibroSeleccionado) {
        Optional<LibroSeleccionado> libroSeleccionado = libroSeleccionadoServicio.obtenerPorId(id);
        if (libroSeleccionado.isPresent()) {
            LibroSeleccionado libroExistente = libroSeleccionado.get();
            libroExistente.setLibro(detallesLibroSeleccionado.getLibro());
            libroExistente.setUsuarios(detallesLibroSeleccionado.getUsuarios());
            libroExistente.setFactura(detallesLibroSeleccionado.getFactura());
            libroExistente.setCantidad(detallesLibroSeleccionado.getCantidad());
            libroExistente.setComprallave(detallesLibroSeleccionado.getComprallave());
            libroSeleccionadoServicio.guardar(libroExistente);
        }
        return "redirect:/views/libroSeleccionado";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable Long id) {
        libroSeleccionadoServicio.eliminar(id);
        return "redirect:/views/libroSeleccionado";
    }
}

