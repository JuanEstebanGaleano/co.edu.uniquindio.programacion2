package co.edu.uniquindio.programacion2trabajos.gestionBiblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear libros, miembros y bibliotecario
        Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes", "1234567890");
        Libro libro2 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", "0987654321");
        Libro libro3 = new Libro("1984", "George Orwell", "1122334455");
        Miembro miembro1 = new Miembro("Juan Pérez", "M001");
        Miembro miembro2 = new Miembro("Ana García", "M002");
        Bibliotecario bibliotecario = new Bibliotecario("Carlos López", "E001");

        // Realizar préstamos
        bibliotecario.gestionarPrestamos(miembro1, libro1);
        bibliotecario.gestionarPrestamos(miembro2, libro2);

        // Ejercicio 1: Buscar un libro y mostrar quién lo tiene
        System.out.println("\nEjercicio 1: Buscar un libro y mostrar quién lo tiene");
        String tituloBuscado = "El Quijote";
        boolean libroEncontrado = false;
        for (Prestamo prestamo : miembro1.getPrestamosActivos()) {
            if (prestamo.getLibro().getTitulo().equalsIgnoreCase(tituloBuscado)) {
                System.out.println("El libro '" + tituloBuscado + "' está en préstamo por " + prestamo.getMiembro().getNombre());
                libroEncontrado = true;
                break;
            }
        }
        if (!libroEncontrado) {
            for (Prestamo prestamo : miembro2.getPrestamosActivos()) {
                if (prestamo.getLibro().getTitulo().equalsIgnoreCase(tituloBuscado)) {
                    System.out.println("El libro '" + tituloBuscado + "' está en préstamo por " + prestamo.getMiembro().getNombre());
                    libroEncontrado = true;
                    break;
                }
            }
        }
        if (!libroEncontrado) {
            System.out.println("El libro '" + tituloBuscado + "' no está en préstamo.");
        }

        // Ejercicio 2: Ver todos los libros prestados a un miembro específico
        System.out.println("\nEjercicio 2: Ver todos los libros prestados a un miembro específico");
        String miembroBuscado = "Juan Pérez";
        boolean hayLibrosPrestados = false;
        if (miembro1.getNombre().equalsIgnoreCase(miembroBuscado)) {
            for (Prestamo prestamo : miembro1.getPrestamosActivos()) {
                System.out.println(prestamo.getLibro().getTitulo());
                hayLibrosPrestados = true;
            }
        } else if (miembro2.getNombre().equalsIgnoreCase(miembroBuscado)) {
            for (Prestamo prestamo : miembro2.getPrestamosActivos()) {
                System.out.println(prestamo.getLibro().getTitulo());
                hayLibrosPrestados = true;
            }
        }
        if (!hayLibrosPrestados) {
            System.out.println("No hay libros prestados a " + miembroBuscado);
        }

        // Ejercicio 3: Listar todos los libros disponibles en la biblioteca
        System.out.println("\nEjercicio 3: Listar todos los libros disponibles en la biblioteca");
        List<Libro> todosLosLibros = List.of(libro1, libro2, libro3);
        List<Libro> librosPrestados = new ArrayList<>();
        for (Prestamo prestamo : miembro1.getPrestamosActivos()) {
            librosPrestados.add(prestamo.getLibro());
        }
        for (Prestamo prestamo : miembro2.getPrestamosActivos()) {
            librosPrestados.add(prestamo.getLibro());
        }
        System.out.println("Libros disponibles en la biblioteca:");
        for (Libro libro : todosLosLibros) {
            if (!librosPrestados.contains(libro)) {
                System.out.println(libro.getTitulo() + " por " + libro.getAutor());
            }
        }
        // Mostrar multas pendientes
        System.out.println("\nMultas pendientes:");
        bibliotecario.mostrarMultasPendientes(miembro1);
        bibliotecario.mostrarMultasPendientes(miembro2);
    }
}
