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
public class Carrera {
    
    int codigoCarrera;
    String nombreCarrera;
    int codigoFacultad;
    String estatusCarrera;

    public int getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(int codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public int getCodigoFacultad() {
        return codigoFacultad;
    }

    public void setCodigoFacultad(int codigoFacultad) {
        this.codigoFacultad = codigoFacultad;
    }

    public String getEstatusCarrera() {
        return estatusCarrera;
    }

    public void setEstatusCarrera(String estatusCarrera) {
        this.estatusCarrera = estatusCarrera;
    }

    public Carrera(int codigoCarrera, String nombreCarrera, int codigoFacultad, String estatusCarrera) {
        this.codigoCarrera = codigoCarrera;
        this.nombreCarrera = nombreCarrera;
        this.codigoFacultad = codigoFacultad;
        this.estatusCarrera = estatusCarrera;
    }

    @Override
    public String toString() {
        return "Carrera{" + "codigoCarrera=" + codigoCarrera + ", nombreCarrera=" + nombreCarrera + ", codigoFacultad=" + codigoFacultad + ", estatusCarrera=" + estatusCarrera + '}';
    }
    
    
 public Carrera() {
    }
    
    
}
