package uts.edu.java.corte2.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uts.edu.java.corte2.modelo.Factura;
import uts.edu.java.corte2.servicio.FacturaServicio;

import java.util.List;

@Controller
@RequestMapping("/views/facturas")
public class FacturaControlador {

    @Autowired
    private FacturaServicio facturaServicio;

    @GetMapping
    public String listarFacturas(Model model) {
        List<Factura> facturas = facturaServicio.listarTodas();
        model.addAttribute("facturas", facturas);
        return "/views/facturas/facturas";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevaFactura(Model model) {
        model.addAttribute("factura", new Factura());
        return "/views/facturas/factura_form";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditarFactura(@PathVariable Long id, Model model) {
        Factura factura = facturaServicio.obtenerPorId(id).orElseThrow(() -> new IllegalArgumentException("Factura inválida Id:" + id));
        model.addAttribute("factura", factura);
        return "/views/facturas/factura_form";
    }

    @PostMapping("/guardar")
    public String guardarFactura(@ModelAttribute("factura") Factura factura) {
        facturaServicio.guardar(factura);
        return "redirect:/views/facturas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarFactura(@PathVariable Long id) {
        facturaServicio.eliminar(id);
        return "redirect:/views/facturas";
    }
}
