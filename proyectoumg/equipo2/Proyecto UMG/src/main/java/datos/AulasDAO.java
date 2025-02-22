/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Aulas;
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
public class AulasDAO {

    private static final String SQL_SELECT = "SELECT codigo_aula, nombre_aula, estatus_aula FROM aulas";
    private static final String SQL_INSERT = "INSERT INTO aulas(nombre_aula, estatus_aula) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE aulas SET nombre_aula=?, estatus_aula=? WHERE codigo_aula = ?";
    private static final String SQL_DELETE = "DELETE FROM aulas WHERE codigo_aula =?";
    private static final String SQL_QUERY = "SELECT codigo_aula, nombre_aula, estatus_aula FROM aulas WHERE codigo_aula = ?";

    public List<Aulas> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Aulas aula = null;
        List<Aulas> aulas = new ArrayList<Aulas>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigoAula = rs.getInt("codigo_aula");
                String nombreAula = rs.getString("nombre_aula");
                String estatusAula = rs.getString("estatus_aula");
              
                
                aula = new Aulas ();
                aula.setCodigoAula(codigoAula);
                aula.setNombreAula(nombreAula);
                aula. setEstatusAula(estatusAula);
          
                
                aulas.add(aula);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return aulas;
    }

    public int insert(Aulas aula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, aula.getNombreAula());
            stmt.setString(2, aula.getEstatusAula());
        
    


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

    public int update(Aulas aula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
             stmt.setString(1, aula.getNombreAula());
            stmt.setString(2, aula.getEstatusAula());
    
        

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

    public int delete(Aulas aula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, aula.getCodigoAula());
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

//    public List<Persona> query(Persona aula) { // Si se utiliza un ArrayList
    public Aulas query(Aulas aula) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aulas> aulas = new ArrayList<Aulas>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, aula.getCodigoAula());
            rs = stmt.executeQuery();
            while (rs.next()) {
                  int codigoAulas = rs.getInt("codigo_aula");
                String nombreAulas = rs.getString("nombre_aula");
                String estatusAulas = rs.getString("estatus_aula");
            
   
                
                aula = new Aulas();
                aula.setCodigoAula(codigoAulas);
                aula.setNombreAula(nombreAulas);
                aula. setEstatusAula(estatusAulas);
     
                
                //aulaes.add(aula); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + aula);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return aulaes;  // Si se utiliza un ArrayList
        return aula;
    }
        
}
