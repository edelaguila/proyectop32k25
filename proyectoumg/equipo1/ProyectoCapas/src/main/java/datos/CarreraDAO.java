/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Carrera;
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
public class CarreraDAO {

    private static final String SQL_SELECT = "SELECT codigo_carrera, nombre_carrera, codigo_facultad, estatus_carrera FROM carreras ";
    private static final String SQL_INSERT = "INSERT INTO carreras(nombre_carrera, codigo_facultad, estatus_carrera) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE carreras SET nombre_carrera=?, codigo_facultad=?, estatus_carrera=? WHERE codigo_carrera = ?";
    private static final String SQL_DELETE = "DELETE FROM carreras WHERE codigo_carrera=?";
    private static final String SQL_QUERY = "SELECT  codigo_carrera, nombre_carrera, codigo_facultad, estatus_carrera FROM carreras WHERE codigo_carrera = ?";
// La lista tiene adetro la clase 
    public List<Carrera> select() {
        Connection conn = null;
        //stmt statement permite colocar sql query
        PreparedStatement stmt = null;
        //Lo que devolvio la base de datos 
        ResultSet rs = null;
        Carrera carrera = null;
        List<Carrera> carreras = new ArrayList<Carrera>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo_carrera = rs.getInt("codigo_carrera");
                String nombre_carrera = rs.getString("nombre_carrera");
                int codigo_facultad = rs.getInt("codigo_facultad");
                String estatus_carrera = rs.getString("estatus_carrera");
                
                carrera = new Carrera();
                carrera.setCodigo_carrera(codigo_carrera);
                carrera.setNombre_carrera(nombre_carrera);
                carrera.setCodigo_facultad(codigo_facultad);
                carrera.setEstatus_carrera(estatus_carrera);
                // este lo envia a la lista alumnos los alumno echos 
                carreras.add(carrera);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return carreras;
    }

   public int insert(Carrera carrera) {
    Connection conn = null;
    PreparedStatement stmt = null;
    int rows = 0;
    try {
        conn = Conexion.getConnection();
        stmt = conn.prepareStatement(SQL_INSERT);
        stmt.setString(1, carrera.getNombre_carrera());
        stmt.setInt(2, carrera.getCodigo_facultad());
        stmt.setString(3, carrera.getEstatus_carrera());

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

    public int update(Carrera carrera) {
    Connection conn = null;
    PreparedStatement stmt = null;
    int rows = 0;

    try {
        conn = Conexion.getConnection();
        System.out.println("ejecutando query: " + SQL_UPDATE);
        stmt = conn.prepareStatement(SQL_UPDATE);
        stmt.setString(1, carrera.getNombre_carrera());
        stmt.setInt(2, carrera.getCodigo_facultad());
        stmt.setString(3, carrera.getEstatus_carrera());
        stmt.setInt(4, carrera.getCodigo_carrera()); 

        rows = stmt.executeUpdate();
        System.out.println("Registros actualizados:" + rows);
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        Conexion.close(stmt);
        Conexion.close(conn);
    }

    return rows;
}

    public int delete(Carrera carrera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, carrera.getCodigo_carrera());
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
    public Carrera query(Carrera carrera) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Carrera> carreras = new ArrayList<Carrera>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, carrera.getCodigo_carrera());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo_carrera = rs.getInt("codigo_carrera");
                String nombre_carrera = rs.getString("nombre_carrera");
                int codigo_facultad = rs.getInt("codigo_facultad");
                String estatus_carrera = rs.getString("estatus_carrera");
                
                carrera = new Carrera();
                carrera.setCodigo_carrera(codigo_carrera);
                carrera.setNombre_carrera(nombre_carrera);
                carrera.setCodigo_facultad(codigo_facultad);
                carrera.setEstatus_carrera(estatus_carrera);
                
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
         return carrera;
    }
        
}

