package co.edu.uniquindio.biblioteca.service;

<<<<<<< HEAD
public interface ILibroCrud {
}
=======
import co.edu.uniquindio.biblioteca.enums.Estado;

public interface ILibroCrud {
    boolean crearLibro(String titulo, String autor, String ISBN, Estado estado);

    boolean eliminarLibro(String ISBN);

    boolean actualizarLibro(String titulo, String Autor, String ISBN,String ISBNNuevo, Estado estado);
}
>>>>>>> b424643a580f9f7f91a7967d0c874a4daa5295d6
