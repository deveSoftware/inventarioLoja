package pruebas;

import com.solsoftware.controladores.ControladorPersona;
import com.solsoftware.modelos.Persona;

import com.solsotfware.conexion.ConexionBaseDatos;

public class TestImplemetacion {

    public static void main(String[] args) {
        ConexionBaseDatos conexion = new ConexionBaseDatos();
        ControladorPersona test = new ControladorPersona(conexion);
        Persona per = new Persona();

        //System.out.println("Lista de Persona "+test.getPersonaDB());
      
    }

}
