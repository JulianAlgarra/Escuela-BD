package org.example.model;

public class Inscripcion {
    private int inscripcionId;
    private int estudianteId;
    private int cursoId;
    private String inscripcionFecha;

    public Inscripcion() {
    }

    public Inscripcion(int inscripcionId, int estudianteId, int cursoId, String inscripcionFecha) {
        this.inscripcionId = inscripcionId;
        this.estudianteId = estudianteId;
        this.cursoId = cursoId;
        this.inscripcionFecha = inscripcionFecha;
    }

    public int getInscripcionId() {
        return inscripcionId;
    }

    public void setInscripcionId(int inscripcionId) {
        this.inscripcionId = inscripcionId;
    }

    public int getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(int estudianteId) {
        this.estudianteId = estudianteId;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public String getInscripcionFecha() {
        return inscripcionFecha;
    }

    public void setInscripcionFecha(String inscripcionFecha) {
        this.inscripcionFecha = inscripcionFecha;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "inscripcionId=" + inscripcionId +
                ", estudianteId=" + estudianteId +
                ", cursoId=" + cursoId +
                ", inscripcionFecha='" + inscripcionFecha + '\'' +
                '}';
    }
}
