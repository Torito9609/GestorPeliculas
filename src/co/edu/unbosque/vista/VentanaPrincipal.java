package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private CardLayout cardLayout;
    private JPanel contenedorCentral;

    private VistaPrincipal vistaMenu;
    private PanelAgregarPelicula panelAgregar;
    private PanelBuscarPelicula panelBuscar;
    private PanelEditarPelicula panelEditar;
    private PanelEliminarPelicula panelEliminar;

    public static final String MENU = "MENU";
    public static final String AGREGAR = "AGREGAR";
    public static final String BUSCAR = "BUSCAR";
    public static final String EDITAR = "EDITAR";
    public static final String ELIMINAR = "ELIMINAR";

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

        vistaMenu = new VistaPrincipal();               // Menú con tabla y botones
        panelAgregar = new PanelAgregarPelicula();
        panelBuscar = new PanelBuscarPelicula();
        panelEditar = new PanelEditarPelicula();
        panelEliminar = new PanelEliminarPelicula();

        contenedorCentral.add(vistaMenu, MENU);
        contenedorCentral.add(panelAgregar, AGREGAR);
        contenedorCentral.add(panelBuscar, BUSCAR);
        contenedorCentral.add(panelEditar, EDITAR);
        contenedorCentral.add(panelEliminar, ELIMINAR);

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

    // Getters para los paneles
    public VistaPrincipal getVistaMenu() {
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
}
