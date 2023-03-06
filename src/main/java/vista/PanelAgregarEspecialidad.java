package vista;

import controlador.ControladorEspecialidad;
import modelo.Especialidad;

import javax.swing.*;
import java.awt.*;

public class PanelAgregarEspecialidad extends JPanel {
    private final Especialidad especialidad;
    private JLabel titulo;
    private JLabel etiquetaNombre;
    private JTextField campoNombre;
    private JButton botonAgregar;
    private final int x = 100;
    private final int y = 100;
    private final int gapY = 5;
    private final int anchoCampo = 250;
    private final int altoCampo = 30;

    public PanelAgregarEspecialidad(Especialidad especialidad){
        this.initComponents();
        this.especialidad = especialidad;
    }

    private void initComponents() {
        this.setLayout(null);
        titulo = new JLabel("Agregar especialidad");
        titulo.setFont(new Font(Font.SANS_SERIF,Font.BOLD, 20));
        titulo.setSize(anchoCampo, altoCampo);
        titulo.setLocation(x + 50, y - 50);
        add(titulo);

        etiquetaNombre = new JLabel("Nombre de la especialidad: ");
        etiquetaNombre.setLocation(x,y);
        etiquetaNombre.setSize(anchoCampo, altoCampo);
        add(etiquetaNombre);

        campoNombre = new JTextField();
        campoNombre.setLocation(x, y + altoCampo + gapY);
        campoNombre.setSize(anchoCampo, altoCampo);
        add(campoNombre);

        botonAgregar = new JButton("Agregar");
        botonAgregar.setSize(100,30);
        botonAgregar.setLocation(x + 75, y + altoCampo * 2 + gapY * 5);
        add(botonAgregar);
    }

    public void agregarEvento(ControladorEspecialidad controlador) {
        botonAgregar.addActionListener(controlador);
    }

    public JTextField getCampoNombre() {
        return campoNombre;
    }
}
