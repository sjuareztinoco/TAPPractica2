package org.example;

import controlador.ControladorEspecialidad;
import controlador.ControladorEspecialidades;
import controlador.ControladorMenu;
import modelo.Especialidad;
import vista.PanelAgregarEspecialidad;
import vista.PanelConsultaEspecialidades;
import vista.VentanaPrincipal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Especialidad especialidad = new Especialidad(); //MODELOS
        List<Especialidad> especialidades = new ArrayList<>();
        PanelAgregarEspecialidad panel1 = new PanelAgregarEspecialidad(especialidad); //VISTAS
        PanelConsultaEspecialidades panel2 = new PanelConsultaEspecialidades(especialidades);
        VentanaPrincipal ventana = new VentanaPrincipal(panel1, panel2);
        ControladorEspecialidad controlador1 = new ControladorEspecialidad(especialidad, panel1); //CONTROLES
        ControladorEspecialidades controlador2 = new ControladorEspecialidades(especialidades, panel2);
        panel1.agregarEvento(controlador1);
        panel2.agregarEvento(controlador2);
        ventana.setSize(500, 350);
        ventana.setLocationRelativeTo(null);
        ControladorMenu controladorMenu = new ControladorMenu(ventana, new HashMap<>(){{
            put("menu-add-esp", panel1);
            put("menu-admin-esp", panel2);
        }});
        ventana.agregarEventosDeMenu(controladorMenu);
        ventana.setVisible(true);
    }
}