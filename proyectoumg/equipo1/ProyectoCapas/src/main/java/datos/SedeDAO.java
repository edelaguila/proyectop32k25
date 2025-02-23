/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Sede;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SedeDAO {

    private static final String SQL_SELECT = "SELECT codigo_sede, nombre_sede, estatus_sede FROM sedes";
    private static final String SQL_INSERT = "INSERT INTO sedes(nombre_sede, estatus_sede) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE sedes SET nombre_sede=?, estatus_sede=? WHERE codigo_sede=?";
    private static final String SQL_DELETE = "DELETE FROM sedes WHERE codigo_sede=?";
    private static final String SQL_QUERY = "SELECT codigo_sede, nombre_sede, estatus_sede FROM sedes WHERE codigo_sede=?";

    public List<Sede> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Sede> sedes = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo_sede = rs.getInt("codigo_sede");
                String nombre_sede = rs.getString("nombre_sede");
                String estatus_sede = rs.getString("estatus_sede");

                Sede sede = new Sede(codigo_sede, nombre_sede, estatus_sede);
                sedes.add(sede);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return sedes;
    }

    public int insert(Sede sede) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, sede.getNombre_sede());
            stmt.setString(2, sede.getEstatus_sede());

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

    public int update(Sede sede) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, sede.getNombre_sede());
            stmt.setString(2, sede.getEstatus_sede());
            stmt.setInt(3, sede.getCodigo_sede());

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

    public int delete(Sede sede) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, sede.getCodigo_sede());
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

    public Sede query(Sede sede) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, sede.getCodigo_sede());
            rs = stmt.executeQuery();
            if (rs.next()) {
                sede.setCodigo_sede(rs.getInt("codigo_sede"));
                sede.setNombre_sede(rs.getString("nombre_sede"));
                sede.setEstatus_sede(rs.getString("estatus_sede"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return sede;
    }
}


