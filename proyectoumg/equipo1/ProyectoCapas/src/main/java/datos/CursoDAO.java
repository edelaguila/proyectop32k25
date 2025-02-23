/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    private static final String SQL_SELECT = "SELECT codigo_curso, nombre_curso, estatus_curso FROM cursos";
    private static final String SQL_INSERT = "INSERT INTO cursos(nombre_curso, estatus_curso) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE cursos SET nombre_curso=?, estatus_curso=? WHERE codigo_curso=?";
    private static final String SQL_DELETE = "DELETE FROM cursos WHERE codigo_curso=?";
    private static final String SQL_QUERY = "SELECT codigo_curso, nombre_curso, estatus_curso FROM cursos WHERE codigo_curso=?";

    public List<Curso> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Curso> cursos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo_curso = rs.getInt("codigo_curso");
                String nombre_curso = rs.getString("nombre_curso");
                String estatus_curso = rs.getString("estatus_curso");

                Curso curso = new Curso(codigo_curso, nombre_curso, estatus_curso);
                cursos.add(curso);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cursos;
    }

    public int insert(Curso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, curso.getNombre_curso());
            stmt.setString(2, curso.getEstatus_curso());

            System.out.println("Ejecutando query: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros insertados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int update(Curso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, curso.getNombre_curso());
            stmt.setString(2, curso.getEstatus_curso());
            stmt.setInt(3, curso.getCodigo_curso());

            System.out.println("Ejecutando query: " + SQL_UPDATE);
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados: " + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int delete(Curso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, curso.getCodigo_curso());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public Curso query(Curso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, curso.getCodigo_curso());
            rs = stmt.executeQuery();
            if (rs.next()) {
                curso.setCodigo_curso(rs.getInt("codigo_curso"));
                curso.setNombre_curso(rs.getString("nombre_curso"));
                curso.setEstatus_curso(rs.getString("estatus_curso"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return curso;
    }
}


