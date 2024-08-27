package co.edu.uniquindio.programacion2trabajos.gestionBiblioteca.model;
import java.time.LocalDate;

public class Prestamo{
    private Libro libro;
    private Miembro miembro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
public Prestamo(){
}
    public Prestamo(Libro libro, Miembro miembro) {
        this.libro = libro;
        this.miembro = miembro;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = null; // No se ha devuelto
    }

    // Getters y Setters
    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Miembro getMiembro() {
        return miembro;
    }

    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public boolean esAtrasado() {
        // Supongamos que el plazo para devolver es de 14 días
        return fechaDevolucion == null && fechaPrestamo.plusDays(14).isBefore(LocalDate.now());
    }
    @Override
    public String toString() {
        return
                "libro=" + (libro != null ? libro.getTitulo() : "No asignado") +  // Mostrar título del libro
                ", miembro=" + (miembro != null ? miembro.getNombre() : "No asignado") + // Mostrar nombre del miembro
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + (fechaDevolucion != null ? fechaDevolucion : "No devuelto")
                ;
    }
}

