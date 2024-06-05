package uts.edu.java.corte2.modelo;



import javax.persistence.*;
import javax.validation.constraints.Min;


@Entity
@Table(name = "Libro")

public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(value = 1, message = "El ID del insumo debe ser mayor que 0")
    private int id_libro;

    private String titulo;
    private String autor;
    private String genero;
    private String imagen;
    private float precio;
    private int stock;
    
	public int getId_libro() {
		return id_libro;
	}
	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Libro [id_libro=" + id_libro + ", titulo=" + titulo + ", autor=" + autor + ", genero=" + genero
				+ ", imagen=" + imagen + ", precio=" + precio + ", stock=" + stock + "]";
	}
	
	
	
    
    
    

    
    

    
}