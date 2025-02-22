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

/* 
*
 * @author visitante
 */
public class CursoDAO {

    private static final String SQL_SELECT = "SELECT codigo_curso, nombre_curso, estatus_curso FROM cursos";
    private static final String SQL_INSERT = "INSERT INTO cursos(nombre_curso, estatus_curso) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE cursos SET nombre_curso=?, estatus_curso=? WHERE codigo_curso = ?";
    private static final String SQL_DELETE = "DELETE FROM cursos WHERE codigo_curso = ?";
    private static final String SQL_QUERY = "SELECT codigo_curso, nombre_curso, estatus_curso FROM cursos WHERE codigo_curso = ?";

    public List<Curso> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Curso curso = null;//alumno es un objeto
        List<Curso> cursos = new ArrayList<Curso>();//alumnos sera la lista donde se guardaran 

        try {//try y catch sirve para capturar el error y permitir que siga avanzando
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigoCurso = rs.getInt("codigo_curso");
                String nombreCurso = rs.getString("nombre_curso");
                String estatusCurso = rs.getString("estatus_curso");
                
                curso = new Curso();
                curso.setCodigoCurso(codigoCurso);
                curso.setNombreCurso(nombreCurso);
                curso.setEstatusCurso(estatusCurso);
                
                
                cursos.add(curso);
              //vendedores---vedores
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
            stmt.setString(1, curso.getNombreCurso());
            stmt.setString(2, curso.getEstatusCurso());


            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
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
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, curso.getNombreCurso());
            stmt.setString(2, curso.getEstatusCurso());
            stmt.setInt(3, curso.getCodigoCurso());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

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
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, curso.getCodigoCurso());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public Curso query(Curso curso) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Curso> cursos = new ArrayList<Curso>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, curso.getCodigoCurso());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigoCurso = rs.getInt("codigo_curso");
                String nombreCurso = rs.getString("nombre_curso");
                String estatusCurso = rs.getString("estatus_curso");
                
                curso = new Curso();
                curso.setCodigoCurso(codigoCurso);
                curso.setNombreCurso(nombreCurso);
                curso.setEstatusCurso(estatusCurso);
                
                //vendedores.add(vendedor); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return vendedores;  // Si se utiliza un ArrayList
        return curso;
    }
        
}
