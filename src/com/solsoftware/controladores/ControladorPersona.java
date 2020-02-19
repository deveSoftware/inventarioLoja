package com.solsoftware.controladores;

import com.solsoftware.modelos.Persona;
import com.solsotfware.conexion.ConexionBaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorPersona {

    private ConexionBaseDatos conexion;
    private static Connection conex;

    public ControladorPersona(ConexionBaseDatos conexion) {
        this.conexion = conexion;
    }

    public Persona getPersonaDB(String cedula) {//método para buscar datos de las personas.
        Persona persona = new Persona();
        try {
            ResultSet resultado;
            conex = conexion.getConnection();
            String consulta = "SELECT * FROM inventario.persona where cedula='" + cedula + "';";
            PreparedStatement preparar = conex.prepareCall(consulta);
            resultado = preparar.executeQuery(consulta);

            if (resultado.next()) {
                persona.setCedula(resultado.getString("cedula"));
                persona.setContrasenia(resultado.getString("contrasenia"));
                persona.setNombre(resultado.getString("nombre_persona"));
                persona.setApellido_paterno(resultado.getString("apellido_paterno"));
                persona.setApellido_materno(resultado.getString("apellido_materno"));
                persona.setTelefono(resultado.getString("telefono"));
                persona.setCorreo(resultado.getString("correo"));
                persona.setTipo(resultado.getInt("tipo"));                
            } else {
                JOptionPane.showMessageDialog(null, "No existen datos");
            }
            resultado.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión " + e.getMessage());
        }
        return persona;
    }

    public boolean guardar(Persona persona) {//método para guardar datos de las personas.

        String guardar = "INSERT INTO `inventario`.`persona` (`cedula`, `contrasenia`, `nombre_persona`, `apellido_paterno`, `apellido_materno`, `telefono`, `correo`, `tipo`) VALUES (?,?,?,?,?,?,?,?);";

        try {
            try (PreparedStatement preparar = conexion.getConnection().prepareStatement(guardar)) {
                preparar.setString(1, persona.getCedula());
                preparar.setString(2, persona.getContrasenia());
                preparar.setString(3, persona.getNombre());
                preparar.setString(4, persona.getApellido_paterno());
                preparar.setString(5, persona.getApellido_materno());
                preparar.setString(6, persona.getTelefono());
                preparar.setString(7, persona.getCorreo());
                preparar.setInt(8, persona.getTipo());    
                preparar.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos Guardados");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El número de identificación "
                                              + "\nya esta registrado, ingrese uno nuevo");            
        }

        return true;
    }

    public boolean modificar(Persona persona) {//método para actualizar datos de las personas

        String modificar = "Update inventario.persona set cedula='" + persona.getCedula() + "',"
                + "contrasenia='" + persona.getContrasenia() + "',"
                + "nombre_nombre='" + persona.getNombre() + "',"
                + "apellido_paterno='" + persona.getApellido_paterno() + "',"
                + "apellido_materno='" + persona.getApellido_materno() + "',"
                + "correo='" + persona.getCorreo() + "',"
                + "telefono='" + persona.getTelefono() + "',"
                + "tipo='" + persona.getTipo() + "'" + "WHERE cedula = '" + persona.getCedula() + "'";
        try {
            try (PreparedStatement preparar = conexion.getConnection().prepareStatement(modificar)) {
                preparar.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos Modificados");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar datos ", "ERROR", JOptionPane.ERROR_MESSAGE);

        }

        return true;
    }

    public boolean eliminar(Persona persona) {//método para eliminar datos de las personas.
        String eliminar = "DELETE FROM `inventario`.`persona` WHERE (`cedula` = '" + persona.getCedula() + "');";
        try {
            try (PreparedStatement preparar = conexion.getConnection().prepareStatement(eliminar)) {
                preparar.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos eliminados");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar datos" + ex.getMessage());

        }

        return true;

    }

    public boolean tablaPersona(JTable tablaPersona, String cedula, String apellido_paterno){//método para que me cargue los datos de las personas en una tabla.

        ResultSet resultado;

        try {
            DefaultTableModel modelo = new DefaultTableModel();
            tablaPersona.setModel(modelo);
            Statement sentencia = conexion.getConnection().createStatement();
            String consulta = "SELECT cedula, concat(nombre_persona,' ',apellido_paterno,' ',apellido_materno)as apellidos FROM inventario.persona where cedula like '%" + cedula + "%'|| apellido_paterno like '%" + apellido_paterno + "%';";
            //preparar = conex.prepareCall(consulta);
            resultado = sentencia.executeQuery(consulta);

            modelo.addColumn("Cedula");
            modelo.addColumn("Apellidos");

            while (resultado.next()) {
                modelo.addRow(new Object[]{resultado.getString("cedula"),resultado.getString("apellidos")});
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar los datos");
        }
        return true;
    }
    public boolean registarAdmin(Persona persona) {//método para guardar datos de las personas.

        String guardar = "INSERT INTO `inventario`.`persona` (`cedula`, `contrasenia`, `nombre_persona`, `apellido_paterno`, `apellido_materno`, `telefono`, `correo`, `tipo`) VALUES (?,?,?,?,?,?,?,?);";

        try {
            try (PreparedStatement preparar = conexion.getConnection().prepareStatement(guardar)) {
                preparar.setString(1, persona.getCedula());
                preparar.setString(2, persona.getContrasenia());
                preparar.setString(3, persona.getNombre());
                preparar.setString(4, persona.getApellido_paterno());
                preparar.setString(5, persona.getApellido_materno());
                preparar.setString(6, persona.getTelefono());
                preparar.setString(7, persona.getCorreo());
                preparar.setInt(8, 2);    
                preparar.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos Guardados");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El número de identificación "
                                              + "\nya esta registrado, ingrese uno nuevo");            
        }

        return true;
    }
}
