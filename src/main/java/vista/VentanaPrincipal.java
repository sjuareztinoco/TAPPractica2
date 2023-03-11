package vista;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    private JPanel panelVistas;
    private JTabbedPane panelTabs;
    private PanelAgregarEspecialidad panelAgregarEspecialidad;
    private PanelConsultaEspecialidades panelConsultaEspecialidades;

    public VentanaPrincipal(
            PanelAgregarEspecialidad panel1,
            PanelConsultaEspecialidades panel2
    ){
        super("Administrar escuela");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(panelVistas);
        panelAgregarEspecialidad = panel1;
        panelTabs.add("Agregar especialidad", panelAgregarEspecialidad);
        panelConsultaEspecialidades = panel2;
        panelTabs.add("Ver especialidades", panel2);
    }

}
