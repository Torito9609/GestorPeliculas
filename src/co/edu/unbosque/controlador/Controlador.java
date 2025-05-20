package co.edu.unbosque.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import co.edu.unbosque.modelo.GestorPeliculas;
import co.edu.unbosque.vista.Vista;

public class Controlador implements ActionListener{
	private Vista vista;
	private GestorPeliculas gestor;
	private Map<String, Runnable> comandos;
	
	public Controlador() {
		this.vista = new Vista();
		comandos = new HashMap<String, Runnable>();
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
	
	private void mostrarPanelAgregar() {
		vista.getVentana().mostrarPanelAgregar();
		vista.getVentana().getPanelAgregar().getBtnGuardar().addActionListener(this);
		vista.getVentana().getPanelAgregar().getBtnVolver().addActionListener(this);
	}
	
	private void finalizarGuardarPelicula() {
		
	}
	
	private void mostrarPanelEditar() {
		vista.getVentana().mostrarPanelEditar();
		vista.getVentana().getPanelEditar().getBtnBuscar().addActionListener(this);
		vista.getVentana().getPanelEditar().getBtnActualizar().addActionListener(this);
		vista.getVentana().getPanelEditar().getBtnVolver().addActionListener(this);
	}
	
	private void buscarDesdeEdicion() {
		
	}
	
	private void finalizarEdicionPelicula() {
		
	}
	
	private void mostrarPanelEliminar() {
		vista.getVentana().mostrarPanelEliminar();
		vista.getVentana().getPanelEliminar().getBtnEliminar().addActionListener(this);
		vista.getVentana().getPanelEliminar().getBtnVolver().addActionListener(this);
	}
	
	private void finalizarEliminarPelicula() {
		
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
