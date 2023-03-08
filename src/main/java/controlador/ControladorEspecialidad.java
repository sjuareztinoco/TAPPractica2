package controlador;

import dao.DAOEspecialidad;
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
        modelo.setNombre(nombre);
        DAOEspecialidad daoEspecialidad = new DAOEspecialidad();
        if (daoEspecialidad.agregar(modelo)) {
            JOptionPane.showMessageDialog(vista,"Se agregó especialidad: " + nombre,
                    "OPERACIÓN EXITOSA", JOptionPane.INFORMATION_MESSAGE);
            vista.getCampoNombre().setText("");
        } else {
            JOptionPane.showMessageDialog(vista,"No se pudo agregar: " + nombre,
                    "Ups!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
