package com.solsoftware.controladores;

import java.sql.Connection;
import com.solsoftware.modelos.Persona;
import com.solsoftware.vistas.LoginVista;
import com.solsoftware.vistas.VentanaHomeVista;
import com.solsotfware.conexion.ConexionBaseDatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControladorLogin {

    ResultSet resultado;
    ConexionBaseDatos conexion =new ConexionBaseDatos();
    private  Connection conex;
    Persona persona = new Persona();

    public Persona entrar(Persona persona,String usuario, String contrasenia) {//método para ingresar al sistema.
        try {
            conex = conexion.getConnection();
            String acceso = "SELECT cedula,contrasenia,tipo FROM inventario.persona where tipo=2;";//solo tipo administrativo.
            PreparedStatement preparar = conex.prepareStatement(acceso);
            resultado = preparar.executeQuery(acceso);
            if(resultado.next()) {
                persona.setCedula(resultado.getString("cedula"));
                persona.setContrasenia(resultado.getString("contrasenia"));
                persona.setTipo(resultado.getInt("tipo"));
            
                }
            if (usuario.equals(resultado.getString("cedula")) && contrasenia.equals(resultado.getString("contrasenia"))) {
                JOptionPane.showMessageDialog(null, "Bienvenido");    
                new VentanaHomeVista().setVisible(true);
                
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Datos Incorrectos");
                }            
            resultado.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de Conexión", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
        }
        return persona;
    }
}
