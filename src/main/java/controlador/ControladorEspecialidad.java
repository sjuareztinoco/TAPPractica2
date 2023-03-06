package controlador;

import modelo.Especialidad;
import vista.PanelAgregarEspecialidad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorEspecialidad implements ActionListener {
    private final Especialidad modelo;
    private final PanelAgregarEspecialidad vista;

    public ControladorEspecialidad(Especialidad modelo, PanelAgregarEspecialidad vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre = vista.getCampoNombre().getText().trim();
        if(nombre.isEmpty() || nombre.isBlank()) {
            JOptionPane.showMessageDialog(vista, "Llene el campo",
                    "CAMPOS VACIOS", JOptionPane.WARNING_MESSAGE);
            return;
        }
        modelo.setId(1);
        modelo.setNombre(nombre);
        JOptionPane.showMessageDialog(vista,modelo.toString());
    }
}
