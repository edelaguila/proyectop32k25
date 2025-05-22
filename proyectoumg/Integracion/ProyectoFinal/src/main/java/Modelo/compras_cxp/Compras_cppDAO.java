/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//declaracion del paquete modelo.compras
package Modelo.compras_cxp;

//Importaciones de archivos que se utilizaran
import Controlador.compras_cxp.*;
import Controlador.compras_cxp.Compra_cpp;
import Modelo.Conexion;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

//Declaracion de la clase compras_cppDAO
public class Compras_cppDAO {

    // Consultas SQL para operaciones CRUD en la tabla compra_cpp
    private static final String SQL_SELECT = "SELECT no_compra, nombre_usuario, apellido_usuario, id_proveedor, producto, cantidad, precio, saldo_anterior, plazo, total   FROM compra_cpp";
    private static final String SQL_INSERT = "INSERT INTO compra_cpp (no_compra, nombre_usuario, apellido_usuario, id_proveedor, producto, cantidad, precio, saldo_anterior, plazo, total) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE compra_cpp SET nombre_usuario=?, apellido_usuario=?, id_proveedor=?, producto=?, cantidad=?, precio=?, saldo_anterior=?, plazo=?, total=? WHERE no_compra=? ";
    private static final String SQL_DELETE = "DELETE FROM compra_cpp WHERE no_compra=?";
    private static final String SQL_QUERY = "SELECT no_compra, nombre_usuario, apellido_usuario, id_proveedor, producto, cantidad, precio, saldo_anterior, plazo, total FROM compra_cpp WHERE no_compra=?";
    
    // Se obtiene todas las compras registradas en la base de datos
    public List<Compra_cpp> select() {
        // Objeto para la conexión a la base de datos
        Connection conn = null;
        // Objeto para preparar la sentencia SQL
        PreparedStatement stmt = null;
        // Objeto para almacenar los resultados de la consulta SQL
        ResultSet rs = null;
        // Lista para guardar los datos de compras
        List<Compra_cpp> list_compra_cpp = new ArrayList<>();

        try {
            // Se establece la conexión con la base de datos
            conn = Conexion.getConnection();
            // Preparacion para la consulta SQL
            stmt = conn.prepareStatement(SQL_SELECT);
            // Se ejecuta la consulta y se obtiene el resultado
            rs = stmt.executeQuery();
            
            // Se recorre el ResultSet obtenido de la consulta a la base de datos
            while (rs.next()) {
                
                //// Se crea un nuevo objeto Compra_cpp por cada registro en el ResultSet
                Compra_cpp compra_cpp = new Compra_cpp();
                // Número de compra
                compra_cpp.setNo_compra(rs.getInt("no_compra"));       
                // Nombre del usuario
                compra_cpp.setNombre_usuario(rs.getString("nombre_usuario")); 
                // Apellido del usuario
                compra_cpp.setApellido_usuario(rs.getString("apellido_usuario")); 
                 // ID del proveedor
                compra_cpp.setId_proveedor(rs.getInt("id_proveedor"));
                 // Producto comprado
                compra_cpp.setProducto(rs.getString("producto"));
                 // Cantidad adquirida
                compra_cpp.setCantidad(rs.getInt("cantidad")); 
                // Precio unitario
                compra_cpp.setPrecio(rs.getInt("precio"));             
                // Saldo anterior del proveedor
                compra_cpp.setSaldo_anterior(rs.getInt("saldo_anterior"));
                // Plazo para el pago
                compra_cpp.setPlazo(rs.getInt("plazo"));    
                // Total de la compra// Plazo para el pago
                compra_cpp.setTotal(rs.getInt("total"));                      
                
                // Se añade el objeto Compra_cpp a la lista de compras
                list_compra_cpp.add(compra_cpp);
            }

        } catch (SQLException ex) {
            // En caso de ocurrir una excepción SQL, se imprime e   l error en la salida estándar
            ex.printStackTrace(System.out);
        } finally {
            // Se cierra el ResultSet
            Conexion.close(rs);
            // Se cierra el Statement
            Conexion.close(stmt);
            //Se cierra la conexion con la base de datos
            Conexion.close(conn);
        }
        // Se retorna la lista con los objetos de compras
        return list_compra_cpp;
    }
    
