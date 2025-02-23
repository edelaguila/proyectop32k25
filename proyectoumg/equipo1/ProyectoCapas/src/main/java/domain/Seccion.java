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
public class Seccion {
   private int codigo_seccion;
   private String nombre_seccion;
   private String estatus_seccion;

   public Seccion() {
   }

   public Seccion(int codigo_seccion, String nombre_seccion, String estatus_seccion) {
       this.codigo_seccion = codigo_seccion;
       this.nombre_seccion = nombre_seccion;
       this.estatus_seccion = estatus_seccion;
   }

   public int getCodigo_seccion() {
       return codigo_seccion;
   }

   public void setCodigo_seccion(int codigo_seccion) {
       this.codigo_seccion = codigo_seccion;
   }

   public String getNombre_seccion() {
       return nombre_seccion;
   }

   public void setNombre_seccion(String nombre_seccion) {
       this.nombre_seccion = nombre_seccion;
   }

   public String getEstatus_seccion() {
       return estatus_seccion;
   }

   public void setEstatus_seccion(String estatus_seccion) {
       this.estatus_seccion = estatus_seccion;
   }

   @Override
   public String toString() {
       return "Seccion{" + "codigo_seccion=" + codigo_seccion + ", nombre_seccion=" + nombre_seccion + ", estatus_seccion=" + estatus_seccion+ '}';
   }
}
