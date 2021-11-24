package main.com.dh.academia.dao.impl;

import main.com.dh.academia.dao.ConfiguracionJDBC;
import main.com.dh.academia.dao.IDao;
import main.com.dh.academia.model.Estudiante;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDaoH2 implements IDao<Estudiante> {

    private ConfiguracionJDBC configuracionJDBC;

    public EstudianteDaoH2(ConfiguracionJDBC configuracionJDBC) {
        this.configuracionJDBC = configuracionJDBC;
    }

    @Override
    public Estudiante guardar(Estudiante estudiante) {
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        Statement stmt = null;
        String query = String.format("INSERT INTO estudiantes VALUES('%s','%s','%s')", estudiante.getId(), estudiante.getNombre(), estudiante.getApellido());
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return estudiante;
    }

    @Override
    public void eliminar(String id) {
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        Statement stmt = null;
        String query = String.format("DELETE FROM estudiantes where id = %s", id);
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public Estudiante buscar(String id) {
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        Statement stmt = null;
        String query = String.format("SELECT id,nombre,apellido  FROM estudiantes where id = '%s'", id);
        Estudiante estudiante = null;
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                String idEstudiante = result.getString("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                estudiante = new Estudiante(idEstudiante, nombre, apellido);
            }

            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return estudiante;
    }

    @Override
    public List<Estudiante> buscarTodos() {
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        Statement stmt = null;
        String query = "SELECT *  FROM estudiantes";
        List<Estudiante> estudiantes = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                String id = result.getString("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                estudiantes.add(new Estudiante(id, nombre, apellido));

            }

            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return estudiantes;
    }
}
