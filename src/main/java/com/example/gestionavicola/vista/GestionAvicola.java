package com.example.gestionavicola.vista;

import com.example.gestionavicola.controlador.TareaController;
import com.example.gestionavicola.modelo.Tarea;
import com.example.gestionavicola.modelo.TareaDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GestionAvicola extends JFrame {
    private JTextField tareaField;
    private JButton agregarButton;
    private JTable tareasTable;
    private TareaController controller;
    private DefaultTableModel tableModel;

    public GestionAvicola() {
        System.out.println("Inicializando componentes...");
        TareaDAO tareaDAO = new TareaDAO();
        controller = new TareaController(this, tareaDAO);

        setTitle("Gestión Avícola");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(247, 95, 34, 255));
        initComponents();
    }

    private void initComponents() {
        tareaField = new JTextField(20);
        agregarButton = new JButton("Agregar Tarea");
        JButton actualizarButton = new JButton("Actualizar Tarea");
        JButton eliminarButton = new JButton("Eliminar Tarea");

        tableModel = new DefaultTableModel(new Object[]{"ID", "Descripción", "Fecha y Hora"}, 0);
        tareasTable = new JTable(tableModel);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(247, 95, 34, 255));
        panel.add(new JLabel("Tarea:"));
        panel.add(tareaField);
        panel.add(agregarButton);
        panel.add(actualizarButton);
        panel.add(eliminarButton);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(tareasTable), BorderLayout.CENTER);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descripcion = tareaField.getText();
                controller.agregarTarea(descripcion);
                tareaField.setText("");
            }
        });

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tareasTable.getSelectedRow();
                if (selectedRow != -1) {
                    int id = (int) tableModel.getValueAt(selectedRow, 0);
                    String descripcion = tareaField.getText();
                    controller.actualizarTarea(id, descripcion);
                    tareaField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona una tarea para actualizar");
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tareasTable.getSelectedRow();
                if (selectedRow != -1) {
                    int id = (int) tableModel.getValueAt(selectedRow, 0);
                    controller.eliminarTarea(id);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona una tarea para eliminar");
                }
            }
        });

        actualizarTabla();
    }

    public void actualizarTabla() {
        tableModel.setRowCount(0);
        List<Tarea> tareas = controller.obtenerTareas();
        for (Tarea tarea : tareas) {
            tableModel.addRow(new Object[]{tarea.getId(), tarea.getDescripcion(), tarea.getFechaHora()});
        }
    }
}
