package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class PanelAgregarPelicula extends JPanel {

    private JTextField txtId, txtNombre, txtRating, txtFecha, txtDuracion;
    private JComboBox<String> comboGenero;
    private JButton btnGuardar;
    private JButton btnVolver;

    private final String[] generos = {
        "Acción", "Aventura", "Comedia", "Drama",
        "Fantasía", "Terror", "Musical", "Misterio", "Suspenso"
    };

    public PanelAgregarPelicula() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Agregar Nueva Película"));
        panelFormulario.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        Font fuente = new Font("Arial", Font.PLAIN, 14);

        txtId = new JTextField(15);
        txtNombre = new JTextField(15);
        comboGenero = new JComboBox<>(generos);
        txtRating = new JTextField(15);
        txtFecha = new JTextField(15);
        txtDuracion = new JTextField(10);

        txtId.setFont(fuente);
        txtNombre.setFont(fuente);
        txtRating.setFont(fuente);
        txtFecha.setFont(fuente);
        txtDuracion.setFont(fuente);
        comboGenero.setFont(fuente);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panelFormulario.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        panelFormulario.add(txtId, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panelFormulario.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        panelFormulario.add(txtNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panelFormulario.add(new JLabel("Género:"), gbc);
        gbc.gridx = 1;
        panelFormulario.add(comboGenero, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panelFormulario.add(new JLabel("Rating (1-10):"), gbc);
        gbc.gridx = 1;
        panelFormulario.add(txtRating, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panelFormulario.add(new JLabel("Fecha estreno (AAAA-MM-DD):"), gbc);
        gbc.gridx = 1;
        panelFormulario.add(txtFecha, gbc);
        
        gbc.gridx = 0;
        gbc.gridy++;
        panelFormulario.add(new JLabel("Duracion"), gbc);
        gbc.gridx = 1;
        panelFormulario.add(txtDuracion, gbc);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setActionCommand("FINALIZAR_GUARDAR");
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelFormulario.add(btnGuardar, gbc);

        add(panelFormulario, BorderLayout.CENTER);

        btnVolver = new JButton("Volver");
        btnVolver.setActionCommand("VOLVER");
        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(Color.WHITE);
        panelInferior.add(btnVolver);

        add(panelInferior, BorderLayout.SOUTH);
    }

	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
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

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
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
	
	public void limpiarCampos() {
		txtId.setText("");
		txtNombre.setText("");
		txtRating.setText("");
		txtFecha.setText("");
		txtDuracion.setText("");
		comboGenero.setSelectedIndex(0);
	}
    
    
}
