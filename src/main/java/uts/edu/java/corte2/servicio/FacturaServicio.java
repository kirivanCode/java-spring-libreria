package uts.edu.java.corte2.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uts.edu.java.corte2.modelo.Factura;
import uts.edu.java.corte2.repositorio.FacturaRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServicio {

    @Autowired
    private FacturaRepositorio facturaRepositorio;

    public List<Factura> listarTodas() {
        return facturaRepositorio.findAll();
    }

    public Optional<Factura> obtenerPorId(Long id) {
        return facturaRepositorio.findById(id);
    }

    public Factura guardar(Factura factura) {
        return facturaRepositorio.save(factura);
    }

    public void eliminar(Long id) {
        facturaRepositorio.deleteById(id);
    }
}
