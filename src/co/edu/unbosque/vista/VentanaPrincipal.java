package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private CardLayout cardLayout;
    private JPanel contenedorCentral;

    private PanelPrincipal vistaMenu;
    private PanelAgregarPelicula panelAgregar;
    private PanelBuscarPelicula panelBuscar;
    private PanelEditarPelicula panelEditar;
    private PanelEliminarPelicula panelEliminar;
    private PanelEstadisticas panelEstadisticas;

    public static final String MENU = "MENU";
    public static final String AGREGAR = "AGREGAR";
    public static final String BUSCAR = "BUSCAR";
    public static final String EDITAR = "EDITAR";
    public static final String ELIMINAR = "ELIMINAR";
    public static final String ESTADISTICAS = "ESTADISTICAS";

    public VentanaPrincipal() {
        setTitle("Gestión de Películas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 550);
        setLocationRelativeTo(null);
        setResizable(false);

        inicializarComponentes();
        setVisible(true);
    }

    private void inicializarComponentes() {
        cardLayout = new CardLayout();
        contenedorCentral = new JPanel(cardLayout);

        vistaMenu = new PanelPrincipal();               
        panelAgregar = new PanelAgregarPelicula();
        panelBuscar = new PanelBuscarPelicula();
        panelEditar = new PanelEditarPelicula();
        panelEliminar = new PanelEliminarPelicula();
        panelEstadisticas = new PanelEstadisticas();

        contenedorCentral.add(vistaMenu, MENU);
        contenedorCentral.add(panelAgregar, AGREGAR);
        contenedorCentral.add(panelBuscar, BUSCAR);
        contenedorCentral.add(panelEditar, EDITAR);
        contenedorCentral.add(panelEliminar, ELIMINAR);
        contenedorCentral.add(panelEstadisticas, ESTADISTICAS);

        add(contenedorCentral, BorderLayout.CENTER);
    }

    // Métodos para mostrar paneles
    public void mostrarMenu() {
        cardLayout.show(contenedorCentral, MENU);
    }

    public void mostrarPanelAgregar() {
        cardLayout.show(contenedorCentral, AGREGAR);
    }

    public void mostrarPanelBuscar() {
        cardLayout.show(contenedorCentral, BUSCAR);
    }

    public void mostrarPanelEditar() {
        cardLayout.show(contenedorCentral, EDITAR);
    }

    public void mostrarPanelEliminar() {
        cardLayout.show(contenedorCentral, ELIMINAR);
    }
    
    public void mostrarPanelEstadisticas() {
    	cardLayout.show(contenedorCentral, ESTADISTICAS);
    }

    // Getters para los paneles
    public PanelPrincipal getVistaMenu() {
        return vistaMenu;
    }

    public PanelAgregarPelicula getPanelAgregar() {
        return panelAgregar;
    }

    public PanelBuscarPelicula getPanelBuscar() {
        return panelBuscar;
    }

    public PanelEditarPelicula getPanelEditar() {
        return panelEditar;
    }

    public PanelEliminarPelicula getPanelEliminar() {
        return panelEliminar;
    }

	public PanelEstadisticas getPanelEstadisticas() {
		return panelEstadisticas;
	}

	public void setPanelEstadisticas(PanelEstadisticas panelEstadisticas) {
		this.panelEstadisticas = panelEstadisticas;
	}
    
    
}
