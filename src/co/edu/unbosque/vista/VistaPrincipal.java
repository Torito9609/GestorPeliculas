package co.edu.unbosque.vista;

import javax.swing.*;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.modelo.PeliculaDto;

import java.awt.*;

public class VistaPrincipal extends JPanel {

	private JButton btnAgregar, btnEditar, btnEliminar, btnBuscar, btnLimpiarFiltros;
	private JTable tablaPeliculas;
	private JComboBox<String> comboFiltroGenero, comboOrdenarPor, comboDireccion;
	private DefaultTableModel modeloTabla;

	public VistaPrincipal() {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnAgregar = new JButton("Agregar");
		btnAgregar.setActionCommand("AGREGAR");
		btnEditar = new JButton("Editar");
		btnEditar.setActionCommand("EDITAR");
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setActionCommand("ELIMINAR");
		btnBuscar = new JButton("Buscar");
		btnBuscar.setActionCommand("BUSCAR");

		panelBotones.add(btnAgregar);
		panelBotones.add(btnEditar);
		panelBotones.add(btnEliminar);
		panelBotones.add(btnBuscar);

		add(panelBotones, BorderLayout.NORTH);

		JPanel panelCentro = new JPanel(new BorderLayout());
		panelCentro.setBackground(Color.WHITE);

		String[] columnas = { "ID", "Nombre", "Género", "Fecha Estreno", "Rating" };
		modeloTabla = new DefaultTableModel(null, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        tablaPeliculas = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaPeliculas);

		panelCentro.add(scrollTabla, BorderLayout.CENTER);

		JPanel panelFiltro = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		comboFiltroGenero = new JComboBox<>(new String[] { "Todos", "Acción", "Aventura", "Comedia", "Drama",
				"Fantasía", "Terror", "Musical", "Misterio", "Suspenso" });
		comboFiltroGenero.setActionCommand("FILTRAR_GENERO");
		btnLimpiarFiltros = new JButton("Limpiar filtros");
		btnLimpiarFiltros.setActionCommand("LIMPIAR_FILTROS");

		panelFiltro.add(Box.createHorizontalStrut(20));

		comboOrdenarPor = new JComboBox<>(new String[] { "Fecha de estreno", "Calificación" });

		comboDireccion = new JComboBox<>(new String[] { "Ascendente", "Descendente" });
		comboDireccion.setActionCommand("ORDENAR_DIRECCION");

		panelFiltro.add(new JLabel("Ordenar por:"));
		panelFiltro.add(comboOrdenarPor);
		panelFiltro.add(comboDireccion);

		panelFiltro.add(new JLabel("Filtrar por género:"));
		panelFiltro.add(comboFiltroGenero);
		panelFiltro.add(btnLimpiarFiltros);

		panelCentro.add(panelFiltro, BorderLayout.SOUTH);
		add(panelCentro, BorderLayout.CENTER);
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JButton getBtnLimpiarFiltros() {
		return btnLimpiarFiltros;
	}

	public JTable getTablaPeliculas() {
		return tablaPeliculas;
	}

	public JComboBox<String> getComboFiltroGenero() {
		return comboFiltroGenero;
	}

	public JComboBox<String> getComboOrdenarPor() {
		return comboOrdenarPor;
	}

	public void setComboOrdenarPor(JComboBox<String> comboOrdenarPor) {
		this.comboOrdenarPor = comboOrdenarPor;
	}

	public JComboBox<String> getComboDireccion() {
		return comboDireccion;
	}

	public void setComboDireccion(JComboBox<String> comboDireccion) {
		this.comboDireccion = comboDireccion;
	}

	public void actualizarTabla(List<PeliculaDto> listaPeliculas) {
		modeloTabla.setRowCount(0);

		for (PeliculaDto pelicula : listaPeliculas) {
			Object[] fila = {
				pelicula.getId(),
				pelicula.getNombre(),
				pelicula.getGenero(),
				pelicula.getFechaEstreno().toString(),
				pelicula.getRating()
			};
			modeloTabla.addRow(fila);
		}		
	}
}
