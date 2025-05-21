/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//declaracion del paquete modelo.compras
package Modelo.compras_cxp;

//Importaciones de archivos que se utilizaran
import Controlador.compras_cxp.*;
import Controlador.compras_cxp.Proveedor;
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

//Declaracion de la clase proveedoresDAO
public class ProveedorDAO {
    
    // Consultas SQL para operaciones CRUD en la tabla proveedor
    private static final String SQL_SELECT = "SELECT id_proveedor, nombre_proveedor, direccion_proveedor, telefono_proveedor, email_proveedor, saldo_proveedor, estatus_proveedor, fecha_registro, plazo_limite   FROM proveedor";
    private static final String SQL_INSERT = "INSERT INTO proveedor (id_proveedor, nombre_proveedor, direccion_proveedor, telefono_proveedor, email_proveedor, saldo_proveedor, estatus_proveedor, fecha_registro, plazo_limite) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE proveedor SET nombre_proveedor=?, direccion_proveedor=?, telefono_proveedor=?, email_proveedor=?, saldo_proveedor=?, estatus_proveedor=?, fecha_registro=?, plazo_limite=? WHERE id_proveedor=? ";
    private static final String SQL_DELETE = "DELETE FROM proveedor WHERE id_proveedor=?";
    private static final String SQL_QUERY = "SELECT id_proveedor, nombre_proveedor, direccion_proveedor, telefono_proveedor, email_proveedor, saldo_proveedor, estatus_proveedor, fecha_registro, plazo_limite FROM proveedor WHERE id_proveedor=?";
    
    // Se obtiene todas los proveedores registradas en la base de datos
    public List<Proveedor> select() {
        // Objeto para la conexión a la base de datos
        Connection conn = null;
        // Objeto para preparar la sentencia SQL
        PreparedStatement stmt = null;
        // Objeto para almacenar los resultados de la consulta SQL
        ResultSet rs = null;
        // Lista para guardar los datos de proveedores
        List<Proveedor> list_proveedores = new ArrayList<>();

        try {
            // Se establece la conexión con la base de datos
            conn = Conexion.getConnection();
            // Preparacion para la consulta SQL
            stmt = conn.prepareStatement(SQL_SELECT);
            // Se ejecuta la consulta y se obtiene el resultado
            rs = stmt.executeQuery();
            
            // Se recorre el ResultSet obtenido de la consulta a la base de datos
            while (rs.next()) {
                // Por cada fila del resultado, se crea un nuevo objeto Proveedor
                Proveedor proveedor = new Proveedor();
                // Se establecen los valores de cada columna del ResultSet a los atributos del objeto Proveedor
                proveedor.setId_proveedor(rs.getInt("id_proveedor"));
                proveedor.setNombre_proveedor(rs.getString("nombre_proveedor"));
                proveedor.setDireccion_proveedor(rs.getString("direccion_proveedor"));
                proveedor.setTelefono_proveedor(rs.getString("telefono_proveedor"));
                proveedor.setEmail_proveedor(rs.getString("email_proveedor"));
                proveedor.setSaldo_proveedor(rs.getInt("saldo_proveedor"));
                proveedor.setEstatus_proveedor(rs.getInt("estatus_proveedor"));
                proveedor.setFecha_registro(rs.getString("fecha_registro"));
                proveedor.setPlazo_limite(rs.getInt("plazo_limite"));
                
                 // Se añade el objeto Proveedor a la lista que almacenará todos los proveedores obtenidos
                list_proveedores.add(proveedor);
            }

        } catch (SQLException ex) {
            // Se imprime cualquier excepción para que ocurra durante el proceso
            ex.printStackTrace(System.out);
        } finally {
            // Se cierran los recursos 
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        //Se retorna la lista de proveedores
        return list_proveedores;
    }
    //Metodo para insertar proveedor
    public int insert(Proveedor proveedor) {
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
            stmt.setInt(1, proveedor.getId_proveedor());
            stmt.setString(2, proveedor.getNombre_proveedor());
            stmt.setString(3, proveedor.getDireccion_proveedor());
            stmt.setString(4, proveedor.getTelefono_proveedor());
            stmt.setString(5, proveedor.getEmail_proveedor());
            stmt.setInt(6, proveedor.getSaldo_proveedor());
            stmt.setInt(7, proveedor.getEstatus_proveedor());
            stmt.setString(8, proveedor.getFecha_registro());
            stmt.setInt(9, proveedor.getPlazo_limite());
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
    public int update(Proveedor proveedor) {
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
            
            // Se asignan los valores a proveedores
            stmt.setString(1, proveedor.getNombre_proveedor());
            stmt.setString(2, proveedor.getDireccion_proveedor());
            stmt.setString(3, proveedor.getTelefono_proveedor());
            stmt.setString(4, proveedor.getEmail_proveedor());
            stmt.setInt(5, proveedor.getSaldo_proveedor());
            stmt.setInt(6, proveedor.getEstatus_proveedor());
            stmt.setString(7, proveedor.getFecha_registro());
            stmt.setInt(8, proveedor.getPlazo_limite());         
            stmt.setInt(9, proveedor.getId_proveedor()); 
            
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
    //Metodo para borrar registros de proveedor
    public int delete(Proveedor proveedor) {
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
            // Se establece el número de proveedor 
            stmt.setInt(1, proveedor.getId_proveedor());

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
    
    public Proveedor query(Proveedor proveedor) {
        // Objeto para la conexión a la base de datos
        Connection conn = null;
        // Objeto para preparar la sentencia SQL
        PreparedStatement stmt = null;
        // Objeto para almacenar los resultados de la consulta SQL
        ResultSet rs = null;

        try {
            // Se establece la conexión con la base de datos
            conn = Conexion.getConnection();
            // Se prepara la sentencia SQL utilizando el número de proveedores
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, proveedor.getId_proveedor());
             // Se ejecuta la consulta
            rs = stmt.executeQuery();
            // Si existe un registro con ese ID, se llena el objeto Proveedor con los datos obtenidos
            if (rs.next()) {
                proveedor.setNombre_proveedor(rs.getString("nombre_proveedor"));
                proveedor.setDireccion_proveedor(rs.getString("direccion_proveedor"));
                proveedor.setTelefono_proveedor(rs.getString("telefono_proveedor"));
                proveedor.setEmail_proveedor(rs.getString("email_proveedor"));
                proveedor.setSaldo_proveedor(rs.getInt("saldo_proveedor"));
                proveedor.setEstatus_proveedor(rs.getInt("estatus_proveedor"));
                proveedor.setFecha_registro(rs.getString("fecha_registro"));
                proveedor.setPlazo_limite(rs.getInt("plazo_limite"));
                
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
        //return proveedores;
        return proveedor;
        
    }
     //Metodo para imprimir un raporte
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
                    + "/src/main/java/ReporteProveedores_cxp/"+ "Reporte.Proveedor.jrxml");
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
