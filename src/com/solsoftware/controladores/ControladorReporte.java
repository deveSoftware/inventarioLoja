package com.solsoftware.controladores;

import com.solsotfware.conexion.ConexionBaseDatos;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ControladorReporte {

    private final ConexionBaseDatos conexion;
    private Connection conex;

    public ControladorReporte(ConexionBaseDatos conexion) {
        this.conexion = conexion;
    }


    public boolean reporteAllBienes() {//descargar bienes en excel.
        
        JPanel panel = null;
        JFileChooser escoger = new JFileChooser();//creo el JFileChooser.
        escoger.setFileFilter(new FileNameExtensionFilter("*.XLSX", ".xlsx"));//solo permito al extención xlsx.
        int seleccion = escoger.showSaveDialog(panel);

        Workbook book = new XSSFWorkbook();//creo el libro de extención xlsx.
        Sheet sheet = book.createSheet("Bienes de la Institución");//para poner nombre a la hoja de excel
        try {
            String cabecera[] = new String[]{"Código del bien", "Código anterior", "Nombre del bien", "Número Acta Matriz", "BLD o BCA",
                "Serie", "Modelo", "Marca", "Color", "Material", "Dimensión", "Ubicación Bodega", "Descripción", "Cuenta Contable",
                "Fecha de ingreso", "Fecha Ultima Depreciación", "Valor Contable", "Observación", "Concialiación",
                "Estado", "Bien no Constatado"};//array para nombre de cada columna.

            CellStyle headerStyle = book.createCellStyle();//estilo de la cabecera.

            Row filaEncabezados = sheet.createRow(0);//es 0 para que las columnas se muestren en la primera fila.

            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }

            PreparedStatement preparar;
            ResultSet resultado = null;
            conex = conexion.getConnection();//obtener la conexion a la BDD.

            int numFilaDatos = 1;//es 1 para que los datso de la BDD se muestren en la segunda  fila.

            CellStyle datosEstilo = book.createCellStyle();
            preparar = conex.prepareCall("SELECT codigo_bien,codigo_anterior,nombre,n_actaMatriz,bld_bca,serie,modelo,marca,"
                    + "color,material,dimension,ubicacion_bodega,descripcion,cuenta_contable,fecha_ingreso,fecha_depreciacion,"
                    + "valor_contable,observacion,conciliacion,estado.nombre_estado,bien_noconstatado FROM inventario.bien join estado on bien.estado=estado.id_estado");//consulta a la BDD que se asignaran a cada cabecera.

            resultado = preparar.executeQuery();

            int numCol = resultado.getMetaData().getColumnCount();//se asigna el numero de columnas de la BDD a las cabeceras.

            while (resultado.next()) {

                Row filaDatos = sheet.createRow(numFilaDatos);

                for (int j = 0; j < numCol; j++) {

                    Cell CeldaDatos = filaDatos.createCell(j);
                    CeldaDatos.setCellStyle(datosEstilo);
                    if (j == 3 || j == 16) {//para que no haya error si una columna es Double 
                        CeldaDatos.setCellValue(resultado.getDouble(j + 1));//j+1 por que en BDD comienza en la posición 0.
                    } else {
                        CeldaDatos.setCellValue(resultado.getString(j + 1));
                    }
                }

                numFilaDatos++;

            }
            for (int k = 0; k < numCol; k++) {//vuelvo a recorrer el numero de columnas que existe para que en Excel se ajuste al texto.
                sheet.autoSizeColumn(k);
            }

            if (seleccion == JFileChooser.APPROVE_OPTION) {//para el JFC para saber si dio clic en aceptar
                File archivoGuardado = escoger.getSelectedFile();//creo un objeto de tipo file y le envio al FOS para generar el archivo 
                //y contateno para especificar qie tipo de archivo es.
                try (FileOutputStream fileOut = new FileOutputStream(archivoGuardado + ".xlsx")) {
                    book.write(fileOut);//escribo el archivo de tipo FOS
                    fileOut.close();//cierro 
                    JOptionPane.showMessageDialog(null, "Se ha guardado Correctamente");
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    public boolean responsableBien() {
        JPanel panel = null;
        JFileChooser escoger = new JFileChooser();//creo el JFileChooser.
        escoger.setFileFilter(new FileNameExtensionFilter("*.XLSX", ".xlsx"));//solo permito al extención xlsx.
        int seleccion = escoger.showSaveDialog(panel);
        Workbook bookResponsable = new XSSFWorkbook();
        Sheet nombreHoja = bookResponsable.createSheet("Responsables");
        try {
            String columna[] = new String[]{"Código del Bien", "Nombre del Bien", "Cédula del Responsable", "Nombre del Responsable"};
            CellStyle cabeceraEstilo = bookResponsable.createCellStyle();
            Row filaColumna = nombreHoja.createRow(0);
            for (int i = 0; i < columna.length; i++) {
                Cell celdaEnzabezado = filaColumna.createCell(i);
                celdaEnzabezado.setCellStyle(cabeceraEstilo);
                celdaEnzabezado.setCellValue(columna[i]);
            }

            PreparedStatement preparar;
            ResultSet resultado = null;
            conex = conexion.getConnection();//obtener la conexion a la BDD.

            int numFilaDatos = 1;//es 1 para que los datso de la BDD se muestren en la segunda  fila.

            CellStyle datosEstilo = bookResponsable.createCellStyle();
            preparar = conex.prepareCall("select bien.codigo_bien,bien.nombre,persona.cedula,concat(persona.nombre_persona,' ',persona.apellido_paterno,' ',persona.apellido_materno) as nombrePersona from persona join bien join responsable on responsable.persona_id_persona=persona.id_persona and responsable.bien_id_bien=bien.id_bien\n"
                                       + "and responsable.persona_id_persona=persona.id_persona  where  bien.codigo_bien like '%' order by persona.cedula ;");//consulta a la BDD que se asignaran a cada cabecera.

            resultado = preparar.executeQuery();

            int numCol = resultado.getMetaData().getColumnCount();//se asigna el numero de columnas de la BDD a las cabeceras.

            while (resultado.next()) {

                Row filaDatos = nombreHoja.createRow(numFilaDatos);

                for (int j = 0; j < numCol; j++) {

                    Cell CeldaDatos = filaDatos.createCell(j);
                    CeldaDatos.setCellStyle(datosEstilo);
                    if (j == 0 || j == 2) {//para que no haya error si una columna es Double 
                        CeldaDatos.setCellValue(resultado.getDouble(j + 1));//j+1 por que en BDD comienza en la posición 0.
                    } else {
                        CeldaDatos.setCellValue(resultado.getString(j + 1));
                    }
                }

                numFilaDatos++;

            }
            for (int k = 0; k < numCol; k++) {//vuelvo a recorrer el numero de columnas que existe para que en Excel se ajuste al texto.
                nombreHoja.autoSizeColumn(k);
            }
            if (seleccion == JFileChooser.APPROVE_OPTION) {//para el JFC para saber si dio clic en aceptar
                File archivoGuardado = escoger.getSelectedFile();//creo un objeto de tipo file y le envio al FOS para generar el archivo 
                //y contateno para especificar qie tipo de archivo es.
                try (FileOutputStream fileOut = new FileOutputStream(archivoGuardado + ".xlsx")) {
                    bookResponsable.write(fileOut);//escribo el archivo de tipo FOS
                    fileOut.close();//cierro 
                    JOptionPane.showMessageDialog(null, "Se ha guardado Correctamente");
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return true;

    }

}
