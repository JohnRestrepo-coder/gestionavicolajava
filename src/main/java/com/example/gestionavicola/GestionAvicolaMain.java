package com.example.gestionavicola;

import com.example.gestionavicola.vista.GestionAvicola;

import javax.swing.SwingUtilities;

public class GestionAvicolaMain {
    public static void main(String[] args) {
        System.out.println("Iniciando aplicación...");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GestionAvicola gestionAvicola = new GestionAvicola();
                gestionAvicola.setVisible(true);
                System.out.println("Ventana mostrada");
            }
        });
    }
}


/* Es el archivo principal que inicia gestionavicola.java */