package Modelo.seguridad;

import Modelo.*;
import Controlador.seguridad.Usuario;
import Controlador.seguridad.permisos;

import Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class UsuarioDAO {

    private static final String SQL_SELECT = "SELECT id_usuario, username, password FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario(username, password) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET username=?, password=? WHERE id_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario=?";
    private static final String SQL_QUERY = "SELECT id_usuario, username, password FROM usuario WHERE username = ?";
    private static final String SQL_QUERY2 = "SELECT id_usuario, username, password FROM usuario WHERE id_usuario = ?";

    public List<Usuario> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_usuario = rs.getInt("id_usuario");
                String username = rs.getString("username");
                String password = rs.getString("password");

                usuario = new Usuario();
                usuario.setId_usuario(id_usuario);
                usuario.setUsername(username);
                usuario.setPassword(password);

                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return usuarios;
    }

    public int insert(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());

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

    public int update(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());
            stmt.setInt(3, usuario.getId_usuario());

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

    public int delete(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getId_usuario());
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

    public Usuario query(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, usuario.getUsername());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_usuario = rs.getInt("id_usuario");
                String username = rs.getString("username");
                String password = rs.getString("password");

                usuario = new Usuario();
                usuario.setId_usuario(id_usuario);
                usuario.setUsername(username);
                usuario.setPassword(password);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return usuario;
    }

    public Usuario query2(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY2);
            stmt = conn.prepareStatement(SQL_QUERY2);
            stmt.setInt(1, usuario.getId_usuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_usuario = rs.getInt("id_usuario");
                String username = rs.getString("username");
                String password = rs.getString("password");

                usuario = new Usuario();
                usuario.setId_usuario(id_usuario);
                usuario.setUsername(username);
                usuario.setPassword(password);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return usuario;
    }
//METODOS PARA PERMISOS A NIVEL DE SEGURIDAD MISHEL LOEIZA 9959-23-3457
 public permisos obtenerPermisosPorUsuario(int idUsuario) {
    permisos permisos = new permisos();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
//CONEXIÒN A PERMISOS
    try {
        conn = Conexion.getConnection();
        String sql = "SELECT puede_mantenimiento, puede_procesos, puede_eliminar, puede_registrar, puede_modificar, " +
                     "APL103, APL104, APL105, APL106, APL107, APL108, APL109, APL110, APL111, APL112 " +
                     "FROM permisos_usuario WHERE id_usuario = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, idUsuario);
        rs = ps.executeQuery();

        if (rs.next()) {
            permisos.setPuedeMantenimiento(rs.getBoolean("puede_mantenimiento"));
            permisos.setPuedeProcesos(rs.getBoolean("puede_procesos"));
            permisos.setPuedeEliminar(rs.getBoolean("puede_eliminar"));
            permisos.setPuedeRegistrar(rs.getBoolean("puede_registrar"));
            permisos.setPuedeModificar(rs.getBoolean("puede_modificar"));
            permisos.setIdUsuario(idUsuario);

            // Asignar permisos de aplicaciones
            for (int i = 103; i <= 112; i++) {
                permisos.setPermisoAplicacion(i, rs.getBoolean("APL" + i));
            }
        }

    } catch (SQLException e) {
        e.printStackTrace(System.out);
    } finally {
        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);
    }
    return permisos;
}
//IMPLEMENTACION DE ELIMINAR A BASE DIRECTAR EN SQL
public boolean eliminarPermisos(int idUsuario) {
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        conn = Conexion.getConnection();
        String sql = "DELETE FROM permisos_usuario WHERE id_usuario = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, idUsuario);
        int rows = ps.executeUpdate();
        return rows > 0;
    } catch (SQLException e) {
        e.printStackTrace(System.out);
        return false;
    } finally {
        Conexion.close(ps);
        Conexion.close(conn);
    }
}
//ACTUALIZACIÒN AUTOMATICA
public boolean actualizarPermisos(int idUsuario, boolean puedeMantenimiento, boolean puedeProcesos,
                                  boolean puedeEliminar, boolean puedeRegistrar, boolean puedeModificar,
                                  boolean[] permisosAplicaciones) {
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        conn = Conexion.getConnection();
        String sql = "UPDATE permisos_usuario SET puede_mantenimiento = ?, puede_procesos = ?, " +
                     "puede_eliminar = ?, puede_registrar = ?, puede_modificar = ?, " +
                     "APL103 = ?, APL104 = ?, APL105 = ?, APL106 = ?, APL107 = ?, " +
                     "APL108 = ?, APL109 = ?, APL110 = ?, APL111 = ?, APL112 = ? " +
                     "WHERE id_usuario = ?";
        ps = conn.prepareStatement(sql);
        ps.setBoolean(1, puedeMantenimiento);
        ps.setBoolean(2, puedeProcesos);
        ps.setBoolean(3, puedeEliminar);
        ps.setBoolean(4, puedeRegistrar);
        ps.setBoolean(5, puedeModificar);

        // Asignación de permisos de aplicaciones
        for (int i = 103; i <= 112; i++) {
            ps.setBoolean(i - 97, permisosAplicaciones[i - 103]);
        }

        ps.setInt(16, idUsuario);

        int rows = ps.executeUpdate();
        return rows > 0;
    } catch (SQLException e) {
        e.printStackTrace(System.out);
        return false;
    } finally {
        Conexion.close(ps);
        Conexion.close(conn);
    }
}

