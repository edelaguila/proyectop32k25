package vista;
//CREADO POR MISHEL LOEIZA 9959-23-3457
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

//PERMISOS GLOBALES
public class NewJPanel extends javax.swing.JPanel {

    public NewJPanel() {
        initComponents();
    }
//CONEXIÒN A LA BASE DE DATOS
    private void buscarPermisosPorId(int id) {
        String JDBC_URL = "jdbc:mysql://localhost/sig2k25?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String usuario = "MISHEL";
        String password = "311";

        try (Connection cn = DriverManager.getConnection(JDBC_URL, usuario, password);
             PreparedStatement pst = cn.prepareStatement("SELECT * FROM permisos_usuario WHERE id_usuario = ?")) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
//PERMISOS
            if (rs.next()) {
                // Marcar los checkboxes según los permisos en la base de datos
                txtPermisoMantenimiento.setSelected(rs.getInt("puede_mantenimiento") == 1);
                txtPermisoProcesos.setSelected(rs.getInt("puede_procesos") == 1);
                txtPermisoEliminar.setSelected(rs.getInt("puede_eliminar") == 1);
                txtPermisoRegistrar.setSelected(rs.getInt("puede_registrar") == 1);
                txtPermisoModificar.setSelected(rs.getInt("puede_modificar") == 1);

                // Ahora también manejar los permisos de aplicaciones APL103 - APL112
                txtAPL103.setSelected(rs.getInt("APL103") == 1);
                txtAPL104.setSelected(rs.getInt("APL104") == 1);
                txtAPL105.setSelected(rs.getInt("APL105") == 1);
                txtAPL106.setSelected(rs.getInt("APL106") == 1);
                txtAPL107.setSelected(rs.getInt("APL107") == 1);
                txtAPL108.setSelected(rs.getInt("APL108") == 1);
                txtAPL109.setSelected(rs.getInt("APL109") == 1);
                txtAPL110.setSelected(rs.getInt("APL110") == 1);
                txtAPL111.setSelected(rs.getInt("APL111") == 1);
                txtAPL112.setSelected(rs.getInt("APL112") == 1);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró usuario con ID: " + id);
                limpiarCheckBoxes();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al buscar permisos: " + e.getMessage());
        }
    }

    private void limpiarCheckBoxes() {
        txtPermisoMantenimiento.setSelected(false);
        txtPermisoProcesos.setSelected(false);
        txtPermisoEliminar.setSelected(false);
        txtPermisoRegistrar.setSelected(false);
        txtPermisoModificar.setSelected(false);

        // Limpiar permisos de aplicaciones también
        txtAPL103.setSelected(false);
        txtAPL104.setSelected(false);
        txtAPL105.setSelected(false);
        txtAPL106.setSelected(false);
        txtAPL107.setSelected(false);
        txtAPL108.setSelected(false);
        txtAPL109.setSelected(false);
        txtAPL110.setSelected(false);
        txtAPL111.setSelected(false);
        txtAPL112.setSelected(false);
    }

    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaDatos = rs.getMetaData();

