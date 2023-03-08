package org.example;

import controlador.ControladorEspecialidad;
import modelo.Especialidad;
import vista.PanelAgregarEspecialidad;
import vista.VentanaPrincipal;

public class Main {
    public static void main(String[] args) {
        Especialidad especialidad = new Especialidad(); //MODELO
        PanelAgregarEspecialidad panel1 = new PanelAgregarEspecialidad(especialidad); //VISTA
        VentanaPrincipal ventana = new VentanaPrincipal(panel1);
        ControladorEspecialidad controlador = new ControladorEspecialidad(especialidad, panel1); //CONTROL
        panel1.agregarEvento(controlador);
        ventana.setSize(500, 350);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}