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
public class Curso {

    public Curso(int codigoCurso, String nombreCurso, String estatusCurso) {
        this.codigoCurso = codigoCurso;
        this.nombreCurso = nombreCurso;
        this.estatusCurso = estatusCurso;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getEstatusCurso() {
        return estatusCurso;
    }

    public void setEstatusCurso(String estatusCurso) {
        this.estatusCurso = estatusCurso;
    }

    @Override
    public String toString() {
        return "Cursos{" + "codigoCurso=" + codigoCurso + ", nombreCurso=" + nombreCurso + ", estatusCurso=" + estatusCurso + '}';
    }
    
    int codigoCurso;
    String nombreCurso;
    String estatusCurso;

   
    
 public Curso() {
    }
    
    
}
