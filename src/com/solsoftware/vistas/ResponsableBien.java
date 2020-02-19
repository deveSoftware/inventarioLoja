package com.solsoftware.vistas;

import com.solsoftware.controladores.ControladorAsigarBien;
import com.solsoftware.controladores.ControladorBien;
import com.solsoftware.controladores.ControladorPersona;
import com.solsoftware.modelos.Asignacion;
import com.solsoftware.modelos.Bien;
import com.solsotfware.conexion.ConexionBaseDatos;
import javax.swing.JOptionPane;

public class ResponsableBien extends javax.swing.JFrame {

    ConexionBaseDatos conexion = new ConexionBaseDatos();
    ControladorPersona personaControl = new ControladorPersona(conexion);
    ControladorBien bienControl = new ControladorBien(conexion);
    Asignacion asignar = new Asignacion();
    Bien bien = new Bien();

    ControladorAsigarBien controlAsignar = new ControladorAsigarBien(conexion);

    public ResponsableBien() {
        initComponents();
        this.setLocationRelativeTo(null);
        tablaAsigancion();
        tablaBienAsignacion();
        opcionGuardarEliminar();
        bienesTotal();
        txtCedulaAsignar.setEditable(false);
        txtCodigoAsignarBien.setEditable(false);
        txtNombreAsignar.setEditable(false);
        txtNombreBienAsignar.setEditable(false);
    }

    public void tablaAsigancion() {
        String buscar = txtBuscarAsignar.getText();
        personaControl.tablaPersona(tableAsignacion, buscar, buscar);
    }

    public void tablaBienAsignacion() {
        String buscar = txtBuscarBienAsiganr.getText();
        controlAsignar.tablaAsignarBien(tableAsigarBien, buscar, cbxVerBienes, buscar);
    }

    public void datosCajaBien() {
        int filaBien = tableAsigarBien.getSelectedRow();
        txtCodigoAsignarBien.setText(tableAsigarBien.getModel().getValueAt(filaBien, 0).toString());
        txtNombreBienAsignar.setText(tableAsigarBien.getModel().getValueAt(filaBien, 1).toString());
    }

    public void datosCajaPersona() {
        if (cbxVerBienes.getSelectedIndex() != 1) {
            int filaPersona = tableAsignacion.getSelectedRow();
            txtCedulaAsignar.setText(tableAsignacion.getModel().getValueAt(filaPersona, 0).toString());
            txtNombreAsignar.setText(tableAsignacion.getModel().getValueAt(filaPersona, 1).toString());
        }
    }

    public Asignacion asignar() {
        asignar.setCedulaAsinado(txtCedulaAsignar.getText());
        asignar.setCodigoAsignadp(txtCodigoAsignarBien.getText());
        return asignar;

    }

    public Asignacion buscar() {
        txtCedulaAsignar.setText(asignar.getCedulaAsinado());
        txtCodigoAsignarBien.setText(asignar.getCodigoAsignadp());
        txtNombreAsignar.setText(asignar.getNombre_persona());
        txtNombreBienAsignar.setText(asignar.getNombre_bien());
        return asignar;
    }

    public void limpiar() {
        txtCedulaAsignar.setText(null);
        txtCodigoAsignarBien.setText(null);
        txtNombreAsignar.setText(null);
        txtNombreBienAsignar.setText(null);
        txtBuscarBienAsiganr.setText(null);
        tableAsigarBien.clearSelection();
        tableAsignacion.clearSelection();
    }

