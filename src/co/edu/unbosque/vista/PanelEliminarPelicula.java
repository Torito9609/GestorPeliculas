package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class PanelEliminarPelicula extends JPanel {

    private JTextField txtIdEliminar;
    private JButton btnEliminar;
    private JButton btnVolver;

    public PanelEliminarPelicula() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        JPanel panelEliminar = new JPanel(new GridLayout(2, 2, 10, 10));
        panelEliminar.setBorder(BorderFactory.createTitledBorder("Eliminar Película"));
        panelEliminar.setBackground(Color.WHITE);
        panelEliminar.setPreferredSize(new Dimension(400, 150));

        txtIdEliminar = new JTextField();
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setActionCommand("FINALIZAR_ELIMINAR");

        panelEliminar.add(new JLabel("ID de la película a eliminar:"));
        panelEliminar.add(txtIdEliminar);
        panelEliminar.add(new JLabel());
        panelEliminar.add(btnEliminar);

        JPanel centro = new JPanel(new GridBagLayout());
        centro.setBackground(Color.WHITE);
        centro.add(panelEliminar);

        add(centro, BorderLayout.CENTER);

        btnVolver = new JButton("Volver");
        btnVolver.setActionCommand("VOLVER");
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelInferior.setBackground(Color.WHITE);
        panelInferior.add(btnVolver);

        add(panelInferior, BorderLayout.SOUTH);
    }

    public String getIdEliminar() {
        return txtIdEliminar.getText().trim();
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public void limpiarCampo() {
        txtIdEliminar.setText("");
    }
}
