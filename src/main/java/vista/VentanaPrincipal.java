package vista;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    private JPanel panelVistas;
    private JTabbedPane panelTabs;
    private PanelAgregarEspecialidad panelAgregarEspecialidad;

    public VentanaPrincipal(){
        super("Administrar escuela");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panelVistas);
        panelAgregarEspecialidad = new PanelAgregarEspecialidad();
        panelTabs.add("Especialidad", panelAgregarEspecialidad);
    }

}
