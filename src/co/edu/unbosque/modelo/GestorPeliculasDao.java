package co.edu.unbosque.modelo;

import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.exception.PeliculaDuplicadaException;
import co.edu.unbosque.exception.PeliculaNoEncontradaException;

public class GestorPeliculasDao implements IGestorPeliculasDao {
	private List<Pelicula> catalogo;
	
	public GestorPeliculasDao() {
		this.catalogo = new ArrayList<Pelicula>();
	}
	
	public void limpiarCatalogo() {
		catalogo.clear();
	}
	
	@Override
	public List<Pelicula> obtenerTodas() {
		return catalogo;
	}

	@Override
	public boolean guardar(Pelicula pelicula) throws PeliculaDuplicadaException {
		//System.out.println("Guardando desde DAO");
		for (Pelicula peliculaC : catalogo) {
			if (pelicula.getId().equals(peliculaC.getId())) {
				throw new PeliculaDuplicadaException("No se pueden agregar películas con ID duplicado.");
			}
		}
		catalogo.add(pelicula);
		return true;
	}

	@Override
	public boolean eliminar(String id) throws PeliculaNoEncontradaException {
		for (Pelicula peliculaC : catalogo) {
			if (id.equals(peliculaC.getId())) {
				catalogo.remove(peliculaC);
				return true;
			}
		}
		throw new PeliculaNoEncontradaException("Pelicula con id " + id + " no existe");
	}

	@Override
	public Pelicula buscarPorId(String id) throws PeliculaNoEncontradaException {
	    for (Pelicula pelicula : catalogo) {
	        if (pelicula.getId().equals(id)) {
	            return pelicula;
	        }
	    }
	    throw new PeliculaNoEncontradaException("No se encontró la película con el id: " + id);
	}


	@Override
	public List<Pelicula> buscarPorTitulo(String titulo) {
		List<Pelicula> coincidencias = new ArrayList<Pelicula>();
		for (Pelicula pelicula : catalogo) {
			if (pelicula.getNombre().toLowerCase().contains(titulo.toLowerCase())) {
				coincidencias.add(pelicula);
			}
		}
		return coincidencias;
	}

	@Override
	public List<Pelicula> filtrarPorGenero(String genero) {
		List<Pelicula> coincidencias = new ArrayList<Pelicula>();
		for (Pelicula pelicula : catalogo) {
			if (pelicula.getGenero().toLowerCase().contains(genero.toLowerCase())) {
				coincidencias.add(pelicula);
			}
		}
		return coincidencias;
	}
	
	@Override
	public boolean actualizar(String id, Pelicula peliculaActualizada) throws PeliculaNoEncontradaException {
		for (int i = 0; i < catalogo.size(); i++) {
			Pelicula actual = catalogo.get(i);
			if (actual.getId().equals(id)) {
				peliculaActualizada.setId(id);
				catalogo.set(i, peliculaActualizada);
				return true;
			}
		}
		throw new PeliculaNoEncontradaException("No se encontró la película con ID: " + id);
	}


	@Override
	public boolean actualizarRating(String idActualizar, double rating) throws PeliculaNoEncontradaException {
		Pelicula peliculaEncontrada = buscarPorId(idActualizar);
		peliculaEncontrada.setRating(rating);
		return true;
	}
	
	@Override
	public List<Pelicula> ordenarPorFecha(boolean ascendente) {
		List<Pelicula> copia = new ArrayList<>(catalogo);
		quicksortPorFecha(copia, 0, copia.size() - 1, ascendente);
		return copia;
	}

	@Override
	public List<Pelicula> ordenarPorRating(boolean ascendente) {
		List<Pelicula> copia = new ArrayList<>(catalogo);
		quicksortPorRating(copia, 0, copia.size() - 1, ascendente);
		return copia;
	}
	
	private void quicksortPorFecha(List<Pelicula> lista, int inicio, int fin, boolean ascendente) {
		if (inicio < fin) {
			int pivoteIndex = particionarPorFecha(lista, inicio, fin, ascendente);
			quicksortPorFecha(lista, inicio, pivoteIndex - 1, ascendente);
			quicksortPorFecha(lista, pivoteIndex + 1, fin, ascendente);
		}
	}

	private int particionarPorFecha(List<Pelicula> lista, int inicio, int fin, boolean ascendente) {
		Pelicula pivote = lista.get(fin);
		int i = inicio - 1;

		for (int j = inicio; j < fin; j++) {
			boolean condicion = ascendente
				? lista.get(j).getFechaEstreno().isBefore(pivote.getFechaEstreno()) ||
				  lista.get(j).getFechaEstreno().isEqual(pivote.getFechaEstreno())
				: lista.get(j).getFechaEstreno().isAfter(pivote.getFechaEstreno()) ||
				  lista.get(j).getFechaEstreno().isEqual(pivote.getFechaEstreno());

			if (condicion) {
				i++;
				Pelicula temp = lista.get(i);
				lista.set(i, lista.get(j));
				lista.set(j, temp);
			}
		}

		Pelicula temp = lista.get(i + 1);
		lista.set(i + 1, lista.get(fin));
		lista.set(fin, temp);
		return i + 1;
	}
	
	private void quicksortPorRating(List<Pelicula> lista, int inicio, int fin, boolean ascendente) {
		if (inicio < fin) {
			int pivoteIndex = particionarPorRating(lista, inicio, fin, ascendente);
			quicksortPorRating(lista, inicio, pivoteIndex - 1, ascendente);
			quicksortPorRating(lista, pivoteIndex + 1, fin, ascendente);
		}
	}

	private int particionarPorRating(List<Pelicula> lista, int inicio, int fin, boolean ascendente) {
		Pelicula pivote = lista.get(fin);
		int i = inicio - 1;

		for (int j = inicio; j < fin; j++) {
			boolean condicion = ascendente
				? lista.get(j).getRating() <= pivote.getRating()
				: lista.get(j).getRating() >= pivote.getRating();

			if (condicion) {
				i++;
				Pelicula temp = lista.get(i);
				lista.set(i, lista.get(j));
				lista.set(j, temp);
			}
		}

		Pelicula temp = lista.get(i + 1);
		lista.set(i + 1, lista.get(fin));
		lista.set(fin, temp);
		return i + 1;
	}
}
