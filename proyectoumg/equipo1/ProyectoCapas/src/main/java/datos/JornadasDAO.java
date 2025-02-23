/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Jornadas;
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
public class JornadasDAO {

    private static final String SQL_SELECT = "SELECT codigo_jornada, nombre_jornada, estatus_jornada FROM jornadas";
    private static final String SQL_INSERT = "INSERT INTO jornadas(nombre_jornada, estatus_jornada) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE jornadas SET  nombre_jornada=?, estatus_jornada=? WHERE codigo_jornada = ?";
    private static final String SQL_DELETE = "DELETE FROM jornadas WHERE codigo_jornada=?";
    private static final String SQL_QUERY = "SELECT codigo_jornada, nombre_jornada, estatus_jornada FROM secciones WHERE codigo_jornada = ?";

    public List<Jornadas> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Jornadas jornadas = null;
        List<Jornadas> list_jornadas = new ArrayList<Jornadas>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo_jornada = rs.getInt("codigo_jornada");
                String nombre_jornada = rs.getString("nombre_jornada");
                String estatus_jornada = rs.getString("estatus_jornada");
                
                jornadas = new Jornadas();
                jornadas.setCodigo_jornada(codigo_jornada);
                jornadas.setNombre_jornada(nombre_jornada);
                jornadas.setEstatus_jornada(estatus_jornada);
              
                
                list_jornadas.add(jornadas);
              //vendedores
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return list_jornadas;
    }

    public int insert(Jornadas jornadas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, jornadas.getNombre_jornada());
            stmt.setString(2, jornadas.getEstatus_jornada());
         


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

    public int update(Jornadas jornadas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, jornadas.getNombre_jornada());
            stmt.setString(2, jornadas.getEstatus_jornada());
            //comodin del where
            stmt.setInt(3,jornadas.getCodigo_jornada());
           

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

    public int delete(Jornadas jornadas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, jornadas.getCodigo_jornada());
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
    public Jornadas query(Jornadas jornadas) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Jornadas> list_Jornadas = new ArrayList<Jornadas>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, jornadas.getCodigo_jornada());
            rs = stmt.executeQuery();
            while (rs.next()) {
             int codigo_jornada = rs.getInt("codigo_jornada");
                String nombre_jornada = rs.getString("nombre_jornada");
                String estatus_jornada = rs.getString("estatus_jornada");
                
                jornadas = new Jornadas();
                jornadas.setCodigo_jornada(codigo_jornada);
                jornadas.setNombre_jornada(nombre_jornada);
                jornadas.setEstatus_jornada(estatus_jornada);
              
              
                
               
                
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
        return jornadas;
    }
        
}