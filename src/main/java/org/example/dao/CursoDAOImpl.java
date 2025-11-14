package org.example.dao;

import org.example.model.Curso;
import org.example.model.Estudiante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAOImpl implements CursoDAO{

    private final Connection connection;

    // Constructor que recibe la conexión como parámetro
    public CursoDAOImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void crear(Curso curso) {
        String sql = "INSERT INTO curso (cursoID, nombre, profesor) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, curso.getCursoId());
            statement.setString(2, curso.getNombre());
            statement.setString(3, curso.getProfesor());
            statement.executeUpdate();
        } catch (SQLException e) {
            if (e.getMessage().contains("foreign key constraint")) {
                System.out.println("No se puede eliminar: el curso tiene inscripciones activas, elimine la inscripcion.");
            } else {
                e.printStackTrace();
            }
        }

    }

    @Override
    public Curso leer(int cursoID) {
        String sql = "SELECT * FROM curso WHERE cursoID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, cursoID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Curso(
                        resultSet.getInt("cursoID"),
                        resultSet.getString("nombre"),
                        resultSet.getString("profesor")

                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void eliminar(int cursoID) {
        String sql = "DELETE FROM curso WHERE cursoID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, cursoID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Curso> listar() {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM curso";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                cursos.add(new Curso(
                        resultSet.getInt("cursoID"),
                        resultSet.getString("nombre"),
                        resultSet.getString("profesor")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cursos;
    }
}
