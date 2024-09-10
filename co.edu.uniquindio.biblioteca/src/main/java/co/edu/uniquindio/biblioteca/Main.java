package co.edu.uniquindio.biblioteca;

import co.edu.uniquindio.biblioteca.factory.ModelFactory;
import co.edu.uniquindio.biblioteca.model.*;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ModelFactory modelFactory = ModelFactory.getInstance();

        crearPrestamo(modelFactory,
                LocalDate.of(2024,9,10),
                LocalDate.of(2024,9,15),
                "2124544",
                "11223",
                "12121");

    }

    private static String obtenerLibro(ModelFactory modelFactory,String ISBN){
        String resultado;
        resultado = modelFactory.obtenerLibro(ISBN).getTitulo();
        return resultado;
    }

    private static String obtenerMiembro(ModelFactory modelFactory,String cedula){
        String resultado;
        resultado = modelFactory.obtenerMiembro(cedula).getNombre();
        return resultado;
    }

    private static String obtenerBibliotecario(ModelFactory modelFactory,String idEmpleado){
        String resultado;
        resultado = modelFactory.obtenerBibliotecario(idEmpleado).getNombre();
        return resultado;
    }

    private static void crearPrestamo(ModelFactory modelFactory,
                                     LocalDate fechaPrestamo,
                                     LocalDate fechaDevolucion,
                                     String cedulaMiembro,
                                     String libroISBN,
                                     String idBibliotecario) {
        modelFactory.crearPrestamo(fechaPrestamo,fechaDevolucion,cedulaMiembro,libroISBN,idBibliotecario);
    }
}