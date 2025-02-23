/*Capa controlador (Domain)
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bitacora {
    private static final String URL = "jdbc:mysql://localhost/umg2?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "admin"; 
    private static final String PASSWORD = "12345"; 
    private static final String ARCHIVO = "logs/bitacora.txt";
 // Archivo donde se guardarán los eventos

    /**
     * Registra un evento en la base de datos y en un archivo de texto.
     *
     * @param mensaje Mensaje que se guardará en la bitácora.
     */
    public static void registrarEvento(String mensaje) {
        String tiempo = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String entrada =  " - " + mensaje;
  // Crear la carpeta logs si no existe
    File carpeta = new File("logs");
    if (!carpeta.exists()) {
        carpeta.mkdir(); // Crea la carpeta si no existe
    }
        // Guardar en la base de datos
        try (Connection conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
             PreparedStatement stmt = conexion.prepareStatement("INSERT INTO bitacora (evento) VALUES (?)")) {
            stmt.setString(1, entrada);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al registrar en la base de datos: " + e.getMessage());
        }

        // Guardar en archivo de texto
        try (FileWriter fw = new FileWriter(ARCHIVO, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(entrada);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }

        // También imprimir en consola
        System.out.println(entrada);
    }

    public void setId(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setEvento(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setFecha(LocalDateTime toLocalDateTime) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getEvento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getFecha() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
