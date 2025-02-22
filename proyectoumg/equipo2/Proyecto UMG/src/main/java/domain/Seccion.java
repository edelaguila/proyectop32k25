/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Home
 */
public class Seccion {
    private int codigoSeccion;
    private String nombreSeccion;
    private String estatusSeccion;

    public Seccion(int codigoSeccion, String nombreSeccion, String estatusSeccion) {
        this.codigoSeccion = codigoSeccion;
        this.nombreSeccion = nombreSeccion;
        this.estatusSeccion = estatusSeccion;
    }

    @Override
    public String toString() {
        return "Seccion{" + "codigoSeccion=" + codigoSeccion + ", nombreSeccion=" + nombreSeccion + ", estatusSeccion=" + estatusSeccion + '}';
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

    

    public Seccion() {
    }
}
