                                //Realizado por Andy Garcia 
//Declaracion del paquete vista.compras
package vista.compras_cxp;

//Importaciones de los archivos a utilizar
import Controlador.compras_cxp.Proveedor;
import Modelo.compras_cxp.ProveedorDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

//Bitacora Implemenrada por Oscar Morales
import Controlador.seguridad.Bitacora;
import Controlador.seguridad.UsuarioConectado;

/**
 *
 * @author visitante
 */

//Declaracion de la clase mantenimiento proveedores
public class MantenimientoProveedores extends javax.swing.JInternalFrame {
    
    //Codigo de la aplicacion mantenimiento proveedores
    final int APLICACION=202;
    
    //Metodo para el llenado de los combo box de los proveedores que existen
    public void llenadoDeCombos() {
        //Instancia de la clase proveedores
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        //Se obteiene la lista de los proveedores
        List<Proveedor> proveedores = proveedorDAO.select();
        //Mensaje al usuario
        cbox_proveedor.addItem("Seleccione una opción");
        //Ciclo que recorre y añade a cada proveedor al combo box
        for (int i = 0; i < proveedores.size(); i++) {
            cbox_proveedor.addItem(proveedores.get(i).getNombre_proveedor());
        }
    }
    
    //Metodo para el llenado de las tablas 
    public void llenadoDeTablas() {
        //Nuevo modelo para la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        //Añadiendo columna del id del proveedor
        modelo.addColumn("Id ");
        //Añadiendo columna el nombre del proveedor
        modelo.addColumn("Nombre ");
        //Añadiendo columna de la dieccion del proveedor
        modelo.addColumn("Direccion ");
        //Añadiendo columna del numero de telefono del proveedor
        modelo.addColumn("Telefono ");
        //Añadiendo columna del id del email del proveedor
        modelo.addColumn("Email ");
        //Añadiendo columna del saldo del proveedor
        modelo.addColumn("Saldo ");
        //Añadiendo columna el estatus del proveedor
        modelo.addColumn("Estatus ");
        //Añadiendo columna de la fecha de registro del proveedor
        modelo.addColumn("Fecha Registro");
        //Añadiendo columna el plazo limite del proveedor
        modelo.addColumn("Plazo Limite");
       
        //Instancia de la clase proveedor
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        //Obteniendo la lista de los proveedores
        List<Proveedor> proveedores = proveedorDAO.select();
        //Estableciendo el modelo en la tabla de vendedores
        tablaProveedores.setModel(modelo);
        // Arreglo temporal para almacenar los datos de cada fila
        String[] dato = new String[9];
        //Ciclo que recorre la lista obtenida  y agrega cada uno de los proveedores a la tabla
        for (int i = 0; i < proveedores.size(); i++) {
            dato[0] = Integer.toString(proveedores.get(i).getId_proveedor());
            dato[1] = proveedores.get(i).getNombre_proveedor();
            dato[2] = proveedores.get(i).getDireccion_proveedor();
            dato[3] = proveedores.get(i).getTelefono_proveedor();
            dato[4] = proveedores.get(i).getEmail_proveedor();
            dato[5] = Integer.toString(proveedores.get(i).getSaldo_proveedor());
            dato[6] = Integer.toString(proveedores.get(i).getEstatus_proveedor());
            dato[7] = proveedores.get(i).getFecha_registro();
            dato[8] = Integer.toString(proveedores.get(i).getPlazo_limite());
            //Agrega la fila al modelo
            modelo.addRow(dato);
        }
    }
    
    //Metodo para buscar un proveedor
    public void buscarProveedor() {
        //Se crea una instancia de la clase proveedor y su dao
        Proveedor proveedorAConsultar = new Proveedor();
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        
         // Se establece el ID del proveedor a consultar desde el campo de texto
        proveedorAConsultar.setId_proveedor(Integer.parseInt(txtbuscado.getText()));
        // Se realiza la consulta en la base de datos
        proveedorAConsultar = proveedorDAO.query(proveedorAConsultar);
        
        // Se llenan los campos con los datos del proveedor
        txtNombre.setText(proveedorAConsultar.getNombre_proveedor());
        txtDireccion.setText(proveedorAConsultar.getDireccion_proveedor());
        txtTelefono.setText(proveedorAConsultar.getTelefono_proveedor());
        txtEmail.setText(proveedorAConsultar.getEmail_proveedor());
        txtSaldo.setText(String.valueOf(proveedorAConsultar.getSaldo_proveedor()));
        txtEstatus.setText(String.valueOf(proveedorAConsultar.getEstatus_proveedor()));
        txtFechaRegistro.setText(proveedorAConsultar.getFecha_registro());
        txtlimite.setText(String.valueOf(proveedorAConsultar.getPlazo_limite()));
        
        //Se registra en la bitacora
        UsuarioConectado usuarioEnSesion = new UsuarioConectado();
        int resultadoBitacora=0;
        Bitacora bitacoraRegistro = new Bitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(usuarioEnSesion.getIdUsuario(), APLICACION,  "Consulta Datos Proveedores"); 
    }
       
