package co.edu.uniquindio.programacion2trabajos.gestionBiblioteca.model;
import javax.swing.JOptionPane;
import java.math.BigDecimal;
public class Main {
    public static void main(String[] args) {
        GestionBiblioteca gestionBiblioteca = new GestionBiblioteca();
        Bibliotecario bibliotecario = new Bibliotecario("Jane Smith", "E001");
        // Inicialización de datos
        gestionBiblioteca.agregarLibro("Cien Años de Soledad", "Gabriel García Márquez", "123456789");
        gestionBiblioteca.agregarLibro("Don Quijote de la Mancha", "Miguel de Cervantes", "987654321");
        gestionBiblioteca.agregarMiembro("Juan Pérez", "M001");
        gestionBiblioteca.agregarMiembro("Ana Gómez", "M002");

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menuPrincipal()));
            switch (opcion) {
                case 1:
                    String titulo = JOptionPane.showInputDialog("Ingrese el título del libro:");
                    String autor = JOptionPane.showInputDialog("Ingrese el autor del libro:");
                    String isbn = JOptionPane.showInputDialog("Ingrese el ISBN del libro:");
                    if (validarDatosLibro(titulo, autor, isbn)) {
                        gestionBiblioteca.agregarLibro(titulo, autor, isbn);
                    } else {
                        JOptionPane.showMessageDialog(null, "Datos del libro inválidos.");
                    }
                    break;
                case 2:
                    String nombreMiembro = JOptionPane.showInputDialog("Ingrese el nombre del miembro:");
                    String idMiembro = JOptionPane.showInputDialog("Ingrese el ID del miembro:");
                    if (validarDatosMiembro(nombreMiembro, idMiembro)) {
                        gestionBiblioteca.agregarMiembro(nombreMiembro, idMiembro);
                    } else {
                        JOptionPane.showMessageDialog(null, "Datos del miembro inválidos.");
                    }
                    break;
                case 3:
                    String isbnPrestamo = JOptionPane.showInputDialog("Ingrese el ISBN del libro a prestar:");
                    String idMiembroPrestamo = JOptionPane.showInputDialog("Ingrese el ID del miembro:");
                    if (validarDatosPrestamo(isbnPrestamo, idMiembroPrestamo)) {
                        gestionBiblioteca.gestionarPrestamo(bibliotecario, isbnPrestamo, idMiembroPrestamo);
                    } else {
                        JOptionPane.showMessageDialog(null, "Datos del préstamo inválidos.");
                    }
                    break;
                case 4:
                    String idMiembroMulta = JOptionPane.showInputDialog("Ingrese el ID del miembro para agregar multa:");
                    BigDecimal montoMulta = new BigDecimal(JOptionPane.showInputDialog("Ingrese el monto de la multa:"));
                    gestionBiblioteca.agregarMulta(idMiembroMulta, montoMulta);
                    break;
                case 5:
                    String idMiembroPagarMulta = JOptionPane.showInputDialog("Ingrese el ID del miembro para pagar multa:");
                    gestionBiblioteca.pagarMulta(idMiembroPagarMulta);
                    break;
                case 6:
                    gestionBiblioteca.mostrarLibros();
                    break;
                case 7:
                    gestionBiblioteca.mostrarMiembros();
                    break;
                case 8:
                    gestionBiblioteca.mostrarMultas();
                    break;
                case 9:
                    String idMiembroLibros = JOptionPane.showInputDialog("Ingrese el ID del miembro para ver los libros adquiridos:");
                    gestionBiblioteca.mostrarLibrosAdquiridosPorMiembro(idMiembroLibros);
                    break;
                case 10:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
            }
        } while (opcion != 10);
    }

    private static String menuPrincipal() {
        return "1. Agregar Libro\n" +
                "2. Agregar Miembro\n" +
                "3. Gestionar Préstamo\n" +
                "4. Agregar Multa\n" +
                "5. Pagar Multa\n" +
                "6. Mostrar Libros\n" +
                "7. Mostrar Miembros\n" +
                "8. Mostrar Multas\n" +
                "9. Mostrar Libros Adquiridos por Miembro\n" +
                "10. Salir\n" +
                "Seleccione una opción:";
    }
    private static boolean validarDatosLibro(String titulo, String autor, String isbn) {
        return titulo != null && !titulo.trim().isEmpty() &&
                autor != null && !autor.trim().isEmpty() &&
                isbn != null && !isbn.trim().isEmpty();
    }
    private static boolean validarDatosMiembro(String nombre, String idMiembro) {
        return nombre != null && !nombre.trim().isEmpty() &&
                idMiembro != null && !idMiembro.trim().isEmpty();
    }
    private static boolean validarDatosPrestamo(String isbn, String idMiembro) {
        return isbn != null && !isbn.trim().isEmpty() &&
                idMiembro != null && !idMiembro.trim().isEmpty();
    }
}