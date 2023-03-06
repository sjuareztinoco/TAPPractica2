package org.example;

import vista.VentanaPrincipal;

public class Main {
    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setSize(500, 350);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}