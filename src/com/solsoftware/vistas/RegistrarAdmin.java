package com.solsoftware.vistas;

import com.solsoftware.controladores.ControladorPersona;
import com.solsoftware.modelos.Persona;
import com.solsoftware.utilidades.Utilidades;
import com.solsotfware.conexion.ConexionBaseDatos;
import javax.swing.JOptionPane;

public class RegistrarAdmin extends javax.swing.JFrame {

    ConexionBaseDatos conexion = new ConexionBaseDatos();
    ControladorPersona personaControl = new ControladorPersona(conexion);
    Utilidades util = new Utilidades();
    Persona persona = new Persona();

    public RegistrarAdmin() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        
    }

    public Persona persona() {//método para poder guardar, eliminar y actualizar.

        persona.setCedula(txtDocuIdentificacion.getText());
        persona.setContrasenia(txtContrasenia.getText());
        persona.setNombre(txtPrimNombre.getText());
        persona.setApellido_paterno(txtApelliPaterno.getText());
        persona.setApellido_materno(txtApelliMaterno.getText());
        persona.setCorreo(txtCorreo.getText());
        persona.setTelefono(txtTelefono.getText());
        return persona;

    }

    public void limpiar() {
        txtDocuIdentificacion.setText(null);
        txtContrasenia.setText(null);
        txtPrimNombre.setText(null);
        txtApelliPaterno.setText(null);
        txtApelliMaterno.setText(null);
        txtCorreo.setText(null);
        txtTelefono.setText(null);
    }

    public boolean camposVacios() { // método para que validar si los campos estan vacios del usuario.

        if (util.valida(txtDocuIdentificacion.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Cédula Incorrecta");
            txtDocuIdentificacion.requestDefaultFocus();
            return false;
        }
        if (txtContrasenia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "El campo contraseña no tiene datos");
            txtContrasenia.requestDefaultFocus();
            return false;

        }
        if (txtApelliPaterno.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "El campo apellido paterno no tiene datos");
            txtApelliPaterno.requestDefaultFocus();
            return false;
        }
        if (txtPrimNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "El campo nombre  no tiene datos");
            txtPrimNombre.requestDefaultFocus();
            return false;

        }
        if (txtTelefono.getText().length() > 10) {
            JOptionPane.showMessageDialog(rootPane, "Solo se admiten 10 digitos para telefono");
            txtTelefono.requestDefaultFocus();
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtDocuIdentificacion = new javax.swing.JTextField();
        txtPrimNombre = new javax.swing.JTextField();
        txtApelliPaterno = new javax.swing.JTextField();
        txtApelliMaterno = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnRegistrarAdmin = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        txtContrasenia = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Administrador");

        jPanel1.setBackground(new java.awt.Color(229, 229, 255));

        txtDocuIdentificacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDocuIdentificacionFocusLost(evt);
            }
        });

        txtPrimNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrimNombreKeyTyped(evt);
            }
        });

        txtApelliPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApelliPaternoKeyTyped(evt);
            }
        });

        txtApelliMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApelliMaternoKeyTyped(evt);
            }
        });

        jLabel1.setText("Contraseña");

        jLabel2.setText("Documento de Identificación");

        jLabel3.setText("Nombres");

        jLabel4.setText("Apellido Paterno");

        jLabel5.setText("Apellido Materno");

        jLabel6.setText("Correo");

        jLabel7.setText("Telefono");

        btnRegistrarAdmin.setText("Registrar");
        btnRegistrarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarAdminActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Ver");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 0, 51));
        jLabel8.setText("*");

        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setText("*");

        jLabel10.setForeground(new java.awt.Color(255, 0, 51));
        jLabel10.setText("*");

        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApelliPaterno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(txtApelliMaterno, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPrimNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDocuIdentificacion, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtContrasenia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnRegistrarAdmin)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDocuIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCheckBox1)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrimNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApelliPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApelliMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrarAdmin)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarAdminActionPerformed
        if (txtDocuIdentificacion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese datos para poder guardar");
            txtDocuIdentificacion.requestDefaultFocus();
            return;
        }
        if (camposVacios() == true) {

            if (JOptionPane.showConfirmDialog(null, "¿Esta seguro de guardar estos datos?", "GUARDAR DATOS", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                personaControl.registarAdmin(persona());
            }
        }
        limpiar();
    }//GEN-LAST:event_btnRegistrarAdminActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        util.verContrasena(txtContrasenia);
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void txtPrimNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrimNombreKeyTyped
        util.mayusculas(evt);
        util.validarTextoTxt(this, evt);
    }//GEN-LAST:event_txtPrimNombreKeyTyped

    private void txtApelliPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApelliPaternoKeyTyped
        util.mayusculas(evt);
        util.validarTextoTxt(this, evt);
    }//GEN-LAST:event_txtApelliPaternoKeyTyped

    private void txtApelliMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApelliMaternoKeyTyped
        util.mayusculas(evt);
        util.validarTextoTxt(this, evt);
    }//GEN-LAST:event_txtApelliMaternoKeyTyped

    private void txtDocuIdentificacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDocuIdentificacionFocusLost
        if (txtDocuIdentificacion.getText().isEmpty()) {
            txtDocuIdentificacion.requestDefaultFocus();
            return;
        }
        if (util.valida(txtDocuIdentificacion.getText()) == false) {
            txtDocuIdentificacion.requestFocus(false);
            return;
        }
    }//GEN-LAST:event_txtDocuIdentificacionFocusLost

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
            java.util.logging.Logger.getLogger(RegistrarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarAdmin;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtApelliMaterno;
    private javax.swing.JTextField txtApelliPaterno;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDocuIdentificacion;
    private javax.swing.JTextField txtPrimNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
