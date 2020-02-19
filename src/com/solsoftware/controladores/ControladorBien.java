package com.solsoftware.controladores;

import com.solsoftware.modelos.Bien;
import com.solsoftware.modelos.Persona;
import com.solsotfware.conexion.ConexionBaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorBien {

    private ConexionBaseDatos conexion;
    private Connection conex;
    Persona persona = new Persona();

    public ControladorBien(ConexionBaseDatos conexion) {
        this.conexion = conexion;
    }

    public Bien BuscarBien(String bienes) {//método para buscar en la BDD todos los bienes.
        Bien bien = new Bien();
        try {
            ResultSet resultado;
            conex = conexion.getConnection();
            String consulta = "select * from inventario.bien where codigo_bien='" + bienes + "'";
            PreparedStatement preparar = conex.prepareCall(consulta);
            resultado = preparar.executeQuery(consulta);

            if (resultado.next()) {
                bien.setCodigo_barra(resultado.getString("codigo_bien"));
                bien.setNombre(resultado.getString("nombre"));
                bien.setCodigo_anterior(resultado.getString("codigo_anterior"));
                bien.setActa_matriz(resultado.getString("n_actaMatriz"));
                bien.setBld_bca(resultado.getString("bld_bca"));
                bien.setSerie(resultado.getString("serie"));
                bien.setModelo(resultado.getString("modelo"));
                bien.setMarca(resultado.getString("marca"));
                bien.setColor(resultado.getString("color"));
                bien.setMaterial(resultado.getString("material"));
                bien.setDimension(resultado.getString("dimension"));
                bien.setUbicacion(resultado.getString("ubicacion_bodega"));
                bien.setDescripcion(resultado.getString("descripcion"));
                bien.setCuenta_contable(resultado.getString("cuenta_contable"));
                bien.setFecha_ingreso(resultado.getDate("fecha_ingreso"));
                bien.setFecha_depresiacion(resultado.getString("fecha_depreciacion"));
                bien.setValor_contable(resultado.getString("valor_contable"));
                bien.setObservacion(resultado.getString("observacion"));
                bien.setConciliacion(resultado.getString("conciliacion"));
                bien.setEstado(resultado.getInt("estado"));
                bien.setBien_noconstatado(resultado.getString("bien_noconstatado"));
            } else {
                JOptionPane.showMessageDialog(null, "No existen datos");
            }
            resultado.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexion " + e.getMessage());
        }
        return bien;
    }

    public boolean guardar(Bien bien) {//método para guardar en la BDD un bien
        String guardar = "INSERT INTO `inventario`.`bien` (`codigo_bien`, `nombre`, `codigo_anterior`, `n_actaMatriz`, `bld_bca`, `serie`, `modelo`, `marca`, `color`, `material`, `dimension`, `ubicacion_bodega`, `descripcion`, `cuenta_contable`, `fecha_ingreso`, `fecha_depreciacion`, `valor_contable`, `observacion`, `conciliacion`, `estado`, `bien_noconstatado`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            try (PreparedStatement preparar = conexion.getConnection().prepareStatement(guardar)) {
                preparar.setString(1, bien.getCodigo_barra());
                preparar.setString(2, bien.getNombre());
                preparar.setString(3, bien.getCodigo_anterior());
                preparar.setString(4, bien.getActa_matriz());
                preparar.setString(5, bien.getBld_bca());
                preparar.setString(6, bien.getSerie());
                preparar.setString(7, bien.getModelo());
                preparar.setString(8, bien.getMarca());
                preparar.setString(9, bien.getColor());
                preparar.setString(10, bien.getMaterial());
                preparar.setString(11, bien.getDimension());
                preparar.setString(12, bien.getUbicacion());
                preparar.setString(13, bien.getDescripcion());
                preparar.setString(14, bien.getCuenta_contable());
                preparar.setDate(15, bien.getFecha_ingreso());
                preparar.setString(16, bien.getFecha_depresiacion());
                preparar.setString(17, bien.getValor_contable());
                preparar.setString(18, bien.getObservacion());
                preparar.setString(19, bien.getConciliacion());
                preparar.setInt(20, bien.getEstado());
                preparar.setString(21, bien.getBien_noconstatado());
                preparar.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos Guardados");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Este articulo ya se encuentra registrado");
        }
        return true;
    }

    public boolean modificar(Bien bien) {//método para modificar en la BDD.
        String actualizar = "UPDATE inventario.bien set codigo_bien ='" + bien.getCodigo_barra() + "',"
                + "nombre = '" + bien.getNombre() + "',"
                + "codigo_anterior = '" + bien.getCodigo_anterior() + "',"
                + "n_actaMatriz = '" + bien.getActa_matriz() + "',"
                + "bld_bca = '" + bien.getBld_bca() + "',"
                + "serie = '" + bien.getSerie() + "',"
                + "modelo = '" + bien.getModelo() + "',"
                + "marca = '" + bien.getMarca() + "',"
                + "color = '" + bien.getColor() + "',"
                + "material = '" + bien.getMaterial() + "',"
                + "dimension = '" + bien.getDimension() + "',"
                + "ubicacion_bodega = '" + bien.getUbicacion() + "',"
                + "descripcion = '" + bien.getDescripcion() + "',"
                + "cuenta_contable = '" + bien.getCuenta_contable() + "',"
                + "fecha_ingreso = '" + bien.getFecha_ingreso() + "',"
                + "fecha_depreciacion = '" + bien.getFecha_depresiacion() + "',"
                + "valor_contable = '" + bien.getValor_contable() + "',"
                + "observacion = '" + bien.getObservacion() + "',"
                + "conciliacion = '" + bien.getConciliacion() + "',"
                + "estado = '" + bien.getEstado() + "',"
                + "bien_noconstatado = '" + bien.getBien_noconstatado() + "'" + "WHERE codigo_bien = '" + bien.getCodigo_barra() + "'";
        try {
            try (PreparedStatement preparar = conexion.getConnection().prepareStatement(actualizar)) {
                preparar.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos Modificados");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar datos" + ex.getMessage()); //"ERROR", JOptionPane.ERROR_MESSAGE
        }
        return true;
    }

    public boolean eliminar(Bien bien) {//método para eliminar algun bien en la BDD.
        String eliminar = "DELETE FROM inventario.bien WHERE codigo_bien = '" + bien.getCodigo_barra() + "';";
        try {
            try (PreparedStatement preparar = conexion.getConnection().prepareStatement(eliminar)) {
                preparar.executeUpdate();

                JOptionPane.showMessageDialog(null, "Datos Eliminados");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar datos" + ex.getMessage());
        }
        return true;
    }

    public boolean tablaBuscar(JTable tablaBien, String codigo_barra, String nombre) {//cargar los bienes en la tabla dependiendo de la consulta.
        ResultSet resultado;
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            tablaBien.setModel(modelo);
            Statement sentencia = conexion.getConnection().createStatement();
            String consulta = "Select * from inventario.bien  where  bien.codigo_bien like '" + codigo_barra + "%' || bien.nombre like '" + nombre + "%';";
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

    public Bien totalBien(Bien bien) {
        String contar = "Select count(*)as total from inventario.bien ";
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
