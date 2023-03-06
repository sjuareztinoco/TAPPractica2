package vista;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    private JPanel panelVistas;
    private JTabbedPane panelTabs;
    private PanelAgregarEspecialidad panelAgregarEspecialidad;

    public VentanaPrincipal(PanelAgregarEspecialidad panel1){
        super("Administrar escuela");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panelVistas);
        panelAgregarEspecialidad = panel1;
        panelTabs.add("Especialidad", panelAgregarEspecialidad);
    }

}
