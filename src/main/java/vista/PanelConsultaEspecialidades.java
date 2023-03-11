package vista;

import dao.DAOEspecialidad;
import modelo.Especialidad;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PanelConsultaEspecialidades extends JPanel {
    private List<Especialidad> especialidades;
    private JLabel titulo;
    private JTable tabla;
    private JButton botonModificar;
    private JButton botonEliminar;
    private final int x = 100;
    private final int y = 100;
    private final int gapY = 5;
    private final int gapX = 10;
    private final int anchoCampo = 250;
    private final int anchoTabla = 250;
    private final int anchoBoton = 100;
    private final int altoCampo = 30;
    private final int altoTabla = 100;
    private final int altoBoton = 30;
    public PanelConsultaEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
        this.especialidades.addAll(new DAOEspecialidad().consultar());
        this.initComponents();
    }

    private void initComponents() {
        this.setLayout(null);
        titulo = new JLabel("Especialidades");
        titulo.setFont(new Font(Font.SANS_SERIF,Font.BOLD, 20));
        titulo.setSize(anchoCampo, altoCampo);
        titulo.setLocation(x + 50, y - 50);
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
        scrollPane.setLocation(x,y);
        scrollPane.setSize(anchoTabla, altoTabla);
        add(scrollPane);

        botonModificar = new JButton("Modificar");
        botonModificar.setLocation(x, y + gapY * 3 + altoTabla);
        botonModificar.setSize(anchoBoton, altoBoton);
        add(botonModificar);

        botonEliminar = new JButton("Eliminar");
        botonEliminar.setLocation(x + gapX + anchoBoton, y + gapY * 3 + altoTabla);
        botonEliminar.setSize(anchoBoton, altoBoton);
        add(botonEliminar);
    }
}
