package org.example;

import controlador.ControladorEspecialidad;
import modelo.Especialidad;
import vista.PanelAgregarEspecialidad;
import vista.PanelConsultaEspecialidades;
import vista.VentanaPrincipal;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Especialidad especialidad = new Especialidad(); //MODELOS
        List<Especialidad> especialidades = new ArrayList<>();
        PanelAgregarEspecialidad panel1 = new PanelAgregarEspecialidad(especialidad); //VISTAS
        PanelConsultaEspecialidades panel2 = new PanelConsultaEspecialidades(especialidades);
        VentanaPrincipal ventana = new VentanaPrincipal(panel1, panel2);
        ControladorEspecialidad controlador = new ControladorEspecialidad(especialidad, panel1); //CONTROL
        panel1.agregarEvento(controlador);
        ventana.setSize(500, 350);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}