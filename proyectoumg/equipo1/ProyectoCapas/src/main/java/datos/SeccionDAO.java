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

public class SeccionDAO {

    private static final String SQL_SELECT = "SELECT codigo_seccion, nombre_seccion, estatus_seccion FROM secciones";
    private static final String SQL_INSERT = "INSERT INTO secciones(nombre_seccion, estatus_seccion) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE secciones SET nombre_seccion=?, estatus_seccion=? WHERE codigo_seccion=?";
    private static final String SQL_DELETE = "DELETE FROM secciones WHERE codigo_seccion=?";
    private static final String SQL_QUERY = "SELECT codigo_seccion, nombre_seccion, estatus_seccion FROM secciones WHERE codigo_seccion=?";

    public List<Seccion> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Seccion> secciones = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo_seccion = rs.getInt("codigo_seccion");
                String nombre_seccion = rs.getString("nombre_seccion");
                String estatus_seccion = rs.getString("estatus_seccion");

                Seccion seccion = new Seccion(codigo_seccion, nombre_seccion, estatus_seccion);
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
            stmt.setString(1, seccion.getNombre_seccion());
            stmt.setString(2, seccion.getEstatus_seccion());

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

    public int update(Seccion seccion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, seccion.getNombre_seccion());
            stmt.setString(2, seccion.getEstatus_seccion());
            stmt.setInt(3, seccion.getCodigo_seccion());

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

    public int delete(Seccion seccion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, seccion.getCodigo_seccion());
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

    public Seccion query(Seccion seccion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, seccion.getCodigo_seccion());
            rs = stmt.executeQuery();
            if (rs.next()) {
                seccion.setCodigo_seccion(rs.getInt("codigo_seccion"));
                seccion.setNombre_seccion(rs.getString("nombre_seccion"));
                seccion.setEstatus_seccion(rs.getString("estatus_seccion"));
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


