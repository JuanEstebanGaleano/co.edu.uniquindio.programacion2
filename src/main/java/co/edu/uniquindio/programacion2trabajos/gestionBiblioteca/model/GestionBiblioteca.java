package co.edu.uniquindio.programacion2trabajos.gestionBiblioteca.model;


import java.util.ArrayList;
import java.util.List;

public class GestionBiblioteca{

    private final List<Libro> libros;
    private final List<Miembro> miembros;
    private final List<Prestamo> prestamos;
    private final List<Multa> multas;
    private final List<Empleado> empleados;

    public GestionBiblioteca() {
        this.libros = new ArrayList<>();
        this.miembros = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.multas = new ArrayList<>();
        this.empleados = new ArrayList<>();
    }

    // Métodos para gestionar libros
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void removerLibro(Libro libro) {
        libros.remove(libro);
    }

    public Libro buscarLibroPorISBN(String ISBN) {
        for (Libro libro : libros) {
            if (libro.getISBN().equals(ISBN)) {
                return libro;
            }
        }
        return null;
    }

    // Métodos para gestionar miembros
    public void agregarMiembro(Miembro miembro) {
        miembros.add(miembro);
    }

    public void removerMiembro(Miembro miembro) {
        miembros.remove(miembro);
    }

    public Miembro buscarMiembroPorID(String idMiembro) {
        for (Miembro miembro : miembros) {
            if (miembro.getIdMiembro().equals(idMiembro)) {
                return miembro;
            }
        }
        return null;
    }

    // Métodos para gestionar préstamos
    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public void removerPrestamo(Prestamo prestamo) {
        prestamos.remove(prestamo);
    }

    public List<Prestamo> obtenerPrestamosActivosPorMiembro(Miembro miembro) {
        List<Prestamo> prestamosActivos = new ArrayList<>();
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getMiembro().equals(miembro) && prestamo.getFechaDevolucion() == null) {
                prestamosActivos.add(prestamo);
            }
        }
        return prestamosActivos;
    }

    // Métodos para gestionar multas
    public void agregarMulta(Multa multa) {
        multas.add(multa);
    }

    public void removerMulta(Multa multa) {
        multas.remove(multa);
    }

    public List<Multa> obtenerMultasPendientesPorMiembro(Miembro miembro) {
        List<Multa> multasPendientes = new ArrayList<>();
        for (Multa multa : multas) {
            if (multa.getMiembro().equals(miembro) && !multa.isPagada()) {
                multasPendientes.add(multa);
            }
        }
        return multasPendientes;
    }

    // Métodos para gestionar empleados
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void removerEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

    public Empleado buscarEmpleadoPorID(String idEmpleado) {
        for (Empleado empleado : empleados) {
            if (empleado.getIdEmpleado().equals(idEmpleado)) {
                return empleado;
            }
        }
        return null;
    }

    // Getters para las listas
    public List<Libro> getLibros() {
        return libros;
    }

    public List<Miembro> getMiembros() {
        return miembros;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public List<Multa> getMultas() {
        return multas;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
}