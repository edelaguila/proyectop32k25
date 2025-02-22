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

    public Curso() {
    }

    private int codigo_curso;
    private String nombre_curso;
    private String estatus_curso;
    
    public int getCodigo_curso() {
        return codigo_curso;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public String getEstatus_curso() {
        return estatus_curso;
    }

    public void setCodigo_curso(int codigo_curso) {
        this.codigo_curso = codigo_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public void setEstatus_curso(String estatus_curso) {
        this.estatus_curso = estatus_curso;
    }

    
    public Curso(int codigo_curso, String nombre_curso, String estatus_curso) {
        this.codigo_curso = codigo_curso;
        this.nombre_curso = nombre_curso;
        this.estatus_curso = estatus_curso;
    }

  
}
