package co.edu.unbosque.test;

import co.edu.unbosque.exception.*;
import co.edu.unbosque.modelo.GestorPeliculas;
import co.edu.unbosque.modelo.GestorPeliculasDao;
import co.edu.unbosque.modelo.PeliculaDto;

import org.junit.jupiter.api.*;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GestorPeliculasTest {

    private GestorPeliculas gestor;
    private GestorPeliculasDao dao;

    @BeforeEach
    public void setUp() {
        dao = new GestorPeliculasDao(); 
        gestor = new GestorPeliculas();
        gestor.setGestor(dao); 
    }

    @AfterEach
    public void limpiar() {
        dao.limpiarCatalogo();
    }
    
    private PeliculaDto crearPelicula(String id, String nombre, String genero, LocalDate fecha, double rating) {
        PeliculaDto dto = new PeliculaDto();
        dto.setId(id);
        dto.setNombre(nombre);
        dto.setGenero(genero);
        dto.setFechaEstreno(fecha);
        dto.setRating(rating);
        return dto;
    }

    
    @Test
    public void testAgregarYEliminarModificaTamano() throws PeliculaDuplicadaException, PeliculaNoEncontradaException {
        PeliculaDto pelicula = crearPelicula("1", "Inception", "Drama", LocalDate.of(2010, 7, 16), 8.8);

        int antes = gestor.buscarPorTitulo("").size();
        gestor.guardarPelicula(pelicula);
        int despuesAgregar = gestor.buscarPorTitulo("").size();
        assertEquals(antes + 1, despuesAgregar);

        gestor.eliminarPelicula("1");
        int despuesEliminar = gestor.buscarPorTitulo("").size();
        assertEquals(antes, despuesEliminar);
    }
    
    @Test
    public void testAgregarDuplicadoLanzaExcepcion() throws PeliculaDuplicadaException {
        PeliculaDto pelicula = crearPelicula("1", "Matrix", "Acción", LocalDate.of(1999, 3, 31), 9.0);
        gestor.guardarPelicula(pelicula);

        assertThrows(PeliculaDuplicadaException.class, () -> {
            gestor.guardarPelicula(pelicula);
        });
    }
    
    @Test
    public void testBuscarIdInexistenteLanzaExcepcion() {
        assertThrows(PeliculaNoEncontradaException.class, () -> {
            gestor.buscarPorId("inexistente");
        });
    }
    
    @Test
    public void testBuscarPorPalabraClave() throws PeliculaDuplicadaException {
        gestor.guardarPelicula(crearPelicula("1", "The Lord of the Rings", "Fantasía", LocalDate.of(2001, 12, 19), 9.0));
        gestor.guardarPelicula(crearPelicula("2", "Star Wars", "Ciencia Ficción", LocalDate.of(1977, 5, 25), 8.6));

        List<PeliculaDto> resultados = gestor.buscarPorTitulo("ring");
        assertEquals(1, resultados.size());
        assertEquals("The Lord of the Rings", resultados.get(0).getNombre());
    }
    
    @Test
    public void testFiltrarPorGenero() throws PeliculaDuplicadaException {
        gestor.guardarPelicula(crearPelicula("1", "Drama 1", "Drama", LocalDate.of(2000, 1, 1), 7.5));
        gestor.guardarPelicula(crearPelicula("2", "Comedia 1", "Comedia", LocalDate.of(2001, 1, 1), 6.0));

        List<PeliculaDto> dramas = gestor.filtrarPorGenero("Drama");
        assertEquals(1, dramas.size());
        assertEquals("Drama 1", dramas.get(0).getNombre());
    }
    
    @Test
    public void testOrdenarPorFechaAscendente() throws PeliculaDuplicadaException {
        gestor.guardarPelicula(crearPelicula("1", "Nueva", "Drama", LocalDate.of(2020, 1, 1), 7.0));
        gestor.guardarPelicula(crearPelicula("2", "Antigua", "Drama", LocalDate.of(1990, 1, 1), 7.0));

        List<PeliculaDto> ordenadas = gestor.obtenerPeliculasOrdenadasPorFecha(true);
        assertEquals("Antigua", ordenadas.get(0).getNombre());
    }



}