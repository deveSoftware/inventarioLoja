package com.solsoftware.controladores;

import java.sql.Connection;
import com.solsoftware.modelos.Asignacion;
import com.solsoftware.modelos.Bien;
import com.solsoftware.modelos.Persona;
import com.solsotfware.conexion.ConexionBaseDatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorAsigarBien {

    Persona persona = new Persona();
    Asignacion asignarBien = new Asignacion();

    private final ConexionBaseDatos conexion;
    private Connection conex;

    public ControladorAsigarBien(ConexionBaseDatos conexion) {
        this.conexion = conexion;
    }

    public boolean tablaAsignarBien(JTable tablaBien, String codigo_barra, JComboBox verBien,String cedula) {//traer datos a la tabla con un switch case 
        //para elegir dos opciones.  
        ResultSet resultado;

        try {
            DefaultTableModel modelo = new DefaultTableModel();
            tablaBien.setModel(modelo);

            String consulta = "";
            switch (verBien.getSelectedIndex()) {
                case 0:
                    consulta = "Select bien.codigo_bien,bien.nombre from bien left join responsable on bien.id_bien=responsable.bien_id_bien where responsable.bien_id_bien is null and bien.codigo_bien like '" + codigo_barra + "%';";
                    break;
                case 1:
                    consulta = "select bien.codigo_bien,bien.nombre, persona.cedula,concat(persona.nombre_persona,' ',persona.apellido_paterno,' ',persona.apellido_materno) as nombrePersona from persona join bien join responsable on responsable.persona_id_persona=persona.id_persona and responsable.bien_id_bien=bien.id_bien\n"
                            + "and responsable.persona_id_persona=persona.id_persona where bien.codigo_bien like '" + codigo_barra + "%' || persona.cedula='"+cedula+"';";
                    break;
            }
            Statement sentencia = conexion.getConnection().createStatement();
            resultado = sentencia.executeQuery(consulta);
            
            modelo.addColumn("Código");
            modelo.addColumn("Nombre");

            while (resultado.next()) {
                modelo.addRow(new Object[]{resultado.getString("codigo_bien"), resultado.getString("nombre")});
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar los datos ", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
        }
        return true;
    }

    public boolean guardarAsignado(Asignacion asignar, JComboBox cbxAsignar) {//asigno o quito la asignacion dependiendo de que opcion tenga la lista. 
        String guardar = "";
        try {
            switch (cbxAsignar.getSelectedIndex()) {
                case 1:
                    guardar = "call guardarAsignado('" + asignar.getCedulaAsinado() + "','" + asignar.getCodigoAsignadp() + "');";
                    JOptionPane.showMessageDialog(null, "Datos Guardados");
                    break;
                case 2:
                    guardar = "call eliminarAsignado('" + asignar.getCedulaAsinado() + "','" + asignar.getCodigoAsignadp() + "')";
                    JOptionPane.showMessageDialog(null, "Datos Eliminados");
                    break;
            }
            try (PreparedStatement preparar = conexion.getConnection().prepareStatement(guardar)) {
                preparar.executeUpdate();
                preparar.close();

            }

        } catch (SQLException ex) {
            System.out.println("Error al guardar los datos " + ex.getMessage());
        }

        return true;
    }

    public Asignacion buscarAsignado(String codigo_bien) {//busco a quien se le asigno tal bien.
        ResultSet resultado;
        PreparedStatement preparar;
        conex = conexion.getConnection();
        String buscar = "call buscarAsignado(" + codigo_bien + ")";
        try {
            preparar = conex.prepareCall(buscar);
            resultado = preparar.executeQuery(buscar);
            if (resultado.next()) {
                asignarBien.setCodigoAsignadp(resultado.getString("codigo_bien"));
                asignarBien.setNombre_bien(resultado.getString("nombre"));
                asignarBien.setCedulaAsinado(resultado.getString("cedula"));
                asignarBien.setNombre_persona(resultado.getString("nombrePersona"));
            } else {
                JOptionPane.showMessageDialog(null, "No tiene asignado ningun responsable", "INFORMACIóN", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar los datos " + ex.getMessage());
        }
        return asignarBien;
    }
    public Bien totalBien(Bien bien) {
        String contar = "Select count(*)as total from inventario.responsable ";
        try {
            ResultSet resultado;
            conex = conexion.getConnection();
            PreparedStatement preparar = conex.prepareStatement(contar);
            resultado = preparar.executeQuery(contar);
            if (resultado.next()) {
                bien.setTotal(resultado.getString("total"));
                preparar.execute();
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo contar" + ex.getMessage());
        }
        return bien;
    }
}
