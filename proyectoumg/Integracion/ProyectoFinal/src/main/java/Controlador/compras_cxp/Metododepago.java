/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Declaracion de paquete controlador compras
package Controlador.compras_cxp;

/**
 *
 * @author visitante
 */

                               //Metododepago.java HECHO POR KATHIA CONTRERAS

//Definiendo clase publica metododepago
public class Metododepago {
    
    //Declarando variables int y String 
    int id_metodoPago;
    String nombreMetodoPago;
    String estatusMetodoPago;
    
    // Constructor que inicializa todos los atributos a utilizar
    public Metododepago(int id_metodoPago, String nombreMetodoPago, String estatusMetodoPago) {
        this.id_metodoPago = id_metodoPago;
        this.nombreMetodoPago = nombreMetodoPago;
        this.estatusMetodoPago = estatusMetodoPago;
    }
    
    // Método que devuelve una representación en texto del objeto   
    @Override
    public String toString() {
        return "Metododepago{" + "id_metodoPago=" + id_metodoPago + ", nombreMetodoPago=" + nombreMetodoPago + ", estatusMetodoPago=" + estatusMetodoPago + '}';
    }
    
    //Metodos setters 
    
    //Estableciendo Id del Metodo de Pago
    public void setId_metodoPago(int id_metodoPago) {
        this.id_metodoPago = id_metodoPago;
    }
    //Estableciendo Nombre del metodo de Pago
    public void setNombreMetodoPago(String nombreMetodoPago) {
        this.nombreMetodoPago = nombreMetodoPago;
    }
    //Estableciendo el estatus del metodo de pago
    public void setEstatusMetodoPago(String estatusMetodoPago) {
        this.estatusMetodoPago = estatusMetodoPago;
    }
    
    //Metodos getters
    
    //Obteniendo Id de metodo de pago
    public int getId_metodoPago() {
        return id_metodoPago;
    }
    
    //Obteniendo Nombre del metodo de pago
    public String getNombreMetodoPago() {
        return nombreMetodoPago;
    }
    
    //Obteniendo estatus del metodo de pago
    public String getEstatusMetodoPago() {
        return estatusMetodoPago;
    }
    
    //Constructor vacio
    public Metododepago() {
    }

    
}