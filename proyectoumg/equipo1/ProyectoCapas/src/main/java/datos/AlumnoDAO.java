/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Alumno;
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
public class AlumnoDAO {

    private static final String SQL_SELECT = "SELECT carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno FROM alumnos";
    private static final String SQL_INSERT = "INSERT INTO alumnos( nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno) VALUES(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE alumnos SET nombre_alumno=?, direccion_alumno=?, telefono_alumno=?, email_alumno=?, estatus_alumno=? WHERE carnet_alumno = ?";
    private static final String SQL_DELETE = "DELETE FROM alumnos WHERE carnet_alumno=?";
    private static final String SQL_QUERY = "SELECT carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno FROM alumnos WHERE carnet_alumno = ?";
// La lista tiene adetro la clase 
    public List<Alumno> select() {
        Connection conn = null;
        //stmt statement permite colocar sql query
        PreparedStatement stmt = null;
        //Lo que devolvio la base de datos 
        ResultSet rs = null;
        Alumno alumno = null;
        List<Alumno> alumnos = new ArrayList<Alumno>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int carnet_alumno = rs.getInt("carnet_alumno");
                String nombre_alumno = rs.getString("nombre_alumno");
                String telefono_alumno = rs.getString("telefono_alumno");
                String direccion_alumno = rs.getString("direccion_alumno");
                String email_alumno = rs.getString("email_alumno");
                String estatus_alumno = rs.getString("estatus_alumno");
                
                alumno = new Alumno();
                alumno.setCarnet_alumno(carnet_alumno);
                alumno.setNombre_alumno(nombre_alumno);
                alumno.setDireccion_alumno(direccion_alumno);
                alumno.setTelefono_alumno(telefono_alumno);
                alumno.setEmail_alumno(email_alumno);
                alumno.setEstatus_alumno(estatus_alumno);
                // este lo envia a la lista alumnos los alumno echos 
                alumnos.add(alumno);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return alumnos;
    }

    public int insert(Alumno alumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, alumno.getNombre_alumno());
            stmt.setString(2, alumno.getDireccion_alumno());
            stmt.setString(3, alumno.getTelefono_alumno());
            stmt.setString(4, alumno.getEmail_alumno());
            stmt.setString(5, alumno.getEstatus_alumno());

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

    public int update(Alumno alumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, alumno.getNombre_alumno());
            stmt.setString(2, alumno.getDireccion_alumno());
            stmt.setString(3, alumno.getTelefono_alumno());
            stmt.setString(4, alumno.getEmail_alumno());
            stmt.setString(5, alumno.getEstatus_alumno());
            stmt.setInt(6, alumno.getCarnet_alumno());
           
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

    public int delete(Alumno alumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, alumno.getCarnet_alumno());
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

 //  public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public Alumno query(Alumno alumno) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Alumno> alumnos = new ArrayList<Alumno>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, alumno.getCarnet_alumno());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int carnet_alumno = rs.getInt("carnet_alumno");
                String nombre_alumno = rs.getString("nombre_alumno");
                String telefono_alumno = rs.getString("telefono_alumno");
                String direccion_alumno = rs.getString("direccion_alumno");
                String email_alumno = rs.getString("email_alumno");
                String estatus_alumno = rs.getString("estatus_alumno");
                
                alumno = new Alumno();
                alumno.setCarnet_alumno(carnet_alumno);
                alumno.setNombre_alumno(nombre_alumno);
                alumno.setDireccion_alumno(direccion_alumno);
                alumno.setTelefono_alumno(telefono_alumno);
                alumno.setEmail_alumno(email_alumno);
                alumno.setEstatus_alumno(estatus_alumno);
                
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
         return alumno;
    }
        
}

