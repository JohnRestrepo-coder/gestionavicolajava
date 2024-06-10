package com.example.gestionavicola.controlador;

import com.example.gestionavicola.modelo.Tarea;
import com.example.gestionavicola.modelo.TareaDAO;
import com.example.gestionavicola.vista.GestionAvicola;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class TareaController {
    private GestionAvicola vista;
    private TareaDAO modelo;

    public TareaController(GestionAvicola vista, TareaDAO modelo) {
        this.vista = vista;
        this.modelo = modelo;
        inicializar();
    }

    private void inicializar() {
        // Agregar lógica para interactuar con la vista y el modelo
    }

    public void agregarTarea(String descripcion) {
        Timestamp fechaHora = new Timestamp(System.currentTimeMillis());
        Tarea tarea = new Tarea(0, descripcion, fechaHora);
        try {
            modelo.agregarTarea(tarea);
            // Actualizar vista
            vista.actualizarTabla();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Tarea> obtenerTareas() {
        try {
            return modelo.obtenerTareas();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void eliminarTarea(int id) {
        try {
            modelo.eliminarTarea(id);
            // Actualizar vista
            vista.actualizarTabla();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarTarea(int id, String descripcion) {
        try {
            modelo.actualizarTarea(id, descripcion);
            // Actualizar vista
            vista.actualizarTabla();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
