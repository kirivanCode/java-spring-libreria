package uts.edu.java.corte2.servicio;

import java.util.List;

import uts.edu.java.corte2.modelo.Libro;


public interface ILibroService {
    public List<Libro> listadoxd();
    
    public Libro listarId(int id_libro);
    public void save(Libro libro);
    public void delete(int id_libro);
}