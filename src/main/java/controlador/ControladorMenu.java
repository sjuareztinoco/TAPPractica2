package controlador;

import com.sun.tools.jconsole.JConsoleContext;
import vista.VentanaPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ControladorMenu implements ActionListener {
    private final VentanaPrincipal vista;
    private final HashMap<String, JPanel> contenidos;

    public ControladorMenu(VentanaPrincipal vista, HashMap<String, JPanel> contenidos) {
        this.vista = vista;
        this.contenidos = contenidos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String origen = e.getActionCommand();
        vista.setContentPane(contenidos.get(origen));
        vista.revalidate();
        vista.repaint();
    }
}