    //Metodo para insertar compras
    public int insert(Compra_cpp compra_cpp) {
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
            stmt.setInt(1, compra_cpp.getNo_compra());
            stmt.setString(2, compra_cpp.getNombre_usuario());
            stmt.setString(3, compra_cpp.getApellido_usuario());
            stmt.setInt(4, compra_cpp.getId_proveedor());
            stmt.setString(5, compra_cpp.getProducto());
            stmt.setInt(6, compra_cpp.getCantidad());
            stmt.setInt(7, compra_cpp.getPrecio());
            stmt.setInt(8, compra_cpp.getSaldo_anterior());
            stmt.setInt(9, compra_cpp.getPlazo());
            stmt.setInt(10, compra_cpp.getTotal());

        // Se ejecuta la sentencia, obteniendo la cantidad de filas insertadas
        rows = stmt.executeUpdate();
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
    public int update(Compra_cpp compra_cpp) {
        // Objeto para la conexión a la base de datos
        Connection conn = null;
        // Objeto para preparar la sentencia SQL
        PreparedStatement stmt = null;
        // Variable para almacenar el número de filas afectadas
        int rows = 0;

        try {
            // Se establece la conexión con la base de datos
            conn = Conexion.getConnection();
            // Se prepara la sentencia SQL para la inserción de datos
            stmt = conn.prepareStatement(SQL_UPDATE);
            // Se asignan los valores a compra_cpp
            stmt.setInt(1, compra_cpp.getNo_compra());
            stmt.setString(2, compra_cpp.getNombre_usuario());
            stmt.setString(3, compra_cpp.getApellido_usuario());
            stmt.setInt(4, compra_cpp.getId_proveedor());
            stmt.setString(5, compra_cpp.getProducto());
            stmt.setInt(6, compra_cpp.getCantidad());
            stmt.setInt(7, compra_cpp.getPrecio());
            stmt.setInt(8, compra_cpp.getSaldo_anterior());
            stmt.setInt(9, compra_cpp.getPlazo());
            stmt.setInt(10, compra_cpp.getTotal());
            
             // Se ejecuta la consulta de inserción y se guarda la cantidad de filas afectadas
            rows = stmt.executeUpdate();
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
    public int delete(Compra_cpp compra_cpp) {
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
            stmt = conn.prepareStatement(SQL_DELETE);
            // Se establece el número de compra como criterio de eliminación
            stmt.setInt(1, compra_cpp.getNo_compra());
            
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            // Se imprime cualquier error que ocurra durante la ejecución
            ex.printStackTrace(System.out);
        } finally {
            // Se cierran los recursos utilizados
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        // Se retorna la cantidad de filas afectadas
        return rows;
    }

    public Compra_cpp query(Compra_cpp compra_cpp) {
        // Objeto para la conexión a la base de datos
        Connection conn = null;
        // Objeto para preparar la sentencia SQL
        PreparedStatement stmt = null;
        // Objeto para almacenar los resultados de la consulta SQL
        ResultSet rs = null;

        try {
        // Se establece la conexión con la base de datos
        conn = Conexion.getConnection();
        // Se prepara la sentencia SQL utilizando el número de compra
        stmt = conn.prepareStatement(SQL_QUERY);
        stmt.setInt(1, compra_cpp.getNo_compra());
         // Se ejecuta la consulta
        rs = stmt.executeQuery();
           
            // Decision si se encuentra una compra con ese número, se rellenan los datos en el objeto compra_cpp
            if (rs.next()) {
                compra_cpp.setNo_compra(rs.getInt("no_compra"));
                compra_cpp.setNombre_usuario(rs.getString("nombre_usuario"));
                compra_cpp.setApellido_usuario(rs.getString("apellido_usuario"));
                compra_cpp.setId_proveedor(rs.getInt("id_proveedor"));
                compra_cpp.setProducto(rs.getString("producto"));
                compra_cpp.setCantidad(rs.getInt("cantidad"));
                compra_cpp.setPrecio(rs.getInt("precio"));
                compra_cpp.setSaldo_anterior(rs.getInt("saldo_anterior"));
                compra_cpp.setPlazo(rs.getInt("plazo"));
                compra_cpp.setTotal(rs.getInt("total"));
                
            }

            
        } catch (SQLException ex) {
            // Si ocurre un error de SQL, se imprime en consola
            ex.printStackTrace(System.out);
        } finally {
            // Se cierran los recursos 
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        // Se devuelve el objeto compra_cpp actualizado
        return compra_cpp;
        
    }
    
    //Metodo para generar e imprimir un reporte
    public void imprimirReporte() {
        //Conexion con la base de datos
        Connection conn = null;
        // Mapa de parámetros que se puede enviar al reporte (aquí está vacío)
        Map p = new HashMap();
        // Objeto que representa el reporte compilado
        JasperReport report;
        // Objeto que representa el reporte ya lleno con los datos
        JasperPrint print;

        try {
            //Conexion con la base de datos
            conn = Conexion.getConnection();
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/main/java/ReporteCompraCPP/"+ "reporte.comprascpp.jrxml");
            //se llena el reporte con los datos obtenidos
            print = JasperFillManager.fillReport(report, p, conn);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("Reporte de Vendedores");
            view.setVisible(true);

        } catch (Exception e) {
            // Si ocurre cualquier error, se imprime la traza del error en consola
            
            e.printStackTrace();
        }
    }
}
