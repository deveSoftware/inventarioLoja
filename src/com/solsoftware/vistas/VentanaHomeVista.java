package com.solsoftware.vistas;

import com.placeholder.PlaceHolder;
import com.solsoftware.controladores.ControladorBien;
import com.solsoftware.controladores.ControladorPersona;
import com.solsoftware.controladores.ControladorReporte;
import com.solsoftware.modelos.Bien;
import com.solsoftware.modelos.Persona;
import com.solsoftware.utilidades.Utilidades;
import com.solsotfware.conexion.ConexionBaseDatos;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public final class VentanaHomeVista extends javax.swing.JFrame {

    ConexionBaseDatos conexion = new ConexionBaseDatos();
    ControladorBien llamada = new ControladorBien(conexion);
    ControladorPersona personaControl = new ControladorPersona(conexion);
    ControladorReporte reporte = new ControladorReporte(conexion);
    Utilidades util = new Utilidades();
    Persona persona = new Persona();
    Bien bien = new Bien();
    ResponsableBien responsableBien = new ResponsableBien();

    public VentanaHomeVista() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        tablaBuscar();
        tablaBuscarPersona();
        bienesTotal();
        txtBuscarArticulo.setFocusable(true);
        txtBuscarUsuarios.setFocusable(true);
        setTitle("Inventario ISTL");
        PlaceHolder text = new PlaceHolder(dateDepresiacion, "año-mes-dia");

    }

    public void cerrar() {
        if (JOptionPane.showConfirmDialog(rootPane, "¿Esta seguro de cerrar sesión?", "SALIR", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
        }
    }

    public void tablaBuscar() { //método para me cargue los datos en la tabla
        String codigo_nombre = txtBuscarArticulo.getText();
        llamada.tablaBuscar(tableBien, codigo_nombre, codigo_nombre);
        bienesTotal();
    }

    public void tablaBuscarPersona() { //método para me cargue los datos en la tabla.
        String cedula_persona = txtBuscarUsuarios.getText();
        personaControl.tablaPersona(tableUsuarios, cedula_persona, cedula_persona);

    }

    public void datosCaja() { // método para pasar el código a las cajas de texto.
        if (PanelArticulos.isVisible()) {
            int filasBien = tableBien.getSelectedRow();
            txtCodigo.setText(tableBien.getModel().getValueAt(filasBien, 0).toString());
        } else if (PanelUsuarios.isVisible()) {
            int filasPersona = tableUsuarios.getSelectedRow();
            txtDocuIdentificacion.setText(tableUsuarios.getModel().getValueAt(filasPersona, 0).toString());
        }

    }

    public Bien buscar() {//método para buscar desde la BDD los bienes. 
        txtNombreBien.setText(bien.getNombre());
        txtBld_bca.setText(bien.getBld_bca());
        txtCodigoAnterior.setText(bien.getCodigo_anterior());
        txtNumeroActa.setText(bien.getActa_matriz());
        txtColor.setText(bien.getColor());
        txtDimension.setText(bien.getDimension());
        txtConciliacion.setText(bien.getConciliacion());
        txtCuentaContable.setText(bien.getCuenta_contable());
        txtMarcaRazaOtros.setText(bien.getMarca());
        txtMaterial.setText(bien.getMaterial());
        txtModeloCaracteristicas.setText(bien.getModelo());
        TxtDescripcion.setText(bien.getDescripcion());
        dateIngreso.setDate(bien.getFecha_ingreso());
        dateDepresiacion.setText(bien.getFecha_depresiacion());
        txtUbicacionBodega.setText(bien.getUbicacion());
        txtSerie.setText(bien.getSerie());
        txtBienNoConstatado.setText(bien.getBien_noconstatado());
        txtObservacion.setText(bien.getObservacion());
        cbxEstado.setSelectedIndex(bien.getEstado());
        txtValorContable.setText(bien.getValor_contable());

        return bien;
    }

    public Persona buscarPersona() {//método para buscar desde la BDD
        txtDocuIdentificacion.setText(persona.getCedula());
        txtContrasenia.setText(persona.getContrasenia());
        txtApelliPaterno.setText(persona.getApellido_paterno());
        txtApelliMaterno.setText(persona.getApellido_materno());
        txtPrimNombre.setText(persona.getNombre());
        txtCorreo.setText(persona.getCorreo());
        txtTelefono.setText(persona.getTelefono());
        cbxTipo.setSelectedIndex(persona.getTipo());
        return persona;
    }

    public Bien Bien() { // método para poder guardar, eliminar y actualizar.
        bien.setCodigo_barra(txtCodigo.getText());
        bien.setNombre(txtNombreBien.getText());
        bien.setDescripcion(TxtDescripcion.getText());
        bien.setEstado((int) cbxEstado.getSelectedIndex());
        bien.setActa_matriz(txtNumeroActa.getText());
        bien.setBld_bca(txtBld_bca.getText());
        bien.setCodigo_anterior(txtCodigoAnterior.getText());
        bien.setColor(txtColor.getText());
        bien.setDimension(txtDimension.getText());
        bien.setConciliacion(txtConciliacion.getText());
        bien.setCuenta_contable(txtCuentaContable.getText());
        bien.setMarca(txtMarcaRazaOtros.getText());
        bien.setMaterial(txtMaterial.getText());
        bien.setModelo(txtModeloCaracteristicas.getText());
        java.util.Date fechaI = dateIngreso.getDate();
        long f = fechaI.getTime();
        java.sql.Date fechaIn = new java.sql.Date(f);
        bien.setFecha_ingreso(fechaIn);
        bien.setFecha_depresiacion(dateDepresiacion.getText());
        bien.setUbicacion(txtUbicacionBodega.getText());
        bien.setSerie(txtSerie.getText());
        bien.setBien_noconstatado(txtBienNoConstatado.getText());
        bien.setObservacion(txtObservacion.getText());
        bien.setValor_contable(txtValorContable.getText());

        return bien;
    }

    public Persona persona() {//método para poder guardar, eliminar y actualizar.

        persona.setCedula(txtDocuIdentificacion.getText());
        persona.setContrasenia(txtContrasenia.getText());
        persona.setNombre(txtPrimNombre.getText());
        persona.setApellido_paterno(txtApelliPaterno.getText());
        persona.setApellido_materno(txtApelliMaterno.getText());
        persona.setCorreo(txtCorreo.getText());
        persona.setTelefono(txtTelefono.getText());
        persona.setTipo(cbxTipo.getSelectedIndex());
        return persona;

    }

    public void nuevo() { // método para limpiar las cajas de texto.
        if (PanelUsuarios.isVisible() == true) {
            txtDocuIdentificacion.setText(null);
            txtContrasenia.setText(null);
            txtApelliPaterno.setText(null);
            txtApelliMaterno.setText(null);
            txtPrimNombre.setText(null);
            txtCorreo.setText(null);
            txtTelefono.setText(null);
            cbxTipo.setSelectedIndex(0);
            tableUsuarios.clearSelection();
            bntGuardPers.setEnabled(true);
            bntEditarPersona.setEnabled(false);
        }
        if (PanelArticulos.isVisible() == true) {
            txtCodigo.setText(null);
            txtNombreBien.setText(null);
            cbxEstado.setSelectedIndex(0);

            TxtDescripcion.setText(null);
            txtValorContable.setText(null);
            txtBld_bca.setText(null);
            txtCodigoAnterior.setText(null);
            txtNumeroActa.setText(null);
            txtColor.setText(null);
            txtDimension.setText(null);
            txtConciliacion.setText(null);
            txtCuentaContable.setText(null);
            txtMarcaRazaOtros.setText(null);
            txtMaterial.setText(null);
            txtModeloCaracteristicas.setText(null);

            dateIngreso.setDate(null);
            dateDepresiacion.setText(null);
            txtUbicacionBodega.setText(null);
            txtSerie.setText(null);
            txtBienNoConstatado.setText(null);
            txtObservacion.setText(null);

            bntGuardarBien.setEnabled(true);
            bntEditarBien.setEnabled(false);

        }
    }

    public boolean camposVacios() { // método para que validar si los campos estan vacios del usuario.

        if (util.valida(txtDocuIdentificacion.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Cédula Incorrecta");
            txtDocuIdentificacion.requestDefaultFocus();
            return false;
        }
        if (txtDocuIdentificacion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese datos para poder guardar");
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
        if (cbxTipo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "El campo tipo no ha sido seleccionado");
            cbxTipo.requestDefaultFocus();
            return false;

        }
        if (txtTelefono.getText().length() > 10) {
            JOptionPane.showMessageDialog(rootPane, "Solo se admiten 10 digitos para telefono");
            txtTelefono.requestDefaultFocus();
            return false;
        }
        return true;
    }

    public boolean cVaciosBien() {//método para saber que campos estan vacios de la ventana Bien.

        if (txtCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo Código esta vacio");
            txtCodigo.requestDefaultFocus();
            return false;
        }
        if (dateIngreso.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Debe registrar la fecha de ingreso");
            dateIngreso.requestDefaultFocus();
            return false;
        }
        if (dateDepresiacion.getText().length() > 11) {
            JOptionPane.showMessageDialog(null, "Ingrese la fecha de depreciación "
                    + "\nen formato año-mes-día");
            dateDepresiacion.requestDefaultFocus();
            return false;
        }
        if (cbxEstado.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "No ha  seleccionado el estado del Bien");
            cbxEstado.requestDefaultFocus();
            return false;
        }
        if (txtNombreBien.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del bien");
            txtNombreBien.requestDefaultFocus();
            return false;
        }
        return true;
    }

    public void btnEliminarBien() {
        if (txtCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por Favor seleccione de la tabla que datos desea eliminar");
        } else if (JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar estos datos?", "ELIMINAR  DATOS", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            llamada.eliminar(Bien());
            nuevo();
        }
        tablaBuscar();
        bienesTotal();
    }//eliminar bien.

    public void btnEditarBien() {
        if (txtCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese datos para poder actualizar");
            txtCodigo.requestDefaultFocus();
            return;

        }
        if (cVaciosBien() == true) {
            if (JOptionPane.showConfirmDialog(null, "¿Esta seguro de modificar estos datos?", "MODIFICAR DATOS", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                llamada.modificar(Bien());
                nuevo();

            }
        }
    }//editar bien.

    public void btnGuardaBien() {
        if (cVaciosBien() == true) {
            if (JOptionPane.showConfirmDialog(null, "¿Esta seguro de guardar estos datos?", "GUARDAR DATOS", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                llamada.guardar(Bien());
                nuevo();
            }
        }
        tablaBuscar();
        bienesTotal();

    }//guardar bien.

    public void btnEliminarPersona() {
        if (txtDocuIdentificacion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por Favor seleccione de la tabla que datos desea eliminar");
        } else if (JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar estos datos?", "ELIMINAR DATOS DATOS", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            personaControl.eliminar(persona());
            nuevo();
        }
        tablaBuscarPersona();
    }//eliminar persona.

    public void btnEditarPersona() {
        if (txtDocuIdentificacion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione datos de la tabla para modificar");
            txtDocuIdentificacion.requestDefaultFocus();
            return;
        }
        if (camposVacios() == true) {
            if (JOptionPane.showConfirmDialog(null, "¿Esta seguro de modificar estos datos?", "MODIFICAR DATOS", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                personaControl.modificar(persona());
                nuevo();
            }
        }
    }//editar persona.

    public void btnGuardaPersona() {
        if (txtDocuIdentificacion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese datos para poder guardar");
            txtDocuIdentificacion.requestDefaultFocus();
            return;
        }
        if (camposVacios() == true) {
            if (JOptionPane.showConfirmDialog(null, "¿Esta seguro de guardar estos datos?", "GUARDAR DATOS", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                personaControl.guardar(persona());
                nuevo();
            }
        }
        tablaBuscarPersona();
    }//guardar persona.

    public Bien totalBien() {//contar todos los bienes.       
        lblTotal.setText(bien.getTotal());
        return bien;
    }

    public void bienesTotal() {
        llamada.totalBien(totalBien());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelFondo = new javax.swing.JPanel();
        PestaUsuario = new javax.swing.JTabbedPane();
        PanelInicio = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnResponsableInicio = new javax.swing.JButton();
        btnTodosBienes = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        PanelArticulos = new javax.swing.JPanel();
        panelIzquierdoAerticulos = new javax.swing.JPanel();
        lblBuscarPor = new javax.swing.JLabel();
        txtBuscarArticulo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBien = new javax.swing.JTable();
        btnBuscarPrincipal = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        panelBotones = new javax.swing.JPanel();
        bntLimpiarBien = new javax.swing.JButton();
        bntGuardarBien = new javax.swing.JButton();
        bntEliminarBien = new javax.swing.JButton();
        bntEditarBien = new javax.swing.JButton();
        btnResponsable = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        PanelCentralArticulos = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        lblNumeroActa = new javax.swing.JLabel();
        txtNumeroActa = new javax.swing.JTextField();
        lblBLD_BCA = new javax.swing.JLabel();
        txtBld_bca = new javax.swing.JTextField();
        txtMarcaRazaOtros = new javax.swing.JTextField();
        lblColor = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        lblMaterial = new javax.swing.JLabel();
        txtMaterial = new javax.swing.JTextField();
        lblDimension = new javax.swing.JLabel();
        txtDimension = new javax.swing.JTextField();
        lblUbicacionBodega = new javax.swing.JLabel();
        txtCodigoAnterior = new javax.swing.JTextField();
        lblNombArtic = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtNombreBien = new javax.swing.JTextArea();
        lblCodigoAnterior = new javax.swing.JLabel();
        txtSerieIdentificacion = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtModeloCaracteristicas = new javax.swing.JTextArea();
        lblModelo = new javax.swing.JLabel();
        lblMarcaRazoOtros = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtUbicacionBodega = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        TxtDescripcion = new javax.swing.JTextArea();
        lblDescripcion1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblFechaIngreso = new javax.swing.JLabel();
        dateIngreso = new com.toedter.calendar.JDateChooser();
        lblValorContable1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtObservacion = new javax.swing.JTextArea();
        cbxEstado = new javax.swing.JComboBox();
        lblEstado = new javax.swing.JLabel();
        lblValorContable2 = new javax.swing.JLabel();
        txtValorContable = new javax.swing.JTextField();
        lblValorContable = new javax.swing.JLabel();
        lblBienNoConstatado = new javax.swing.JLabel();
        txtConciliacion = new javax.swing.JTextField();
        lblConciliacion = new javax.swing.JLabel();
        txtBienNoConstatado = new javax.swing.JTextField();
        lblCuentaContable = new javax.swing.JLabel();
        txtCuentaContable = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dateDepresiacion = new javax.swing.JTextField();
        PanelUsuarios = new javax.swing.JPanel();
        panelIzquierdoUsuarios = new javax.swing.JPanel();
        lblBuscar = new javax.swing.JLabel();
        txtBuscarUsuarios = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableUsuarios = new javax.swing.JTable();
        btnBuscarUsuarios = new javax.swing.JButton();
        btnLimpiarUsuarios = new javax.swing.JButton();
        PanelCentralUsuarios = new javax.swing.JPanel();
        lblIdentificacion = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        lblApellPaterno = new javax.swing.JLabel();
        lblApellMaterno = new javax.swing.JLabel();
        lblPrimNombre = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        txtDocuIdentificacion = new javax.swing.JTextField();
        txtContrasenia = new javax.swing.JPasswordField();
        txtApelliPaterno = new javax.swing.JTextField();
        txtApelliMaterno = new javax.swing.JTextField();
        txtPrimNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        cbxTipo = new javax.swing.JComboBox<>();
        checkVerContra = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        PanelDeBotones = new javax.swing.JPanel();
        btnEliminarPersona = new javax.swing.JButton();
        bntEditarPersona = new javax.swing.JButton();
        bntNuevo = new javax.swing.JButton();
        bntGuardPers = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        PanelFondo.setBackground(new java.awt.Color(229, 229, 255));
        PanelFondo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        PestaUsuario.setBackground(new java.awt.Color(229, 229, 255));

        PanelInicio.setBackground(new java.awt.Color(229, 229, 255));
        PanelInicio.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/solsoftware/imagenes/sello instituto SIN FONDO.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(229, 229, 255));

        btnResponsableInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/solsoftware/Iconos/usuario.png"))); // NOI18N
        btnResponsableInicio.setText("Responsable");
        btnResponsableInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResponsableInicioActionPerformed(evt);
            }
        });

        btnTodosBienes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/solsoftware/Iconos/excel.png"))); // NOI18N
        btnTodosBienes.setText("Todos los Bienes");
        btnTodosBienes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosBienesActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/solsoftware/Iconos/excel.png"))); // NOI18N
        jButton2.setText("Bienes Asignados");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Reportes");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/solsoftware/Iconos/salir.png"))); // NOI18N
        jButton3.setText("Cerrar Sesión");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnResponsableInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTodosBienes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnResponsableInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTodosBienes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelInicioLayout = new javax.swing.GroupLayout(PanelInicio);
        PanelInicio.setLayout(PanelInicioLayout);
        PanelInicioLayout.setHorizontalGroup(
            PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 311, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(474, 474, 474))
        );
        PanelInicioLayout.setVerticalGroup(
            PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInicioLayout.createSequentialGroup()
                .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInicioLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel3))
                    .addGroup(PanelInicioLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(2458, Short.MAX_VALUE))
        );

        PestaUsuario.addTab("INICIO", PanelInicio);

        PanelArticulos.setBackground(new java.awt.Color(229, 229, 255));
        PanelArticulos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        panelIzquierdoAerticulos.setBackground(new java.awt.Color(229, 229, 255));
        panelIzquierdoAerticulos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblBuscarPor.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblBuscarPor.setText("Buscar :");

        txtBuscarArticulo.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        txtBuscarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarArticuloActionPerformed(evt);
            }
        });
        txtBuscarArticulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarArticuloKeyPressed(evt);
            }
        });

        tableBien = new javax.swing.JTable(){
            public boolean isCellEditable(int a,int b){
                return false;
            }
        };
        tableBien.setAutoCreateRowSorter(true);
        tableBien.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        tableBien.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tableBien.setModel(new javax.swing.table.DefaultTableModel(
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
        tableBien.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableBien.setGridColor(new java.awt.Color(0, 153, 153));
        tableBien.getTableHeader().setReorderingAllowed(false);
        tableBien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableBien);

        btnBuscarPrincipal.setBackground(new java.awt.Color(24, 139, 165));
        btnBuscarPrincipal.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnBuscarPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/solsoftware/Iconos/LupaBuscarIcono.png"))); // NOI18N
        btnBuscarPrincipal.setToolTipText("Buscar");
        btnBuscarPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPrincipalActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(24, 139, 165));
        btnLimpiar.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/solsoftware/Iconos/BrochaLimpiarIcono.png"))); // NOI18N
        btnLimpiar.setToolTipText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel6.setText(" Bienes totales del Instituto: ");

        lblTotal.setText("yaposi");

        javax.swing.GroupLayout panelIzquierdoAerticulosLayout = new javax.swing.GroupLayout(panelIzquierdoAerticulos);
        panelIzquierdoAerticulos.setLayout(panelIzquierdoAerticulosLayout);
        panelIzquierdoAerticulosLayout.setHorizontalGroup(
            panelIzquierdoAerticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIzquierdoAerticulosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelIzquierdoAerticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                    .addGroup(panelIzquierdoAerticulosLayout.createSequentialGroup()
                        .addComponent(lblBuscarPor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarArticulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelIzquierdoAerticulosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelIzquierdoAerticulosLayout.setVerticalGroup(
            panelIzquierdoAerticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIzquierdoAerticulosLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelIzquierdoAerticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIzquierdoAerticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelIzquierdoAerticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBuscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnBuscarPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelIzquierdoAerticulosLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIzquierdoAerticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        panelBotones.setBackground(new java.awt.Color(229, 229, 255));
        panelBotones.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        bntLimpiarBien.setFont(new java.awt.Font("Yu Gothic", 1, 11)); // NOI18N
        bntLimpiarBien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/solsoftware/Iconos/BrochaLimpiarIcono.png"))); // NOI18N
        bntLimpiarBien.setText("Limpiar");
        bntLimpiarBien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLimpiarBienActionPerformed(evt);
            }
        });

        bntGuardarBien.setFont(new java.awt.Font("Yu Gothic", 1, 11)); // NOI18N
        bntGuardarBien.setForeground(new java.awt.Color(51, 51, 51));
        bntGuardarBien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/solsoftware/Iconos/guardarIcono32.png"))); // NOI18N
        bntGuardarBien.setMnemonic('g');
        bntGuardarBien.setText("Guardar");
        bntGuardarBien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntGuardarBienActionPerformed(evt);
            }
        });

        bntEliminarBien.setFont(new java.awt.Font("Yu Gothic", 1, 11)); // NOI18N
        bntEliminarBien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/solsoftware/Iconos/BorrarIcono32.png"))); // NOI18N
        bntEliminarBien.setText("Eliminar");
        bntEliminarBien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEliminarBienActionPerformed(evt);
            }
        });

        bntEditarBien.setFont(new java.awt.Font("Yu Gothic", 1, 11)); // NOI18N
        bntEditarBien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/solsoftware/Iconos/actualizarIcono.png"))); // NOI18N
        bntEditarBien.setText("Actualizar");
        bntEditarBien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEditarBienActionPerformed(evt);
            }
        });

        btnResponsable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/solsoftware/Iconos/usuario.png"))); // NOI18N
        btnResponsable.setText(" Responsable");
        btnResponsable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResponsableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bntLimpiarBien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntEliminarBien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntEditarBien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntGuardarBien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnResponsable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 60, Short.MAX_VALUE))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(bntLimpiarBien, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bntEliminarBien, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bntEditarBien, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bntGuardarBien, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnResponsable)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        PanelCentralArticulos.setBackground(new java.awt.Color(229, 229, 255));
        PanelCentralArticulos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelCentralArticulos.setAutoscrolls(true);

        lblCodigo.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblCodigo.setText("Nombre del Artículo");

        lblNumeroActa.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblNumeroActa.setText("Numero de Acta");

        lblBLD_BCA.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblBLD_BCA.setText("BLD/BCA");

        lblColor.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblColor.setText("Color");

        lblMaterial.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblMaterial.setText("Material");

        lblDimension.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblDimension.setText("Dimensiones");

        lblUbicacionBodega.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblUbicacionBodega.setText("Ubicación De Bodega");

        lblNombArtic.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblNombArtic.setText("Código del bien");

        txtNombreBien.setColumns(20);
        txtNombreBien.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtNombreBien.setLineWrap(true);
        txtNombreBien.setRows(5);
        jScrollPane6.setViewportView(txtNombreBien);

        lblCodigoAnterior.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblCodigoAnterior.setText("Codigo Anterior");

        txtSerieIdentificacion.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        txtSerieIdentificacion.setText("Serie/Identificación");

        txtModeloCaracteristicas.setColumns(20);
        txtModeloCaracteristicas.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtModeloCaracteristicas.setLineWrap(true);
        txtModeloCaracteristicas.setRows(5);
        jScrollPane7.setViewportView(txtModeloCaracteristicas);

        lblModelo.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblModelo.setText("Modelo/Características");

        lblMarcaRazoOtros.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblMarcaRazoOtros.setText("Marca/Raza/Otros ");

        txtUbicacionBodega.setColumns(20);
        txtUbicacionBodega.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtUbicacionBodega.setLineWrap(true);
        txtUbicacionBodega.setRows(5);
        jScrollPane8.setViewportView(txtUbicacionBodega);

        TxtDescripcion.setColumns(22);
        TxtDescripcion.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        TxtDescripcion.setLineWrap(true);
        TxtDescripcion.setRows(6);
        TxtDescripcion.setTabSize(10);
        TxtDescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jScrollPane3.setViewportView(TxtDescripcion);

        lblDescripcion1.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblDescripcion1.setText("Descripción");

        txtCodigo.setSelectionColor(new java.awt.Color(255, 0, 0));

        lblFechaIngreso.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblFechaIngreso.setText("Fecha de Ingreso");

        dateIngreso.setDateFormatString("yyyy-MM-dd");

        lblValorContable1.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblValorContable1.setText("Observación");

        txtObservacion.setColumns(20);
        txtObservacion.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtObservacion.setLineWrap(true);
        txtObservacion.setRows(5);
        jScrollPane4.setViewportView(txtObservacion);

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una opción", "Funcional", "Por Reparar", "De Baja" }));

        lblEstado.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblEstado.setText("Estado");

        lblValorContable2.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblValorContable2.setText("Fecha Última Depreciación");

        lblValorContable.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblValorContable.setText("Valor Contable ");

        lblBienNoConstatado.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblBienNoConstatado.setText("Bien No Constatado");

        lblConciliacion.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblConciliacion.setText("Conciliación ");

        lblCuentaContable.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblCuentaContable.setText("Cuenta Contable ");

        txtCuentaContable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuentaContableKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("*");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("*");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("*");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("*");

        dateDepresiacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dateDepresiacionKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout PanelCentralArticulosLayout = new javax.swing.GroupLayout(PanelCentralArticulos);
        PanelCentralArticulos.setLayout(PanelCentralArticulosLayout);
        PanelCentralArticulosLayout.setHorizontalGroup(
            PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                .addGroup(PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblNombArtic)
                        .addGap(147, 147, 147)
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblCodigo)
                        .addGap(117, 117, 117)
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblFechaIngreso)
                        .addGap(136, 136, 136)
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addComponent(dateIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblValorContable2)
                        .addGap(79, 79, 79)
                        .addComponent(dateDepresiacion, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtSerieIdentificacion)
                        .addGap(129, 129, 129)
                        .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblColor)
                        .addGap(229, 229, 229)
                        .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblMarcaRazoOtros)
                        .addGap(135, 135, 135)
                        .addComponent(txtMarcaRazaOtros, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblEstado)
                        .addGap(207, 207, 207)
                        .addComponent(jLabel5)
                        .addGap(4, 4, 4)
                        .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(lblDescripcion1)
                        .addGap(180, 180, 180)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                        .addGroup(PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblValorContable1))
                            .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblModelo))
                            .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblUbicacionBodega))
                            .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblValorContable)
                                    .addComponent(lblCodigoAnterior)))
                            .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblConciliacion))
                            .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblCuentaContable))
                            .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblBienNoConstatado))
                            .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblNumeroActa))
                            .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblBLD_BCA))
                            .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblMaterial))
                            .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblDimension)))
                        .addGap(107, 107, 107)
                        .addGroup(PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigoAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValorContable, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConciliacion, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCuentaContable, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBienNoConstatado, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumeroActa, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBld_bca, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDimension, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29))
        );
        PanelCentralArticulosLayout.setVerticalGroup(
            PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombArtic)
                    .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1))
                    .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblCodigo))
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaIngreso)
                    .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4))
                    .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(dateIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblValorContable2)
                    .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(dateDepresiacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSerieIdentificacion)
                    .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblColor)
                    .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMarcaRazoOtros)
                    .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtMarcaRazaOtros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEstado)
                    .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5))
                    .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescripcion1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValorContable1))
                .addGap(18, 18, 18)
                .addGroup(PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblModelo))
                .addGroup(PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblUbicacionBodega))
                    .addGroup(PanelCentralArticulosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigoAnterior))
                .addGap(18, 18, 18)
                .addGroup(PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorContable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValorContable))
                .addGap(18, 18, 18)
                .addGroup(PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConciliacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblConciliacion))
                .addGap(18, 18, 18)
                .addGroup(PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCuentaContable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCuentaContable))
                .addGap(18, 18, 18)
                .addGroup(PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBienNoConstatado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBienNoConstatado))
                .addGap(18, 18, 18)
                .addGroup(PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNumeroActa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumeroActa))
                .addGap(18, 18, 18)
                .addGroup(PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBld_bca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBLD_BCA))
                .addGap(18, 18, 18)
                .addGroup(PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelCentralArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDimension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDimension))
                .addGap(160, 160, 160))
        );

        jScrollPane5.setViewportView(PanelCentralArticulos);

        javax.swing.GroupLayout PanelArticulosLayout = new javax.swing.GroupLayout(PanelArticulos);
        PanelArticulos.setLayout(PanelArticulosLayout);
        PanelArticulosLayout.setHorizontalGroup(
            PanelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelArticulosLayout.createSequentialGroup()
                .addComponent(panelIzquierdoAerticulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelArticulosLayout.setVerticalGroup(
            PanelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelArticulosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(panelIzquierdoAerticulos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(2312, Short.MAX_VALUE))
        );

        PestaUsuario.addTab("BIENES", PanelArticulos);

        PanelUsuarios.setBackground(new java.awt.Color(229, 229, 255));
        PanelUsuarios.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        panelIzquierdoUsuarios.setBackground(new java.awt.Color(229, 229, 255));
        panelIzquierdoUsuarios.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblBuscar.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblBuscar.setText("Buscar :");

        txtBuscarUsuarios.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        txtBuscarUsuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarUsuariosKeyPressed(evt);
            }
        });

        tableUsuarios = new javax.swing.JTable(){
            public boolean isCellEditable(int a,int b){
                return false;
            }
        };
        tableUsuarios.setAutoCreateRowSorter(true);
        tableUsuarios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        tableUsuarios.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
                "Cedula", "Apellidos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableUsuarios.setGridColor(new java.awt.Color(0, 153, 153));
        tableUsuarios.getTableHeader().setReorderingAllowed(false);
        tableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUsuariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableUsuarios);
        if (tableUsuarios.getColumnModel().getColumnCount() > 0) {
            tableUsuarios.getColumnModel().getColumn(0).setResizable(false);
            tableUsuarios.getColumnModel().getColumn(1).setResizable(false);
        }

        btnBuscarUsuarios.setBackground(new java.awt.Color(24, 139, 165));
        btnBuscarUsuarios.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnBuscarUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/solsoftware/Iconos/LupaBuscarIcono.png"))); // NOI18N
        btnBuscarUsuarios.setToolTipText("Buscar");
        btnBuscarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuariosActionPerformed(evt);
            }
        });

        btnLimpiarUsuarios.setBackground(new java.awt.Color(24, 139, 165));
        btnLimpiarUsuarios.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnLimpiarUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/solsoftware/Iconos/BrochaLimpiarIcono.png"))); // NOI18N
        btnLimpiarUsuarios.setToolTipText("Limpiar");
        btnLimpiarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelIzquierdoUsuariosLayout = new javax.swing.GroupLayout(panelIzquierdoUsuarios);
        panelIzquierdoUsuarios.setLayout(panelIzquierdoUsuariosLayout);
        panelIzquierdoUsuariosLayout.setHorizontalGroup(
            panelIzquierdoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIzquierdoUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelIzquierdoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIzquierdoUsuariosLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(lblBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        panelIzquierdoUsuariosLayout.setVerticalGroup(
            panelIzquierdoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIzquierdoUsuariosLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(panelIzquierdoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelIzquierdoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBuscarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnLimpiarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelCentralUsuarios.setBackground(new java.awt.Color(229, 229, 255));
        PanelCentralUsuarios.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblIdentificacion.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblIdentificacion.setText("Documento de Identificación");

        lblContraseña.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblContraseña.setText("Contraseña");

        lblApellPaterno.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblApellPaterno.setText("Apellido Paterno");

        lblApellMaterno.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblApellMaterno.setText("Apellido Materno");

        lblPrimNombre.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblPrimNombre.setText("Nombres");

        lblCorreo.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblCorreo.setText("Correo");

        lblTelefono.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblTelefono.setText("Teléfono");

        lblTipo.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lblTipo.setText("Tipo de Usuario");

        txtDocuIdentificacion.setToolTipText("Campo Obligatorio");
        txtDocuIdentificacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDocuIdentificacionFocusLost(evt);
            }
        });
        txtDocuIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocuIdentificacionKeyTyped(evt);
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

        txtPrimNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrimNombreKeyTyped(evt);
            }
        });

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opción", "Docente", "Administrativo" }));

        checkVerContra.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        checkVerContra.setText("Visualizar");
        checkVerContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkVerContraActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 0, 0));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("*");

        jLabel9.setBackground(new java.awt.Color(255, 0, 0));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("*");

        jLabel10.setBackground(new java.awt.Color(255, 0, 0));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("*");

        jLabel11.setBackground(new java.awt.Color(255, 0, 0));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("*");

        jLabel12.setBackground(new java.awt.Color(255, 0, 0));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("*");

        javax.swing.GroupLayout PanelCentralUsuariosLayout = new javax.swing.GroupLayout(PanelCentralUsuarios);
        PanelCentralUsuarios.setLayout(PanelCentralUsuariosLayout);
        PanelCentralUsuariosLayout.setHorizontalGroup(
            PanelCentralUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCentralUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCentralUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCentralUsuariosLayout.createSequentialGroup()
                        .addComponent(lblContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCentralUsuariosLayout.createSequentialGroup()
                        .addComponent(lblIdentificacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCentralUsuariosLayout.createSequentialGroup()
                        .addGroup(PanelCentralUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblApellMaterno)
                            .addComponent(lblCorreo)
                            .addComponent(lblTelefono))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelCentralUsuariosLayout.createSequentialGroup()
                        .addComponent(lblApellPaterno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCentralUsuariosLayout.createSequentialGroup()
                        .addComponent(lblPrimNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCentralUsuariosLayout.createSequentialGroup()
                        .addComponent(lblTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(PanelCentralUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTelefono)
                    .addComponent(txtCorreo)
                    .addComponent(txtPrimNombre)
                    .addComponent(txtApelliMaterno)
                    .addComponent(txtApelliPaterno)
                    .addComponent(txtDocuIdentificacion)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkVerContra)
                .addGap(21, 21, 21))
        );
        PanelCentralUsuariosLayout.setVerticalGroup(
            PanelCentralUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCentralUsuariosLayout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addGroup(PanelCentralUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdentificacion)
                    .addComponent(txtDocuIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCentralUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContraseña)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkVerContra)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCentralUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellPaterno)
                    .addComponent(txtApelliPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCentralUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellMaterno)
                    .addComponent(txtApelliMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCentralUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrimNombre)
                    .addComponent(txtPrimNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCentralUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCentralUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCentralUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(2497, Short.MAX_VALUE))
        );

        PanelDeBotones.setBackground(new java.awt.Color(229, 229, 255));
        PanelDeBotones.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnEliminarPersona.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEliminarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/solsoftware/Iconos/BorrarIcono32.png"))); // NOI18N
        btnEliminarPersona.setText("Eliminar");
        btnEliminarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPersonaActionPerformed(evt);
            }
        });

        bntEditarPersona.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bntEditarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/solsoftware/Iconos/actualizarIcono.png"))); // NOI18N
        bntEditarPersona.setText("Actualizar");
        bntEditarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEditarPersonaActionPerformed(evt);
            }
        });

        bntNuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bntNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/solsoftware/Iconos/BrochaLimpiarIcono.png"))); // NOI18N
        bntNuevo.setText("Limpiar");
        bntNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNuevoActionPerformed(evt);
            }
        });

        bntGuardPers.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bntGuardPers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/solsoftware/Iconos/guardarIcono32.png"))); // NOI18N
        bntGuardPers.setText("Guardar");
        bntGuardPers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntGuardPersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelDeBotonesLayout = new javax.swing.GroupLayout(PanelDeBotones);
        PanelDeBotones.setLayout(PanelDeBotonesLayout);
        PanelDeBotonesLayout.setHorizontalGroup(
            PanelDeBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDeBotonesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(PanelDeBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarPersona, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntEditarPersona, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntNuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntGuardPers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        PanelDeBotonesLayout.setVerticalGroup(
            PanelDeBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDeBotonesLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(bntNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bntEditarPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bntGuardPers, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(297, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelUsuariosLayout = new javax.swing.GroupLayout(PanelUsuarios);
        PanelUsuarios.setLayout(PanelUsuariosLayout);
        PanelUsuariosLayout.setHorizontalGroup(
            PanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUsuariosLayout.createSequentialGroup()
                .addComponent(panelIzquierdoUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelCentralUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PanelDeBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        PanelUsuariosLayout.setVerticalGroup(
            PanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelIzquierdoUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelUsuariosLayout.createSequentialGroup()
                        .addComponent(PanelDeBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(2201, Short.MAX_VALUE))
                    .addComponent(PanelCentralUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        PestaUsuario.addTab("USUARIOS", PanelUsuarios);

        javax.swing.GroupLayout PanelFondoLayout = new javax.swing.GroupLayout(PanelFondo);
        PanelFondo.setLayout(PanelFondoLayout);
        PanelFondoLayout.setHorizontalGroup(
            PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFondoLayout.createSequentialGroup()
                .addComponent(PestaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 1366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelFondoLayout.setVerticalGroup(
            PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFondoLayout.createSequentialGroup()
                .addComponent(PestaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 3017, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntGuardPersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntGuardPersActionPerformed
        btnGuardaPersona();
    }//GEN-LAST:event_bntGuardPersActionPerformed

    private void bntNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNuevoActionPerformed
        nuevo();
    }//GEN-LAST:event_bntNuevoActionPerformed

    private void bntEditarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEditarPersonaActionPerformed
        btnEditarPersona();
    }//GEN-LAST:event_bntEditarPersonaActionPerformed

    private void btnEliminarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPersonaActionPerformed
        btnEliminarPersona();
    }//GEN-LAST:event_btnEliminarPersonaActionPerformed

    private void checkVerContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkVerContraActionPerformed
        util.verContrasena(txtContrasenia);
    }//GEN-LAST:event_checkVerContraActionPerformed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        util.validarDigitosTxt(this, evt);
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtPrimNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrimNombreKeyTyped
        util.mayusculas(evt);
        util.validarTextoTxt(this, evt);
    }//GEN-LAST:event_txtPrimNombreKeyTyped

    private void txtApelliMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApelliMaternoKeyTyped
        util.mayusculas(evt);
        util.validarTextoTxt(this, evt);
    }//GEN-LAST:event_txtApelliMaternoKeyTyped

    private void txtApelliPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApelliPaternoKeyTyped
        util.mayusculas(evt);
        util.validarTextoTxt(this, evt);
    }//GEN-LAST:event_txtApelliPaternoKeyTyped

    private void txtDocuIdentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocuIdentificacionKeyTyped
        util.validarDigitosTxt(this, evt);
        
    }//GEN-LAST:event_txtDocuIdentificacionKeyTyped
    
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

    private void btnLimpiarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarUsuariosActionPerformed
        txtBuscarUsuarios.setText(null);
    }//GEN-LAST:event_btnLimpiarUsuariosActionPerformed

    private void btnBuscarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuariosActionPerformed
        tablaBuscarPersona();
    }//GEN-LAST:event_btnBuscarUsuariosActionPerformed

    private void tableUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUsuariosMouseClicked
        datosCaja();
        if (evt.getClickCount() == 1) {
            String cedula = txtDocuIdentificacion.getText();
            persona = personaControl.getPersonaDB(cedula);
            buscarPersona();
        }
        bntGuardPers.setEnabled(false);
        bntEditarPersona.setEnabled(true);
    }//GEN-LAST:event_tableUsuariosMouseClicked

    private void txtBuscarUsuariosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarUsuariosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            tablaBuscarPersona();
        }
    }//GEN-LAST:event_txtBuscarUsuariosKeyPressed

    private void bntEditarBienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEditarBienActionPerformed
        btnEditarBien();
    }//GEN-LAST:event_bntEditarBienActionPerformed

    private void bntEliminarBienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEliminarBienActionPerformed
        btnEliminarBien();
    }//GEN-LAST:event_bntEliminarBienActionPerformed

    private void bntGuardarBienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntGuardarBienActionPerformed
        btnGuardaBien();
    }//GEN-LAST:event_bntGuardarBienActionPerformed

    private void bntLimpiarBienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLimpiarBienActionPerformed
        nuevo();
    }//GEN-LAST:event_bntLimpiarBienActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtBuscarArticulo.setText(null);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPrincipalActionPerformed
        tablaBuscar();
    }//GEN-LAST:event_btnBuscarPrincipalActionPerformed

    private void tableBienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBienMouseClicked
        datosCaja();
        if (evt.getClickCount() == 1) {
            String codigo = txtCodigo.getText();
            bien = llamada.BuscarBien(codigo);
            buscar();
            bienesTotal();
        }
        tablaBuscar();
        bntGuardarBien.setEnabled(false);
        bntEditarBien.setEnabled(true);
        if (bntGuardarBien.isEnabled() == false) {
        }

    }//GEN-LAST:event_tableBienMouseClicked

    private void txtBuscarArticuloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarArticuloKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            tablaBuscar();
        }
    }//GEN-LAST:event_txtBuscarArticuloKeyPressed

    private void txtBuscarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarArticuloActionPerformed
        this.setFocusable(true);
    }//GEN-LAST:event_txtBuscarArticuloActionPerformed

    private void txtCuentaContableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuentaContableKeyTyped
        util.controlCaracteresEspeciales(this, evt);
    }//GEN-LAST:event_txtCuentaContableKeyTyped

    private void dateDepresiacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateDepresiacionKeyTyped
        util.validarDigitosBien(this, evt);
    }//GEN-LAST:event_dateDepresiacionKeyTyped

    private void btnResponsableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResponsableActionPerformed
         if(responsableBien.isVisible()==false){
            responsableBien.setVisible(true);
        }
    }//GEN-LAST:event_btnResponsableActionPerformed

    private void btnResponsableInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResponsableInicioActionPerformed
        if(responsableBien.isVisible()==false){
            responsableBien.setVisible(true);
        }
    }//GEN-LAST:event_btnResponsableInicioActionPerformed

    private void btnTodosBienesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosBienesActionPerformed
        reporte.reporteAllBienes();
    }//GEN-LAST:event_btnTodosBienesActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        reporte.responsableBien();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        cerrar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cerrar();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(VentanaHomeVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaHomeVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaHomeVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaHomeVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaHomeVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelArticulos;
    private javax.swing.JPanel PanelCentralArticulos;
    private javax.swing.JPanel PanelCentralUsuarios;
    private javax.swing.JPanel PanelDeBotones;
    private javax.swing.JPanel PanelFondo;
    private javax.swing.JPanel PanelInicio;
    private javax.swing.JPanel PanelUsuarios;
    private javax.swing.JTabbedPane PestaUsuario;
    private javax.swing.JTextArea TxtDescripcion;
    private javax.swing.JButton bntEditarBien;
    private javax.swing.JButton bntEditarPersona;
    private javax.swing.JButton bntEliminarBien;
    private javax.swing.JButton bntGuardPers;
    private javax.swing.JButton bntGuardarBien;
    private javax.swing.JButton bntLimpiarBien;
    private javax.swing.JButton bntNuevo;
    private javax.swing.JButton btnBuscarPrincipal;
    private javax.swing.JButton btnBuscarUsuarios;
    private javax.swing.JButton btnEliminarPersona;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiarUsuarios;
    private javax.swing.JButton btnResponsable;
    private javax.swing.JButton btnResponsableInicio;
    private javax.swing.JButton btnTodosBienes;
    private javax.swing.JComboBox cbxEstado;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JCheckBox checkVerContra;
    private javax.swing.JTextField dateDepresiacion;
    private com.toedter.calendar.JDateChooser dateIngreso;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lblApellMaterno;
    private javax.swing.JLabel lblApellPaterno;
    private javax.swing.JLabel lblBLD_BCA;
    private javax.swing.JLabel lblBienNoConstatado;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblBuscarPor;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigoAnterior;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblConciliacion;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblCuentaContable;
    private javax.swing.JLabel lblDescripcion1;
    private javax.swing.JLabel lblDimension;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblIdentificacion;
    private javax.swing.JLabel lblMarcaRazoOtros;
    private javax.swing.JLabel lblMaterial;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNombArtic;
    private javax.swing.JLabel lblNumeroActa;
    private javax.swing.JLabel lblPrimNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblUbicacionBodega;
    private javax.swing.JLabel lblValorContable;
    private javax.swing.JLabel lblValorContable1;
    private javax.swing.JLabel lblValorContable2;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelIzquierdoAerticulos;
    private javax.swing.JPanel panelIzquierdoUsuarios;
    private javax.swing.JTable tableBien;
    private javax.swing.JTable tableUsuarios;
    private javax.swing.JTextField txtApelliMaterno;
    private javax.swing.JTextField txtApelliPaterno;
    private javax.swing.JTextField txtBienNoConstatado;
    private javax.swing.JTextField txtBld_bca;
    private javax.swing.JTextField txtBuscarArticulo;
    private javax.swing.JTextField txtBuscarUsuarios;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoAnterior;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtConciliacion;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtCuentaContable;
    private javax.swing.JTextField txtDimension;
    private javax.swing.JTextField txtDocuIdentificacion;
    private javax.swing.JTextField txtMarcaRazaOtros;
    private javax.swing.JTextField txtMaterial;
    private javax.swing.JTextArea txtModeloCaracteristicas;
    private javax.swing.JTextArea txtNombreBien;
    private javax.swing.JTextField txtNumeroActa;
    private javax.swing.JTextArea txtObservacion;
    private javax.swing.JTextField txtPrimNombre;
    private javax.swing.JTextField txtSerie;
    private javax.swing.JLabel txtSerieIdentificacion;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextArea txtUbicacionBodega;
    private javax.swing.JTextField txtValorContable;
    // End of variables declaration//GEN-END:variables
}
