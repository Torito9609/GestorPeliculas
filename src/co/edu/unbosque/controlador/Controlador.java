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
	}
	
	private void asignarOyentes() {
		vista.getVentana().getVistaMenu().getBtnAgregar().addActionListener(this);
		vista.getVentana().getVistaMenu().getBtnEditar().addActionListener(this);
		vista.getVentana().getVistaMenu().getBtnEliminar().addActionListener(this);
		vista.getVentana().getVistaMenu().getBtnBuscar().addActionListener(this);
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
		
	}
	
	private void filtrarPorGenero() {
		
	}
	
	private void ordenarTabla() {
		
	}
	
	private void limpiarFiltros() {
		
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
