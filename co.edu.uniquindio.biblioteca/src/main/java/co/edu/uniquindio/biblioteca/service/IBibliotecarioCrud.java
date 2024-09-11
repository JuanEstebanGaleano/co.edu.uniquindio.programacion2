package co.edu.uniquindio.biblioteca.service;

public interface IBibliotecarioCrud {
    boolean crearBibliotecario(String nombre,String cedula);
    boolean eliminarBibliotecario(String cedula);
    boolean actualizarBibliotecario(String nombre,String cedula);
}
