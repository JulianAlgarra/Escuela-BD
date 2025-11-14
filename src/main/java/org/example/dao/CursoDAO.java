package org.example.dao;

import org.example.model.Curso;
import java.util.*;

public interface CursoDAO {
    void crear (Curso curso);
    Curso leer (int cursoID);
    void eliminar (int cursoID);
    List<Curso> listar();
}
