package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Biblioteca que contiene una colección de libros.
 * Permite agregar, eliminar y buscar libros por su título o autor.
 * @author Noelia Navas (aka github.com/NoeliaNavas)
 * @version 1.0
 */

public class Biblioteca {
    /** Lista de libros en la biblioteca */
    private final List<Libro> libros;

    /**
     * Constructor vacío para la clase Biblioteca.
     * Inicializa la lista de libros como una lista vacía.
     */
    public Biblioteca() {
        libros = new ArrayList<>();
    }

    /**
     * Constructor de la clase Biblioteca que inicializa la lista de libros
     * con una lista proporcionada.
     *
     * @param libros Lista de libros a agregar a la biblioteca.
     */
// Test: NO HAY QUE TESTEAR ESTE METODO
    public Biblioteca(List<Libro> libros) {
        this.libros = libros;
    }

    /**
     * Agrega un libro a la biblioteca.
     *
     * @param libro El libro que se desea agregar.
     * @return true si el libro se agregó con éxito, false si no.
     */
// Test: Comprobar si se ha agregado
    public boolean agregarLibro(Libro libro) {
        return libros.add(libro);
    }

    /**
     * Elimina un libro de la biblioteca.
     *
     * @param libro El libro que se desea eliminar.
     * @return true si el libro se eliminó con éxito, false si no.
     */
// Test: comprobar si se ha eliminado
    public boolean eliminarLibro(Libro libro) {
        return libros.remove(libro);
    }

    /**
     * Obtiene la lista completa de libros en la biblioteca.
     *
     * @return Lista de libros presentes en la biblioteca.
     */
    public List<Libro> getLibros() {
        return libros;
    }

    /**
     * Busca un libro en la biblioteca por su título.
     *
     * @param titulo El título del libro que se desea buscar.
     * @return El libro si se encuentra, o null si no se encuentra.
     */
// Test 01: buscar libro existente y comprobar que lo localiza.
// Test 02: buscar libro NO existente y comprobar que no lo localiza.
    public Libro encuentraLibroPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        return null;
    }

    /**
     * @deprecated
     * Este método está obsoleto. Se recomienda utilizar el método {@link #encuentraLibrosPorAutor(String)}.
     * Busca un libro en la biblioteca por su autor.
     * @param autor El autor del libro que se desea buscar.
     * @return El primer libro que corresponde al autor, o null si no se encuentra.
     */
    public Libro encuentaLibroPorAutor(String autor) {
        for (Libro libro : libros) {
            if (libro.getAutor().equals(autor)) {
                return libro;
            }
        }
        return null;
    }

    /**
     * Busca libros en la biblioteca por autor.
     * Este método reemplaza al anterior {@link #encuentaLibroPorAutor(String)}.
     * Disponible desde la versión 2.0.
     *
     * @param autor El autor de los libros que se desea buscar.
     * @return Una lista de libros que corresponden al autor, o una lista vacía si no se encuentran.
     */
// TODO: Testear este metodo.
// Test: Comprobar la lista de libros que devuelve para un autor existentes.
// Test: Comprobar la lista de libros que devuelve para un autor No existente
    public List<Libro> encuentraLibrosPorAutor(String autor) {
        List<Libro> listaLibros = null;
        for (Libro libro : libros) {
            if (libro.getAutor().equals(autor)) {
                if (listaLibros == null) {
                    listaLibros = new ArrayList<>();
                }
                listaLibros.add(libro);
            }
        }
        return listaLibros;
    }
}