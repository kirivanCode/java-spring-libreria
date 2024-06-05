package uts.edu.java.corte2.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uts.edu.java.corte2.modelo.Rol;
import uts.edu.java.corte2.servicio.RolServicio;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RolControlador {

    @Autowired
    private RolServicio rolServicio;

    @GetMapping
    public List<Rol> listarTodos() {
        return rolServicio.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> obtenerPorId(@PathVariable Long id) {
        Optional<Rol> rol = rolServicio.obtenerPorId(id);
        return rol.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Rol guardar(@RequestBody Rol rol) {
        return rolServicio.guardar(rol);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        rolServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
