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
public class Seccion {
    
    private int codigoSeccion;
    private String nombreSeccion;
    private String estatusSeccion;

    public Seccion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public String toString() {
        return "Seccion{" + "codigoSeccion=" + codigoSeccion + ", nombreSeccion=" + nombreSeccion + ", estatusSeccion=" + estatusSeccion + '}';
    }

    public Seccion(int codigoSeccion, String nombreSeccion, String estatusSeccion) {
        this.codigoSeccion = codigoSeccion;
        this.nombreSeccion = nombreSeccion;
        this.estatusSeccion = estatusSeccion;
    }

    public int getCodigoSeccion() {
        return codigoSeccion;
    }

    public void setCodigoSeccion(int codigoSeccion) {
        this.codigoSeccion = codigoSeccion;
    }

    public String getNombreSeccion() {
        return nombreSeccion;
    }

    public void setNombreSeccion(String nombreSeccion) {
        this.nombreSeccion = nombreSeccion;
    }

    public String getEstatusSeccion() {
        return estatusSeccion;
    }

    public void setEstatusSeccion(String estatusSeccion) {
        this.estatusSeccion = estatusSeccion;
    }

    public void add(Seccion seccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
