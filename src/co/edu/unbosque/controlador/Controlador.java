package co.edu.unbosque.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.edu.unbosque.exception.PeliculaDuplicadaException;
import co.edu.unbosque.exception.PeliculaNoEncontradaException;
import co.edu.unbosque.modelo.GestorPeliculas;
import co.edu.unbosque.modelo.GestorPeliculasDao;
import co.edu.unbosque.modelo.Pelicula;
import co.edu.unbosque.modelo.PeliculaDto;
import co.edu.unbosque.vista.Vista;

public class Controlador implements ActionListener{
	private Vista vista;
	private GestorPeliculas gestor;
	private Map<String, Runnable> comandos;
	
	public Controlador() {
		this.vista = new Vista();
		comandos = new HashMap<String, Runnable>();
		GestorPeliculasDao dao = new GestorPeliculasDao();
		gestor = new GestorPeliculas();
		gestor.setGestor(dao);
		registrarComandos();
		asignarOyentes();
	}
	
	private void registrarComandos() {
		comandos.put("AGREGAR", this::mostrarPanelAgregar);
		comandos.put("EDITAR", this::mostrarPanelEditar);
		comandos.put("ELIMINAR", this::mostrarPanelEliminar);
		comandos.put("BUSCAR", this::mostrarPanelBusqueda);
		comandos.put("FILTRO_GENERO", this::filtrarPorGenero);
		comandos.put("FINALIZAR_GUARDAR", this::finalizarGuardarPelicula);
		comandos.put("VOLVER", this::volverAlInicio);
		comandos.put("BUSCAR_EDITAR", this::buscarDesdeEdicion);
		comandos.put("ACTUALIZAR_EDITAR", this::finalizarEdicionPelicula);
		comandos.put("FINALIZAR_BUSCAR", this::buscarPelicula);
		comandos.put("FINALIZAR_ELIMINAR", this::finalizarEliminarPelicula);
		comandos.put("ORDENAR_DIRECCION", this::ordenarTabla);
		comandos.put("LIMPIAR_FILTROS", this::limpiarFiltros);
		comandos.put("ESTADISTICAS", this::mostrarPanelEstadisticas);
	}
	
	private void asignarOyentes() {
		vista.getVentana().getVistaMenu().getBtnAgregar().addActionListener(this);
		vista.getVentana().getVistaMenu().getBtnEditar().addActionListener(this);
		vista.getVentana().getVistaMenu().getBtnEliminar().addActionListener(this);
		vista.getVentana().getVistaMenu().getBtnBuscar().addActionListener(this);
		vista.getVentana().getVistaMenu().getBtnEstadisticas().addActionListener(this);
		vista.getVentana().getVistaMenu().getComboFiltroGenero().addActionListener(this);
	}
	
	private void reiniciarTabla() {
		List<PeliculaDto> peliculas = gestor.obtenerTodas();
		vista.getVentana().getVistaMenu().actualizarTabla(peliculas);
	}
	
	private void mostrarPanelAgregar() {
		vista.getVentana().mostrarPanelAgregar();
		vista.getVentana().getPanelAgregar().getBtnGuardar().addActionListener(this);
		vista.getVentana().getPanelAgregar().getBtnVolver().addActionListener(this);
	}
	
	private void finalizarGuardarPelicula() {
		String id = vista.getVentana().getPanelAgregar().getTxtId().getText().trim();
		String nombre = vista.getVentana().getPanelAgregar().getTxtNombre().getText().trim();
		double rating = Double.parseDouble(vista.getVentana().getPanelAgregar().getTxtRating().getText().trim());
		LocalDate fecha = LocalDate.parse(vista.getVentana().getPanelAgregar().getTxtFecha().getText().trim());
		double duracion = Double.parseDouble(vista.getVentana().getPanelAgregar().getTxtDuracion().getText().trim());
		String genero = vista.getVentana().getPanelAgregar().getComboGenero().getSelectedItem().toString();
		
		PeliculaDto pelicula = new PeliculaDto();
		
		pelicula.setId(id);
		pelicula.setNombre(nombre);
		pelicula.setRating(rating);
		pelicula.setFechaEstreno(fecha);
		pelicula.setDuracionMinutos(duracion);
		pelicula.setGenero(genero);
		
		try {
			gestor.guardarPelicula(pelicula);
			reiniciarTabla();
			volverAlInicio();
		} catch (PeliculaDuplicadaException e) {
			vista.mostrarMensajeError(e.getMessage());		
		}
		
	}
	
	private void mostrarPanelEditar() {
		vista.getVentana().mostrarPanelEditar();
		vista.getVentana().getPanelEditar().getBtnBuscar().addActionListener(this);
		vista.getVentana().getPanelEditar().getBtnActualizar().addActionListener(this);
		vista.getVentana().getPanelEditar().getBtnVolver().addActionListener(this);
	}
	
