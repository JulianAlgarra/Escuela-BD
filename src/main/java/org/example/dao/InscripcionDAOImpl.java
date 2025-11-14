package org.example.dao;

import org.example.model.Estudiante;
import org.example.model.Inscripcion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InscripcionDAOImpl implements InscripcionDAO{

    private final Connection connection;

    // Constructor que recibe la conexión como parámetro
    public InscripcionDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(Inscripcion inscripcion) {
        String sql = "INSERT INTO inscripcion (estudianteID, cursoID, fechaInscripcion) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, inscripcion.getEstudianteId());
            statement.setInt(2, inscripcion.getCursoId());
            statement.setString(3, inscripcion.getInscripcionFecha());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Inscripcion leer(int inscripcionID) {
        String sql = "SELECT * FROM inscripcion WHERE inscripcionID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, inscripcionID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Inscripcion(
                        resultSet.getInt("inscripcionID"),
                        resultSet.getInt("estudianteID"),
                        resultSet.getInt("cursoID"),
                        resultSet.getString("fechaInscripcion")

                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void eliminar(int inscripcionID) {
        String sql = "DELETE FROM inscripcion WHERE inscripcionID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, inscripcionID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Inscripcion> listar() {
        List<Inscripcion> inscripciones = new ArrayList<>();
        String sql = "SELECT * FROM inscripcion";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                inscripciones.add(new Inscripcion(
                        resultSet.getInt("inscripcionID"),
                        resultSet.getInt("estudianteID"),
                        resultSet.getInt("cursoID"),
                        resultSet.getString("fechaInscripcion")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inscripciones;
    }
}
