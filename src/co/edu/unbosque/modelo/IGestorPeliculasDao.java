package co.edu.unbosque.modelo;

import co.edu.unbosque.exception.PeliculaDuplicadaException;
import co.edu.unbosque.exception.PeliculaNoEncontradaException;
import java.util.*;

public interface IGestorPeliculasDao {
	
	boolean guardar(Pelicula pelicula) throws PeliculaDuplicadaException;
	
	boolean eliminar(String id) throws PeliculaNoEncontradaException;
	
	Pelicula buscarPorId(String id) throws PeliculaNoEncontradaException;
	
	List<Pelicula> buscarPorTitulo(String titulo) throws PeliculaNoEncontradaException;
	
	List<Pelicula> filtrarPorGenero(String genero) throws PeliculaNoEncontradaException;
	
	boolean actualizarRating(String idActualizar, double rating) throws PeliculaNoEncontradaException;
	
	List<Pelicula> ordenarPorFecha(boolean ascendente);
	
	List<Pelicula> ordenarPorRating(boolean ascendente);
}
