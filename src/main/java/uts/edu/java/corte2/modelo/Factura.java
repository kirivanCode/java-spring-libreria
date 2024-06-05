
package uts.edu.java.corte2.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double total;

    @OneToMany(mappedBy = "factura")
    private List<LibroSeleccionado> librosSeleccionados;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<LibroSeleccionado> getLibrosSeleccionados() {
        return librosSeleccionados;
    }

    public void setLibrosSeleccionados(List<LibroSeleccionado> librosSeleccionados) {
        this.librosSeleccionados = librosSeleccionados;
    }

  
}
