package co.edu.uniquindio.programacion2trabajos.gestionBiblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Miembro {
    private String nombre;
    private String idMiembro;
    private final List<Prestamo> prestamosActivos;
    private final List<Multa> multasPendientes;

    public Miembro(String nombre, String idMiembro) {
        this.nombre = nombre;
        this.idMiembro = idMiembro;
        this.prestamosActivos = new ArrayList<>();
        this.multasPendientes = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(String idMiembro) {
        this.idMiembro = idMiembro;
    }

    public List<Prestamo> getPrestamosActivos() {
        return prestamosActivos;
    }

    public void agregarPrestamo(Prestamo prestamo) {
        prestamosActivos.add(prestamo);
    }

    public void removerPrestamo(Prestamo prestamo) {
        prestamosActivos.remove(prestamo);
    }

    public List<Multa> getMultasPendientes() {
        return multasPendientes;
    }

    public void agregarMulta(Multa multa) {
        multasPendientes.add(multa);
    }

    public void pagarMulta(Multa multa) {
        multasPendientes.remove(multa);
    }


}

