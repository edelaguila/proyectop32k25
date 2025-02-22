package datos;

import domain.Carreras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarrerasDAO {

    private static final String SQL_SELECT = "SELECT codigo_carrera, nombre_carrera, codigo_facultad, estatus_carrera FROM carreras";
    private static final String SQL_INSERT = "INSERT INTO carreras(nombre_carrera, codigo_facultad, estatus_carrera) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE carreras SET nombre_carrera=?, codigo_facultad=?, estatus_carrera=? WHERE codigo_carrera=?";
    private static final String SQL_DELETE = "DELETE FROM carreras WHERE codigo_carrera=?";
    private static final String SQL_QUERY = "SELECT codigo_carrera, nombre_carrera, codigo_facultad, estatus_carrera FROM carreras WHERE codigo_carrera=?";

    public List<Carreras> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Carreras carrera = null;
        List<Carreras> carreras = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigoCarrera = rs.getInt("codigo_carrera");
                String nombreCarrera = rs.getString("nombre_carrera");
                int codigoFacultad = rs.getInt("codigo_facultad");
                String estatusCarrera = rs.getString("estatus_carrera");

                carrera = new Carreras(codigoCarrera, nombreCarrera, codigoFacultad, estatusCarrera);
                carreras.add(carrera);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return carreras;
    }

    public int insert(Carreras carreras) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, carreras.getNombre_carrera());
            stmt.setInt(2, carreras.getCodigo_facultad());
            stmt.setString(3, carreras.getEstatus_carrera());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int update(Carreras carreras) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, carreras.getNombre_carrera());
            stmt.setInt(2, carreras.getCodigo_facultad());
            stmt.setString(3, carreras.getEstatus_carrera());
            stmt.setInt(4, carreras.getCodigo_carrera());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int delete(Carreras carreras) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, carreras.getCodigo_carrera());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public Carreras query(Carreras carreras) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, carreras.getCodigo_carrera());
            rs = stmt.executeQuery();
            if (rs.next()) {
                carreras.setNombre_carrera(rs.getString("nombre_carrera"));
                carreras.setCodigo_facultad(rs.getInt("codigo_facultad"));
                carreras.setEstatus_carrera(rs.getString("estatus_carrera"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return carreras;
    }
}
