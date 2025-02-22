/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Seccion;
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
public class SeccionDAO {
    private static final String SQL_SELECT = "SELECT codigo_seccion, nombre_seccion, estatus_seccion FROM secciones";
    private static final String SQL_INSERT = "INSERT INTO secciones(nombre_seccion, estatus_seccion) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE secciones SET nombre_seccion=?, estatus_seccion=? WHERE codigo_seccion=?";
    private static final String SQL_DELETE = "DELETE FROM secciones WHERE codigo_seccion=?";
    private static final String SQL_QUERY = "SELECT codigo_seccion, nombre_seccion, estatus_seccion FROM secciones WHERE codigo_seccion=?";

    public List<Seccion> select() {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Seccion seccion = null;
        List<Seccion> secciones = new ArrayList<Seccion>(); 
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigoSeccion = rs.getInt("codigo_seccion");
                String nombreSeccion = rs.getString("nombre_seccion");
                String estatusSeccion = rs.getString("estatus_seccion");
                
                seccion = new Seccion();

                seccion.setCodigoSeccion(codigoSeccion);
                seccion.setNombreSeccion(nombreSeccion);
                seccion.setEstatusSeccion(estatusSeccion);
                
                secciones.add(seccion);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return secciones;
    }

    public int insert(Seccion seccion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, seccion.getNombreSeccion());
            stmt.setString(2, seccion.getEstatusSeccion());
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

    public int update(Seccion seccion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, seccion.getNombreSeccion());
            stmt.setString(2, seccion.getEstatusSeccion());
            stmt.setInt(3, seccion.getCodigoSeccion());
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

    public int delete(Seccion seccion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, seccion.getCodigoSeccion());
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

    public Seccion query(Seccion seccion) { 
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Seccion> secciones = new ArrayList<Seccion>();
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, seccion.getCodigoSeccion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigoSeccion = rs.getInt("codigo_seccion");
                String nombreSeccion = rs.getString("nombre_seccion");
                String estatusSeccion = rs.getString("estatus_seccion");
                
                seccion = new Seccion();

                seccion.setCodigoSeccion(codigoSeccion);
                seccion.setNombreSeccion(nombreSeccion);
                seccion.setEstatusSeccion(estatusSeccion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return seccion;
    }
        
}
