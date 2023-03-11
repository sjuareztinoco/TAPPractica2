package controlador;

import dao.DAOEspecialidad;
import modelo.Especialidad;
import vista.PanelConsultaEspecialidades;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControladorEspecialidades implements ActionListener {
    private final List<Especialidad> modelo;
    private final PanelConsultaEspecialidades vista;

    public ControladorEspecialidades(List<Especialidad> modelo, PanelConsultaEspecialidades vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String origen = e.getActionCommand();
        switch (origen) {
            case "recargar" -> recargar();
            case "modificar" -> actualizar();
            case "eliminar" -> eliminar();
        }
    }

    private void recargar() {
        modelo.clear();
        modelo.addAll(new DAOEspecialidad().consultar());
        vista.getTabla().setModel(new DefaultTableModel(
                modelo.stream()
                    .map(registro -> new Object[]{registro.getId(), registro.getNombre()})
                    .toArray(Object[][]::new),
                    new Object[]{"ID", "Especialidad"}
            )
        );
        vista.repaint();
    }

    private void actualizar() {
        int filaSeleccionada = vista.getTabla().getSelectedRow();
        if (filaSeleccionada != -1) {
            int confirmacion = JOptionPane.showConfirmDialog(
                    vista,
                    "¿Está seguro de actualizar la fila seleccionada?",
                    "Confirmación",
                    JOptionPane.YES_NO_OPTION
            );
            if (confirmacion == JOptionPane.YES_OPTION) {
                Integer idEspecialidad = (Integer) vista.getTabla().getValueAt(filaSeleccionada,0);
                String nombreEspecialidad = (String) vista.getTabla().getValueAt(filaSeleccionada,1);
                Especialidad especialidad = new Especialidad(idEspecialidad, nombreEspecialidad);
                DAOEspecialidad daoEspecialidad = new DAOEspecialidad();
                if (daoEspecialidad.actualizar(idEspecialidad, especialidad)) {
                    this.recargar();
                    JOptionPane.showMessageDialog(
                            vista,
                            "El registro se ha actualizado correctamente",
                            "Actualización exitosa",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            vista,
                            "Algo salió mal. Intente nuevamente",
                            "Actualización fallida",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        } else {
            JOptionPane.showMessageDialog(
                    vista,
                    "No se ha seleccionado una fila",
                    "Actualización fallida",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void eliminar() {
        int filaSeleccionada = vista.getTabla().getSelectedRow();
        if (filaSeleccionada != -1) {
            int confirmacion = JOptionPane.showConfirmDialog(
                vista,
                "¿Está seguro de eliminar la fila seleccionada?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION
            );
            if (confirmacion == JOptionPane.YES_OPTION) {
                Integer idEspecialidad = (Integer) vista.getTabla().getValueAt(filaSeleccionada,0);
                DAOEspecialidad daoEspecialidad = new DAOEspecialidad();
                if(daoEspecialidad.eliminar(idEspecialidad)) {
                    this.recargar();
                    JOptionPane.showMessageDialog(
                            vista,
                            "El registro se ha eliminado correctamente",
                            "Eliminación exitosa",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            vista,
                            "Algo salió mal. Intente nuevamente",
                            "Eliminación fallida",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        } else {
            JOptionPane.showMessageDialog(
                vista,
                "No se ha seleccionado una fila",
                "Eliminación fallida",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
