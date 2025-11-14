package org.example.dao;

import org.example.model.Estudiante;
import java.util.*;

public interface EstudianteDAO {
    void crear (Estudiante estudiante);
    Estudiante leer (int estudianteID);
    void eliminar (int estudianteID);
    List<Estudiante> listar();
}
