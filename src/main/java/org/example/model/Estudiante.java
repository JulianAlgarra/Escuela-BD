package org.example.model;

public class Estudiante {
    private int estudianteId;
    private String nombre;
    private String correo;

    public Estudiante() {
    }

    public Estudiante(int estudianteId, String nombre, String correo) {
        this.estudianteId = estudianteId;
        this.nombre = nombre;
        this.correo = correo;
    }

    public int getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(int estudianteId) {
        this.estudianteId = estudianteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "estudianteId=" + estudianteId +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
