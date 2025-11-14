package org.example.model;

public class Curso {
    private int cursoId;
    private String nombre;
    private String profesor;

    public Curso() {
    }

    public Curso(int cursoId, String nombre, String profesor) {
        this.cursoId = cursoId;
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "cursoId=" + cursoId +
                ", nombre='" + nombre + '\'' +
                ", profesor='" + profesor + '\'' +
                '}';
    }
}
