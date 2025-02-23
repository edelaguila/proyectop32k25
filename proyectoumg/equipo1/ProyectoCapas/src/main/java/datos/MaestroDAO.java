/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Maestro;
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
public class MaestroDAO {

    private static final String SQL_SELECT = "SELECT codigo_maestro, nombre_maestro, direccion_maestro, telefono_maestro, email_maestro, estatus_maestro FROM maestros";
    private static final String SQL_INSERT = "INSERT INTO maestros( nombre_maestro, direccion_maestro, telefono_maestro, email_maestro, estatus_maestro) VALUES(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE maestros SET nombre_maestro=?, direccion_maestro=?, telefono_maestro=?, email_maestro=?, estatus_maestro=? WHERE codigo_maestro = ?";
    private static final String SQL_DELETE = "DELETE FROM maestros WHERE codigo_maestro=?";
    private static final String SQL_QUERY = "SELECT codigo_maestro, nombre_maestro, direccion_maestro, telefono_maestro, email_maestro, estatus_maestro FROM maestros WHERE codigo_maestro = ?";
// La lista tiene adetro la clase 
    public List<Maestro> select() {
        Connection conn = null;
        //stmt statement permite colocar sql query
        PreparedStatement stmt = null;
        //Lo que devolvio la base de datos 
        ResultSet rs = null;
        Maestro maestro = null;
        List<Maestro> maestros = new ArrayList<Maestro>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int carnet_maestro = rs.getInt("codigo_maestro");
                String nombre_maestro = rs.getString("nombre_maestro");
                String telefono_maestro = rs.getString("telefono_maestro");
                String direccion_maestro = rs.getString("direccion_maestro");
                String email_maestro = rs.getString("email_maestro");
                String estatus_maestro = rs.getString("estatus_maestro");
                
                maestro = new Maestro();
                maestro.setCarnet_maestro(carnet_maestro);
                maestro.setNombre_maestro(nombre_maestro);
                maestro.setDireccion_maestro(direccion_maestro);
                maestro.setTelefono_maestro(telefono_maestro);
                maestro.setEmail_maestro(email_maestro);
                maestro.setEstatus_maestro(estatus_maestro);
                // este lo envia a la lista maestros los maestro echos 
                maestros.add(maestro);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return maestros;
    }

    public int insert(Maestro maestro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, maestro.getNombre_maestro());
            stmt.setString(2, maestro.getDireccion_maestro());
            stmt.setString(3, maestro.getTelefono_maestro());
            stmt.setString(4, maestro.getEmail_maestro());
            stmt.setString(5, maestro.getEstatus_maestro());

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

    public int update(Maestro maestro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, maestro.getNombre_maestro());
            stmt.setString(2, maestro.getDireccion_maestro());
            stmt.setString(3, maestro.getTelefono_maestro());
            stmt.setString(4, maestro.getEmail_maestro());
            stmt.setString(5, maestro.getEstatus_maestro());
            stmt.setInt(6, maestro.getCarnet_maestro());
           
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

    public int delete(Maestro maestro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, maestro.getCarnet_maestro());
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
    public Maestro query(Maestro maestro) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Maestro> maestros = new ArrayList<Maestro>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, maestro.getCarnet_maestro());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int carnet_maestro = rs.getInt("codigo_maestro");
                String nombre_maestro = rs.getString("nombre_maestro");
                String telefono_maestro = rs.getString("telefono_maestro");
                String direccion_maestro = rs.getString("direccion_maestro");
                String email_maestro = rs.getString("email_maestro");
                String estatus_maestro = rs.getString("estatus_maestro");
                
                maestro = new Maestro();
                maestro.setCarnet_maestro(carnet_maestro);
                maestro.setNombre_maestro(nombre_maestro);
                maestro.setDireccion_maestro(direccion_maestro);
                maestro.setTelefono_maestro(telefono_maestro);
                maestro.setEmail_maestro(email_maestro);
                maestro.setEstatus_maestro(estatus_maestro);
                
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
         return maestro;
    }
        
}

