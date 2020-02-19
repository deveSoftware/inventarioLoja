package com.solsoftware.vistas;

import com.solsoftware.controladores.ControladorLogin;
import com.solsoftware.modelos.Persona;
import com.solsoftware.utilidades.Utilidades;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class LoginVista extends javax.swing.JFrame {

    ResultSet resultado;
    ControladorLogin controlLogin = new ControladorLogin();
    Persona persona = new Persona();
    Utilidades util = new Utilidades();
    RegistrarAdmin admin = new RegistrarAdmin();

    public LoginVista() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
       }

    public Persona login() {

        persona.setCedula(txtUsuarioLogin.getText());
        persona.setContrasenia(txtContraseniaLogin.getText());
        return persona;
    }

    public boolean camposVacios() { // método para que validar si los campos estan vacios del usuario.
        if (txtUsuarioLogin.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "El campo usuario no tiene datos");
            txtUsuarioLogin.requestDefaultFocus();
            return false;
        }
        if (txtContraseniaLogin.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "El campo contraseña no tiene datos");
            txtContraseniaLogin.requestDefaultFocus();
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin = new javax.swing.JPanel();
        lblContraseña = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        bntIngresar = new javax.swing.JButton();
        txtUsuarioLogin = new javax.swing.JTextField();
        txtContraseniaLogin = new javax.swing.JPasswordField();
        lblLogoLogin = new javax.swing.JLabel();
        menuResgistrar = new javax.swing.JMenuBar();
        menuOpcion = new javax.swing.JMenu();
        subMenuRegistrar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inicio de Sesión");
        setIconImage(getIconImage());
        getContentPane().setLayout(new java.awt.GridLayout());

        panelLogin.setBackground(new java.awt.Color(229, 229, 255));
        panelLogin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inicio De Sesion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 18))); // NOI18N

        lblContraseña.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblContraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/solsoftware/Iconos/PasswordIcono.png"))); // NOI18N

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/solsoftware/Iconos/UsuarioIcono.png"))); // NOI18N

        bntIngresar.setBackground(new java.awt.Color(24, 139, 165));
        bntIngresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bntIngresar.setText("Ingresar");
        bntIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntIngresarActionPerformed(evt);
            }
        });

        txtUsuarioLogin.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        txtUsuarioLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioLoginActionPerformed(evt);
            }
        });

        txtContraseniaLogin.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        txtContraseniaLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseniaLoginActionPerformed(evt);
            }
        });
        txtContraseniaLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraseniaLoginKeyPressed(evt);
            }
        });

        lblLogoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/solsoftware/imagenes/sello instituto.png"))); // NOI18N

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(lblUsuario)
                        .addGap(52, 52, 52)
                        .addComponent(txtUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(lblContraseña)
                        .addGap(52, 52, 52)
                        .addComponent(txtContraseniaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(bntIngresar))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(lblLogoLogin)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addComponent(lblLogoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContraseniaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bntIngresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelLogin);

        menuOpcion.setText("Opciones");

        subMenuRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/solsoftware/Iconos/admin.png"))); // NOI18N
        subMenuRegistrar.setText("Nuevo Administrador");
        subMenuRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuRegistrarActionPerformed(evt);
            }
        });
        menuOpcion.add(subMenuRegistrar);

        menuResgistrar.add(menuOpcion);

        setJMenuBar(menuResgistrar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioLoginActionPerformed
        setFocusable(true);

    }//GEN-LAST:event_txtUsuarioLoginActionPerformed

    private void txtContraseniaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseniaLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseniaLoginActionPerformed

    private void bntIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntIngresarActionPerformed
        if (camposVacios() == true) {
            persona = controlLogin.entrar(login(), txtUsuarioLogin.getText(), txtContraseniaLogin.getText());
        }
        if (this != null) {
            this.dispose();
        }
    }//GEN-LAST:event_bntIngresarActionPerformed

    private void txtContraseniaLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseniaLoginKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (camposVacios() == true) {
                persona = controlLogin.entrar(login(), txtUsuarioLogin.getText(), txtContraseniaLogin.getText());
            }
            if (this != null) {
                this.dispose();
            }
        }
    }//GEN-LAST:event_txtContraseniaLoginKeyPressed

    private void subMenuRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuRegistrarActionPerformed
      if(admin.isVisible()==false){
          admin.setVisible(true);
      }
    }//GEN-LAST:event_subMenuRegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(LoginVista.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginVista.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginVista.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginVista.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntIngresar;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblLogoLogin;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenu menuOpcion;
    private javax.swing.JMenuBar menuResgistrar;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JMenuItem subMenuRegistrar;
    private javax.swing.JPasswordField txtContraseniaLogin;
    private javax.swing.JTextField txtUsuarioLogin;
    // End of variables declaration//GEN-END:variables
}
