package com.example.gestionavicola.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TareaDAO {
    public void agregarTarea(Tarea tarea) throws SQLException {
        String sql = "INSERT INTO tareas (descripcion, fecha_hora) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tarea.getDescripcion());
            stmt.setTimestamp(2, tarea.getFechaHora());
            stmt.executeUpdate();
        }
    }

    public List<Tarea> obtenerTareas() throws SQLException {
        List<Tarea> tareas = new ArrayList<>();
        String sql = "SELECT * FROM tareas";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String descripcion = rs.getString("descripcion");
                Timestamp fechaHora = rs.getTimestamp("fecha_hora");
                tareas.add(new Tarea(id, descripcion, fechaHora));
            }
        }
        return tareas;
    }

    public void eliminarTarea(int id) throws SQLException {
        String sql = "DELETE FROM tareas WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public void actualizarTarea(int id, String descripcion) throws SQLException {
        String sql = "UPDATE tareas SET descripcion = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, descripcion);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }
}
