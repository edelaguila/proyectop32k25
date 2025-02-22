/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author andre
 */

public class Aulas {
    private int codigoAula;
    private String nombreAula;
    private String estatusAula;

    // Constructor vacío (obligatorio si usas 'new Aulas()' sin parámetros)
    public Aulas() {
    }

    // Constructor con parámetros (opcional)
    public Aulas(int codigoAula, String nombreAula, String estatusAula) {
        this.codigoAula = codigoAula;
        this.nombreAula = nombreAula;
        this.estatusAula = estatusAula;
    }

    // Getters y Setters
    public int getCodigoAula() {
        return codigoAula;
    }

    public void setCodigoAula(int codigoAula) {
        this.codigoAula = codigoAula;
    }

    public String getNombreAula() {
        return nombreAula;
    }

    public void setNombreAula(String nombreAula) {
        this.nombreAula = nombreAula;
    }

    public String getEstatusAula() {
        return estatusAula;
    }

    public void setEstatusAula(String estatusAula) {
        this.estatusAula = estatusAula;
    }
}
         
 

  

