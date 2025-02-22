/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Maestro;
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
public class MaestroDAO {
// el ? ño utiliza java para poder trasladarle informacion a una base de datos desde java
   private static final String SQL_SELECT = "SELECT codigo_maestro, nombre_maestro, direccion_maestro, telefono_maetro, email_maestro, estatus_maestro FROM maestros";
    private static final String SQL_INSERT = "INSERT INTO maestros(nombre_maestro, direccion_maestro, telefono_maetro, email_maestro, estatus_maestro ) VALUES(?, ?,  ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE maestros SET nombre_maestro=?, direccion_maestro=?, telefono_maetro=?, email_maestro=?, estatus_maestro=? WHERE codigo_maestro = ?";
    private static final String SQL_DELETE = "DELETE FROM maestros WHERE codigo_maestro=?";
    private static final String SQL_QUERY = "SELECT codigo_maestro, nombre_maestro, direccion_maestro, telefono_maetro, email_maestro, estatus_maestro  FROM maestros WHERE codigo_maestro = ?";  
 //-------------------------------------------------------------------------------
    //SELECT
    public List<Maestro> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        //inicializacion del objeto
        Maestro maestro = null;
       //trae todo los registros de la tabla y los coloca en la lista
        List<Maestro> maestros_list = new ArrayList<Maestro>();
//condicional sobre algun error try y catch
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
    //llenamos   de registros nuestra lista       
            while (rs.next()) {
        //variables temporales para guardar los registros de la base de datos
                int codigo_maestro = rs.getInt("codigo_maestro");
                String nombre_maestro = rs.getString("nombre_maestro");
                String direccion_maestro = rs.getString("direccion_maestro");
                String telefono_maestro  = rs.getString("telefono_maetro");
                String email_maestro = rs.getString("email_maestro");
                String estatus_mestro = rs.getString("estatus_maestro");
                
        //llenamos los atributos de los objetos colocando los datos que hay en las temporales
                maestro = new Maestro();
                maestro.setCodigoMaestro(codigo_maestro);
                maestro.setNombreMaestro(nombre_maestro);
                maestro.setDireMaestro(direccion_maestro);
                maestro.setTelefonoMaestro(telefono_maestro);
                maestro.setEmailMaestro(email_maestro);
                maestro.setEstatusMaestro(estatus_mestro);
               //añadimos a la lista todos los registros o el objeto 
                maestros_list.add(maestro);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
//retornamos la lista de todos los alumnos que hay en la base de datos
        return maestros_list;
    }
//-------------------------------------------------------------------------------
    //INSERT
    public int insert(Maestro maestro) {
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
           stmt.setString(1, maestro.getNombreMaestro());
            stmt.setString(2, maestro.getDireMaestro());
            stmt.setString(3, maestro.getTelefonoMaestro());
            stmt.setString(4, maestro.getEmailMaestro());
            stmt.setString(5, maestro.getEstatusMaestro());


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
    public int update(Maestro maestro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
       //imprimimos en la consola que haremos un update     
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            //comodines de java , colocaremos datos de java dentro la base de datos
            stmt.setString(1, maestro.getNombreMaestro());
            stmt.setString(2, maestro.getDireMaestro());
            stmt.setString(3, maestro.getTelefonoMaestro());
            stmt.setString(4, maestro.getEmailMaestro());
            stmt.setString(5, maestro.getEstatusMaestro());
           //comodin del where
            stmt.setInt(6,maestro.getCodigoMaestro());
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
    public int delete(Maestro maestro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
        //toma el comodin (numero de carnet) y ejecuta  el SQL_DELETE 
            stmt.setInt(1, maestro.getCodigoMaestro());
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
    public Maestro query(Maestro maestro) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
   //TODA LA INFORMACION LA AGREGAMOS A UNA LIST   
        List<Maestro> maestros_list = new ArrayList<Maestro>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
  //Traemos el comodin del Where para consultar la base de datos          
            stmt.setInt(1, maestro.getCodigoMaestro());
        //ejecuta la SQL_QUERY   
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                //variables temporales para guardar los registros de la base de datos
                int codigo_maestro = rs.getInt("codigo_maestro");
                String nombre_maestro = rs.getString("nombre_maestro");
                String direccion_maestro = rs.getString("direccion_maestro");
                String telefono_maestro  = rs.getString("telefono_maetro");
                String email_maestro = rs.getString("email_maestro");
                String estatus_mestro = rs.getString("estatus_maestro");
                
        //llenamos los atributos de los objetos colocando los datos que hay en las temporales
                maestro = new Maestro();
                maestro.setCodigoMaestro(codigo_maestro);
                maestro.setNombreMaestro(nombre_maestro);
                maestro.setDireMaestro(direccion_maestro);
                maestro.setTelefonoMaestro(telefono_maestro);
                maestro.setEmailMaestro(email_maestro);
                maestro.setEstatusMaestro(estatus_mestro);
               //añadimos a la lista todos los registros o el objeto 
                maestros_list.add(maestro);
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
        return maestro;
    }
        
}
