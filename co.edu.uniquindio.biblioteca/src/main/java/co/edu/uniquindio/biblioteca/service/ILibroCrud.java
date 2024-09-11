package co.edu.uniquindio.biblioteca.service;
import co.edu.uniquindio.biblioteca.enums.Estado;

public interface ILibroCrud {
    boolean crearLibro(String titulo, String autor, String ISBN, Estado estado);

    boolean eliminarLibro(String ISBN);

    boolean actualizarLibro(String titulo, String Autor, String ISBN,String ISBNNuevo, Estado estado);
}
