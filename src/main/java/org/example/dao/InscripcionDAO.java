package org.example.dao;

import org.example.model.Inscripcion;
import java.util.*;

public interface InscripcionDAO {
    void crear (Inscripcion inscripcion);
    Inscripcion leer (int inscripcionID);
    void eliminar (int inscripcionID);
    List<Inscripcion> listar();
}
