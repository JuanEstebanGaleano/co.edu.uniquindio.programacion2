package co.edu.uniquindio.programacion2trabajos.gestionBiblioteca.model;
import co.edu.uniquindio.programacion2trabajos.gestionBiblioteca.model.services.GestionInventario;
public class Bibliotecario extends Empleado implements GestionInventario {
    public Bibliotecario(String nombre, String idEmpleado) {
        super(nombre, idEmpleado);
    }
    @Override
    public void gestionarItem() {
        System.out.println("Gestionando ítem en la biblioteca...");
    }
    public void gestionarPrestamo(Prestamo prestamo) {
        System.out.println("Préstamo gestionado para el libro: " + prestamo.getLibro().getTitulo());
    }
}