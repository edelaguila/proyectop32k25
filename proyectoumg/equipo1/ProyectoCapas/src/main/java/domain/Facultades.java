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
public class Facultades {

   
   private int codigoFacultad;
   private  String nombreFacultad;
   private  String estatusFacultadString;

  

//METODOS PARA OBTENER Y COLOCAR INFORMACION DENTRO DE LOS ATRIBUTOS PRIVADOS
   public int getCodigoFacultad() {
        return codigoFacultad;
    }

    public void setCodigoFacultad(int codigoFacultad) {
        this.codigoFacultad = codigoFacultad;
    }

    public String getNombreFacultad() {
        return nombreFacultad;
    }

    public void setNombreFacultad(String nombreFacultad) {
        this.nombreFacultad = nombreFacultad;
    }

    public String getEstatusFacultadString() {
        return estatusFacultadString;
    }

    public void setEstatusFacultadString(String estatusFacultadString) {
        this.estatusFacultadString = estatusFacultadString;
    }
//SOBRE CARGA DE CONSTRUCTORES ( GENERAMOS OBJETOS CON DISTINTOS ATRIBUTOS)
    public Facultades() {
    
    }

    
     public Facultades(int codigoFacultad, String nombreFacultad, String estatusFacultadString) {
        this.codigoFacultad = codigoFacultad;
        this.nombreFacultad = nombreFacultad;
        this.estatusFacultadString = estatusFacultadString;
    }

     @Override
    public String toString() {
        return "Facultades{" + "codigoFacultad=" + codigoFacultad + 
                ", nombreFacultad=" + nombreFacultad +
                ", estatusFacultadString=" +
                estatusFacultadString + '}';
    }
  
}

   

