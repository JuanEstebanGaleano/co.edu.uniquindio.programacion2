package co.edu.uniquindio.programacion2trabajos.gestionBiblioteca.model;

public class Main {
    public static void main(String[] args) {
        // Crear algunos libros
        Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes", "1234567890");
        Libro libro2 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", "0987654321");

        // Crear algunos miembros
        Miembro miembro1 = new Miembro("Juan Pérez", "M001");
        Miembro miembro2 = new Miembro("Ana García", "M002");

        // Crear un bibliotecario
        Bibliotecario bibliotecario = new Bibliotecario("Carlos López", "E001");

        // Realizar algunos préstamos
        bibliotecario.gestionarPrestamos(miembro1, libro1); // Juan pide El Quijote
        bibliotecario.gestionarPrestamos(miembro2, libro2); // Ana pide Cien Años de Soledad

        // Mostrar préstamos activos
        System.out.println("Préstamos activos de " + miembro1.getNombre() + ":");
        bibliotecario.mostrarPrestamosActivos(miembro1);
        System.out.println("\nPréstamos activos de " + miembro2.getNombre() + ":");
        bibliotecario.mostrarPrestamosActivos(miembro2);

        // Intentar devolver un libro después de 15 días para aplicar una multa
        Prestamo prestamo1 = miembro1.getPrestamosActivos().getFirst(); // Obtener el préstamo de El Quijote
        prestamo1.setFechaPrestamo(prestamo1.getFechaPrestamo().minusDays(15)); // Restamos 15 días
        bibliotecario.devolverLibro(miembro1, prestamo1); // Juan devuelve El Quijote (tarde)

        // Mostrar multas pendientes
        System.out.println("\nMultas pendientes de " + miembro1.getNombre() + ":");
        bibliotecario.mostrarMultasPendientes(miembro1);

        // Ana devuelve su libro a tiempo
        Prestamo prestamo2 = miembro2.getPrestamosActivos().getFirst(); // Obtener el préstamo de Cien Años de Soledad
        bibliotecario.devolverLibro(miembro2, prestamo2); // Ana devuelve Cien Años de Soledad a tiempo

        // Mostrar multas pendientes para Ana (debería ser ninguna)
        System.out.println("\nMultas pendientes de " + miembro2.getNombre() + ":");
        bibliotecario.mostrarMultasPendientes(miembro2);

        // Pagar la multa de Juan
        if (!miembro1.getMultasPendientes().isEmpty()) {
            Multa multa = miembro1.getMultasPendientes().getFirst(); // Obtener la primera multa
            miembro1.pagarMulta(multa);
            System.out.println("\nMulta pagada por " + miembro1.getNombre() + ": " + multa.getMonto());
        } else {
            System.out.println("\nNo hay multas pendientes para " + miembro1.getNombre());
        }

        // Mostrar multas pendientes para Juan (debería estar vacía)
        System.out.println("\nMultas pendientes de " + miembro1.getNombre() + ":");
        bibliotecario.mostrarMultasPendientes(miembro1);
    }
}