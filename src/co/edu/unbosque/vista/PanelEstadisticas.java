package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class PanelEstadisticas extends JPanel {

	private JLabel lblTotalPeliculasValor;
	private JLabel lblPromedioRatingValor;
	private JLabel lblDuracionTotalValor;
	private JButton btnVolver;

	public PanelEstadisticas() {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		JPanel panelDatos = new JPanel(new GridLayout(3, 2, 15, 15));
		panelDatos.setBorder(BorderFactory.createTitledBorder("Estadísticas del Catálogo"));
		panelDatos.setBackground(Color.WHITE);

		JLabel lblTotalPeliculas = new JLabel("Número total de películas:");
		lblTotalPeliculasValor = new JLabel("0");

		JLabel lblPromedioRating = new JLabel("Calificación promedio global:");
		lblPromedioRatingValor = new JLabel("0.0");

		JLabel lblDuracionTotal = new JLabel("Duración total del catálogo (horas):");
		lblDuracionTotalValor = new JLabel("0.0");

		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");

		panelDatos.add(lblTotalPeliculas);
		panelDatos.add(lblTotalPeliculasValor);
		panelDatos.add(lblPromedioRating);
		panelDatos.add(lblPromedioRatingValor);
		panelDatos.add(lblDuracionTotal);
		panelDatos.add(lblDuracionTotalValor);
		panelDatos.add(btnVolver);

		JPanel contenedor = new JPanel(new FlowLayout(FlowLayout.CENTER));
		contenedor.setBackground(Color.WHITE);
		contenedor.add(panelDatos);

		add(contenedor, BorderLayout.CENTER);
	}

	public void setTotalPeliculas(int total) {
		lblTotalPeliculasValor.setText(String.valueOf(total));
	}

	public void setPromedioRating(double promedio) {
		lblPromedioRatingValor.setText(String.format("%.2f", promedio));
	}

	public void setDuracionTotalHoras(double horas) {
		lblDuracionTotalValor.setText(String.format("%.2f", horas));
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

}
