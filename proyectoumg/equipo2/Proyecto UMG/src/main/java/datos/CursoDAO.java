/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Curso;
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
public class CursoDAO {

    private static final String SQL_SELECT = "SELECT codigo_curso, nombre_curso, estatus_curso FROM cursos";
    private static final String SQL_INSERT = "INSERT INTO cursos(nombre_curso, estatus_curso) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE cursos SET nombre_curso=?, estatus_curso=? WHERE codigo_curso= ?";
    private static final String SQL_DELETE = "DELETE FROM cursos WHERE codigo_curso=?";
    private static final String SQL_QUERY = "SELECT codigo_curso, nombre_curso, estatus_curso FROM cursos WHERE codigo_curso = ?";

    //se crea una lista con la clase vendedor adentro
    //lo siguiente son las variables que contiene la base de datos null sirve para inicializar las variables
    public List<Curso> select() {
        Connection conn = null; //variable que se usa para abrir la base de datos
        PreparedStatement stmt = null; //statement permite colocar un comando de sql
        ResultSet rs = null; //resul set trae información de la base de datps
        Curso curso = null;
        List<Curso> cursos = new ArrayList<Curso>();
        
//vendedor con minuscula es de tipo lista que contiene objetos con la forma de los atributos y metodos de la clase Vendedor
        try { //try sirve para manejo de erroes, catch tiene la misma función
            conn = Conexion.getConnection(); // ya que no hay error, abre la base de datos
            stmt = conn.prepareStatement(SQL_SELECT); //prepara la instrucción sql server->consulta definida arriba, esto trae todos los registros
            rs = stmt.executeQuery();//trae lo que buscaba el select y lo almacema en rs
            while (rs.next()) {
//recorremos la variable si existe un siguiente (registro) hasta que termina con todo lo que trajimos de la base de datos
                int codigo_curso = rs.getInt("codigo_curso");//se crea la primera variable local del primer registro que se encontro en la base de datos
                String nombre_curso = rs.getString("nombre_curso");
                String estatus_curso = rs.getString("estatus_curso");
                
                curso = new Curso (); //vendedor es objeto y Vendedor es la llamada al cosntructor
                curso.setCodigo_curso(codigo_curso);//trae todo a las variables temporales con las cuales se va a establecer el objeto
                curso.setNombre_curso(nombre_curso);
                curso.setEstatus_curso(estatus_curso);
                
                cursos.add(curso);//añadimos todo a la lista que habiamos creado al principo y lo llevamos a la capa vista
            }

        } catch (SQLException ex) {//si hay problema con la base de datos estas funciones evitan que se salga del programa
            //limite de interrupción
            ex.printStackTrace(System.out);
        } finally { //cierra las conexiones con la base de datos ya que si la deja abierta se pone lenta
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return cursos; //retorna la lista que hicimos
    }

    public int insert(Curso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, curso.getNombre_curso());
            stmt.setString(2, curso.getEstatus_curso());

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

    public int update(Curso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, curso.getNombre_curso());
            stmt.setString(2, curso.getEstatus_curso ());
            stmt.setInt(3, curso.getCodigo_curso());

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

    public int delete(Curso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, curso.getCodigo_curso());
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
    public Curso query(Curso curso) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Curso> cursos = new ArrayList<Curso>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, curso.getCodigo_curso());
            rs = stmt.executeQuery();
            while (rs.next()) {       
                int codigo_curso = rs.getInt("codigo_curso");//se crea la primera variable local del primer registro que se encontro en la base de datos
                String nombre_curso = rs.getString("nombre_curso");
                String estatus_curso = rs.getString("estatus_curso");
                
                curso = new Curso(); //vendedor es objeto y Vendedor es la llamada al cosntructor
                curso.setCodigo_curso(codigo_curso);//trae todo a las variables temporales con las cuales se va a establecer el objeto
                curso.setNombre_curso(nombre_curso);
                curso.setEstatus_curso(estatus_curso);
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
        return curso;
    }
        
}
