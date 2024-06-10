package com.example.gestionavicola.modelo;

import java.sql.Timestamp;

public class Tarea {
    private int id;
    private String descripcion;
    private Timestamp fechaHora;

    public Tarea(int id, String descripcion, Timestamp fechaHora) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }
}
