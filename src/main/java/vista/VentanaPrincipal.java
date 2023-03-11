package vista;

import controlador.ControladorMenu;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    private JPanel panelVistas;
    private JMenuBar barraMenu;
    private JMenu menuEspecialidad;
    private JMenuItem itemAgregarEspecialidad;
    private JMenuItem itemAdministrarEspecialidades;
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

        barraMenu = new JMenuBar();
        menuEspecialidad = new JMenu("Especialidades");
        itemAgregarEspecialidad = new JMenuItem("Agregar");
        itemAgregarEspecialidad.setActionCommand("menu-add-esp");
        itemAdministrarEspecialidades = new JMenuItem("Administrar");
        itemAdministrarEspecialidades.setActionCommand("menu-admin-esp");

        menuEspecialidad.add(itemAgregarEspecialidad);
        menuEspecialidad.add(itemAdministrarEspecialidades);
        barraMenu.add(menuEspecialidad);
        this.setJMenuBar(barraMenu);

        panelAgregarEspecialidad = panel1;
        panelConsultaEspecialidades = panel2;
    }

    public void agregarEventosDeMenu(ControladorMenu controladorMenu) {
        this.itemAgregarEspecialidad.addActionListener(controladorMenu);
        this.itemAdministrarEspecialidades.addActionListener(controladorMenu);
    }

}
