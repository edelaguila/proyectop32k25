/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Declaracion del paquete Modelo.seguridad
package Modelo.seguridad;

//Importando archivos a utilizar
import Controlador.seguridad.Relusuapl; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import Modelo.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */

//Declaracion de la clase relacion usuario aplicacion
public class RelusuaplDAO {
                        //Modificacion de fecha en RelusuaplDAO Hecho por Kathia Contreras
    
    // Consultas SQL para operaciones CRUD en la tabla relusuapl
    private static final String SQL_SELECT = "SELECT id_relusuapl, id_aplicacion, id_usuario, der_insertar, der_editar, der_eliminar, der_imprimir, fecha FROM relusuapl";
    private static final String SQL_INSERT = "INSERT INTO relusuapl(id_relusuapl, id_aplicacion, id_usuario, der_insertar, der_editar, der_eliminar, der_imprimir,fecha) VALUES(?, ?, ?, ?, ?, ?, ?,?)";
    private static final String SQL_UPDATE = "UPDATE relusuapl SET id_aplicacion=?, id_usuario=?, der_insertar=?, der_editar=?, der_eliminar=?, der_imprimir=?, fecha =? WHERE id_relusuapl = ?";
    private static final String SQL_DELETE = "DELETE FROM relusuapl WHERE id_relusuapl=?";
    private static final String SQL_QUERY = "SELECT id_relusuapl, id_aplicacion, id_usuario, der_insertar, der_editar, der_eliminar, der_imprimir, fecha FROM relusuapl WHERE id_relusuapl = ?";
    
    // Se obtiene todas las relaciones usuario aplicacion registradas en la base de datos
    public List<Relusuapl> select() {
        // Objeto para la conexión a la base de datos
        Connection conn = null;
        // Objeto para preparar la sentencia SQL
        PreparedStatement stmt = null;
        // Objeto para almacenar los resultados de la consulta SQL
        ResultSet rs = null;
        Relusuapl relusuapl = null;
        
        // Lista para guardar las relaciones usuario aplicacion
        List<Relusuapl> relusuaples = new ArrayList<Relusuapl>();

        try {
            // Se establece la conexión con la base de datos
            conn = Conexion.getConnection();
            // Preparacion para la consulta SQL
            stmt = conn.prepareStatement(SQL_SELECT);
            // Se ejecuta la consulta y se obtiene el resultado
            rs = stmt.executeQuery();
            
            // Se recorre el ResultSet obtenido de la consulta a la base de datos
            while (rs.next()) {
                
                //Se obtienen los valores de las variables
                int idDerechosusuapl = rs.getInt("id_relusuapl");
                int idAplicacion = rs.getInt("id_aplicacion");
                int idUsuario = rs.getInt("id_usuario");
                String derInsertar = rs.getString("der_insertar");
                String derEditar = rs.getString("der_editar");
                String derEliminar = rs.getString("der_eliminar");
                String derImprimir = rs.getString("der_imprimir");
                String fechaRelUsuApl = rs.getString("fecha");
                relusuapl = new Relusuapl();
                relusuapl.setId_relusuapl(idDerechosusuapl);
                relusuapl.setId_aplicacion(idAplicacion);
                relusuapl.setId_usuario(idUsuario);
                relusuapl.setDer_insertar(derInsertar);
                relusuapl.setDer_editar(derEditar);
                relusuapl.setDer_eliminar(derEliminar);
                relusuapl.setDer_imprimir(derImprimir);
                relusuapl.setFecha_relusuapl(fechaRelUsuApl);
                
                // Se agrega el objeto a la lista de relacion usuario aplicacion (métodos de pago)
                relusuaples.add(relusuapl);
            }
        // Si ocurre una excepción SQL, se imprime la traza del error
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
             // Se cierra el ResultSet
            Conexion.close(rs);
            // Se cierra el Statement
            Conexion.close(stmt);
            //Se cierra la conexion con la base de datos
            Conexion.close(conn);
        }
        // Se retorna la lista de las relaciones usuario aplicacion 
        return relusuaples;
    }

