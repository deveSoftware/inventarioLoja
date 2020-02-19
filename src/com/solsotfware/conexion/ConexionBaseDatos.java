package com.solsotfware.conexion;

import java.sql.Connection;
import static java.lang.Class.forName;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionBaseDatos {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/inventario";
    private static final String USUARIO = "root";
    private static final String CONTRASENIA = "root";
    private Connection connection;

    public ConexionBaseDatos() {
        conect();
    }

    private Connection conect() {
        try {
            forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(URL, USUARIO, CONTRASENIA);
            System.out.println("Conectado");
           
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Sin conexión");
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean isconectado() {
        if (connection != null) {
            return true;
        } else {
            return connection == null;
        }
    }
}
