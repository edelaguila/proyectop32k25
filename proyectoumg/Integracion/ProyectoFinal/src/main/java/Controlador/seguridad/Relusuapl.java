/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.seguridad;

/**
 *
 * @author visitante
 */

//Declaracion de la clase relacion usuario aplicacion
public class Relusuapl {
    
    //Declaracion de variables int y string
    int id_relusuapl;
    int id_aplicacion;
    int id_usuario;
    String der_insertar;
    String der_editar;
    String der_eliminar;
    String der_imprimir;
                //Modificacion de fecha en Relusuapl Hecho por Kathia Contreras
    String Fecha_relusuapl;
    
    
    // Constructor que inicializa todos los atributos a utilizar
    public Relusuapl(int id_relusuapl, int id_aplicacion, int id_usuario, String der_insertar, String der_editar, String der_eliminar, String der_imprimir, String Fecha_relusuapl) {
        this.id_relusuapl = id_relusuapl;
        this.id_aplicacion = id_aplicacion;
        this.id_usuario = id_usuario;
        this.der_insertar = der_insertar;
        this.der_editar = der_editar;
        this.der_eliminar = der_eliminar;
        this.der_imprimir = der_imprimir;
        this.Fecha_relusuapl = Fecha_relusuapl;
    }
    
    // Método que devuelve una representación en texto del objeto 
    @Override
    public String toString() {
        return "Relusuapl{" + "id_relusuapl=" + id_relusuapl + ", id_aplicacion=" + id_aplicacion + ", id_usuario=" + id_usuario + ", der_insertar=" + der_insertar + ", der_editar=" + der_editar + ", der_eliminar=" + der_eliminar + ", der_imprimir=" + der_imprimir + ", Fecha_relusuapl=" + Fecha_relusuapl + '}';
    }
    
    
    //Metodos getters y setters
    
    //Obteniendo el id de la relacion usuario aplicacion
    public int getId_relusuapl() {
        return id_relusuapl;
    }
    //Estableciendo el id de la relacion usuario aplicacion
    public void setId_relusuapl(int id_relusuapl) {
        this.id_relusuapl = id_relusuapl;
    }
    
    //Obteniendo el id de la aplicacion
    public int getId_aplicacion() {
        return id_aplicacion;
    }
    
    //Estableciendo el id de la aplicacion
    public void setId_aplicacion(int id_aplicacion) {
        this.id_aplicacion = id_aplicacion;
    }
    
    //Obteniendo el id del usuario
    public int getId_usuario() {
        return id_usuario;
    }
    
    //Estableciendo el id del usuario
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    //Obteniendo el derecho a insertar
    public String getDer_insertar() {
        return der_insertar;
    }
    
    //Estableciendo el derecho a Insertar
    public void setDer_insertar(String der_insertar) {
        this.der_insertar = der_insertar;
    }
    
    //Obteniendo el derecho a editar
    public String getDer_editar() {
        return der_editar;
    }
    
    //Estableciendo el derecho a editar
    public void setDer_editar(String der_editar) {
        this.der_editar = der_editar;
    }
    
    //Obteniendo el derecho a eliminar
    public String getDer_eliminar() {
        return der_eliminar;
    }   
    
    //Estableciendo el derecho a eliminar
    public void setDer_eliminar(String der_eliminar) {
        this.der_eliminar = der_eliminar;
    }
    
    //Obteniendo el derecho a imprimir
    public String getDer_imprimir() {
        return der_imprimir;
    }
    
    //Estableciendo el derecho a imprimir
    public void setDer_imprimir(String der_imprimir) {
        this.der_imprimir = der_imprimir;
    }
    
    //Obteniendo el derecho de fecha relacion usuario aplicacion
    public String getFecha_relusuapl() {
        return Fecha_relusuapl;
    }
    
    //Estableciendo la fecha de relacion usuario aplicacion
    public void setFecha_relusuapl(String Fecha_relusuapl) {
        this.Fecha_relusuapl = Fecha_relusuapl;
    }
    //Constructor vacio
        public Relusuapl() {
    }
   
}
