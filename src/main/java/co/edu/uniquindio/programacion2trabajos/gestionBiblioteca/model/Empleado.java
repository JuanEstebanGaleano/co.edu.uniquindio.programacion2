package co.edu.uniquindio.programacion2trabajos.gestionBiblioteca.model;

public class Empleado  {
private String nombre;
private String idEmpleado;

public Empleado(String nombre, String idEmpleado) {
    this.nombre = nombre;
    this.idEmpleado = idEmpleado;
}

// Getters y Setters
public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public String getIdEmpleado() {
    return idEmpleado;
}

public void setIdEmpleado(String idEmpleado) {
    this.idEmpleado = idEmpleado;
}
}
