package co.edu.uniquindio.programacion2trabajos.gestionBiblioteca.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Multa multaPendiente;


    public static void main(String[] args) {
        // Crear instancia de la biblioteca
        GestionBiblioteca biblioteca = new GestionBiblioteca();

        // Crear libros, miembros y bibliotecario
        Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes", "1234567890");
        Libro libro2 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", "0987654321");
        Libro libro3 = new Libro("1984", "George Orwell", "1122334455");
        Miembro miembro1 = new Miembro("Juan Pérez", "M001");
        Miembro miembro2 = new Miembro("Ana García", "M002");
        Empleado bibliotecario = new Empleado("Carlos López", "E001");

        // Agregar libros, miembros y empleados a la biblioteca
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarMiembro(miembro1);
        biblioteca.agregarMiembro(miembro2);
        biblioteca.agregarEmpleado(bibliotecario);

        // Realizar préstamos
        prestarLibro(biblioteca, miembro1, libro1);
        prestarLibro(biblioteca, miembro2, libro2);


        // Ejemplo de atraso
        LocalDate fechaAtrasada = LocalDate.now().minusDays(15); // 15 días atrás
        Prestamo prestamo1 = biblioteca.obtenerPrestamosActivosPorMiembro(miembro1).get(0);
        prestamo1.setFechaDevolucion(fechaAtrasada);

        // Añadir multa por atraso
        if (prestamo1.esAtrasado()) {
            BigDecimal montoMulta = new BigDecimal("10.00"); // Ejemplo de monto de multa
            Multa multa = new Multa(miembro1, montoMulta);
            biblioteca.agregarMulta(multa);
            miembro1.agregarMulta(multa);
        }

        // Ejercicio 1: Buscar un libro y mostrar quién lo tiene
        System.out.println("\nEjercicio 1: Buscar un libro y mostrar quién lo tiene");
        String tituloBuscado = "El Quijote";
        Prestamo prestamoEncontrado = buscarPrestamoPorTitulo(biblioteca, tituloBuscado);
        if (prestamoEncontrado != null) {
            System.out.println("El libro '" + tituloBuscado + "' está en préstamo por " + prestamoEncontrado.getMiembro().getNombre());
        } else {
            System.out.println("El libro '" + tituloBuscado + "' no está en préstamo.");
        }

        // Ejercicio 2: Ver todos los libros prestados a un miembro específico
        System.out.println("\nEjercicio 2: Ver todos los libros prestados a un miembro específico");
        String miembroBuscado = "Juan Pérez";
        Miembro miembro = biblioteca.buscarMiembroPorID("M001"); // Buscar miembro por ID
        if (miembro != null && miembro.getNombre().equalsIgnoreCase(miembroBuscado)) {
            List<Prestamo> prestamosActivos = biblioteca.obtenerPrestamosActivosPorMiembro(miembro);
            if (prestamosActivos.isEmpty()) {
                System.out.println("No hay libros prestados a " + miembroBuscado);
            } else {
                for (Prestamo prestamo : prestamosActivos) {
                    System.out.println(prestamo.getLibro().getTitulo());
                }
            }
        } else {
            System.out.println("No se encontró el miembro " + miembroBuscado);
        }

        // Ejercicio 3: Listar todos los libros disponibles en la biblioteca
        System.out.println("\nEjercicio 3: Listar todos los libros disponibles en la biblioteca");
        List<Libro> librosDisponibles = new ArrayList<>(biblioteca.getLibros());
        for (Prestamo prestamo : biblioteca.getPrestamos()) {
            librosDisponibles.remove(prestamo.getLibro());
        }
        System.out.println("Libros disponibles en la biblioteca:");
        for (Libro libro : librosDisponibles) {
            System.out.println(libro.getTitulo() + " por " + libro.getAutor());
        }

        // Mostrar multas pendientes
        System.out.println("\nMultas pendientes:");
        mostrarMultasPendientes(biblioteca, miembro1);
        mostrarMultasPendientes(biblioteca, miembro2);

        // Pagar una multa
        if (multaPendiente != null) {
            miembro1.pagarMulta(multaPendiente);
            multaPendiente.setPagada(true); // Actualizar el estado de la multa
            System.out.println("La multa de " + multaPendiente.getMonto() + " ha sido pagada.");
        }
    }

    private static void prestarLibro(GestionBiblioteca biblioteca, Miembro miembro, Libro libro) {
        if (libro.isDisponible()) {
            libro.setDisponible(false);
            Prestamo prestamo = new Prestamo(libro, miembro);
            biblioteca.agregarPrestamo(prestamo);
            miembro.agregarPrestamo(prestamo);
        } else {
            System.out.println("El libro '" + libro.getTitulo() + "' no está disponible para préstamo.");
        }
    }

    private static Prestamo buscarPrestamoPorTitulo(GestionBiblioteca biblioteca, String titulo) {
        for (Prestamo prestamo : biblioteca.getPrestamos()) {
            if (prestamo.getLibro().getTitulo().equalsIgnoreCase(titulo)) {
                return prestamo;
            }
        }
        return null;
    }

    private static void mostrarMultasPendientes(GestionBiblioteca biblioteca, Miembro miembro) {
        List<Multa> multasPendientes = biblioteca.obtenerMultasPendientesPorMiembro(miembro);
        if (multasPendientes.isEmpty()) {
            System.out.println("No hay multas pendientes para " + miembro.getNombre());
        } else {
            for (Multa multa : multasPendientes) {
                System.out.println(multa);
            }
        }
    }
}