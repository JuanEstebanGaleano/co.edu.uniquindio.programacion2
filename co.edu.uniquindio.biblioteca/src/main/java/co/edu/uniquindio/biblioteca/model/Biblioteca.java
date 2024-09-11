package co.edu.uniquindio.biblioteca.model;

import co.edu.uniquindio.biblioteca.enums.Estado;
import co.edu.uniquindio.biblioteca.service.IMiembroCrud;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca implements IMiembroCrud {

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

    private Bibliotecario obtenerBibliotecario(String idEmpleado){
        for (Bibliotecario bibliotecario : getListaBibliotecarios()) {
            if(bibliotecario.getIdEmpleado().equals(idEmpleado)){

                return bibliotecario;
            }
        }
        System.out.println("No se encontro el bibliotecario");

        return null;
    }

    private Libro obtenerLibro(String ISBN){
        for (Libro libro : getListaLibros()) {
            if(libro.getISBN().equals(ISBN)){

                return libro;
            }
        }
        return null;
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
        return false;
    }

    private Miembro obtenerMiembro(String cedula){
        for (Miembro miembro : getListaMiembros()) {
            if(miembro.getCedula().equals(cedula)){
                return miembro;
            }
        }
        return null;
    }

    @Override
    public boolean crearMiembro(String nombre, String cedula) {
        Miembro miembroExistente = obtenerMiembro(cedula);
        if (miembroExistente == null){
            Miembro miembro = new Miembro();
            miembro.setNombre(nombre);
            miembro.setCedula(cedula);
            getListaMiembros().add(miembro);
            return true;
        }else
            return false;
    }

    @Override
    public boolean eliminarMiembro(String cedula) {
        Miembro miembroExistente = obtenerMiembro(cedula);
        if (miembroExistente != null) {
            getListaMiembros().remove(miembroExistente);
            return true;
        }else
            return false;
    }

    @Override
    public boolean actualizarMiembro(String nombreNuevo, String cedula, String cedulaNueva) {
        Miembro miembroExistente = obtenerMiembro(cedula);
        if (miembroExistente != null){
            miembroExistente.setNombre(nombreNuevo);
            miembroExistente.setCedula(cedulaNueva);
            return true;
        }else
            return false;
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
                            libro.setBibliotecarioAsociado(bibliotecario);
                            libro.setPrestamoAsociado(prestamo);
                            bibliotecario.getListaLibros().add(libro);
                            bibliotecario.getListaPrestamos().add(prestamo);
                            miembro.getListaPrestamosActivos().add(prestamo);
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
}