        Vector<String> columnas = new Vector<>();
        int columnCount = metaDatos.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            columnas.add(metaDatos.getColumnName(i));
        }

        Vector<Vector<Object>> datos = new Vector<>();
        while (rs.next()) {
            Vector<Object> fila = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                fila.add(rs.getObject(i));
            }
            datos.add(fila);
        }

        return new DefaultTableModel(datos, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    private DefaultTableModel cargarPermisosUsuarioDesdeBD() {
        DefaultTableModel modelo = null;
        String JDBC_URL = "jdbc:mysql://localhost/sig2k25?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String usuario = "MISHEL";
        String password = "311";

        try (Connection cn = DriverManager.getConnection(JDBC_URL, usuario, password);
             PreparedStatement pst = cn.prepareStatement("SELECT * FROM permisos_usuario");
             ResultSet rs = pst.executeQuery()) {

            modelo = buildTableModel(rs);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar permisos: " + e.getMessage());
        }
        return modelo;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TABLAB = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        txtPermisoMantenimiento = new javax.swing.JCheckBox();
        txtPermisoProcesos = new javax.swing.JCheckBox();
        txtPermisoEliminar = new javax.swing.JCheckBox();
        txtPermisoModificar = new javax.swing.JCheckBox();
        txtPermisoRegistrar = new javax.swing.JCheckBox();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        txtAPL104 = new javax.swing.JCheckBox();
        txtAPL103 = new javax.swing.JCheckBox();
        txtAPL106 = new javax.swing.JCheckBox();
        txtAPL107 = new javax.swing.JCheckBox();
        txtAPL108 = new javax.swing.JCheckBox();
        txtAPL105 = new javax.swing.JCheckBox();
        txtAPL110 = new javax.swing.JCheckBox();
        txtAPL109 = new javax.swing.JCheckBox();
        txtAPL111 = new javax.swing.JCheckBox();
        txtAPL112 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane1.setBackground(new java.awt.Color(153, 204, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        TABLAB.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TABLAB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Vendedor", "ID Empleado", "Correo", "Telefono", "Direccion", "Porcentaje", "Comision"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TABLAB);

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("MOSTRAR PERMISOS DE LOS USUARIOS");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 153, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("ACTUALIZAR PERMISOS");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("ID_USUARIO");

        jButton3.setBackground(new java.awt.Color(204, 255, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("AGREGAR PERMISOS ");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtPermisoMantenimiento.setText("MANTENIMIENTOS");

        txtPermisoProcesos.setText("PROCESOS");

        txtPermisoEliminar.setText("ELIMINAR");

        txtPermisoModificar.setText("MODIFICAR");

        txtPermisoRegistrar.setText("REGISTRAR");

        jButton4.setBackground(new java.awt.Color(255, 153, 153));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setText("ELIMINAR PERMISOS");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 204, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setText("BUSCAR");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("¡AGREGA PERMISOS A USUARIOS EXISTENTES");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText(" EN LA BASE DE DATOS DE LA EMPRESA!");

        jLabel4.setBackground(new java.awt.Color(255, 255, 153));
        jLabel4.setText("⚠️ TOMA EN CUENTA:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("SI EL USUARIO NO EXISTE");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("NO SERA POSIBLE OTORGARLE PERMISOS ");

        jButton6.setBackground(new java.awt.Color(102, 255, 255));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setText("LIMPIAR");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        txtAPL104.setText("104");

        txtAPL103.setText("103");

        txtAPL106.setText("106");

        txtAPL107.setText("107");

        txtAPL108.setText("108");

        txtAPL105.setText("105");

        txtAPL110.setText("110");

        txtAPL109.setText("109");

        txtAPL111.setText("111");

        txtAPL112.setText("112");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("MODULOS");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("FUNCIONES");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("APLICACIONES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(txtAPL103)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtAPL107)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtAPL111))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtAPL104)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtAPL108)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtAPL112))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtAPL105)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtAPL109)))
                                    .addGap(39, 39, 39)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(6, 6, 6))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtAPL106)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtAPL110)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPermisoMantenimiento)
                                    .addComponent(txtPermisoProcesos)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel9)))
                                .addGap(82, 82, 82)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPermisoRegistrar)
                                    .addComponent(txtPermisoEliminar)
                                    .addComponent(txtPermisoModificar))))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(80, 80, 80))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5)
                            .addComponent(jButton6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPermisoMantenimiento)
                            .addComponent(txtPermisoEliminar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPermisoProcesos)
                            .addComponent(txtPermisoRegistrar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtAPL103)
                                    .addComponent(txtAPL107)
                                    .addComponent(txtAPL111))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtAPL104)
                                    .addComponent(txtAPL108)
                                    .addComponent(txtAPL112))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtAPL105)
                                    .addComponent(txtAPL109))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtAPL106)
                                    .addComponent(txtAPL110)
                                    .addComponent(jButton2)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPermisoModificar)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addGap(5, 5, 5)
                .addComponent(jLabel6)
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 // Acción del botón para cargar datos y poner en la tabla
       DefaultTableModel model = cargarPermisosUsuarioDesdeBD();
        if (model != null) {
            TABLAB.setModel(model);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                                       
    try {
        int id = Integer.parseInt(txtId.getText());
        
        // Captura permisos de usuario
        int pm = txtPermisoMantenimiento.isSelected() ? 1 : 0;
        int pp = txtPermisoProcesos.isSelected() ? 1 : 0;
        int pe = txtPermisoEliminar.isSelected() ? 1 : 0;
        int pr = txtPermisoRegistrar.isSelected() ? 1 : 0;
        int pmf = txtPermisoModificar.isSelected() ? 1 : 0;

        // Captura permisos de aplicaciones APL103 - APL112
        int apl103 = txtAPL103.isSelected() ? 1 : 0;
        int apl104 = txtAPL104.isSelected() ? 1 : 0;
        int apl105 = txtAPL105.isSelected() ? 1 : 0;
        int apl106 = txtAPL106.isSelected() ? 1 : 0;
        int apl107 = txtAPL107.isSelected() ? 1 : 0;
        int apl108 = txtAPL108.isSelected() ? 1 : 0;
        int apl109 = txtAPL109.isSelected() ? 1 : 0;
        int apl110 = txtAPL110.isSelected() ? 1 : 0;
        int apl111 = txtAPL111.isSelected() ? 1 : 0;
        int apl112 = txtAPL112.isSelected() ? 1 : 0;

        String JDBC_URL = "jdbc:mysql://localhost/sig2k25?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String usuario = "MISHEL";
        String password = "311";

        try (Connection cn = DriverManager.getConnection(JDBC_URL, usuario, password);
             PreparedStatement pst = cn.prepareStatement("UPDATE permisos_usuario SET puede_mantenimiento=?, puede_procesos=?, puede_eliminar=?, puede_registrar=?, puede_modificar=?, "
                                                          + "APL103=?, APL104=?, APL105=?, APL106=?, APL107=?, APL108=?, APL109=?, APL110=?, APL111=?, APL112=? WHERE id_usuario=?")) {

            // Asignación de permisos de usuario
            pst.setInt(1, pm);
            pst.setInt(2, pp);
            pst.setInt(3, pe);
            pst.setInt(4, pr);
            pst.setInt(5, pmf);

            // Asignación de permisos de aplicaciones
            pst.setInt(6, apl103);
            pst.setInt(7, apl104);
            pst.setInt(8, apl105);
            pst.setInt(9, apl106);
            pst.setInt(10, apl107);
            pst.setInt(11, apl108);
            pst.setInt(12, apl109);
            pst.setInt(13, apl110);
            pst.setInt(14, apl111);
            pst.setInt(15, apl112);

            // Asigna el ID del usuario
            pst.setInt(16, id);

            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(this, "Permisos actualizados correctamente.");
                TABLAB.setModel(cargarPermisosUsuarioDesdeBD());
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el usuario con ese ID.");
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al actualizar permisos: " + e.getMessage());
    }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                                         
    try {
        int id = Integer.parseInt(txtId.getText());

        // Captura permisos de usuario
        int pm = txtPermisoMantenimiento.isSelected() ? 1 : 0;
        int pp = txtPermisoProcesos.isSelected() ? 1 : 0;
        int pe = txtPermisoEliminar.isSelected() ? 1 : 0;
        int pr = txtPermisoRegistrar.isSelected() ? 1 : 0;
        int pmf = txtPermisoModificar.isSelected() ? 1 : 0;

        // Captura permisos de aplicaciones APL103 - APL112
        int apl103 = txtAPL103.isSelected() ? 1 : 0;
        int apl104 = txtAPL104.isSelected() ? 1 : 0;
        int apl105 = txtAPL105.isSelected() ? 1 : 0;
        int apl106 = txtAPL106.isSelected() ? 1 : 0;
        int apl107 = txtAPL107.isSelected() ? 1 : 0;
        int apl108 = txtAPL108.isSelected() ? 1 : 0;
        int apl109 = txtAPL109.isSelected() ? 1 : 0;
        int apl110 = txtAPL110.isSelected() ? 1 : 0;
        int apl111 = txtAPL111.isSelected() ? 1 : 0;
        int apl112 = txtAPL112.isSelected() ? 1 : 0;

        String JDBC_URL = "jdbc:mysql://localhost/sig2k25?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String usuario = "MISHEL";
        String password = "311";

        try (Connection cn = DriverManager.getConnection(JDBC_URL, usuario, password);
             PreparedStatement pst = cn.prepareStatement("INSERT INTO permisos_usuario (id_usuario, puede_mantenimiento, puede_procesos, puede_eliminar, puede_registrar, puede_modificar, "
                                                          + "APL103, APL104, APL105, APL106, APL107, APL108, APL109, APL110, APL111, APL112) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            // Asignación de permisos de usuario
            pst.setInt(1, id);
            pst.setInt(2, pm);
            pst.setInt(3, pp);
            pst.setInt(4, pe);
            pst.setInt(5, pr);
            pst.setInt(6, pmf);

            // Asignación de permisos de aplicaciones
            pst.setInt(7, apl103);
            pst.setInt(8, apl104);
            pst.setInt(9, apl105);
            pst.setInt(10, apl106);
            pst.setInt(11, apl107);
            pst.setInt(12, apl108);
            pst.setInt(13, apl109);
            pst.setInt(14, apl110);
            pst.setInt(15, apl111);
            pst.setInt(16, apl112);

            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(this, "Permisos agregados correctamente.");
                TABLAB.setModel(cargarPermisosUsuarioDesdeBD());
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar los permisos.");
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al agregar permisos: " + e.getMessage());
    }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
                                        
    try {
        int id = Integer.parseInt(txtId.getText());

        String JDBC_URL = "jdbc:mysql://localhost/sig2k25?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String usuario = "MISHEL";
        String password = "311";

        try (Connection cn = DriverManager.getConnection(JDBC_URL, usuario, password);
             PreparedStatement pst = cn.prepareStatement("DELETE FROM permisos_usuario WHERE id_usuario=?")) {

            pst.setInt(1, id);

            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(this, "Permisos eliminados correctamente.");
                TABLAB.setModel(cargarPermisosUsuarioDesdeBD());
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el usuario con ese ID.");
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al eliminar permisos: " + e.getMessage());
    }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
                                        
    try {
        String idText = txtId.getText().trim();
        
        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID antes de buscar.");
            return;
        }

        int id = Integer.parseInt(idText);
        buscarPermisosPorId(id);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Ingrese un ID válido.");
    }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
                                        
    // Limpia el campo de ID
    txtId.setText("");

    // Desmarca todos los checkboxes de permisos generales
    txtPermisoMantenimiento.setSelected(false);
    txtPermisoProcesos.setSelected(false);
    txtPermisoEliminar.setSelected(false);
    txtPermisoRegistrar.setSelected(false);
    txtPermisoModificar.setSelected(false);

    // Desmarca también los permisos de aplicaciones APL103 - APL112
    txtAPL103.setSelected(false);
    txtAPL104.setSelected(false);
    txtAPL105.setSelected(false);
    txtAPL106.setSelected(false);
    txtAPL107.setSelected(false);
    txtAPL108.setSelected(false);
    txtAPL109.setSelected(false);
    txtAPL110.setSelected(false);
    txtAPL111.setSelected(false);
    txtAPL112.setSelected(false);

    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TABLAB;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox txtAPL103;
    private javax.swing.JCheckBox txtAPL104;
    private javax.swing.JCheckBox txtAPL105;
    private javax.swing.JCheckBox txtAPL106;
    private javax.swing.JCheckBox txtAPL107;
    private javax.swing.JCheckBox txtAPL108;
    private javax.swing.JCheckBox txtAPL109;
    private javax.swing.JCheckBox txtAPL110;
    private javax.swing.JCheckBox txtAPL111;
    private javax.swing.JCheckBox txtAPL112;
    private javax.swing.JTextField txtId;
    private javax.swing.JCheckBox txtPermisoEliminar;
    private javax.swing.JCheckBox txtPermisoMantenimiento;
    private javax.swing.JCheckBox txtPermisoModificar;
    private javax.swing.JCheckBox txtPermisoProcesos;
    private javax.swing.JCheckBox txtPermisoRegistrar;
    // End of variables declaration//GEN-END:variables

   
}
