package co.edu.uniquindio.biblioteca.service;

public interface IMiembroCrud {

    boolean crearMiembro(String nombre,String cedula);
    boolean eliminarMiembro(String cedula);
    boolean actualizarMiembro(String nombre,String cedula);
}
