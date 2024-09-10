package co.edu.uniquindio.biblioteca.factory;

import co.edu.uniquindio.biblioteca.enums.Estado;
import co.edu.uniquindio.biblioteca.model.*;

import java.time.LocalDate;
import java.util.Date;

public class ModelFactory {

    private static ModelFactory modelFactory;
    private Biblioteca biblioteca;

    private ModelFactory() {
        inicializarDatos();
    }

    public static ModelFactory getInstance(){
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }

        return modelFactory;
    }

    public void crearPrestamo(LocalDate fechaPrestamo,
                              LocalDate fechaDevolucion,
                              String cedulaMiembro,
                              String ISBN,
                              String idBibliotecario) {
        biblioteca.crearPrestamo(fechaPrestamo,fechaDevolucion,cedulaMiembro,ISBN,idBibliotecario);
    }

    public Miembro obtenerMiembro(String cedula) {
        return biblioteca.obtenerMiembro(cedula);
    }

    public Bibliotecario obtenerBibliotecario(String idEmpleado) {
        return biblioteca.obtenerBibliotecario(idEmpleado);
    }

    public Libro obtenerLibro(String ISBN) {
        return biblioteca.obtenerLibro(ISBN);
    }

    private Biblioteca inicializarDatos() {
        biblioteca = new Biblioteca("Socrates");
        Libro libro1 = new Libro();
        libro1.setTitulo("El viejo y el mar");
        libro1.setAutor("Hugo Boss");
        libro1.setISBN("11223");
        libro1.setEstado(Estado.DISPONIBLE);
        biblioteca.getListaLibros().add(libro1);
        Libro libro2 = new Libro();
        libro2.setTitulo("100 años de soledad");
        libro2.setAutor("Maluma");
        libro2.setISBN("63516");
        libro2.setEstado(Estado.DISPONIBLE);
        biblioteca.getListaLibros().add(libro2);
        Libro libro3 = new Libro();
        libro3.setTitulo("La ultima cocacola");
        libro3.setAutor("Pacho");
        libro3.setISBN("6421");
        libro3.setEstado(Estado.DISPONIBLE);
        biblioteca.getListaLibros().add(libro3);
        Bibliotecario bibliotecario1 = new Bibliotecario();
        bibliotecario1.setNombre("Andres");
        bibliotecario1.setIdEmpleado("12121");
        biblioteca.getListaBibliotecarios().add(bibliotecario1);
        Bibliotecario bibliotecario2 = new Bibliotecario();
        bibliotecario2.setNombre("Esteban");
        bibliotecario2.setIdEmpleado("12441");
        biblioteca.getListaBibliotecarios().add(bibliotecario2);
        Miembro miembro1 = new Miembro();
        miembro1.setNombre("Pedro");
        miembro1.setCedula("2124544");
        biblioteca.getListaMiembros().add(miembro1);
        Miembro miembro2 = new Miembro();
        miembro2.setNombre("Luis");
        miembro2.setCedula("66467643");
        biblioteca.getListaMiembros().add(miembro2);

        System.out.println("-----LIBROS-----");
        System.out.println(biblioteca.getListaLibros().toString());
        System.out.println("-----MIEMBROS-----");
        System.out.println(biblioteca.getListaMiembros().toString());
        System.out.println("-----BIBLIOTECARIOS-----");
        System.out.println(biblioteca.getListaBibliotecarios().toString());

        return biblioteca;
    }
}
