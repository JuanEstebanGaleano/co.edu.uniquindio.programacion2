package co.edu.uniquindio.programacion2trabajos.gestionBiblioteca.model;
import java.util.ArrayList;
import java.util.List;
public class Miembro {
    private String nombre;
    private String idMiembro;
    private List<Prestamo> prestamosActivos;
    public Miembro(String nombre, String idMiembro) {
        this.nombre = nombre;
        this.idMiembro = idMiembro;
        this.prestamosActivos = new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getIdMiembro() {
        return idMiembro;
    }
    public void setIdMiembro(String idMiembro) {
        this.idMiembro = idMiembro;
    }
    public List<Prestamo> getPrestamos() {
        return prestamosActivos;
    }
    public void agregarPrestamo(Prestamo prestamo) {
        this.prestamosActivos.add(prestamo);
    }
    public void eliminarPrestamo(Prestamo prestamo) {
        this.prestamosActivos.remove(prestamo);
    }
    public void setPrestamosActivos(List<Prestamo> prestamosActivos) {
        this.prestamosActivos = prestamosActivos;
    }
    public List<Prestamo> getPrestamosActivos() {
        return prestamosActivos;
    }
    public void mostrarLibrosAdquiridos() {
        System.out.println("Libros adquiridos por " + nombre + ":");
        for (Prestamo prestamo : prestamosActivos) {
            System.out.println(prestamo.getLibro().getTitulo() + " - ISBN: " + prestamo.getLibro().getIsbn());
        }
    }
}