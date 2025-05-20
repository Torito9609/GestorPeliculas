package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class Vista extends JPanel {
	private VentanaPrincipal ventana;

	public Vista() {
		this.ventana = new VentanaPrincipal();
	}

	public VentanaPrincipal getVentana() {
		return ventana;
	}

	public void setVentana(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	public void mostrarMensajeExito(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE,
				UIManager.getIcon("OptionPane.informationIcon"));
	}

	public void mostrarMensajeAdvertencia(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE,
				UIManager.getIcon("OptionPane.warningIcon"));
	}

	public void mostrarMensajeError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE,
				UIManager.getIcon("OptionPane.errorIcon"));
	}

	public int mostrarMensajeConfirmacion(String mensaje) {
		return JOptionPane.showConfirmDialog(null, mensaje, "Confirmación", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, UIManager.getIcon("OptionPane.questionIcon"));
	}
}
