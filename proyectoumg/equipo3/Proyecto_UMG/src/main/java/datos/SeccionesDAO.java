/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Secciones;
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
public class SeccionesDAO {

    private static final String SQL_SELECT = "SELECT codigo_seccion, nombre_seccion, estatus_seccion FROM secciones";
    private static final String SQL_INSERT = "INSERT INTO secciones(nombre_seccion, estatus_seccion) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE secciones SET  nombre_seccion=?, estatus_seccion=? WHERE codigo_seccion = ?";
    private static final String SQL_DELETE = "DELETE FROM secciones WHERE codigo_seccion=?";
    private static final String SQL_QUERY = "SELECT codigo_seccion, nombre_seccion, estatus_seccion FROM secciones WHERE codigo_seccion = ?";

    public List<Secciones> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Secciones secciones = null;
        List<Secciones> list_seccion = new ArrayList<Secciones>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo_seccion = rs.getInt("codigo_seccion");
                String nombre_seccion = rs.getString("nombre_seccion");
                String estatus_seccion = rs.getString("estatus_Seccion");
                
                secciones = new Secciones();
                secciones.setCodigo_seccion(codigo_seccion);
                secciones.setNombre_seccion(nombre_seccion);
                secciones.setEstatus_seccion(estatus_seccion);
              
                
                list_seccion.add(secciones);
              //vendedores
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return list_seccion;
    }

    public int insert(Secciones secciones) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, secciones.getNombre_seccion());
            stmt.setString(2, secciones.getEstatus_seccion());
         


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

    public int update(Secciones secciones) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, secciones.getNombre_seccion());
            stmt.setString(2, secciones.getEstatus_seccion());
            //comodin del where
            stmt.setInt(3,secciones.getCodigo_seccion());
           

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

    public int delete(Secciones secciones) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, secciones.getCodigo_seccion());
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
    public Secciones query(Secciones secciones) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Secciones> list_seccion = new ArrayList<Secciones>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, secciones.getCodigo_seccion());
            rs = stmt.executeQuery();
            while (rs.next()) {
             int codigo_seccion = rs.getInt("codigo_seccion");
                String nombre_seccion = rs.getString("nombre_seccion");
                String estatus_seccion = rs.getString("estatus_Seccion");
                
                secciones = new Secciones();
                secciones.setCodigo_seccion(codigo_seccion);
                secciones.setNombre_seccion(nombre_seccion);
                secciones.setEstatus_seccion(estatus_seccion);
              
                
               
                
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
        return secciones;
    }
        
}