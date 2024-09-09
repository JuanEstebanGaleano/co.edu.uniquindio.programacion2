package co.edu.uniquindio.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Miembro {

    private String nombre;
    private String cedula;
    private List<Prestamo> listaPrestamosActivos = new ArrayList<>();

    public Miembro() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public List<Prestamo> getListaPrestamosActivos() {
        return listaPrestamosActivos;
    }

    public void setListaPrestamosActivos(List<Prestamo> listaPrestamosActivos) {
        this.listaPrestamosActivos = listaPrestamosActivos;
    }

    @Override
    public String toString() {
        return "Miembro{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", listaPrestamosActivos=" + listaPrestamosActivos +
                '}';
    }
}
