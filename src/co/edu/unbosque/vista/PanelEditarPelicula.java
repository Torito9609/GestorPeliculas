package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class PanelEditarPelicula extends JPanel {

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
		JPanel panelFormulario = new JPanel(new GridLayout(7, 2, 10, 10));
		panelFormulario.setBorder(BorderFactory.createTitledBorder("Editar Película"));
		panelFormulario.setBackground(Color.WHITE);
		panelFormulario.setPreferredSize(new Dimension(450, 320));

		txtIdBuscar = new JTextField();
		txtNombre = new JTextField();
		comboGenero = new JComboBox<>(generos);
		txtRating = new JTextField();
		txtFecha = new JTextField();
		txtDuracion = new JTextField();

		btnBuscar = new JButton("Buscar");
		btnBuscar.setActionCommand("BUSCAR_EDITAR");
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setActionCommand("ACTUALIZAR_EDITAR");
		btnActualizar.setEnabled(false);

		panelFormulario.add(new JLabel("ID a buscar:"));
		panelFormulario.add(txtIdBuscar);
		panelFormulario.add(new JLabel());
		panelFormulario.add(btnBuscar);

		panelFormulario.add(new JLabel("Nuevo nombre:"));
		panelFormulario.add(txtNombre);

		panelFormulario.add(new JLabel("Nuevo género:"));
		panelFormulario.add(comboGenero);

		panelFormulario.add(new JLabel("Nuevo rating:"));
		panelFormulario.add(txtRating);

		panelFormulario.add(new JLabel("Nueva fecha (AAAA-MM-DD):"));
		panelFormulario.add(txtFecha);

		panelFormulario.add(new JLabel("Nueva Duracion"));
		panelFormulario.add(txtDuracion);

		panelFormulario.add(new JLabel());
		panelFormulario.add(btnActualizar);

		JPanel centro = new JPanel(new GridBagLayout());
		centro.setBackground(Color.WHITE);
		centro.add(panelFormulario);

		add(centro, BorderLayout.CENTER);

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
