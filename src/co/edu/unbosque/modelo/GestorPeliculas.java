package co.edu.unbosque.modelo;

import java.util.List;

import co.edu.unbosque.exception.PeliculaDuplicadaException;
import co.edu.unbosque.exception.PeliculaNoEncontradaException;

public class GestorPeliculas {
	private GestorPeliculasDao gestor;
	
	
	
	public List<PeliculaDto> obtenerTodas(){
		List<Pelicula> todas = gestor.obtenerTodas();
		return MapHandler.allPeliculaToPeliculaDto(todas);
	}

	public void guardarPelicula(PeliculaDto peliculaDto) throws PeliculaDuplicadaException {
		Pelicula pelicula = MapHandler.peliculaDtoToPelicula(peliculaDto);
		System.out.println("Guardando desde gestor");
		gestor.guardar(pelicula);
	}
	
	public void eliminarPelicula(String id) throws PeliculaNoEncontradaException {
		gestor.eliminar(id);
	}
	
	public PeliculaDto buscarPorId(String id) throws PeliculaNoEncontradaException {
		Pelicula encontrada = gestor.buscarPorId(id);
		return MapHandler.peliculaToDto(encontrada);
	}
	
	public List<PeliculaDto> buscarPorTitulo(String titulo){
		List<Pelicula> peliculas = gestor.buscarPorTitulo(titulo);
		return MapHandler.allPeliculaToPeliculaDto(peliculas);
	}
	
	public List<PeliculaDto> filtrarPorGenero(String genero){
		List<Pelicula> peliculas = gestor.filtrarPorGenero(genero);
		return MapHandler.allPeliculaToPeliculaDto(peliculas);
	}
	
	public void actualizarRating(String idActualizar, double rating) throws PeliculaNoEncontradaException {
		gestor.actualizarRating(idActualizar, rating);
	}
	
	public List<PeliculaDto> obtenerPeliculasOrdenadasPorFecha(boolean ascendente) {
		List<Pelicula> ordenadas = gestor.ordenarPorFecha(ascendente);
		return MapHandler.allPeliculaToPeliculaDto(ordenadas);
	}

	public List<PeliculaDto> obtenerPeliculasOrdenadasPorRating(boolean ascendente) {
		List<Pelicula> ordenadas = gestor.ordenarPorRating(ascendente);
		return MapHandler.allPeliculaToPeliculaDto(ordenadas);
	}

	public GestorPeliculasDao getGestor() {
		return gestor;
	}

	public void setGestor(GestorPeliculasDao gestor) {
		this.gestor = gestor;
	}
}
