package com.solsoftware.utilidades;

import java.awt.Frame;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Utilidades {
    boolean a = true;
    char i = '*';
    
    public void validarDigitosTxt(Frame frame, java.awt.event.KeyEvent evt) {//metodo para que solo se perimtan numeros.
        char digitos = evt.getKeyChar();
        if (Character.isLetter(digitos)) {
            frame.getToolkit().beep();
            evt.consume();//elimina letras cuando se ingresan
            JOptionPane.showMessageDialog(null, "Solo se permiten Digitos");
        } else if ((int) evt.getKeyChar() > 32 && (int) evt.getKeyChar() <= 47 //condicional para que no ingrese caracteres especiales.
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
            frame.getToolkit().beep();
            evt.consume();//elimina caracteres especiales cuando se ingresan
        }
    }

    public void validarTextoTxt(Frame frame, java.awt.event.KeyEvent evt) {//metodo para que solo se permita texto.
        char letras = evt.getKeyChar();
        if (Character.isDigit(letras)) {
            frame.getToolkit().beep();
            evt.consume();//elimina numeros cuando se los ingresa
            JOptionPane.showMessageDialog(null, "Solo se permiten Letras");
        } else if ((int) evt.getKeyChar() > 32 && (int) evt.getKeyChar() <= 47 //condicional para que no ingrese caracteres especiales.
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 163) {
            frame.getToolkit().beep();
            evt.consume();//elimina letras cuando se ingresan
        }
    }

    public boolean valida(String x) {//algoritmo para verificar que la cédula sea valida.
        int suma = 0;
        if (x.length() == 9 || x.length()>10) {//si hay solo 9 numeros la cédula no es correcta/
            JOptionPane.showMessageDialog(null, "Cédula incorrecta");
            return false;
        } else {
            int a[] = new int[x.length() / 2];
            int b[] = new int[(x.length() / 2)];
            int c = 0;
            int d = 1;
            for (int i = 0; i < x.length() / 2; i++) {
                a[i] = Integer.parseInt(String.valueOf(x.charAt(c)));
                c = c + 2;
                if (i < (x.length() / 2) - 1) {
                    b[i] = Integer.parseInt(String.valueOf(x.charAt(d)));
                    d = d + 2;
                }
            }

            for (int i = 0; i < a.length; i++) {
                a[i] = a[i] * 2;
                if (a[i] > 9) {
                    a[i] = a[i] - 9;
                }
                suma = suma + a[i] + b[i];
            }
            int aux = suma / 10;
            int dec = (aux + 1) * 10;
            if ((dec - suma) == Integer.parseInt(String.valueOf(x.charAt(x.length() - 1)))) {
                return true;
            } else if (suma % 10 == 0 && x.charAt(x.length() - 1) == '0') {

            } else {
                JOptionPane.showMessageDialog(null, "Cédula incorrecta");
                return false;
            }

        }
        return true;

    }

    public void mayusculas(java.awt.event.KeyEvent evt) {//método para hacer las letras en mayusculas
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }

    public void controlCaracteresEspeciales(Frame frame, java.awt.event.KeyEvent evt) {//método solo para numeros y letras
        if ((int) evt.getKeyChar() > 32 && (int) evt.getKeyChar() <= 47
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 163
                || (int) evt.getKeyChar() >= 163 && (int) evt.getKeyChar() <= 255) {
            frame.getToolkit().beep();
            evt.consume();//elimina caracteres cuando se ingresan
            JOptionPane.showMessageDialog(null, "Solo se permiten letras y numeros");
        }

    }

    public void validarDigitosBien(Frame frame, java.awt.event.KeyEvent evt) {//metodo para que solo se perimtan numeros.
        char digitos = evt.getKeyChar();
        if (Character.isLetter(digitos)) {
            frame.getToolkit().beep();
            evt.consume();//elimina letras cuando se ingresan
            JOptionPane.showMessageDialog(null, "Solo se permiten Digitos");

        }
    }

    public void verContrasena(JPasswordField txtContrasenia) {//metodo para visualizar la contraseña de un JPassword.

        if (a) {  // a es una variable boolean en true
            txtContrasenia.setEchoChar((char) 0); // este método es el que hace visible el texto del jPasswordField
            a = false;
        } else {
            txtContrasenia.setEchoChar(i); // i es el char para que no sea visible la contraseña.
            a = true;
        }
    }
}