    public int insert(Relusuapl relusuapl) { 
        // Objeto para la conexión a la base de datos
        Connection conn = null;
        // Objeto para preparar la sentencia SQL
        PreparedStatement stmt = null;
        // Variable para almacenar la cantidad de filas afectadas
        int rows = 0;
        try {
            // Se establece la conexión a la base de datos
            conn = Conexion.getConnection();
            // Se prepara la sentencia SQL con los valores que serán insertados
            stmt = conn.prepareStatement(SQL_INSERT);
            
            // Se asignan los valores a los parámetros de la sentencia SQL
            stmt.setInt(1, relusuapl.getId_relusuapl());
            stmt.setInt(2, relusuapl.getId_aplicacion());
            stmt.setInt(3, relusuapl.getId_usuario());
            stmt.setString(4, relusuapl.getDer_insertar());
            stmt.setString(5, relusuapl.getDer_editar());
            stmt.setString(6, relusuapl.getDer_eliminar());
            stmt.setString(7, relusuapl.getDer_imprimir());
            stmt.setString(8, relusuapl.getFecha_relusuapl());
            System.out.println("ejecutando query: " + SQL_INSERT);
            // Se ejecuta la sentencia, obteniendo la cantidad de filas insertadas
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        } catch (SQLException ex) {
            // Se imprime cualquier excepción para que ocurra durante el proceso
            ex.printStackTrace(System.out);
        } finally {
            // Se cierran los recursos 
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        // Se retorna el número de filas afectadas por la operación
        return rows;
    }
    //Método para actualizar registros
    public int update(Relusuapl relusuapl) {
        // Objeto para la conexión a la base de datos
        Connection conn = null;
        // Objeto para preparar la sentencia SQL
        PreparedStatement stmt = null;
        // Variable para almacenar el número de filas afectadas
        int rows = 0;

        try {
            // Se establece la conexión con la base de datos
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            // Se prepara la sentencia SQL para la inserción de datos
            stmt = conn.prepareStatement(SQL_UPDATE);
            // Se asignan los valores a resulapl
            stmt.setInt(1, relusuapl.getId_aplicacion());
            stmt.setInt(2, relusuapl.getId_usuario());
            stmt.setString(3, relusuapl.getDer_insertar());
            stmt.setString(4, relusuapl.getDer_editar());
            stmt.setString(5, relusuapl.getDer_eliminar());
            stmt.setString(6, relusuapl.getDer_imprimir());
            stmt.setString(7, relusuapl.getFecha_relusuapl());
            // Se ejecuta la consulta de inserción y se guarda la cantidad de las filas afectadas
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado: " + rows);

        } catch (SQLException ex) {
            // En caso de error, se imprime el stack trace para debugging
            ex.printStackTrace(System.out);
        } finally {
            // Se cierra el Statement
            Conexion.close(stmt);
            //Se cierra la conexion con la base de datos
            Conexion.close(conn);
        }
        //Retorno del numero de filas insertadas
        return rows;
    }
    //Metodo para borrar registros
    public int delete(Relusuapl relusuapl) {
        // Objeto para la conexión a la base de datos
        Connection conn = null;
        // Objeto para preparar la sentencia SQL
        PreparedStatement stmt = null;
        // Variable para almacenar la cantidad de filas afectadas
        int rows = 0;

        try {
            // Se establece la conexión con la base de datos
            conn = Conexion.getConnection();
             // Se prepara la sentencia SQL para eliminar un registro
            System.out.println("Ejecutando query: " + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            // Se establece el número de relacion usuario aplicacion
            stmt.setInt(1, relusuapl.getId_relusuapl());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados: " + rows);
        // Se imprime cualquier error que ocurra durante la ejecución    
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            // Se cierran los recursos utilizados
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        // Se retorna la cantidad de filas afectadas
        return rows;
    }
    
    //Metodo para realizar una consulta
    public Relusuapl query(Relusuapl relusuapl) {    
        // Objeto para la conexión a la base de datos
        Connection conn = null;
        // Objeto para preparar la sentencia SQL
        PreparedStatement stmt = null;
        // Objeto para almacenar los resultados de la consulta SQL
        ResultSet rs = null;
        
        // Lista para almacenar los datos obtenidos
        List<Relusuapl> relusuaples = new ArrayList<Relusuapl>();
        int rows = 0;

        try {
            // Se establece la conexión con la base de datos
            conn = Conexion.getConnection();
            // Se prepara la sentencia SQL utilizando el número de relaciones usuario aplicacion
            System.out.println("Ejecutando query: " + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, relusuapl.getId_relusuapl());
            // Se ejecuta la consulta
            rs = stmt.executeQuery();
            while (rs.next()) {
                // Se extraen  datos de cada columna
                int idDerechosusuapl = rs.getInt("id_relusuapl");
                int idAplicacion = rs.getInt("id_aplicacion");
                int idUsuario = rs.getInt("id_usuario");
                String derInsertar = rs.getString("der_insertar");
                String derEditar = rs.getString("der_editar");
                String derEliminar = rs.getString("der_eliminar");
                String derImprimir = rs.getString("der_imprimir");
                String fechaRelUsuApl = rs.getString("fecha");
                
                // Se crea un nuevo objeto Relusuapl asignando sus atributos con los valores obtenidos
                relusuapl = new Relusuapl();
                relusuapl.setId_relusuapl(idDerechosusuapl);
                relusuapl.setId_aplicacion(idAplicacion);
                relusuapl.setId_usuario(idUsuario);
                relusuapl.setDer_insertar(derInsertar);
                relusuapl.setDer_editar(derEditar);
                relusuapl.setDer_eliminar(derEliminar);
                relusuapl.setDer_imprimir(derImprimir);
                relusuapl.setFecha_relusuapl(fechaRelUsuApl);
            }
        // Si ocurre un error de SQL, se imprime en consolaistros buscado:" + vendedor);    
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            // Se cierran los recursos
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        //Retorno relacion usuario aplicaciones
        return relusuapl; 
    }
        
}
