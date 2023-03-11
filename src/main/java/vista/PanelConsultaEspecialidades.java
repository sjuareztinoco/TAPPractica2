package vista;

import controlador.ControladorEspecialidades;
import dao.DAOEspecialidad;
import modelo.Especialidad;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

import static vista.ConstantesVistas.*;

public class PanelConsultaEspecialidades extends JPanel {
    private List<Especialidad> especialidades;
    private JLabel titulo;
    private JTable tabla;
    private JButton botonModificar;
    private JButton botonEliminar;
    private JButton botonRecargar;

    public PanelConsultaEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
        this.especialidades.addAll(new DAOEspecialidad().consultar());
        this.initComponents();
    }

    private void initComponents() {
        this.setLayout(null);
        titulo = new JLabel("Especialidades");
        titulo.setFont(new Font(Font.SANS_SERIF,Font.BOLD, 20));
        titulo.setSize(ANCHO_CAMPO, ALTO_CAMPO);
        titulo.setLocation(X + 60, Y - 50);
        add(titulo);
        DefaultTableModel dtm = new DefaultTableModel(
                especialidades.stream()
                .map(registro -> new Object[]{registro.getId(), registro.getNombre()})
                .toArray(Object[][]::new),
                new Object[]{"ID", "Especialidad"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };
        tabla = new JTable(dtm);
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setLocation(X - 15,Y);
        scrollPane.setSize(ANCHO_TABLA, ALTO_TABLA);
        add(scrollPane);

        botonModificar = new JButton("Modificar");
        botonModificar.setLocation(X - 15, Y + GAP_Y + ALTO_TABLA);
        botonModificar.setSize(ANCHO_BOTON, ALTO_BOTON);
        botonModificar.setActionCommand("modificar");
        add(botonModificar);

        botonEliminar = new JButton("Eliminar");
        botonEliminar.setLocation(X - 15 + GAP_X + ANCHO_BOTON, Y + GAP_Y + ALTO_TABLA);
        botonEliminar.setSize(ANCHO_BOTON, ALTO_BOTON);
        botonEliminar.setActionCommand("eliminar");
        add(botonEliminar);

        botonRecargar = new JButton("Recargar");
        botonRecargar.setLocation(X - 15 + (GAP_X + ANCHO_BOTON) * 2, Y + GAP_Y +ALTO_TABLA);
        botonRecargar.setSize(ANCHO_BOTON, ALTO_BOTON);
        botonRecargar.setActionCommand("recargar");
        add(botonRecargar);
    }

    public void agregarEvento(ControladorEspecialidades controlador) {
        this.botonRecargar.addActionListener(controlador);
        this.botonEliminar.addActionListener(controlador);
        this.botonModificar.addActionListener(controlador);
    }

    public JTable getTabla() {
        return this.tabla;
    }
}
