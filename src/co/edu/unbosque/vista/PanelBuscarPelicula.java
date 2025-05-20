package co.edu.unbosque.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.modelo.PeliculaDto;

import java.awt.*;
import java.util.List;

public class PanelBuscarPelicula extends JPanel {

    private JTextField txtBuscar;
    private JButton btnBuscar;
    private JTable tablaResultados;
    private JButton btnVolver;
    private DefaultTableModel modeloTabla;

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

        String[] columnas = { "ID", "Nombre", "Género", "Fecha Estreno", "Rating" };
		modeloTabla = new DefaultTableModel(null, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        tablaResultados = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaResultados);
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

    public void limpiarBusqueda() {
        
    }
}
