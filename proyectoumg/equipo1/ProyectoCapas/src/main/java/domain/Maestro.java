/*Capa controlador (Domain)
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
    private int  carnet_maestro;
    private String nombre_maestro;
    private String direccion_maestro;
    private String telefono_maestro;
    private String email_maestro;
    private String estatus_maestro;
       public Maestro() {
    }
    public Maestro(int carnet_maestro, String nombre_maestro, String direccion_maestro, String telefono_maestro, String email_maestro, String estatus_maestro) {
        this.carnet_maestro = carnet_maestro;
        this.nombre_maestro = nombre_maestro;
        this.direccion_maestro = direccion_maestro;
        this.telefono_maestro = telefono_maestro;
        this.email_maestro = email_maestro;
        this.estatus_maestro = estatus_maestro;
    }

    public int getCarnet_maestro() {
        return carnet_maestro;
    }

    public void setCarnet_maestro(int carnet_maestro) {
        this.carnet_maestro = carnet_maestro;
    }

    public String getNombre_maestro() {
        return nombre_maestro;
    }

    public void setNombre_maestro(String nombre_maestro) {
        this.nombre_maestro = nombre_maestro;
    }

    public String getDireccion_maestro() {
        return direccion_maestro;
    }

    public void setDireccion_maestro(String direccion_maestro) {
        this.direccion_maestro = direccion_maestro;
    }

    public String getTelefono_maestro() {
        return telefono_maestro;
    }

    public void setTelefono_maestro(String telefono_maestro) {
        this.telefono_maestro = telefono_maestro;
    }

    public String getEmail_maestro() {
        return email_maestro;
    }

    public void setEmail_maestro(String email_maestro) {
        this.email_maestro = email_maestro;
    }

    public String getEstatus_maestro() {
        return estatus_maestro;
    }

    public void setEstatus_maestro(String estatus_maestro) {
        this.estatus_maestro = estatus_maestro;
    }

    @Override
    public String toString() {
        return "Maestro{" + "carnet_maestro=" + carnet_maestro + ", nombre_maestro=" + nombre_maestro + ", direccion_maestro=" + direccion_maestro + ", telefono_maestro=" + telefono_maestro + ", email_maestro=" + email_maestro + ", estatus_maestro=" + estatus_maestro + '}';
    }
    
  
   
   

    }

  
    
