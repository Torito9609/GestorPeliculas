package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class PanelEditarPelicula extends JPanel {
	private JLabel idOculto;
	private JTextField txtIdBuscar, txtNombre, txtRating, txtFecha, txtDuracion;
	private JComboBox<String> comboGenero;
	private JButton btnBuscar, btnActualizar, btnVolver;

	private final String[] generos = { " ", "Acción", "Aventura", "Comedia", "Drama", "Fantasía", "Terror", "Musical",
			"Misterio", "Suspenso" };

	public PanelEditarPelicula() {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		JPanel panelFormulario = new JPanel(new GridBagLayout());
		panelFormulario.setBorder(BorderFactory.createTitledBorder("Editar Película"));
		panelFormulario.setBackground(Color.WHITE);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(8, 12, 8, 12); 
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;

		txtIdBuscar = new JTextField(15);
		txtNombre = new JTextField(15);
		comboGenero = new JComboBox<>(generos);
		txtRating = new JTextField(15);
		txtFecha = new JTextField(15);
		txtDuracion = new JTextField(15);
		idOculto = new JLabel();
		idOculto.setVisible(false);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setActionCommand("BUSCAR_EDITAR");

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setActionCommand("ACTUALIZAR_EDITAR");
		btnActualizar.setEnabled(false);

		gbc.gridx = 0; gbc.gridy = 0;
		panelFormulario.add(new JLabel("ID a buscar:"), gbc);
		gbc.gridx = 1;
		panelFormulario.add(txtIdBuscar, gbc);
		gbc.gridx = 2;
		panelFormulario.add(btnBuscar, gbc);

		gbc.gridx = 0; gbc.gridy++;
		panelFormulario.add(new JLabel("Nuevo nombre:"), gbc);
		gbc.gridx = 1; gbc.gridwidth = 2;
		panelFormulario.add(txtNombre, gbc);

		gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 1;
		panelFormulario.add(new JLabel("Nuevo género:"), gbc);
		gbc.gridx = 1; gbc.gridwidth = 2;
		panelFormulario.add(comboGenero, gbc);

		gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 1;
		panelFormulario.add(new JLabel("Nuevo rating:"), gbc);
		gbc.gridx = 1; gbc.gridwidth = 2;
		panelFormulario.add(txtRating, gbc);

		gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 1;
		panelFormulario.add(new JLabel("Nueva fecha (AAAA-MM-DD):"), gbc);
		gbc.gridx = 1; gbc.gridwidth = 2;
		panelFormulario.add(txtFecha, gbc);

		gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 1;
		panelFormulario.add(new JLabel("Nueva duración (min):"), gbc);
		gbc.gridx = 1; gbc.gridwidth = 2;
		panelFormulario.add(txtDuracion, gbc);
		
		gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 1;
		panelFormulario.add(idOculto);
		gbc.gridx = 1; gbc.gridwidth = 2;
		panelFormulario.add(txtDuracion, gbc);

		gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		panelFormulario.add(btnActualizar, gbc);

		JPanel contenedorCentro = new JPanel(new BorderLayout());
		contenedorCentro.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
		contenedorCentro.setBackground(Color.WHITE);
		contenedorCentro.add(panelFormulario, BorderLayout.CENTER);

		add(contenedorCentro, BorderLayout.CENTER);

		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");
		JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelInferior.setBackground(Color.WHITE);
		panelInferior.add(btnVolver);
		add(panelInferior, BorderLayout.SOUTH);
	}


	public JTextField getTxtIdBuscar() {
		return txtIdBuscar;
	}

	public void setTxtIdBuscar(JTextField txtIdBuscar) {
		this.txtIdBuscar = txtIdBuscar;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtRating() {
		return txtRating;
	}

	public void setTxtRating(JTextField txtRating) {
		this.txtRating = txtRating;
	}

	public JTextField getTxtFecha() {
		return txtFecha;
	}

	public void setTxtFecha(JTextField txtFecha) {
		this.txtFecha = txtFecha;
	}

	public JTextField getTxtDuracion() {
		return txtDuracion;
	}

	public void setTxtDuracion(JTextField txtDuracion) {
		this.txtDuracion = txtDuracion;
	}

	public JComboBox<String> getComboGenero() {
		return comboGenero;
	}

	public void setComboGenero(JComboBox<String> comboGenero) {
		this.comboGenero = comboGenero;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public String[] getGeneros() {
		return generos;
	}

	public JLabel getIdOculto() {
		return idOculto;
	}

	public void setIdOculto(JLabel idOculto) {
		this.idOculto = idOculto;
	}

	public void llenarCampos(String nombre, String genero, String rating, String fecha, String duracion) {
		txtNombre.setText(nombre);
		comboGenero.setSelectedItem(genero);
		txtRating.setText(rating);
		txtFecha.setText(fecha);
		txtDuracion.setText(duracion);
		btnActualizar.setEnabled(true);
	}

	public void limpiarCampos() {
		txtIdBuscar.setText("");
		txtNombre.setText("");
		txtRating.setText("");
		txtFecha.setText("");
		txtDuracion.setText("");
		comboGenero.setSelectedIndex(0);
		btnActualizar.setEnabled(false);
	}
}
