/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Alumno;
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
public class AlumnoDAO {
 //constantes que guardan el codigo lmd o sql
    private static final String SQL_SELECT = "SELECT carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno FROM alumnos";
    //se deja afuera la llave primaria que es autonumerica (preguntar carnet_alumno en insert y update) //VERIFICAR SI SE QUITA DE AQUI CARNET_ALUMNO POR ORDEN DE CAMPO Y SI ES AUTONUMERICO
    private static final String SQL_INSERT = "INSERT INTO alumnos( nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE alumnos SET nombre_alumno=?, direccion_alumno=?, telefono_alumno=?, email_alumno=?, estatus_alumno=? WHERE carnet_alumno=?";
    private static final String SQL_DELETE = "DELETE FROM alumnos WHERE carnet_alumno=?";
    private static final String SQL_QUERY = "SELECT carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno FROM alumnos WHERE carnet_alumno=?";
//primer metodo select que consulta
    //Alumno nombre de la clase
    //List es una lista donde va a ingresar todos los registros de la base de datos4
    public List<Alumno> select() {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        //Alumno es la clase y alumno es el objeto y se declara nulo para eliminar basura de memoria
        //se define objeto
        Alumno alumno = null;
        //cree lista asociado a Alumno y la lista se llamará alumnos
        List<Alumno> alumnos = new ArrayList<Alumno>(); 
        try {
            //nos conectamos abriendo la base de datos
            conn = Conexion.getConnection();
            //trasladamos el comando que vamos a ejecutar para este metodo es select
            stmt = conn.prepareStatement(SQL_SELECT);
            //ejecuta el comando sql y trae todos los registros
            rs = stmt.executeQuery();
            //ciclo que mientras haya otro registro al ya no haber se termina el ciclo
            while (rs.next()) {
                //empezamos a llenar el objeto
                //carnetAlumno es el objeto y carnet_alumno es el campo de la base de datos que trae a través de rs
                //String carnetAlumno = rs.getString("carnet_alumno");
                int carnetAlumno = rs.getInt("carnet_alumno");
                //getString convierte a String por si hay algun tipo de dato que no sea ese aqui lo convierte (buena practica)
                String nombreAlumno = rs.getString("nombre_alumno");
                String direccionAlumno = rs.getString("direccion_alumno");
                String telefonoAlumno= rs.getString("telefono_alumno");
                String emailAlumno= rs.getString("email_alumno");
                String estatusAlumno= rs.getString("estatus_alumno");
                //se instancia el objeto
                alumno = new Alumno();
                //AQUI TRANSFERIMOS REGISTROS DE LA BASE DE DATOS QUE ESTABAN ALMACENADOS EN 
                //TODAS LA VARIABLES TEMPORALES AL OBJETO
                
                //al objeto le agregamos los atributos con set para acceder ya que son privados
                //enviamos carnetAlumno con set
                alumno.setCarnetAlumno(carnetAlumno);
                alumno.setNombreAlumno(nombreAlumno);
                alumno.setDireccionAlumno(direccionAlumno);
                alumno.setTelefonoAlumno(telefonoAlumno);
                alumno.setEmailAlumno(emailAlumno);
                alumno.setEstatusAlumno(estatusAlumno);
                //mandamos a lista temporal el objeto
                alumnos.add(alumno);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        //retorna la estructura o lista de todos los alumnos que se extrajeron de la base de datos
        return alumnos;
    }
//clase Alumno y objeto alumno son los parametros que recibe este metodo
    public int insert(Alumno alumno) {
        //conecta a base de datos
        Connection conn = null;
        //aqui se traslada la instruccion sql que se va a correr en la base de datos
        PreparedStatement stmt = null;
        int rows = 0;
        //try y catch sirve por si hay algun problema en el proceso
        try {
            //apertura de la conexión
            conn = Conexion.getConnection();
            //preparo y mando comando sql de insert
            stmt = conn.prepareStatement(SQL_INSERT);
            //empezamos a trasladar info del programa local hacia la base de datos
            //trasladamos lo que esta en el objeto hacia la base de datos, con todos los campos
            //PREGUNTAR CAMPO CARNET
            //con get sacamos informacion del objeto para extraerla y la mandamos al primer comodin representado por 1
            stmt.setString(1, alumno.getNombreAlumno());
            //2 es el segundo comodin
            stmt.setString(2, alumno.getDireccionAlumno());
            stmt.setString(3, alumno.getTelefonoAlumno());
            stmt.setString(4, alumno.getEmailAlumno());
            stmt.setString(5, alumno.getEstatusAlumno());
            //VERIFICAR CARNET SI NO SON 6 COMODINES
            //seteamos la variable que permite conectarnos a la base de datos 
            System.out.println("ejecutando query:" + SQL_INSERT);
            //y la ejecutamos
            rows = stmt.executeUpdate();
            //informa que se acaba de agregar una fila
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            //cerramos conexiones
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        //retorna el numero de columnas que seria "1"
        return rows;
    }
//metodo que actualiza en la base de datos
    public int update(Alumno alumno) {
        //conecta a base de datos
        Connection conn = null;
        //prepara la instruciion sql que recibe los registros de la base de datos
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            //abre la conexion a la base de datos
            conn = Conexion.getConnection();
            //imprime en consola que se actualizara un registro
            System.out.println("ejecutando query: " + SQL_UPDATE);
            //se prepara el statement y se le manda que se hara un update
            stmt = conn.prepareStatement(SQL_UPDATE);
            //verificar si se agrega o no el carnet
            //en primer comodin, del objeto alumno se obtiene la info del nombre por medio de get
            stmt.setString(1, alumno.getNombreAlumno());
            stmt.setString(2, alumno.getDireccionAlumno());
            stmt.setString(3, alumno.getTelefonoAlumno());
            stmt.setString(4, alumno.getEmailAlumno());
            stmt.setString(5, alumno.getEstatusAlumno());
            stmt.setInt(6, alumno.getCarnetAlumno());
            //ejectura instruccion stmt
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            //cierra conexion
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Alumno alumno) {
        //conecta a base de datos
        Connection conn = null;
        //prepara stmt de instruccion de sql que se pasa a base de datos
        PreparedStatement stmt = null;
        int rows = 0;
         //try y catch que evita errores
        try {
            //abre base de datos
            conn = Conexion.getConnection();
            //imprimimos en consola que se ejecutara un delete
            System.out.println("Ejecutando query:" + SQL_DELETE);
            //preparamos el stmt para delete, aqui se pasa la info
            stmt = conn.prepareStatement(SQL_DELETE);
            //delete solo tiene un comodin porque aqui con el carnet elimina todo el registro
            stmt.setInt(1, alumno.getCarnetAlumno());
            //ejecuta comando y borra registro
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            //cierra conexion
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    //ultimo metodo es un select enfocado con un where
    //ESTE METODO SE LLAMA QUERY Y NO SELECT PORQUE NO TRAE TODOS LOS REGISTROS DE LA BASE DE DATOS SE ENFOCA EN UN REGISTRO
    //Se define clase alumno y el parametro de la clase y su objeto
    public Alumno query(Alumno alumno) { 
        //se conecta a la base de datos
        Connection conn = null;
        //se define el stmt para la instruccion sql
        PreparedStatement stmt = null;
        //rs la consulta que se hara a la base de datos
        ResultSet rs = null;
        //la info se pone en una lista y se llamara alumnos de la clase Alumno
        List<Alumno> alumnos = new ArrayList<Alumno>();
        //la lista es si caso se dan varios resultados, deberia ser solo uno
        int rows = 0;
          //try y catch para evitar algun problema
        try {
            //abrimos la conexion a la base de datos
            conn = Conexion.getConnection();
            //imprimimos es consola que se ejecutara la instruccion query
            System.out.println("Ejecutando query:" + SQL_QUERY);
            //se prepara stmt y se le envia la instruccion query
            stmt = conn.prepareStatement(SQL_QUERY);
            //query solo tiene un comodin que es el carnet
            stmt.setInt(1, alumno.getCarnetAlumno());
            //ejecutamos la consulta con el codigo de carnet que se quiere 
            rs = stmt.executeQuery();
            //SI HUBIERA MAS DE UNO SE INGRESA A UN WHILE 
            //QUE SE EJECUTA MIENTRAS HAYA OTRO REGISTRO
            while (rs.next()) {
                //LOS QUE CUMPLEN CON ESA SENTENCIA
                //INFO DE LA BASE DE DATOS A VARIABLES TEMPORALES
                int carnetAlumno = rs.getInt("carnet_alumno");
                String nombreAlumno = rs.getString("nombre_alumno");
                String direccionAlumno = rs.getString("direccion_alumno");
                String telefonoAlumno=rs.getString("telefono_alumno");
                String emailAlumno=rs.getString("email_alumno");
                String estatusAlumno=rs.getString("estatus_alumno");
                //instanciamos el objeto y su constructor
                alumno = new Alumno();
                //mandamos el registro al objeto de las variables temporales al objeto
                alumno.setCarnetAlumno(carnetAlumno);
                alumno.setNombreAlumno(nombreAlumno);
                alumno.setDireccionAlumno(direccionAlumno);
                alumno.setTelefonoAlumno(telefonoAlumno);
                alumno.setEmailAlumno(emailAlumno);
                alumno.setEstatusAlumno(estatusAlumno);
                //alumnos.add(alumno); // Si se utiliza un ArrayList que es la lista se le agrega el objeto  que es el registro
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
        //devuelvo el objeto con la info del registro que esto requiriendo
        return alumno;
    }
        
}
