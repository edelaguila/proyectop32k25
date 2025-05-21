/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    //Declaracion del paquete controlador.compras
    package Controlador.compras_cxp;
    
    //Importando funciones
    import java.time.LocalDateTime;

    /**
     *
     * @author visitante
     */
    
    //Definiendo clase proveedor
    public class Proveedor {
        
        //Declarando variables int y string
        int id_proveedor;
        String nombre_proveedor;
        String direccion_proveedor;
        String telefono_proveedor;
        String email_proveedor;
        String fecha_registro;
        int saldo_proveedor;
        int estatus_proveedor;
        int plazo_limite;
        
    //Metodos setters
        
    //Estableciendo id del proveedor
    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }
    
    //Estableciendo nombre del proveedor
    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }
    
    //Estableciendo direccion del proveedor
    public void setDireccion_proveedor(String direccion_proveedor) {
        this.direccion_proveedor = direccion_proveedor;
    }
    
    //Estableciendo telefono del proveedor
    public void setTelefono_proveedor(String telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }
    
    //Estableciendo email del proveedor
    public void setEmail_proveedor(String email_proveedor) {
        this.email_proveedor = email_proveedor;
    }
    
    //Estableciendo fecha de registro
    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
    //Estableciendo salto del proveedor
    public void setSaldo_proveedor(int saldo_proveedor) {
        this.saldo_proveedor = saldo_proveedor;
    }
    
    //Estableciendo estatus del proveedor
    public void setEstatus_proveedor(int estatus_proveedor) {
        this.estatus_proveedor = estatus_proveedor;
    }
    
    //Estableciendo plazo limite
    public void setPlazo_limite(int plazo_limite) {
        this.plazo_limite = plazo_limite;
    }
    
    //Metodos getters
    
    //Obteniendo id del proveedor
    public int getId_proveedor() {
        return id_proveedor;
    }
    
    //Obteniendo nombre del proveedor
    public String getNombre_proveedor() {
        return nombre_proveedor;
    }
    
    //Obteniendo direccion del proveedor
    public String getDireccion_proveedor() {
        return direccion_proveedor;
    }
    
    //Obteniendo telefono del proveedor
    public String getTelefono_proveedor() {
        return telefono_proveedor;
    }
    
    //Obteniendo email del proveedor
    public String getEmail_proveedor() {
        return email_proveedor;
    }
    //Obteniendo fecha de registro
    public String getFecha_registro() {
        return fecha_registro;
    }
    
    //Obteniendo saldo del proveedor
    public int getSaldo_proveedor() {
        return saldo_proveedor;
    }
    
    //Obteniendo estatus del proveedor
    public int getEstatus_proveedor() {
        return estatus_proveedor;
    }
    
    //Obteniendo plazo limite
    public int getPlazo_limite() {
        return plazo_limite;
    }
        
        //Declarando atributos a utilizar
        public Proveedor(int id_proveedor, String nombre_proveedor, String direccion_proveedor, String telefono_proveedor, String email_proveedor, int saldo_proveedor, int estatus_proveedor, String fecha_registro, int plazo_limite) {
            this.id_proveedor = id_proveedor;
            this.nombre_proveedor = nombre_proveedor;
            this.direccion_proveedor = direccion_proveedor;
            this.telefono_proveedor = telefono_proveedor;
            this.email_proveedor = email_proveedor;
            this.saldo_proveedor = saldo_proveedor;
            this.estatus_proveedor = estatus_proveedor;
            this.fecha_registro = fecha_registro;
            this.plazo_limite = plazo_limite;
            
            
        }
        
        // Método que devuelve una representación en texto del objeto   
        @Override
        public String toString() {
            return "Proveedor{" + "id_proveedor=" + id_proveedor + ", nombre_proveedor=" + nombre_proveedor + ", direccion_proveedor=" + direccion_proveedor + ", telefono_proveedor=" + telefono_proveedor + ", email_proveedor=" + email_proveedor + ", saldo_proveedor=" + saldo_proveedor + ", estatus_proveedor=" + estatus_proveedor + ", fecha_registro=" + fecha_registro + ",plazo_limite=" + plazo_limite+'}';
        }
            

        //Constructor vacio
        public Proveedor() {
        }

    }
    