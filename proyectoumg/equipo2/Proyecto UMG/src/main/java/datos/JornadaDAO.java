/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Jornada;
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
public class JornadaDAO {

    private static final String SQL_SELECT = "SELECT codigo_jornada, nombre_jornada, estatus_jornada FROM jornadas";
    private static final String SQL_INSERT = "INSERT INTO jornadas(nombre_jornada, estatus_jornada) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE jornadas SET nombre_jornada=?, estatus_jornada=? WHERE codigo_jornada= ?";
    private static final String SQL_DELETE = "DELETE FROM jornadas WHERE codigo_jornada=?";
    private static final String SQL_QUERY = "SELECT codigo_jornada, nombre_jornada, estatus_jornada FROM jornadas WHERE codigo_jornada = ?";

    //se crea una lista con la clase vendedor adentro
    //lo siguiente son las variables que contiene la base de datos null sirve para inicializar las variables
    public List<Jornada> select() {
        Connection conn = null; //variable que se usa para abrir la base de datos
        PreparedStatement stmt = null; //statement permite colocar un comando de sql
        ResultSet rs = null; //resul set trae información de la base de datps
        Jornada jornada = null;
        List<Jornada> jornadas = new ArrayList<Jornada>();
        
//vendedor con minuscula es de tipo lista que contiene objetos con la forma de los atributos y metodos de la clase Vendedor
        try { //try sirve para manejo de erroes, catch tiene la misma función
            conn = Conexion.getConnection(); // ya que no hay error, abre la base de datos
            stmt = conn.prepareStatement(SQL_SELECT); //prepara la instrucción sql server->consulta definida arriba, esto trae todos los registros
            rs = stmt.executeQuery();//trae lo que buscaba el select y lo almacema en rs
            while (rs.next()) {
//recorremos la variable si existe un siguiente (registro) hasta que termina con todo lo que trajimos de la base de datos
                int codigo_jornada = rs.getInt("codigo_jornada");//se crea la primera variable local del primer registro que se encontro en la base de datos
                String nombre_jornada = rs.getString("nombre_jornada");
                String estatus_jornada = rs.getString("estatus_jornada");
                
                jornada = new Jornada(); //vendedor es objeto y Vendedor es la llamada al cosntructor
                jornada.setCodigo_jornada(codigo_jornada);//trae todo a las variables temporales con las cuales se va a establecer el objeto
                jornada.setNombre_jornada(nombre_jornada);
                jornada.setEstatus_jornada(estatus_jornada);
                
                jornadas.add(jornada);//añadimos todo a la lista que habiamos creado al principo y lo llevamos a la capa vista
            }

        } catch (SQLException ex) {//si hay problema con la base de datos estas funciones evitan que se salga del programa
            //limite de interrupción
            ex.printStackTrace(System.out);
        } finally { //cierra las conexiones con la base de datos ya que si la deja abierta se pone lenta
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return jornadas; //retorna la lista que hicimos
    }

    public int insert(Jornada jornada) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, jornada.getNombre_jornada());
            stmt.setString(2, jornada.getEstatus_jornada());


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

    public int update(Jornada jornada) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, jornada.getNombre_jornada());
            stmt.setString(2, jornada.getEstatus_jornada ());
            stmt.setInt(3, jornada.getCodigo_jornada());

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

    public int delete(Jornada jornada) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, jornada.getCodigo_jornada());
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
    public Jornada query(Jornada jornada) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Jornada> jornadas = new ArrayList<Jornada>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, jornada.getCodigo_jornada());
            rs = stmt.executeQuery();
            while (rs.next()) {       
                int codigo_jornada = rs.getInt("codigo_jornada");//se crea la primera variable local del primer registro que se encontro en la base de datos
                String nombre_jornada = rs.getString("nombre_jornada");
                String estatus_jornada = rs.getString("estatus_jornada");
                
                jornada = new Jornada(); //vendedor es objeto y Vendedor es la llamada al cosntructor
                jornada.setCodigo_jornada(codigo_jornada);//trae todo a las variables temporales con las cuales se va a establecer el objeto
                jornada.setNombre_jornada(nombre_jornada);
                jornada.setEstatus_jornada(estatus_jornada);
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
        return jornada;
    }
        
}
