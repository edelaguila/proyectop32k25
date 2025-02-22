/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class alumnoDAO {

    private static final String SQL_SELECT = "SELECT carnet_alumno, nombrealumno, direalumno, telefono, emailalumno, Estatus_alumno FROM alumnos";
    private static final String SQL_INSERT = "INSERT INTO alumnos(nombrealumno, direalumno, telefono, emailalumno, Estatus_alumno) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE alumnos SET  nombrealumno=?, direalumno=?, telefono=?, emailalumno=?, Estatus_alumno=? WHERE carnet_alumno = ?";
    private static final String SQL_DELETE = "DELETE FROM alumnos WHERE carnet_alumno=?";
    private static final String SQL_QUERY = "SELECT carnet_alumno, nombrealumno, direalumno, telefono, emailalumno, Estatus_alumno FROM alumnos WHERE carnet_alumno = ?";

    public List<alumno> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        alumno alumnos = null;
        List<alumno> estudiantes = new ArrayList<alumno>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int carnet_alumno = rs.getInt("carnet_alumno");
                String nombrealumno = rs.getString("nombrealumno");
                String direalumno = rs.getString("direalumno");
                String telefono = rs.getString("telefono");
                String emailalumno = rs.getString("emailalumno");
                String Estatus_alumno = rs.getString("Estatus_alumno");
                
                alumnos = new alumno();
                alumnos.setcarnet_alumno(carnet_alumno);
                alumnos.setnombrealumno(nombrealumno);
                alumnos.setdirealumno(direalumno);
                alumnos.settelefono(telefono);
                alumnos.setemailalumno(emailalumno);
                alumnos.setEstatus_alumno(Estatus_alumno);
                
                estudiantes.add(alumnos);
              //vendedores
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return estudiantes;
    }

    public int insert(alumno alumnos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, alumnos.getnombrealumno());
            stmt.setString(2, alumnos.getdirealumno());
            stmt.setString(3, alumnos.gettelefono());
            stmt.setString(4, alumnos.getemailalumno());
            stmt.setString(5, alumnos.getEstatus_alumno());
         


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

    public int update(alumno alumnos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, alumnos.getnombrealumno());
            stmt.setString(2, alumnos.getdirealumno());
            stmt.setString(3, alumnos.gettelefono());
            stmt.setString(4, alumnos.getemailalumno());
            stmt.setString(5, alumnos.getEstatus_alumno());
            //comodin del where
            stmt.setInt(6,alumnos.getcarnet_alumno());
           

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

    public int delete(alumno alumnos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, alumnos.getcarnet_alumno());
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
    public alumno query(alumno alumnos) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<alumno> estudiantes = new ArrayList<alumno>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, alumnos.getcarnet_alumno());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int carnet_alumno = rs.getInt("carnet_alumno");
                String nombrealumno = rs.getString("nombrealumno");
                String direalumno = rs.getString("direalumno");
                String telefono = rs.getString("telefono");
                String emailalumno = rs.getString("emailalumno");
                String Estatus_alumno = rs.getString("Estatus_alumno");
                
                alumnos = new alumno();
                alumnos.setcarnet_alumno(carnet_alumno);
                alumnos.setnombrealumno(nombrealumno);
                alumnos.setdirealumno(direalumno);
                alumnos.settelefono(telefono);
                alumnos.setemailalumno(emailalumno);
                alumnos.setEstatus_alumno(Estatus_alumno);
                
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
        return alumnos;
    }
        
}