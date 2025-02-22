    package datos;

import java.sql.*;

public class Conexion {
    //aqui tiene umg-kc el nombre de la base de datos
    private static final String JDBC_URL = "jdbc:mysql://localhost/umg?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "usuprueba";
    private static final String JDBC_PASS = "123456";
   
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }
    
}
