package co.edu.uniquindio.biblioteca;

import co.edu.uniquindio.biblioteca.factory.ModelFactory;
import co.edu.uniquindio.biblioteca.model.*;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ModelFactory modelFactory = ModelFactory.getInstance();

        crearPrestamo(
                modelFactory,
                LocalDate.of(2024, 9, 10),
                LocalDate.of(2024, 9, 15),
                "2124544",
                "11223",
                "12121"
        );
        //crud miembro
        crearMiembro(modelFactory,"Lucho","98482947");
        eliminarMiembro(modelFactory,"66467643");
        actualizarMiembro(modelFactory,"Hernesto","3198371","22125131");
    }

    private static void crudMiembro(ModelFactory modelFactory,String nombre,String cedula) {
        crearMiembro(modelFactory,nombre,cedula);
        eliminarMiembro(modelFactory,cedula);
        //actualizarMienbro(modelFactory,nombre,cedula);
    }

    private static void actualizarMiembro(ModelFactory modelFactory, String nombreNuevo, String cedula,String cedulaNueva) {
        boolean resultado = modelFactory.actualizarMiembro(nombreNuevo,cedula,cedulaNueva);
        notificacion(resultado,"Actulizado");
    }

    private static void eliminarMiembro(ModelFactory modelFactory, String cedula) {
        boolean resultado = modelFactory.eliminarMiembro(cedula);
        notificacion(resultado,"eliminado");
    }

    private static void crearMiembro(ModelFactory modelFactory,String nombre,String cedula) {
        boolean resultado = modelFactory.crearMiembro(nombre,cedula);
        notificacion(resultado,"registrado");
    }

    private static void notificacion(boolean resultado,String mensaje) {
        if (resultado)
            System.out.println("El miembro se ha " + mensaje + " correctamente");
        else
            System.out.println("El miembro no se ha " + mensaje + " correctamente");
    }

    /*private static String obtenerLibro(ModelFactory modelFactory,String ISBN){
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
    }*/

    private static void crearPrestamo(ModelFactory modelFactory,
                                     LocalDate fechaPrestamo,
                                     LocalDate fechaDevolucion,
                                     String cedulaMiembro,
                                     String libroISBN,
                                     String idBibliotecario) {
        modelFactory.crearPrestamo(fechaPrestamo,fechaDevolucion,cedulaMiembro,libroISBN,idBibliotecario);
    }
}