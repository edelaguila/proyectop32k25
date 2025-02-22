/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Home
 */
public class Maestro {

    public Maestro(int codigoMaestro, String nombreMaestro, String direccionMaestro, String telefonoMaestro, String emailMaestro, String estatusMaestro) {
        this.codigoMaestro = codigoMaestro;
        this.nombreMaestro = nombreMaestro;
        this.direccionMaestro = direccionMaestro;
        this.telefonoMaestro = telefonoMaestro;
        this.emailMaestro = emailMaestro;
        this.estatusMaestro = estatusMaestro;
    }
    private int codigoMaestro;
    private String nombreMaestro;
    private String direccionMaestro;
    private String telefonoMaestro;
    private String emailMaestro;
    private String estatusMaestro;

    @Override
    public String toString() {
        return "Maestro{" + "codigoMaestro=" + codigoMaestro + ", nombreMaestro=" + nombreMaestro + ", direccionMaestro=" + direccionMaestro + ", telefonoMaestro=" + telefonoMaestro + ", emailMaestro=" + emailMaestro + ", estatusMaestro=" + estatusMaestro + '}';
    }

    public void setCodigoMaestro(int codigoMaestro) {
        this.codigoMaestro = codigoMaestro;
    }

    public void setNombreMaestro(String nombreMaestro) {
        this.nombreMaestro = nombreMaestro;
    }

    public void setDireccionMaestro(String direccionMaestro) {
        this.direccionMaestro = direccionMaestro;
    }

    public void setTelefonoMaestro(String telefonoMaestro) {
        this.telefonoMaestro = telefonoMaestro;
    }

    public void setEmailMaestro(String emailMaestro) {
        this.emailMaestro = emailMaestro;
    }

    public void setEstatusMaestro(String estatusMaestro) {
        this.estatusMaestro = estatusMaestro;
    }

    public int getCodigoMaestro() {
        return codigoMaestro;
    }

    public String getNombreMaestro() {
        return nombreMaestro;
    }

    public String getDireccionMaestro() {
        return direccionMaestro;
    }

    public String getTelefonoMaestro() {
        return telefonoMaestro;
    }

    public String getEmailMaestro() {
        return emailMaestro;
    }

    public String getEstatusMaestro() {
        return estatusMaestro;
    }
    public Maestro() {
    }
}

