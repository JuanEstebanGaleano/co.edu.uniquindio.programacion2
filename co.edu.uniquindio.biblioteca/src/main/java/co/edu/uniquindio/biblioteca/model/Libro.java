package co.edu.uniquindio.biblioteca.model;

import co.edu.uniquindio.biblioteca.enums.Estado;

public class Libro {

    private String titulo;
    private String autor;
    private String ISBN;
    private Estado estado;
    private Bibliotecario bibliotecarioAsociado;
    private Prestamo prestamoAsociado;

    public Libro() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Bibliotecario getBibliotecarioAsociado() {
        return bibliotecarioAsociado;
    }

    public void setBibliotecarioAsociado(Bibliotecario bibliotecarioAsociado) {
        this.bibliotecarioAsociado = bibliotecarioAsociado;
    }

    public Prestamo getPrestamoAsociado() {
        return prestamoAsociado;
    }

    public void setPrestamoAsociado(Prestamo prestamoAsociado) {
        this.prestamoAsociado = prestamoAsociado;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", estado=" + estado +
                ", bibliotecarioAsociado=" + bibliotecarioAsociado +
                ", prestamoAsociado=" + prestamoAsociado +
                '}';
    }
}
