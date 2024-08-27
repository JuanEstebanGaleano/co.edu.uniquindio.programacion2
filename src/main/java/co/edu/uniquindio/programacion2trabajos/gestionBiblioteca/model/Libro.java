package co.edu.uniquindio.programacion2trabajos.gestionBiblioteca.model;

public class Libro {
    private String titulo;
    private String autor;
    private String ISBN;
    private boolean disponible;

    public Libro(String titulo, String autor, String ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.disponible = true; // Inicialmente disponible
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

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}

