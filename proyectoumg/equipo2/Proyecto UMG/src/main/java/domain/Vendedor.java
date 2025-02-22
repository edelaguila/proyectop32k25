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
public class Vendedor {
    //ATRIBUTOS DE LA CLASE Vendedor
    int id_vendedor;
    String nombreVendedor;
    String direVendedor;
//HAY 3 CONSTRUCTORES SE LLAMAN CONSTRUCTORES SOBRECARGADOS
//PRIMER CONSTRUCTOR PARA INSTANCIAR OBJETO    
    public Vendedor() {
    }
//TIENE PARAMETRO Id_vendedor MAS ESPECIFICO
    public Vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }
//RECIBE 2 PARAMETROS EL CONSTRUCTOR SE SOBRECARGAN PARA MEJORES POSIBILIDADES
    public Vendedor(String nombreVendedor, String direVendedor) {
        this.nombreVendedor = nombreVendedor;
        this.direVendedor = direVendedor;
    }
//GET DEL ATRIBUTO QUE ESTAN PRIVADOS
    public int getId_vendedor() {
        return id_vendedor;
    }
//SET DEL ATRIBUTO QUE ESTAN PRIVADOS
    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }
//GET DEL ATRIBUTO QUE ESTAN PRIVADOS
    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }
//GET DEL ATRIBUTO QUE ESTAN PRIVADOS
    public String getDireVendedor() {
        return direVendedor;
    }

    public void setDireVendedor(String direVendedor) {
        this.direVendedor = direVendedor;
    }
   //METODO QUE VERIFICA SI SE INGRESO, IMPRIME EN CONSOLA
    @Override
    public String toString() {
        return "Vendedor{" + "id_vendedor=" + id_vendedor + ", nombreVendedor=" + nombreVendedor + ", direVendedor=" + direVendedor + '}';
    }
    
}
