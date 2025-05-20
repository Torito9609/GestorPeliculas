package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class PanelBuscarPelicula extends JPanel {

    private JTextField txtBuscar;
    private JButton btnBuscar;
    private JTable tablaResultados;
    private JScrollPane scrollTabla;
    private JButton btnVolver;

    public PanelBuscarPelicula() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        JPanel panelBusqueda = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelBusqueda.setBackground(Color.WHITE);
        panelBusqueda.setBorder(BorderFactory.createTitledBorder("Buscar por Título"));

        txtBuscar = new JTextField(30);
        btnBuscar = new JButton("Buscar");
        btnBuscar.setActionCommand("FINALIZAR_BUSCAR");

        panelBusqueda.add(new JLabel("Título o parte del nombre:"));
        panelBusqueda.add(txtBuscar);
        panelBusqueda.add(btnBuscar);

        add(panelBusqueda, BorderLayout.NORTH);

        String[] columnas = {"ID", "Nombre", "Género", "Fecha Estreno", "Rating"};
        tablaResultados = new JTable(new Object[0][5], columnas);
        scrollTabla = new JScrollPane(tablaResultados);
        add(scrollTabla, BorderLayout.CENTER);

        btnVolver = new JButton("Volver");
        btnVolver.setActionCommand("VOLVER");
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelInferior.setBackground(Color.WHITE);
        panelInferior.add(btnVolver);

        add(panelInferior, BorderLayout.SOUTH);
    }

    public String getTextoBusqueda() {
        return txtBuscar.getText().trim();
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public void mostrarResultados(Object[][] datos) {
        String[] columnas = {"ID", "Nombre", "Género", "Fecha Estreno", "Rating"};
        tablaResultados.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));
    }

    public void limpiarBusqueda() {
        txtBuscar.setText("");
        mostrarResultados(new Object[0][5]);
    }
}
