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
public class Maestro {

   
   private int codigoMaestro;
   private  String nombreMaestro;
   private  String direMaestro;
   private  String telefonoMaestro;
   private  String emailMaestro;
   private  String estatusMaestro;

    

   
    

//METODOS PARA OBTENER Y COLOCAR INFORMACION DENTRO DE LOS ATRIBUTOS PRIVADOS
    public int getCodigoMaestro() {
        return codigoMaestro;
    }

    public void setCodigoMaestro(int codigoMaestro) {
        this.codigoMaestro = codigoMaestro;
    }

    public String getNombreMaestro() {
        return nombreMaestro;
    }

    public void setNombreMaestro(String nombreMaestro) {
        this.nombreMaestro = nombreMaestro;
    }

    public String getDireMaestro() {
        return direMaestro;
    }

    public void setDireMaestro(String direMaestro) {
        this.direMaestro = direMaestro;
    }

    public String getTelefonoMaestro() {
        return telefonoMaestro;
    }

    public void setTelefonoMaestro(String telefonoMaestro) {
        this.telefonoMaestro = telefonoMaestro;
    }

    public String getEmailMaestro() {
        return emailMaestro;
    }

    public void setEmailMaestro(String emailMaestro) {
        this.emailMaestro = emailMaestro;
    }

    public String getEstatusMaestro() {
        return estatusMaestro;
    }

    public void setEstatusMaestro(String estatusMaestro) {
        this.estatusMaestro = estatusMaestro;
    }
    
//SOBRE CARGA DE CONSTRUCTORES ( GENERAMOS OBJETOS CON DISTINTOS ATRIBUTOS)

   public Maestro() {
    }
   
    public Maestro(int codigoMaestro, String nombreMaestro, String direMaestro,
            String telefonoMaestro, String emailMaestro, String estatusMaestro) {
        this.codigoMaestro = codigoMaestro;
        this.nombreMaestro = nombreMaestro;
        this.direMaestro = direMaestro;
        this.telefonoMaestro = telefonoMaestro;
        this.emailMaestro = emailMaestro;
        this.estatusMaestro = estatusMaestro;
    }


@Override
    public String toString() {
        return "Maestro{" + "codigoMaestro=" + codigoMaestro + ", nombreMaestro=" + nombreMaestro + ", direMaestro=" + direMaestro + ", telefonoMaestro=" + telefonoMaestro + ", emailMaestro=" + emailMaestro + ", estatusMaestro=" + estatusMaestro + '}';
    }
}

   

