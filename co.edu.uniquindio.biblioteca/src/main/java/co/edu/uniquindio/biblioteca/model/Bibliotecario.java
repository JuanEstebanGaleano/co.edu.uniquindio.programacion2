package co.edu.uniquindio.biblioteca.model;

import co.edu.uniquindio.biblioteca.service.IGestionInventario;

import java.util.ArrayList;
import java.util.List;

public class Bibliotecario extends Empleado implements IGestionInventario {

    private List<Libro> listaLibros = new ArrayList();
    private List<Prestamo> listaPrestamos = new ArrayList();

    public Bibliotecario() {
    }

    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public List<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(List<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

    @Override
    public void gestionarItem() {
    
    }
}
