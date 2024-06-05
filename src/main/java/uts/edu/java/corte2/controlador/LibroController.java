package uts.edu.java.corte2.controlador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import uts.edu.java.corte2.modelo.Libro;
import uts.edu.java.corte2.servicio.LibroService;

@Controller
@RequestMapping("/views/libro")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping("/")
    public String verLibro(Model model) {
        List<Libro> listalibro = libroService.listadoxd();
       
        model.addAttribute("listalibro", listalibro);
        return "/views/libro/libro";
    }

    @GetMapping("/new")
    public String mostrarPaginaNuevoLibro(Model model) {
        Libro libro = new Libro();
        model.addAttribute("libro", libro);
        return "/views/libro/nuevo_libro";
    }

    @PostMapping("/save")
    public String saveLibro(@Valid @ModelAttribute("libro") Libro libro, Errors errors, Model model,
                             RedirectAttributes attribute) {
        if (errors.hasErrors()) {
            return "/views/libro/nuevo_libro";
        }
        libroService.save(libro);
        attribute.addFlashAttribute("success", "Libro guardado con éxito");
        return "redirect:/views/libro/";
    }

    @GetMapping("/listar/{id_libro}")
    public String listarId(@PathVariable int id_libro, Model model) {
        model.addAttribute("libro", libroService.listarId(id_libro));
        return "/views/libro/editar_libro";
    }

    @RequestMapping("/delete/{id_libro}")
    public String deleteLibro(@PathVariable(name = "id_libro") int id_libro, RedirectAttributes attribute) {
        try {
            libroService.delete(id_libro);
            attribute.addFlashAttribute("info", "Libro eliminado correctamente");
        } catch (Exception e) {
            attribute.addFlashAttribute("error", "No se pudo eliminar el libro");
        }
        return "redirect:/views/libro/";
    }
}