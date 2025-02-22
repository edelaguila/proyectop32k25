/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Vendedor;
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
public class VendedorDAO {

    private static final String SQL_SELECT = "SELECT id_vendedor, nombrevendedor, direvendedor FROM vendedor";
    private static final String SQL_INSERT = "INSERT INTO vendedor(nombrevendedor, direvendedor) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE vendedor SET nombrevendedor=?, direvendedor=? WHERE idvendedor = ?";
    private static final String SQL_DELETE = "DELETE FROM vendedor WHERE idvendedor=?";
    private static final String SQL_QUERY = "SELECT id_vendedor, nombrevendedor, direvendedor FROM vendedor WHERE id_vendedor = ?";
//METODO PUBLICO LLAMADO SELECT DEL OBEJETO INTERNO QUE YA EXISTE DE JAVA LLAMADO LIST, Vendedor es su clase
    public List<Vendedor> select() {
        //variantes basicas para conectar a base de datos
        //conectta a base de datos esto abre base de datos
        Connection conn = null;
        //stmt instruccion que permite colocar un comando de sql, update,insert,delete etc
        PreparedStatement stmt = null;
        //lo que devuelve a base de datos y se ingresan a rs
        ResultSet rs = null;
        //Vendedor es la clase y vendedor es el objeto
        Vendedor vendedor = null;
        //estructura se llama lista que es una lista que se llena con objetos
        List<Vendedor> vendedores = new ArrayList<Vendedor>();
        //try control de errores para que se detenga y no se salga  del programa
        try {
            //si no hay error entonces
            //define la apertura de base de datos o sea abre base de datos
            //obtiene info de la base de datos 
            conn = Conexion.getConnection();
            //Statement es igual a sql_Select que es una consulta que se definio arriba, 
            //TRAE TODOS LOS REGISTROS PORQUE NO HAY WHERE POR LO QUE TRAE A TODOS
            stmt = conn.prepareStatement(SQL_SELECT);
            //rs= id vendedor etc. resultado de la busqueda a traves de un select trae todos los registros de la base de datos
            rs = stmt.executeQuery();
            //recorre la variable rs que tiene todos los registros
            while (rs.next()) {
                //mientras hayan registros en rs sigue ejecutando el codigo
                //primera variable local toma de la base de datos y la manda a la variable local
                int id_vendedor = rs.getInt("id_vendedor");
                String nombre = rs.getString("nombrevendedor");
                String direccion = rs.getString("direvendedor");
                //objeto vendedor con minusculas
                //se usa constructor new Vendedor(); sin ningun parametro
                vendedor = new Vendedor();
                //establece que id_vendedor la variable local lo manda al objeto que inicialmente lo trajo de la base de datos
                vendedor.setId_vendedor(id_vendedor);
                vendedor.setNombreVendedor(nombre);
                vendedor.setDireVendedor(direccion);
                //vendedores es la lista, se agregó el objeto a la lista vendedores
                vendedores.add(vendedor);
            }
        //catch igual es para control de errores
        } catch (SQLException ex) {
            //si hay erro imprime a la consola que hubo un error en sistema
            ex.printStackTrace(System.out);
           //si no hubo error cierra
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            //cierra conexion
            Conexion.close(conn);
        }
        //retorna la lista 
        return vendedores;
    }

    public int insert(Vendedor vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, vendedor.getNombreVendedor());
            stmt.setString(2, vendedor.getDireVendedor());


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

    public int update(Vendedor vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, vendedor.getNombreVendedor());
            stmt.setString(2, vendedor.getDireVendedor());
            stmt.setInt(3, vendedor.getId_vendedor());

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

    public int delete(Vendedor vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, vendedor.getId_vendedor());
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
    public Vendedor query(Vendedor vendedor) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Vendedor> vendedores = new ArrayList<Vendedor>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, vendedor.getId_vendedor());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_vendedor = rs.getInt("id_vendedor");
                String nombre = rs.getString("nombrevendedor");
                String direccion = rs.getString("direvendedor");
                
                vendedor = new Vendedor();
                vendedor.setId_vendedor(id_vendedor);
                vendedor.setNombreVendedor(nombre);
                vendedor.setDireVendedor(direccion);
                
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
        return vendedor;
    }
        
}
