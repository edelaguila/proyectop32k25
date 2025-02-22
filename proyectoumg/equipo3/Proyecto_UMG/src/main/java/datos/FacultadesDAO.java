/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Facultades;
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
public class FacultadesDAO {
// el ? ño utiliza java para poder trasladarle informacion a una base de datos desde java
   private static final String SQL_SELECT = "SELECT codigo_facultad, nombre_facultad,estatus_facultad FROM facultades";
    private static final String SQL_INSERT = "INSERT INTO facultades( nombre_facultad,estatus_facultad ) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE facultades SET nombre_facultad=?, estatus_facultad=?WHERE codigo_facultad = ?";
    private static final String SQL_DELETE = "DELETE FROM facultades WHERE codigo_facultad=?";
    private static final String SQL_QUERY = "SELECT codigo_facultad, nombre_facultad, estatus_facultad  FROM facultades WHERE codigo_facultad = ?";  
 //-------------------------------------------------------------------------------
    //SELECT
    public List<Facultades> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        //inicializacion del objeto
        Facultades facultades = null;
       //trae todo los registros de la tabla y los coloca en la lista
        List<Facultades> facultades_list = new ArrayList<Facultades>();
//condicional sobre algun error try y catch
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
    //llenamos   de registros nuestra lista       
            while (rs.next()) {
        //variables temporales para guardar los registros de la base de datos
                int codigo_facultad = rs.getInt("codigo_facultad");
                String nombre_facultad = rs.getString("nombre_facultad");
                String estatus_facultad = rs.getString("estatus_facultad");
                
        //llenamos los atributos de los objetos colocando los datos que hay en las temporales
                facultades = new Facultades();
                facultades.setCodigoFacultad(codigo_facultad);
                facultades.setNombreFacultad(nombre_facultad);
                facultades.setEstatusFacultadString(estatus_facultad);
               //añadimos a la lista todos los registros o el objeto 
                facultades_list.add(facultades);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
//retornamos la lista de todos los alumnos que hay en la base de datos
        return facultades_list;
    }
//-------------------------------------------------------------------------------
    //INSERT
    public int insert(Facultades facultades) {
   //abrimos la conexion
        Connection conn = null;
        PreparedStatement stmt = null;
   //
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
           //Extraemos la informacion de java a la base de datos
           // llenamos los comodines declarados en SQL_insert
           stmt.setString(1, facultades.getNombreFacultad());
            stmt.setString(2, facultades.getEstatusFacultadString());
            
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
    //imprime en consola cuantas rows o filas fueron agregadas        
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
//retorna la cantidad de filas
        return rows;
    }
//-------------------------------------------------------------------------------
    //UPDATE
    public int update(Facultades facultades) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
       //imprimimos en la consola que haremos un update     
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            //comodines de java , colocaremos datos de java dentro la base de datos
            stmt.setString(1, facultades.getNombreFacultad());
            stmt.setString(2, facultades.getEstatusFacultadString());
           //comodin del where
            stmt.setInt(3,facultades.getCodigoFacultad());
//ejecucion del stmt
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
//-------------------------------------------------------------------------------
    //DELETE
    public int delete(Facultades facultades) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
        //toma el comodin (numero de carnet) y ejecuta  el SQL_DELETE 
            stmt.setInt(1, facultades.getCodigoFacultad());
            rows = stmt.executeUpdate();
        //en consola dira cuantos registros seran eliminados
            System.out.println("Registros eliminados:" + rows);
        
        } 
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } 
        finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    //-------------------------------------------------------------------------------
    //QUERY
//TRAE LA INFORMACION ESPESIFICA DE UN REGISTRO USANDO UN SELEC Y WHERE
    public Facultades query(Facultades facultades) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
   //TODA LA INFORMACION LA AGREGAMOS A UNA LIST   
        List<Facultades> facultades_list = new ArrayList<Facultades>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
  //Traemos el comodin del Where para consultar la base de datos          
            stmt.setInt(1, facultades.getCodigoFacultad());
        //ejecuta la SQL_QUERY   
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                //variables temporales para guardar los registros de la base de datos
                int codigo_facultad = rs.getInt("codigo_facultad");
                String nombre_facultad = rs.getString("nombre_facultad");
                String estatus_facultad = rs.getString("estatus_facultad");
                
        //llenamos los atributos de los objetos colocando los datos que hay en las temporales
                facultades = new Facultades();
                facultades.setCodigoFacultad(codigo_facultad);
                facultades.setNombreFacultad(nombre_facultad);
                facultades.setEstatusFacultadString(estatus_facultad);
               //añadimos a la lista todos los registros o el objeto 
                facultades_list.add(facultades);
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return el objeto unico;  // Si se utiliza un ArrayList
        return facultades;
    }
        
}
