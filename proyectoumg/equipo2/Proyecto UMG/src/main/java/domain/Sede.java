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
public class Sede {

    public Sede(int codigo_sede, String nombre_sede, String estatus_sede) {
        this.codigo_sede = codigo_sede;
        this.nombre_sede = nombre_sede;
        this.estatus_sede = estatus_sede;
    }

    public int getCodigo_sede() {
        return codigo_sede;
    }

    public String getNombre_sede() {
        return nombre_sede;
    }

    public String getEstatus_sede() {
        return estatus_sede;
    }

    public void setCodigo_sede(int codigo_sede) {
        this.codigo_sede = codigo_sede;
    }

    public void setNombre_sede(String nombre_sede) {
        this.nombre_sede = nombre_sede;
    }

    public void setEstatus_sede(String estatus_sede) {
        this.estatus_sede = estatus_sede;
    }

    @Override
    public String toString() {
        return "Sede{" + "codigo_sede=" + codigo_sede + ", nombre_sede=" + nombre_sede + ", estatus_sede=" + estatus_sede + '}';
    }
    
    int codigo_sede;
    String nombre_sede;
    String estatus_sede;
    
    public Sede() { //sin nada, sin parametros
    }
    
    

}
