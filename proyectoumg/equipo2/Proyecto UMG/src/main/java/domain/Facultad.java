/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author visitante
 */
public class Facultad {

    public Facultad(int codigo_facultad, String nombre_facultad, String estatus_facultad) {
        this.codigo_facultad = codigo_facultad;
        this.nombre_facultad = nombre_facultad;
        this.estatus_facultad = estatus_facultad;
    }

    public int getCodigo_facultad() {
        return codigo_facultad;
    }

    public String getNombre_facultad() {
        return nombre_facultad;
    }

    public String getEstatus_facultad() {
        return estatus_facultad;
    }

    public void setCodigo_facultad(int codigo_facultad) {
        this.codigo_facultad = codigo_facultad;
    }

    public void setNombre_facultad(String nombre_facultad) {
        this.nombre_facultad = nombre_facultad;
    }

    public void setEstatus_facultad(String estatus_facultad) {
        this.estatus_facultad = estatus_facultad;
    }

    @Override
    public String toString() {
        return "Facultad{" + "codigo_facultad=" + codigo_facultad + ", nombre_facultad=" + nombre_facultad + ", estatus_facultad=" + estatus_facultad + '}';
    }
    
    int codigo_facultad;
    String nombre_facultad;
    String estatus_facultad;
    
    public Facultad() { //sin nada, sin parametros
    }
    
    

}
