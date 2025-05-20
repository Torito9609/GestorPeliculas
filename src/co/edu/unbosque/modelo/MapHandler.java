package co.edu.unbosque.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MapHandler {

	public static Pelicula peliculaDtoToPelicula(PeliculaDto peliculaDto) {
		String nombre = peliculaDto.getNombre();
		LocalDate fechaEstreno = peliculaDto.getFechaEstreno();
		String genero = peliculaDto.getGenero();
		double rating = peliculaDto.getRating();
		String id = UUID.randomUUID().toString();
		double duracionMinutos = peliculaDto.getDuracionMinutos();

		Pelicula pelicula = new Pelicula(id, nombre, rating, genero, fechaEstreno, duracionMinutos);

		return pelicula;
	}

	public static PeliculaDto peliculaToDto(Pelicula pelicula) {
		String nombre = pelicula.getNombre();
		LocalDate fechaEstreno = pelicula.getFechaEstreno();
		String genero = pelicula.getGenero();
		double rating = pelicula.getRating();
		double duracionMinutos = pelicula.getDuracionMinutos();

		PeliculaDto peliculaDto = new PeliculaDto();

		peliculaDto.setNombre(nombre);
		peliculaDto.setFechaEstreno(fechaEstreno);
		peliculaDto.setGenero(genero);
		peliculaDto.setRating(rating);
		peliculaDto.setDuracionMinutos(duracionMinutos);
		
		return peliculaDto;
	}
	
	public static List<Pelicula> allPeliculaDtoToPelicula(List<PeliculaDto> peliculasDto) {
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		for(PeliculaDto peliculaDto : peliculasDto) {
			Pelicula pelicula = peliculaDtoToPelicula(peliculaDto);
			peliculas.add(pelicula);
		}
		return peliculas;
	}
	
	public static List<PeliculaDto> allPeliculaToPeliculaDto(List<Pelicula> peliculas) {
		List<PeliculaDto> peliculasDto = new ArrayList<PeliculaDto>();
		for(Pelicula pelicula : peliculas) {
			PeliculaDto peliculaDto = peliculaToDto(pelicula);
			peliculasDto.add(peliculaDto);
		}
		return peliculasDto;
	}

}
