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

/**
 *
 * @author visitante
 */
public class SedeDAO {

    private static final String SQL_SELECT = "SELECT codigo_sede, nombre_sede, estatus_sede FROM sedes";
    private static final String SQL_INSERT = "INSERT INTO sedes(nombre_sede, estatus_sede) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE sedes SET nombre_sede=?, estatus_sede=? WHERE codigo_sede = ?"; //comodines son los =?
    private static final String SQL_DELETE = "DELETE FROM sedes WHERE codigo_sede=?";
    private static final String SQL_QUERY = "SELECT codigo_sede, nombre_sede, estatus_sede FROM sedes WHERE codigo_sede = ?";

    public List<Sede> select() { //consultar
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Sede sede = null; //vendedor = alumno, Vendedor = Alumno
        List<Sede> sedes = new ArrayList<Sede>(); //vendedores = alumnos

        try { //permite condicionar y captar un error
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigoSede = rs.getInt("codigo_sede");
                String nombreSede = rs.getString("nombre_sede");
                String estatusSede = rs.getString("estatus_sede");
                
                sede = new Sede();
                sede.setCodigo_sede(codigoSede);
                sede.setNombre_sede(nombreSede);
                sede.setEstatus_sede(estatusSede);
                
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

    public int insert(Sede sede) { //insertar datos
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            //stmt.setString(1, alumno.getCarnet_alumno());
            stmt.setString(1, sede.getNombre_sede());
            stmt.setString(2, sede.getEstatus_sede());

            System.out.println("ejecutando query: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Sede sede) { //actualizar
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, sede.getNombre_sede());
            stmt.setString(2, sede.getEstatus_sede());
            stmt.setInt(3, sede.getCodigo_sede());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado: " + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Sede sede) {//elimina
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_DELETE);
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

//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public Sede query(Sede sede) {    //Select enfocado
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Sede> sedes = new ArrayList<Sede>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, sede.getCodigo_sede());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigoSede = rs.getInt("codigo_sede");
                String nombreSede = rs.getString("nombre_sede");
                String estatusSede = rs.getString("estatus_sede");
                
                sede = new Sede();
                sede.setCodigo_sede(codigoSede);
                sede.setNombre_sede(nombreSede);
                sede.setEstatus_sede(estatusSede);
                //con los set, enviamos los objetos
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
        return sede; //retorna el objeto unico
    }
        
}
