package co.edu.uniquindio.biblioteca.model;

import java.time.LocalDate;

public class Prestamo {

    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Miembro miembroAsociado;
    private Libro libroAsociado;
    private Bibliotecario bibliotecarioAsociado;

    public Prestamo() {
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

    public Miembro getMiembroAsociado() {
        return miembroAsociado;
    }

    public void setMiembroAsociado(Miembro miembroAsociado) {
        this.miembroAsociado = miembroAsociado;
    }

    public Libro getLibroAsociado() {
        return libroAsociado;
    }

    public void setLibroAsociado(Libro libroAsociado) {
        this.libroAsociado = libroAsociado;
    }

    public Bibliotecario getBibliotecarioAsociado() {
        return bibliotecarioAsociado;
    }

    public void setBibliotecarioAsociado(Bibliotecario bibliotecarioAsociado) {
        this.bibliotecarioAsociado = bibliotecarioAsociado;
    }
}
