package co.edu.uniquindio.programacion2trabajos.gestionBiblioteca.model;

import co.edu.uniquindio.programacion2trabajos.gestionBiblioteca.model.services.GestionInventario;

import java.util.ArrayList;
import java.util.List;

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
    // Implementación de gestión de inventario
    public void gestionarItem() {
        System.out.println("Gestión de ítem de la biblioteca realizada.");
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

    @Override
    public String toString() {
        return "Bibliotecario{" +
                "prestamos=" + prestamos +
                '}';
    }
}
