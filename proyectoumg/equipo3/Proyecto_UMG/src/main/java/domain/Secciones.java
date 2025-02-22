/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author melen
 */
public class Secciones {

   
    // defino atributos de forma privada (principio de encapsulamiento)
    private int codigo_seccion;
    private String nombre_seccion;
    private String estatus_seccion;
    //contructor vacio 
    public Secciones() {
    }
    //contructor sobre cargado
    public Secciones(int codigo_seccion, String nombre_seccion, String estatus_seccion) {
        this.codigo_seccion = codigo_seccion;
        this.nombre_seccion = nombre_seccion;
        this.estatus_seccion = estatus_seccion;
    }
    
    //definicion de get y set para acceder a los atributos 
     public int getCodigo_seccion() {
        return codigo_seccion;
    }

    public void setCodigo_seccion(int codigo_seccion) {
        this.codigo_seccion = codigo_seccion;
    }

    public String getNombre_seccion() {
        return nombre_seccion;
    }

    public void setNombre_seccion(String nombre_seccion) {
        this.nombre_seccion = nombre_seccion;
    }

    public String getEstatus_seccion() {
        return estatus_seccion;
    }

    public void setEstatus_seccion(String estatus_seccion) {
        this.estatus_seccion = estatus_seccion;
    }
     @Override
    public String toString() {
        return "Secciones{" + "codigo_seccion=" + codigo_seccion + ", nombre_seccion=" + nombre_seccion + ", estatus_seccion=" + estatus_seccion + '}';
    }
    

    
    
}

