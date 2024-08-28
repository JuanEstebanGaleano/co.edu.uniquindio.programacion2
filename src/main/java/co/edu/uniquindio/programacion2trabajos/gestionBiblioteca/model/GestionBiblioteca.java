package co.edu.uniquindio.programacion2trabajos.gestionBiblioteca.model;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class GestionBiblioteca {
    private List<Libro> libros;
    private List<Miembro> miembros;
    private List<Multa> multas; // Lista de multas
    public GestionBiblioteca() {
        libros = new ArrayList<>();
        miembros = new ArrayList<>();
        multas = new ArrayList<>();
    }
    public void agregarLibro(String titulo, String autor, String isbn) {
        if (!isbnValido(isbn)) {
            System.out.println("ISBN no válido.");
            return;
        }
        Libro libro = new Libro(titulo, autor, isbn);
        libros.add(libro);
        System.out.println("Libro agregado con éxito.");
    }
    public void agregarMiembro(String nombre, String idMiembro) {
        Miembro miembro = new Miembro(nombre, idMiembro);
        miembros.add(miembro);
        System.out.println("Miembro agregado con éxito.");
    }
    public void gestionarPrestamo(Bibliotecario bibliotecario, String isbn, String idMiembro) {
        if (libros.isEmpty() || miembros.isEmpty()) {
            System.out.println("Debe haber al menos un libro y un miembro en el sistema para realizar un préstamo.");
            return;
        }
        Libro libro = buscarLibro(isbn);
        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return;
        }
        if (!libro.estaDisponible()) {
            System.out.println("El libro no está disponible para préstamo.");
            return;
        }
        Miembro miembro = buscarMiembro(idMiembro);
        if (miembro == null) {
            System.out.println("Miembro no encontrado.");
            return;
        }
        Prestamo prestamo = new Prestamo(libro, miembro, new Date(), null);
        bibliotecario.gestionarItem();
        bibliotecario.gestionarPrestamo(prestamo);
        miembro.agregarPrestamo(prestamo);
        System.out.println("Préstamo realizado con éxito.");
    }
    public void agregarMulta(String idMiembro, BigDecimal monto) {
        Miembro miembro = buscarMiembro(idMiembro);
        if (miembro != null) {
            Multa multa = new Multa(miembro, monto);
            multas.add(multa);
            System.out.println("Multa agregada con éxito.");
        } else {
            System.out.println("Miembro no encontrado.");
        }
    }
    public void pagarMulta(String idMiembro) {
        boolean multaEncontrada = false;
        for (Multa multa : multas) {
            // Verifica que el ID del miembro coincida y la multa no esté pagada
            if (multa.getMiembro().getIdMiembro().equals(idMiembro) && !multa.isPagada()) {
                multa.setPagada(true);
                System.out.println("Multa pagada con éxito.");
                multaEncontrada = true;
                break; // Sale del bucle una vez que se encuentra y se paga la multa
            }
        }
        if (!multaEncontrada) {
            System.out.println("No se encontró multa pendiente para el miembro especificado.");
        }
    }
    public void mostrarMultas() {
        System.out.println("Lista de Multas:");
        for (Multa multa : multas) {
            System.out.println(multa);
        }
    }
    public void mostrarLibrosAdquiridosPorMiembro(String idMiembro) {
        Miembro miembro = buscarMiembro(idMiembro);
        if (miembro != null) {
            miembro.mostrarLibrosAdquiridos();
        } else {
            System.out.println("Miembro no encontrado.");
        }
    }
    private boolean isbnValido(String isbn) {
        return isbn != null && !isbn.trim().isEmpty() && isbn.matches("\\d+");
    }
    private Libro buscarLibro(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }
    Miembro buscarMiembro(String idMiembro) {
        for (Miembro miembro : miembros) {
            if (miembro.getIdMiembro().equals(idMiembro)) {
                return miembro;
            }
        }
        return null;
    }
    public void mostrarLibros() {
        System.out.println("Lista de Libros:");
        for (Libro libro : libros) {
            System.out.println(libro.getTitulo() + " - " + libro.getAutor() + " (ISBN: " + libro.getIsbn() + ")");
        }
    }
    public void mostrarMiembros() {
        System.out.println("Lista de Miembros:");
        for (Miembro miembro : miembros) {
            System.out.println(miembro.getNombre() + " (ID: " + miembro.getIdMiembro() + ")");
        }
    }
}