package org.example.dao;
import org.example.model.Estudiante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAOImpl implements EstudianteDAO {

    private final Connection connection;

    // Constructor que recibe la conexión como parámetro
    public EstudianteDAOImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void crear(Estudiante estudiante) {
        String sql = "INSERT INTO estudiante (nombre, correo) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, estudiante.getNombre());
            statement.setString(2, estudiante.getCorreo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Estudiante leer(int estudianteID) {
        String sql = "SELECT * FROM estudiante WHERE estudianteID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, estudianteID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Estudiante(
                        resultSet.getInt("estudianteID"),
                        resultSet.getString("nombre"),
                        resultSet.getString("correo")

                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void eliminar(int estudianteID) {
        String sql = "DELETE FROM estudiante WHERE estudianteID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, estudianteID);
            statement.executeUpdate();
        } catch (SQLException e) {

                if (e.getMessage().contains("foreign key constraint")) {
                    System.out.println("No se puede eliminar: el estudiante tiene inscripciones activas, elimine la inscripcion.");
                } else {
                    e.printStackTrace();
                }

        }

    }

    @Override
    public List<Estudiante> listar() {
        List<Estudiante> estudiantes = new ArrayList<>();
        String sql = "SELECT * FROM estudiante";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                estudiantes.add(new Estudiante(
                        resultSet.getInt("estudianteID"),
                        resultSet.getString("nombre"),
                        resultSet.getString("correo")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudiantes;


    }
}
