/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author cdavi
 */
public class Aula {
    private int codigoAulas ;
    private String nombreAula;
    private String estatusAula;

    @Override
    public String toString() {
        return "Aulas{" + "codigoAulas=" + codigoAulas + ", nombreAula=" + nombreAula + ", estatusAula=" + estatusAula + '}';
    }

    public int getCodigoAulas() {
        return codigoAulas;
    }

    public void setCodigoAulas(int codigoAulas) {
        this.codigoAulas = codigoAulas;
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

    public Aula(int codigoAulas, String nombreAula, String estatusAula) {
        this.codigoAulas = codigoAulas;
        this.nombreAula = nombreAula;
        this.estatusAula = estatusAula;
    }

    public Aula() {
    }
}