	private void buscarDesdeEdicion() {
		String idBuscar = vista.getVentana().getPanelEditar().getTxtIdBuscar().getText().trim();
		try {
			PeliculaDto peliculaEditar = gestor.buscarPorId(idBuscar);
			vista.getVentana().getPanelEditar().llenarCampos(
					peliculaEditar.getNombre(),
					peliculaEditar.getGenero(),
					String.valueOf(peliculaEditar.getRating()),
					peliculaEditar.getFechaEstreno().toString(),
					String.valueOf(peliculaEditar.getDuracionMinutos())
					);
			vista.getVentana().getPanelEditar().getIdOculto().setText(peliculaEditar.getId());
		} catch (PeliculaNoEncontradaException e) {
			vista.mostrarMensajeError(e.getMessage());
		}
	}
	
	private void finalizarEdicionPelicula() {
		String nombre = vista.getVentana().getPanelEditar().getTxtNombre().getText().trim();
		String genero = vista.getVentana().getPanelEditar().getComboGenero().getSelectedItem().toString();
		LocalDate fecha = LocalDate.parse(vista.getVentana().getPanelEditar().getTxtFecha().getText());
		double rating = Double.parseDouble(vista.getVentana().getPanelEditar().getTxtRating().getText());
		double duracion = Double.parseDouble(vista.getVentana().getPanelEditar().getTxtDuracion().getText());
		String id = vista.getVentana().getPanelEditar().getIdOculto().getText();
		
		PeliculaDto peliculaEditada = new PeliculaDto();
		
		peliculaEditada.setId(id);
		peliculaEditada.setNombre(nombre);
		peliculaEditada.setGenero(genero);
		peliculaEditada.setFechaEstreno(fecha);
		peliculaEditada.setRating(rating);
		peliculaEditada.setDuracionMinutos(duracion);
		
		try {
			gestor.actualizarPelicula(peliculaEditada.getId(), peliculaEditada);
			reiniciarTabla();
			volverAlInicio();
		} catch (PeliculaNoEncontradaException e) {
			vista.mostrarMensajeError(e.getMessage());
		}
	}
	
	private void mostrarPanelEliminar() {
		vista.getVentana().mostrarPanelEliminar();
		vista.getVentana().getPanelEliminar().getBtnEliminar().addActionListener(this);
		vista.getVentana().getPanelEliminar().getBtnVolver().addActionListener(this);
	}
	
	private void finalizarEliminarPelicula() {
		String idEliminar = vista.getVentana().getPanelEliminar().getIdEliminar();
		try {
			gestor.eliminarPelicula(idEliminar);
			reiniciarTabla();
			volverAlInicio();
		} catch (PeliculaNoEncontradaException e) {
			vista.mostrarMensajeError("La pelicula no existe");
		}
	}
	
	private void mostrarPanelBusqueda() {
		vista.getVentana().mostrarPanelBuscar();
		vista.getVentana().getPanelBuscar().getBtnBuscar().addActionListener(this);
		vista.getVentana().getPanelBuscar().getBtnVolver().addActionListener(this);
	}
	
	private void buscarPelicula() {
		String nombre = vista.getVentana().getPanelBuscar().getTextoBusqueda();
		List<PeliculaDto> coincidencias = gestor.buscarPorTitulo(nombre);
		vista.getVentana().getPanelBuscar().actualizarTabla(coincidencias);
	}
	
	private void filtrarPorGenero() {
		String genero = vista.getVentana().getVistaMenu().getComboFiltroGenero().getSelectedItem().toString();
		List<PeliculaDto> peliculas = gestor.filtrarPorGenero(genero);
		vista.getVentana().getVistaMenu().actualizarTabla(peliculas);
	}
	
	private void ordenarTabla() {
		String criterio = vista.getVentana().getVistaMenu().getComboOrdenarPor().getSelectedItem().toString();
		switch(criterio) {
		case "Fecha de estreno":
			boolean ordenF = vista.getVentana().getVistaMenu().getComboDireccion().getSelectedItem().toString().equals("Ascendente");
			List<PeliculaDto> peliculasF= gestor.obtenerPeliculasOrdenadasPorFecha(ordenF);
			vista.getVentana().getVistaMenu().actualizarTabla(peliculasF);
			break;
		case "Calificacion":
			boolean ordenC = vista.getVentana().getVistaMenu().getComboDireccion().getSelectedItem().toString().equals("Descendente");
			List<PeliculaDto> peliculasC = gestor.obtenerPeliculasOrdenadasPorRating(ordenC);
			vista.getVentana().getVistaMenu().actualizarTabla(peliculasC);
			break;
		}
		
	}
	
	private void limpiarFiltros() {
		reiniciarTabla();
	}
	
	private void mostrarPanelEstadisticas() {
		double[] estadisticas = gestor.obtenerEstadisticas();
		
		vista.getVentana().getPanelEstadisticas().setTotalPeliculas((int) estadisticas[0]);
		vista.getVentana().getPanelEstadisticas().setPromedioRating(estadisticas[1]);
		vista.getVentana().getPanelEstadisticas().setDuracionTotalHoras(estadisticas[2]);
		vista.getVentana().mostrarPanelEstadisticas();
		vista.getVentana().getPanelEstadisticas().getBtnVolver().addActionListener(this);
		
	}
	
	private void volverAlInicio() {
		vista.getVentana().mostrarMenu();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		Runnable action = comandos.get(comando);
		System.out.println(comando);
		if (action != null) {
			action.run();
		} else {
			System.out.println("Comando no reconocido.");
		}	
	}

}
