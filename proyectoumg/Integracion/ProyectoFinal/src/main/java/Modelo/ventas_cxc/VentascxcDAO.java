/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.ventas_cxc;

import Controlador.ventas_cxc.Ventascxc;
import Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentascxcDAO {

    private static final String SQL_SELECT = "SELECT no_factura, no_venta, id_vendedor, nombre_cliente, apellido_cliente, proCodigo, cantidad, proPrecios, saldo_actual, proNombre, dias_credito, total, precio_producto FROM transaccionalvxc";

    private static final String SQL_INSERT = "INSERT INTO transaccionalvxc(no_factura, no_venta, id_vendedor, nombre_cliente, apellido_cliente, proCodigo, cantidad, proPrecios, saldo_actual, proNombre, dias_credito, total, precio_producto) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public List<Ventascxc> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Ventascxc transaccion;
        List<Ventascxc> listaTransacciones = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                transaccion = new Ventascxc();
                transaccion.setNo_factura(rs.getInt("no_factura"));
                transaccion.setNo_venta(rs.getString("no_venta"));
                transaccion.setId_vendedor(rs.getInt("id_vendedor"));
                transaccion.setNombre_cliente(rs.getString("nombre_cliente"));
                transaccion.setApellido_cliente(rs.getString("apellido_cliente"));
                transaccion.setPro_codigo(rs.getInt("proCodigo"));
                transaccion.setCantidad(rs.getInt("cantidad"));
                transaccion.setProPrecios(rs.getDouble("proPrecios"));
                transaccion.setSaldo_actual(rs.getDouble("saldo_actual"));
                transaccion.setProNombre(rs.getString("proNombre"));
                transaccion.setDias_credito(rs.getInt("dias_credito"));
                transaccion.setTotal(rs.getDouble("total"));
                transaccion.setPrecio_producto(rs.getString("precio_producto"));

                listaTransacciones.add(transaccion);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return listaTransacciones;
    }

    public boolean insert(Ventascxc venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rowsAffected = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, venta.getNo_factura());
            stmt.setString(2, venta.getNo_venta());
            stmt.setInt(3, venta.getId_vendedor());
            stmt.setString(4, venta.getNombre_cliente());
            stmt.setString(5, venta.getApellido_cliente());
            stmt.setInt(6, venta.getPro_codigo());
            stmt.setInt(7, venta.getCantidad());
            stmt.setDouble(8, venta.getProPrecios());
            stmt.setDouble(9, venta.getSaldo_actual());
            stmt.setString(10, venta.getProNombre());
            stmt.setInt(11, venta.getDias_credito());
            stmt.setDouble(12, venta.getTotal());
            stmt.setString(13, venta.getPrecio_producto());

            rowsAffected = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rowsAffected > 0;
    }

    
    public String obtenerUltimoNoVenta() {
    String sql = "SELECT MAX(no_venta) FROM ventas";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        if (rs.next()) {
            return rs.getString(1);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


}


