package co.edu.uniquindio.biblioteca.service;

public interface IEmpleadoCrud {
    boolean crearEmpleado(String nombre, String idEmpleado);
    boolean eliminarEmpleado(String idEmpleado);
    boolean actualizarEmpleado(String nombre,String idEmpleado);
}
