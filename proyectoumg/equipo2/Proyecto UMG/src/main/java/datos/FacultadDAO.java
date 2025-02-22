/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Facultad; 
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
public class FacultadDAO {

    private static final String SQL_SELECT = "SELECT codigo_facultad, nombre_facultad, estatus_facultad FROM facultades";
    private static final String SQL_INSERT = "INSERT INTO facultades(nombre_facultad, estatus_facultad) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE facultades SET nombre_facultad=?, estatus_facultad=? WHERE codigo_facultad = ?"; //comodines son los =?
    private static final String SQL_DELETE = "DELETE FROM facultades WHERE codigo_facultad=?";
    private static final String SQL_QUERY = "SELECT codigo_facultad, nombre_facultad, estatus_facultad FROM facultades WHERE codigo_facultad = ?";

    public List<Facultad> select() { //primer mantenimiento, va a consultar
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Facultad facultad = null; //vendedor = alumno, Vendedor = Alumno
        List<Facultad> facultades = new ArrayList<Facultad>(); //vendedores = alumnos

        try { //try es un if, permite condicionar y captar un error
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigoFacultad = rs.getInt("codigo_facultad");
                String nombreFacultad = rs.getString("nombre_facultad");
                String estatusFacultad = rs.getString("estatus_facultad");
                
                facultad = new Facultad();
                facultad.setCodigo_facultad(codigoFacultad);
                facultad.setNombre_facultad(nombreFacultad);
                facultad.setEstatus_facultad(estatusFacultad);
                
                facultades.add(facultad);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return facultades;
    }

    public int insert(Facultad facultad) { //segundo metodo, permite establecer informacion
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            //stmt.setString(1, alumno.getCarnet_alumno());
            stmt.setString(1, facultad.getNombre_facultad());
            stmt.setString(2, facultad.getEstatus_facultad());

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

    public int update(Facultad facultad) { //tercer mantenimiento, actualiza
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, facultad.getNombre_facultad());
            stmt.setString(2, facultad.getEstatus_facultad());
            stmt.setInt(3, facultad.getCodigo_facultad());
            
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

    public int delete(Facultad facultad) {//cuarto metodo, borra
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, facultad.getCodigo_facultad());
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
    public Facultad query(Facultad facultad) {    //Select enfocado
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Facultad> facultades = new ArrayList<Facultad>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, facultad.getCodigo_facultad());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigoFacultad = rs.getInt("codigo_facultad");
                String nombreFacultad = rs.getString("nombre_facultad");
                String estatusFacultad = rs.getString("estatus_facultad");
                
                facultad = new Facultad();
                facultad.setCodigo_facultad(codigoFacultad);
                facultad.setNombre_facultad(nombreFacultad);
                facultad.setEstatus_facultad(estatusFacultad);
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
        return facultad; //retorna el objeto unico
    }
        
}