    // Constructor del formulario Mantenimiento Proveedores
    public MantenimientoProveedores() {
        //inicializacion de los componentes graficos
        initComponents();
        //Llamado al metodo de llenado de tablas
        llenadoDeTablas();
        //Llamado al metodo de llenado de los combo box
        llenadoDeCombos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb2 = new javax.swing.JLabel();
        lbusu = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        label3 = new javax.swing.JLabel();
        txtbuscado = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProveedores = new javax.swing.JTable();
        cbox_proveedor = new javax.swing.JComboBox<>();
        label4 = new javax.swing.JLabel();
        dire = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtSaldo = new javax.swing.JTextField();
        txtEstatus = new javax.swing.JTextField();
        txtReporte = new javax.swing.JButton();
        txtAyuda = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtFechaRegistro = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtlimite = new javax.swing.JTextField();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimiento Proveedores");
        setVisible(true);

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.setEnabled(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("Proveedores - 202");

        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        label3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label3.setText("Nombre");

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tablaProveedores.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Proveedor", "Nombre Proveedor", "Direccion Proveedor", "Telefono Proveedor", "Email Proveedor", "Saldo Proveedor", "Estatus Proveedor", "Fecha Registro"
            }
        ));
        jScrollPane1.setViewportView(tablaProveedores);

        cbox_proveedor.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_proveedorActionPerformed(evt);
            }
        });

        label4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label4.setText("Proveedores");

        dire.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        dire.setText("Direccion");

        lb.setForeground(new java.awt.Color(204, 204, 204));
        lb.setText(".");

        jButton1.setText("jButton1");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("Telefono");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Email");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Saldo");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setText("Estatus");

        txtReporte.setText("Reporte");
        txtReporte.setEnabled(false);
        txtReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReporteActionPerformed(evt);
            }
        });

        txtAyuda.setText("Ayudas");
        txtAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAyudaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setText("Fecha Registro");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setText("Días de plazo Limite");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtbuscado, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(791, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(dire)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                                    .addComponent(txtDireccion)
                                    .addComponent(txtEmail)
                                    .addComponent(txtSaldo)
                                    .addComponent(txtEstatus)
                                    .addComponent(txtNombre)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtlimite, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(label1)
                                .addGap(294, 294, 294))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(190, 190, 190))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(label4)
                                        .addGap(18, 18, 18)))
                                .addComponent(cbox_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtReporte)
                                .addGap(48, 48, 48)
                                .addComponent(txtAyuda)))
                        .addContainerGap(130, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label4)
                                    .addComponent(cbox_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lb)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(45, 45, 45)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(label3)
                                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(11, 11, 11)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dire)
                                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel1)
                                        .addGap(13, 13, 13))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtlimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addGap(15, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnEliminar)
                    .addComponent(btnModificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbuscado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar)
                            .addComponent(btnLimpiar))
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtReporte)
                            .addComponent(txtAyuda))
                        .addGap(54, 54, 54))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Boton eliminar
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //Instancia de la clase proveedor y su dato
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        //Creacion de un objeto de la clase proveedor
        Proveedor proveedorAEliminar = new Proveedor();
        
        //Asignacion del id al proveedor que se desea eliminar
        proveedorAEliminar.setId_proveedor(Integer.parseInt(txtbuscado.getText()));
        proveedorDAO.delete(proveedorAEliminar);
        //Llamado del llenado de tablas
        llenadoDeTablas();
        
        //Se registra en la bitacora
        UsuarioConectado usuarioEnSesion = new UsuarioConectado();
        int resultadoBitacora=0;
        Bitacora bitacoraRegistro = new Bitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(usuarioEnSesion.getIdUsuario(), APLICACION,  "Borrar Datos Proveedores");
    }//GEN-LAST:event_btnEliminarActionPerformed

    //Boton registrar
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
    //Instancia del proveedordao
    ProveedorDAO proveedorDAO = new ProveedorDAO();
    //Se crea un objeto del proveedor
    Proveedor proveedorAInsertar = new Proveedor(); 
        
        //Se asignan los valores de los campos de texto al objeto proveedor
        proveedorAInsertar.setNombre_proveedor(txtNombre.getText());
        proveedorAInsertar.setDireccion_proveedor(txtDireccion.getText());
        proveedorAInsertar.setTelefono_proveedor(txtTelefono.getText());
        proveedorAInsertar.setEmail_proveedor(txtEmail.getText());
        proveedorAInsertar.setSaldo_proveedor(Integer.parseInt(txtSaldo.getText()));
        proveedorAInsertar.setEstatus_proveedor(Integer.parseInt(txtEstatus.getText()));              
        proveedorAInsertar.setFecha_registro(txtFechaRegistro.getText());
        proveedorAInsertar.setPlazo_limite(Integer.parseInt(txtlimite.getText()));
        
        //Se inserta el proveedor
        proveedorDAO.insert(proveedorAInsertar);
        
        //Se registra en la bitacora
        UsuarioConectado usuarioEnSesion = new UsuarioConectado();
        int resultadoBitacora=0;
        Bitacora bitacoraRegistro = new Bitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(usuarioEnSesion.getIdUsuario(), APLICACION,  "Ingreso Datos Proveedores");
        llenadoDeTablas();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    //Boton buscar
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //Llamado del metodo buscar un proveedor
        buscarProveedor();
    
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
    
        //Se creau na instancia del proveedordao 
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        //Se crea un objeto de la clase proveedor
        Proveedor proveedorAActualizar = new Proveedor();
        
        //Se establecen los valores desde los campos del formulario
        proveedorAActualizar.setId_proveedor(Integer.parseInt(txtbuscado.getText()));
        proveedorAActualizar.setNombre_proveedor(txtNombre.getText());
        proveedorAActualizar.setDireccion_proveedor(txtDireccion.getText());
        proveedorAActualizar.setTelefono_proveedor(txtTelefono.getText());
        proveedorAActualizar.setEmail_proveedor(txtEmail.getText());
        proveedorAActualizar.setSaldo_proveedor(Integer.parseInt(txtSaldo.getText())); 
        proveedorAActualizar.setEstatus_proveedor(Integer.parseInt(txtEstatus.getText()));
        proveedorAActualizar.setFecha_registro(txtFechaRegistro.getText());
        proveedorAActualizar.setPlazo_limite(Integer.parseInt(txtlimite.getText()));
        //Se actualizan los datos
        proveedorDAO.update(proveedorAActualizar);
        //Se llama el metodo de llenado de las tablas
        llenadoDeTablas();
        
        UsuarioConectado usuarioEnSesion = new UsuarioConectado();
        int resultadoBitacora=0;
        Bitacora bitacoraRegistro = new Bitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(usuarioEnSesion.getIdUsuario(), APLICACION,  "Actualizacion Datos Proveedores");
    }//GEN-LAST:event_btnModificarActionPerformed
    
    //Boton limpiar
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // Se restablece el ComboBox del proveedor al primer elemento
        cbox_proveedor.setSelectedIndex(0);
        //Se limpia los datos de los campos
        txtNombre.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        txtSaldo.setText("");
        txtEstatus.setText("");
        txtFechaRegistro.setText("");
        txtbuscado.setText("");
        txtlimite.setText("");
       
        //btnRegistrar.setEnabled(true);
        //btnModificar.setEnabled(true);
        //btnEliminar.setEnabled(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void cbox_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_proveedorActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_proveedorActionPerformed
    
                //Serie de funciones publicas para Seguridad. Hecho por Pablo Palencia
    //Funciones publicas son llamadas cuando se crea la ventana para habilitar o desahibilitar botones
    
    //Se habilida el boton eliminar
    public void habilitarEliminar(boolean habilitado) {
        btnEliminar.setEnabled(habilitado);
    }
    
    //Se habilita el boton registrar
    public void habilitarRegistrar(boolean habilitado) {
        btnRegistrar.setEnabled(habilitado);
    }
    
    //Se habilita el boton buscar
    public void habilitarBuscar(boolean habilitado) {
        txtReporte.setEnabled(habilitado);
    }
    
    //Se habilita el boton modificar
    public void habilitarModificar(boolean habilitado) {
        btnModificar.setEnabled(habilitado);
    }
    
    //Boton reporte
    private void txtReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReporteActionPerformed
        //Instancia del proveedordao
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        //Se llama el metodo para imprimir un reporte
        proveedorDAO.imprimirReporte(); 
        
        UsuarioConectado usuarioEnSesion = new UsuarioConectado();
        int resultadoBitacora=0;
        Bitacora bitacoraRegistro = new Bitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(usuarioEnSesion.getIdUsuario(), APLICACION,  "Visualizar reporte Proveedores");
    }//GEN-LAST:event_txtReporteActionPerformed
    
    //Boton ayuda
                         //Ayuda realizado por Andy Garcia
    private void txtAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAyudaActionPerformed
                        //ayuda implementada por Alisson López
       
        try {
            //Verificacion si el archivo de ayuda existe
            if ((new File("src\\main\\java\\ayudas\\ayudasComprasyCuentasPorPagar.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\ayudas\\ayudasComprasyCuentasPorPagar.chm");
                p.waitFor();
            } else {
                //Muestra mensaje en consola si no se encuentra el archivo de ayuda
                System.out.println("La ayuda no Fue encontrada");
            }
            System.out.println("Correcto");
        } catch (Exception ex) {
            // En caso de error, imprime la traza para diagnóstico
            ex.printStackTrace();
        } 
        
        UsuarioConectado usuarioEnSesion = new UsuarioConectado();
        int resultadoBitacora=0;
        Bitacora bitacoraRegistro = new Bitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(usuarioEnSesion.getIdUsuario(), APLICACION,  "Gestion Ayuda Proveedores");
    }//GEN-LAST:event_txtAyudaActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbox_proveedor;
    private javax.swing.JLabel dire;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTable tablaProveedores;
    private javax.swing.JButton txtAyuda;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEstatus;
    private javax.swing.JTextField txtFechaRegistro;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JButton txtReporte;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtbuscado;
    private javax.swing.JTextField txtlimite;
    // End of variables declaration//GEN-END:variables
}
