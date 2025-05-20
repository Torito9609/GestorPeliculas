package co.edu.unbosque.modelo;

import java.time.LocalDate;

public class Pelicula {
	private String id;
	private String nombre;
	private double rating;
	private String genero;
	private LocalDate fechaEstreno;
	private double duracionMinutos;
	

	public Pelicula(String id, String nombre, double rating, String genero, LocalDate fechaEstreno, double duracionMinutos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.rating = rating;
		this.genero = genero;
		this.fechaEstreno = fechaEstreno;
		this.duracionMinutos = duracionMinutos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDate getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(LocalDate fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public double getDuracionMinutos() {
		return duracionMinutos;
	}

	public void setDuracionMinutos(double duracionMinutos) {
		this.duracionMinutos = duracionMinutos;
	}
	
	

}
