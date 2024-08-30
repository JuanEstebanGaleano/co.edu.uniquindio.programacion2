package co.edu.uniquindio.programacion2trabajos.gestionBiblioteca.model;
public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponible;
    public Libro(){
    }
    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponible = true;
    }
    public void prestar() {
        if (disponible) {
            disponible = false;
        }
    }
    public void devolver() {
        disponible = true;
    }
    public boolean estaDisponible() {
        return disponible;
    }
    // Getters y Setters
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
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}