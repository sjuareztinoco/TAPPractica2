package vista;

import controlador.ControladorEspecialidad;
import modelo.Especialidad;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import static vista.ConstantesVistas.*;

public class PanelAgregarEspecialidad extends JPanel {
    private Especialidad especialidad;
    private JLabel titulo;
    private JLabel etiquetaNombre;
    private JTextField campoNombre;
    private JButton botonAgregar;
    public PanelAgregarEspecialidad(Especialidad especialidad){
        this.especialidad = especialidad;
        this.initComponents();
    }

    private void initComponents() {
        this.setLayout(null);
        titulo = new JLabel("Agregar especialidad");
        titulo.setFont(new Font(Font.SANS_SERIF,Font.BOLD, 20));
        titulo.setSize(ANCHO_CAMPO, ALTO_CAMPO);
        titulo.setLocation(X + 40, Y - 50);
        add(titulo);

        etiquetaNombre = new JLabel("Nombre de la especialidad: ");
        etiquetaNombre.setLocation(X,Y);
        etiquetaNombre.setSize(ANCHO_CAMPO, ALTO_CAMPO);
        add(etiquetaNombre);

        campoNombre = new JTextField();
        campoNombre.setLocation(X, Y + ALTO_CAMPO + GAP_Y);
        campoNombre.setSize(ANCHO_CAMPO, ALTO_CAMPO);
        add(campoNombre);

        botonAgregar = new JButton("Agregar");
        botonAgregar.setSize(100,30);
        botonAgregar.setLocation(X + 75, Y + ALTO_CAMPO * 2 + GAP_Y * 2);
        botonAgregar.setActionCommand("agregar");
        add(botonAgregar);
    }

    public void agregarEvento(ControladorEspecialidad controlador) {
        botonAgregar.addActionListener(controlador);
    }

    public JTextField getCampoNombre() {
        return campoNombre;
    }
}
