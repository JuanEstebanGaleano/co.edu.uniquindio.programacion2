package co.edu.uniquindio.biblioteca.model;

import co.edu.uniquindio.biblioteca.enums.Estado;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private String nombre;
    private List<Miembro> listaMiembros = new ArrayList<>();
    private List<Prestamo> listaPrestamos = new ArrayList<>();
    private List<Libro> listaLibros = new ArrayList<>();
    private List<Bibliotecario> listaBibliotecarios = new ArrayList<>();

    public Biblioteca(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Miembro> getListaMiembros() {
        return listaMiembros;
    }

    public void setListaMiembros(List<Miembro> listaMiembros) {
        this.listaMiembros = listaMiembros;
    }

    public List<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(List<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public List<Bibliotecario> getListaBibliotecarios() {
        return listaBibliotecarios;
    }

    public void setListaBibliotecarios(List<Bibliotecario> listaBibliotecarios) {
        this.listaBibliotecarios = listaBibliotecarios;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nombre='" + nombre + '\'' +
                ", listaMiembros=" + listaMiembros +
                ", listaPrestamos=" + listaPrestamos +
                ", listaLibros=" + listaLibros +
                ", listaBibliotecarios=" + listaBibliotecarios +
                '}';
    }

    public Miembro obtenerMiembro(String cedula){
        for (Miembro miembro : getListaMiembros()) {
            if(miembro.getCedula().equals(cedula)){
                return miembro;
            }
        }
        System.out.println("No se encontro el miembro");

        return null;
    }

    public Bibliotecario obtenerBibliotecario(String idEmpleado){
        for (Bibliotecario bibliotecario : getListaBibliotecarios()) {
            if(bibliotecario.getIdEmpleado().equals(idEmpleado)){

                return bibliotecario;
            }
        }
        System.out.println("No se encontro el bibliotecario");

        return null;
    }

    public Libro obtenerLibro(String ISBN){
        for (Libro libro : getListaLibros()) {
            if(libro.getISBN().equals(ISBN)){

                return libro;
            }
        }
        System.out.println("No se encontro el bibliotecario");

        return null;
    }

    public Prestamo crearPrestamo(LocalDate fechaPrestamo,
                                 LocalDate fechaDevolucion,
                                 String cedulaMiembro,
                                 String ISBN,
                                 String idBibliotecario) {
        Prestamo prestamo = new Prestamo();
        if (obtenerLibro(ISBN) != null) {
            Libro libro = obtenerLibro(ISBN);
            if (ISBN == libro.getISBN()) {
                if (obtenerMiembro(cedulaMiembro) != null) {
                    Miembro miembro = obtenerMiembro(cedulaMiembro);
                    if (obtenerBibliotecario(idBibliotecario) != null) {
                        Bibliotecario bibliotecario = obtenerBibliotecario(idBibliotecario);
                        if (disponibilidadLibro(ISBN) == true) {
                            prestamo.setFechaPrestamo(fechaPrestamo);
                            prestamo.setFechaDevolucion(fechaDevolucion);
                            prestamo.setMiembroAsociado(miembro);
                            prestamo.setLibroAsociado(libro);
                            prestamo.setBibliotecarioAsociado(bibliotecario);
                            getListaPrestamos().add(prestamo);
                            libro.setEstado(Estado.PRESTADO);
                            System.out.println("RESERVA CREADA\n" + "Libro prestado: " + libro.getTitulo() + "\n" +
                                    "ISBN: " + libro.getISBN() + "\n" + "Miembro asociado: " + miembro.getNombre() + "\n" +
                                    "Bibliotecario asociado: " + bibliotecario.getNombre() + "\n" +
                                    "Fecha prestamo: " + fechaPrestamo + "\n" + "Fecha devolucion: " + fechaDevolucion);
                        }
                    }
                }
            }
        }

        return prestamo;
    }

    public boolean disponibilidadLibro(String ISBN){
        for (Libro libro : getListaLibros()){
            if (libro.getISBN().equalsIgnoreCase(ISBN)){
                if (libro.getEstado() == Estado.DISPONIBLE){
                    return true;
                } else {
                    System.out.println("Libro no esta disponible");
                    return false;
                }
            }
        }
        System.out.println("Libro no encontrado en la lista");
        return false;
    }

}
