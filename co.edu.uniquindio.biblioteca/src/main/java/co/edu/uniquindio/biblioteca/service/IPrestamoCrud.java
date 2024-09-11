package co.edu.uniquindio.biblioteca.service;

import java.time.LocalDate;

public interface IPrestamoCrud {

    boolean crearPrestamo(LocalDate fechaPrestamo,
                          LocalDate fechaDevolucion,
                          String cedulaMiembro,
                          String ISBN,
                          String idBibliotecario);
    boolean eliminarPrestamo(String cedulaMiembro,
                            String ISBN);
    boolean actualizarPrestamo(LocalDate fechaPrestamo,
                               LocalDate fechaDevolucion,
                               String cedulaMiembro,
                               String ISBN,
                               String idBibliotecario);
}