public boolean insertarPermisos(int idUsuario, boolean puedeMantenimiento, boolean puedeProcesos,
                               boolean puedeEliminar, boolean puedeRegistrar, boolean puedeModificar,
                               boolean[] permisosAplicaciones) {
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        conn = Conexion.getConnection();
        String sql = "INSERT INTO permisos_usuario (id_usuario, puede_mantenimiento, puede_procesos, " +
                     "puede_eliminar, puede_registrar, puede_modificar, " +
                     "APL103, APL104, APL105, APL106, APL107, APL108, APL109, APL110, APL111, APL112) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, idUsuario);
        ps.setBoolean(2, puedeMantenimiento);
        ps.setBoolean(3, puedeProcesos);
        ps.setBoolean(4, puedeEliminar);
        ps.setBoolean(5, puedeRegistrar);
        ps.setBoolean(6, puedeModificar);

        // Asignación de permisos de aplicaciones
        for (int i = 103; i <= 112; i++) {
            ps.setBoolean(i - 97, permisosAplicaciones[i - 103]);
        }

        int rows = ps.executeUpdate();
        return rows > 0;
    } catch (SQLException e) {
        e.printStackTrace(System.out);
        return false;
    } finally {
        Conexion.close(ps);
        Conexion.close(conn);
    }
}

public boolean existeUsuario(int idUsuario) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        conn = Conexion.getConnection();
        String sql = "SELECT 1 FROM usuario WHERE id_usuario = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, idUsuario);
        rs = ps.executeQuery();
        return rs.next();
    } catch (SQLException e) {
        e.printStackTrace(System.out);
        return false;
    } finally {
        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);
    }
}

public List<Integer> obtenerTodosIds() {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    List<Integer> ids = new ArrayList<>();
    try {
        conn = Conexion.getConnection();
        String sql = "SELECT id_usuario FROM usuario";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            ids.add(rs.getInt("id_usuario"));
        }
    } catch (SQLException e) {
        e.printStackTrace(System.out);
    } finally {
        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);
    }
    return ids;
}

public String obtenerUsernamePorId(Integer idUsuario) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String username = null;
    try {
        conn = Conexion.getConnection();
        String sql = "SELECT username FROM usuario WHERE id_usuario = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, idUsuario);
        rs = ps.executeQuery();
        if (rs.next()) {
            username = rs.getString("username");
        }
    } catch (SQLException e) {
        e.printStackTrace(System.out);
    } finally {
        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);
    }
    return username;
}

public List<permisos> obtenerPermisos() {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    List<permisos> listaPermisos = new ArrayList<>();

    try {
        conn = Conexion.getConnection();
        String sql = "SELECT id_usuario, puede_mantenimiento, puede_procesos, puede_eliminar, puede_registrar, puede_modificar, " +
                     "APL103, APL104, APL105, APL106, APL107, APL108, APL109, APL110, APL111, APL112 " +
                     "FROM permisos_usuario";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            permisos p = new permisos();
            p.setIdUsuario(rs.getInt("id_usuario"));
            p.setPuedeMantenimiento(rs.getBoolean("puede_mantenimiento"));
            p.setPuedeProcesos(rs.getBoolean("puede_procesos"));
            p.setPuedeEliminar(rs.getBoolean("puede_eliminar"));
            p.setPuedeRegistrar(rs.getBoolean("puede_registrar"));
            p.setPuedeModificar(rs.getBoolean("puede_modificar"));

            // Asignar permisos de aplicaciones dinámicamente
            for (int i = 103; i <= 112; i++) {
                p.setPermisoAplicacion(i, rs.getBoolean("APL" + i));
            }

            listaPermisos.add(p);
        }
    } catch (SQLException e) {
        e.printStackTrace(System.out);
    } finally {
        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);
    }
    return listaPermisos;
}
public List<Usuario> obtenerUsuariosConPerfil() {
    List<Usuario> lista = new ArrayList<>();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        conn = Conexion.getConnection();
        // 🔥 Consulta SQL con `LEFT JOIN` para incluir usuarios sin perfil
        String sql = "SELECT u.id_usuario, u.username, COALESCE(r.id_perfil, 'Sin perfil') AS perfil " +
                     "FROM usuario u " +
                     "LEFT JOIN relperfusu r ON u.id_usuario = r.id_usuario";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();

        while (rs.next()) {
            Usuario u = new Usuario();
            u.setId_usuario(rs.getInt("id_usuario"));
            u.setUsername(rs.getString("username"));
            u.setPerfil(rs.getInt("id_perfil")); 
 //  "Sin perfil"

            System.out.println("ID: " + u.getId_usuario() + " | Nombre: " + u.getUsername() + " | Perfil: " + u.getPerfil()); // 🚀 Verifica si llega bien

            lista.add(u);
        }
    } catch (SQLException e) {
        e.printStackTrace(System.out);
    } finally {
        Conexion.close(rs);
        Conexion.close(stmt);
        Conexion.close(conn);
    }

    return lista;
}

    public List<Usuario> obtenerTodosLosUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}