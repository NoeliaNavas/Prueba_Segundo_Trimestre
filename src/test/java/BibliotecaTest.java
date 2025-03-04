package test.java;

import main.java.Biblioteca;
import main.java.Libro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private Libro libro1;
    private Libro libro2;

    @BeforeEach
    public void setUp() {
        // Se crea una nueva instancia de Biblioteca antes de cada prueba.
        biblioteca = new Biblioteca();
        libro1 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 1605);
        libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967);
    }

    @Test
    public void testAgregarLibro() {
        // Se agrega un libro a la biblioteca
        boolean result = biblioteca.agregarLibro(libro1);

        // Se comprueba si el libro fue agregado correctamente
        assertTrue(result, "El libro debería haberse agregado correctamente.");
        assertEquals(1, biblioteca.getLibros().size(), "La biblioteca debería contener 1 libro.");
    }

    @Test
    public void testEliminarLibro() {
        // Se agrega un libro primero
        biblioteca.agregarLibro(libro1);

        // Se elimina el libro de la biblioteca
        boolean result = biblioteca.eliminarLibro(libro1);

        // Se comprueba si el libro fue eliminado correctamente
        assertTrue(result, "El libro debería haberse eliminado correctamente.");
        assertEquals(0, biblioteca.getLibros().size(), "La biblioteca debería estar vacía.");
    }

    @Test
    public void testEncuentraLibroPorTitulo_Existente() {
        // Se agrega un libro a la biblioteca
        biblioteca.agregarLibro(libro1);

        // Se busca el libro por su título
        Libro encontrado = biblioteca.encuentraLibroPorTitulo("Don Quijote de la Mancha");

        // Se comprueba si el libro encontrado es el esperado
        assertNotNull(encontrado, "El libro debería haber sido encontrado.");
        assertEquals(libro1, encontrado, "El libro encontrado no es el esperado.");
    }

    @Test
    public void testEncuentraLibroPorTitulo_NoExistente() {
        // Se agrega un libro a la biblioteca
        biblioteca.agregarLibro(libro1);

        // Se busca un libro que no existe
        Libro encontrado = biblioteca.encuentraLibroPorTitulo("El nombre de la rosa");

        // Se comprueba que el libro no fue encontrado
        assertNull(encontrado, "El libro no debería haber sido encontrado.");
    }

    @Test
    public void testEncuentraLibrosPorAutor_Existente() {
        // Se agregan dos libros con el mismo autor
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        // Se busca los libros por autor
        List<Libro> librosPorAutor = biblioteca.encuentraLibrosPorAutor("Miguel de Cervantes");

        // Se comprueba que se haya encontrado el libro correcto
        assertEquals(1, librosPorAutor.size(), "Debería haberse encontrado 1 libro del autor.");
        assertTrue(librosPorAutor.contains(libro1), "La lista debería contener el libro de Miguel de Cervantes.");
    }

    @Test
    public void testEncuentraLibrosPorAutor_NoExistente() {
        // Se agrega un libro de un autor
        biblioteca.agregarLibro(libro1);

        // Se busca un autor que no tiene libros en la biblioteca
        List<Libro> librosPorAutor = biblioteca.encuentraLibrosPorAutor("J.K. Rowling");

        // Se comprueba que la lista esté vacía
        assertTrue(librosPorAutor.isEmpty(), "No debería haberse encontrado libros para este autor.");
    }
}