    public boolean elegirAsignado() {
        if (cbxElegirAsignar.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Por favor seleccione una opción");
            cbxElegirAsignar.requestDefaultFocus();
            return false;
        }
        if (txtCedulaAsignar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "El campo de la cédula no tiene datos");
            txtCedulaAsignar.requestDefaultFocus();
            return false;

        }
        if (txtCodigoAsignarBien.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "El campo del código del bien no tiene datos");
            txtCodigoAsignarBien.requestDefaultFocus();
            return false;
        }

        return true;
    }

    public void guardar_eliminarAsignado() {
        if (elegirAsignado() == true) {
            if (cbxElegirAsignar.getSelectedIndex() == 1) {
                if (JOptionPane.showConfirmDialog(null, "¿Esta seguro de asignar el bien " + txtCodigoAsignarBien.getText() + " a " + txtNombreAsignar.getText() + "?", "GUARDAR DATOS", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    controlAsignar.guardarAsignado(asignar(), cbxElegirAsignar);
                    limpiar();                   
                    bienesTotal();
                }
            }
            if (cbxElegirAsignar.getSelectedIndex() == 2) {
                if (JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar estos datos?", "ELIMINAR  DATOS", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    controlAsignar.guardarAsignado(asignar(), cbxElegirAsignar);
                    limpiar();                    
                    bienesTotal();
                }
            }
        }
    }

    public void opcionGuardarEliminar() {
        if (cbxVerBienes.getSelectedIndex() == 0) {
            cbxElegirAsignar.setSelectedIndex(1);
            cbxElegirAsignar.setEnabled(false);
            tableAsignacion.setEnabled(true);
            limpiar();
            bienesTotal();
        }
        if (cbxVerBienes.getSelectedIndex() == 1) {
            cbxElegirAsignar.setSelectedIndex(2);

            cbxElegirAsignar.setEnabled(false);
            limpiar();
            bienesTotal();
        }
    }

    public Bien totalBien() {//contar todos los bienes.       
        lblTotal.setText(bien.getTotal());
        return bien;
    }

    public void bienesTotal() {
        controlAsignar.totalBien(totalBien());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCedulaAsignar = new javax.swing.JTextField();
        txtNombreAsignar = new javax.swing.JTextField();
        txtCodigoAsignarBien = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAsignacion = new javax.swing.JTable();
        txtBuscarAsignar = new javax.swing.JTextField();
        btnBuscarAsignar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableAsigarBien = new javax.swing.JTable();
        txtBuscarBienAsiganr = new javax.swing.JTextField();
        btnBuscarBienAsignar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtNombreBienAsignar = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        cbxElegirAsignar = new javax.swing.JComboBox<>();
        btnAceptarAsignar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbxVerBienes = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asingar Responsables");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(null);
        setResizable(false);

        jLabel1.setText("Documento de identificación");

        jLabel2.setText("Nombres");

        jLabel3.setText("Código del  Bien");

        tableAsignacion = new javax.swing.JTable(){
            public boolean isCellEditable(int a,int b){
                return false;
            }
        };
        tableAsignacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAsignacion.setFocusable(false);
        tableAsignacion.getTableHeader().setReorderingAllowed(false);
        tableAsignacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAsignacionMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableAsignacion);

        btnBuscarAsignar.setText("Buscar");
        btnBuscarAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAsignarActionPerformed(evt);
            }
        });

        tableAsigarBien = new javax.swing.JTable(){
            public boolean isCellEditable(int a,int b){
                return false;
            }
        };
        tableAsigarBien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAsigarBien.setFocusable(false);
        tableAsigarBien.getTableHeader().setResizingAllowed(false);
        tableAsigarBien.getTableHeader().setReorderingAllowed(false);
        tableAsigarBien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAsigarBienMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableAsigarBien);

        btnBuscarBienAsignar.setText("Buscar");
        btnBuscarBienAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarBienAsignarActionPerformed(evt);
            }
        });

        txtNombreBienAsignar.setColumns(20);
        txtNombreBienAsignar.setLineWrap(true);
        txtNombreBienAsignar.setRows(5);
        jScrollPane4.setViewportView(txtNombreBienAsignar);

        jLabel4.setText("Nombre del  Bien");

        cbxElegirAsignar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir", "Asignar", "Quitar asignación" }));

        btnAceptarAsignar.setText("Aceptar");
        btnAceptarAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarAsignarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("*");

        cbxVerBienes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bienes no asignados", "Bienes asignados" }));
        cbxVerBienes.setActionCommand("null");
        cbxVerBienes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbxVerBienes.setEditor(null);
        cbxVerBienes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxVerBienesActionPerformed(evt);
            }
        });

        jLabel6.setText("Ver");

        jLabel7.setText("Bienes totales asignados:");

        lblTotal.setText("jLabel8");

        jMenuItem2.setText("jMenuItem2");
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(cbxVerBienes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(txtBuscarBienAsiganr, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarBienAsignar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jLabel7)
                        .addGap(28, 28, 28)
                        .addComponent(lblTotal)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBuscarAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCedulaAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNombreAsignar)
                                        .addComponent(txtCodigoAsignarBien)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarAsignar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxElegirAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(btnAceptarAsignar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBuscarBienAsignar)
                    .addComponent(txtBuscarBienAsiganr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCedulaAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxElegirAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbxVerBienes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombreAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigoAsignarBien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarAsignar)
                            .addComponent(txtBuscarAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAceptarAsignar)
                        .addComponent(btnLimpiar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(lblTotal)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAsignarActionPerformed
        tablaAsigancion();
    }//GEN-LAST:event_btnBuscarAsignarActionPerformed

    private void btnBuscarBienAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarBienAsignarActionPerformed
        tablaBienAsignacion();
    }//GEN-LAST:event_btnBuscarBienAsignarActionPerformed

    private void tableAsigarBienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAsigarBienMouseClicked
        if (evt.getClickCount() == 1) {
            datosCajaBien();
        }
        datosCajaBien();
        if (cbxVerBienes.getSelectedIndex() == 1) {
            if (evt.getClickCount() == 1) {
                asignar = controlAsignar.buscarAsignado(txtCodigoAsignarBien.getText());
                buscar();
            }
        }

    }//GEN-LAST:event_tableAsigarBienMouseClicked

    private void tableAsignacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAsignacionMouseClicked
        if (evt.getClickCount() == 1) {
            datosCajaPersona();
        }
    }//GEN-LAST:event_tableAsignacionMouseClicked

    private void btnAceptarAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarAsignarActionPerformed
        guardar_eliminarAsignado();
        tablaBienAsignacion();
        bienesTotal();
    }//GEN-LAST:event_btnAceptarAsignarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void cbxVerBienesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxVerBienesActionPerformed
        tablaBienAsignacion();
        opcionGuardarEliminar();        
        
    }//GEN-LAST:event_cbxVerBienesActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ResponsableBien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResponsableBien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResponsableBien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResponsableBien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResponsableBien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarAsignar;
    private javax.swing.JButton btnBuscarAsignar;
    private javax.swing.JButton btnBuscarBienAsignar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cbxElegirAsignar;
    private javax.swing.JComboBox<String> cbxVerBienes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tableAsigarBien;
    private javax.swing.JTable tableAsignacion;
    private javax.swing.JTextField txtBuscarAsignar;
    private javax.swing.JTextField txtBuscarBienAsiganr;
    private javax.swing.JTextField txtCedulaAsignar;
    private javax.swing.JTextField txtCodigoAsignarBien;
    private javax.swing.JTextField txtNombreAsignar;
    private javax.swing.JTextArea txtNombreBienAsignar;
    // End of variables declaration//GEN-END:variables
}
