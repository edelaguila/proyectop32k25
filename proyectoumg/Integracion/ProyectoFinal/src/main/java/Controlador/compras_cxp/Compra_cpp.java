/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
    //Declaracion de paquete controlador de compras
    package Controlador.compras_cxp;

    import java.time.LocalDateTime;

    /**
     *
     * @author visitante
     */
    
    //Definiendo clase publica Compra_cpp
    public class Compra_cpp {
        
        //Declarando variables int y string
        int no_compra;
        String nombre_usuario;
        String apellido_usuario;
        int id_proveedor;
        String producto;
        int cantidad;
        int precio;
        int saldo_anterior;
        int plazo;
        int total;
    
    // Constructor que inicializa todos los atributos a utilizar
    public Compra_cpp(int no_compra, String nombre_usuario, String apellido_usuario, int id_proveedor, String producto, int cantidad, int precio, int saldo_anterior, int plazo, int total) {
        this.no_compra = no_compra;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.id_proveedor = id_proveedor;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.saldo_anterior = saldo_anterior;
        this.plazo = plazo;
        this.total = total;
    }
    
    // Método que devuelve una representación en texto del objeto   
    @Override
    public String toString() {
        return "Compra_cpp{" + "no_compra=" + no_compra + ", nombre_usuario=" + nombre_usuario + ", apellido_usuario=" + apellido_usuario + ", id_proveedor=" + id_proveedor + ", producto=" + producto + ", cantidad=" + cantidad + ", precio=" + precio + ", saldo_anterior=" + saldo_anterior + ", plazo=" + plazo + ", total=" + total + '}';
    }
    
    
    //Metodos getters y setters
    
    //Obteniendo Numero de compra
    public int getNo_compra() {
        return no_compra;
    }
    
    //Estableciendo Numero de compra
    public void setNo_compra(int no_compra) {
        this.no_compra = no_compra;
    }
    
    //Obteniendo Nombre del usuario
    public String getNombre_usuario() {
        return nombre_usuario;
    }
    
    //Estableciendo Nombre de usuario
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
    
    //Obteniendo apellido del usuario
    public String getApellido_usuario() {
        return apellido_usuario;
    }
    
    //Estableciendo apellido de usuario
    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }
    
    //Obteniendo id del proveedor
    public int getId_proveedor() {
        return id_proveedor;
    }
    
    //Estableciendo  Id del proveedor
    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }
    
    //Obteniendo producto
    public String getProducto() {
        return producto;
    }
    
    //Estableciendo producto
    public void setProducto(String producto) {
        this.producto = producto;
    }
    
    //Obteniendo cantidad de productos
    public int getCantidad() {
        return cantidad;
    }
    
    //Estableciendo cantidad de productos
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    //Obteniendo precio del producto
    public int getPrecio() {
        return precio;
    }
    
    //Estableiendo precio del producto
    public void setPrecio(int precio) {
        this.precio = precio;
    }   
    
    //Obteniendo saldo anterior
    public int getSaldo_anterior() {
        return saldo_anterior;
    }
    
    //Estableciendo saldo anterior
    public void setSaldo_anterior(int saldo_anterior) {
        this.saldo_anterior = saldo_anterior;
    }
    
    //Obteniendo plazo
    public int getPlazo() {
        return plazo;
    }
    
    //Estableciendo plazo
    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }
    
    //Obteniendo el total
    public int getTotal() {
        return total;
    }
    
    //Estableciendo total
    public void setTotal(int total) {
        this.total = total;
    }
       

        //Constructor vacio
        public Compra_cpp() {
        }

    }
    