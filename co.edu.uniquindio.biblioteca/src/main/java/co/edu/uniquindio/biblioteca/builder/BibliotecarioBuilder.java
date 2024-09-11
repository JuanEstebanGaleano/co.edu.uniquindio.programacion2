package co.edu.uniquindio.biblioteca.builder;

import co.edu.uniquindio.biblioteca.model.Bibliotecario;
import co.edu.uniquindio.biblioteca.model.Libro;
import co.edu.uniquindio.biblioteca.model.Prestamo;

import java.util.ArrayList;
import java.util.List;

public class BibliotecarioBuilder {

    private String nombre;
    private String idEmpleado;
    private List<Libro> listaLibros = new ArrayList<>();
    private List<Prestamo> listaPrestamos = new ArrayList<>();

    public BibliotecarioBuilder() {
    }

    public BibliotecarioBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public BibliotecarioBuilder setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
        return this;
    }

    public BibliotecarioBuilder setListaLibros(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
        return this;
    }

    public BibliotecarioBuilder setListaPrestamos(List<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
        return this;
    }

    public Bibliotecario build() {
        Bibliotecario bibliotecario = new Bibliotecario(nombre, idEmpleado);
        bibliotecario.setListaLibros(listaLibros);
        bibliotecario.setListaPrestamos(listaPrestamos);
        return bibliotecario;
    }
}


















