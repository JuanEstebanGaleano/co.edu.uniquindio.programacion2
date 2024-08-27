package co.edu.uniquindio.programacion2trabajos.gestionBiblioteca.model;

import co.edu.uniquindio.programacion2trabajos.gestionBiblioteca.model.services.GestionInventario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class Bibliotecario extends Empleado implements GestionInventario {
    private List<Prestamo> prestamos = new ArrayList<>();

    public Bibliotecario(String nombre, String idEmpleado) {
        super(nombre, idEmpleado);
    }

    // Métodos de gestión de préstamos
    public void gestionarPrestamos(Miembro miembro, Libro libro) {
        if (libro.isDisponible()) {
            Prestamo nuevoPrestamo = new Prestamo(libro, miembro);
            miembro.agregarPrestamo(nuevoPrestamo);
            libro.setDisponible(false);
            prestamos.add(nuevoPrestamo); // Añadir el préstamo a la lista
            System.out.println("Préstamo realizado: " + nuevoPrestamo);
        } else {
            System.out.println("El libro no está disponible para préstamo.");
        }
    }

    public void devolverLibro(Miembro miembro, Prestamo prestamo) {
        if (miembro.getPrestamosActivos().contains(prestamo)) {
            if (prestamo.esAtrasado()) {
                BigDecimal multaMonto = new BigDecimal("5.00"); // Ejemplo de multa
                Multa multa = new Multa(miembro, multaMonto);
                miembro.agregarMulta(multa);
                System.out.println("Multa aplicada por atraso: " + multaMonto);
            }
            prestamo.getLibro().setDisponible(true);
            prestamo.setFechaDevolucion(LocalDate.now());
            miembro.removerPrestamo(prestamo);
            prestamos.remove(prestamo); // Eliminar el préstamo de la lista
            System.out.println("Libro devuelto: " + prestamo.getLibro().getTitulo());
        } else {
            System.out.println("El préstamo no pertenece a este miembro.");
        }
    }

    // Implementación de gestión de inventario
    @Override
    public void gestionarItem() {
        System.out.println("Gestión de ítem de la biblioteca realizada.");
    }

    // Métodos de visualización
    public void mostrarPrestamosActivos(Miembro miembro) {
        List<Prestamo> prestamosActivos = miembro.getPrestamosActivos();
        if (prestamosActivos.isEmpty()) {
            System.out.println("No hay préstamos activos para el miembro: " + miembro.getNombre());
        } else {
            System.out.println("Préstamos activos para el miembro: " + miembro.getNombre());
            for (Prestamo prestamo : prestamosActivos) {
                System.out.println(prestamo);
            }
        }
    }

    public void mostrarMultasPendientes(Miembro miembro) {
        List<Multa> multas = miembro.getMultasPendientes();
        if (multas.isEmpty()) {
            System.out.println("No hay multas pendientes para el miembro: " + miembro.getNombre());
        } else {
            System.out.println("Multas pendientes para el miembro: " + miembro.getNombre());
            for (Multa multa : multas) {
                System.out.println(multa);
            }
        }
    }

    // Nuevo método para obtener todos los préstamos
    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    @Override
    public String toString() {
        return "Bibliotecario{" +
                "prestamos=" + prestamos +
                '}';
    }
}
