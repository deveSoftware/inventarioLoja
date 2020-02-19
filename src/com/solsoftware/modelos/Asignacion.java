
package com.solsoftware.modelos;

public class Asignacion {
  private String cedulaAsinado,codigoAsignadp,nombre_persona,nombre_bien;

    public String getCedulaAsinado() {
        return cedulaAsinado;
    }

    public void setCedulaAsinado(String cedulaAsinado) {
        this.cedulaAsinado = cedulaAsinado;
    }

    public String getCodigoAsignadp() {
        return codigoAsignadp;
    }

    public void setCodigoAsignadp(String codigoAsignadp) {
        this.codigoAsignadp = codigoAsignadp;
    }

    public String getNombre_persona() {
        return nombre_persona;
    }

    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }

    public String getNombre_bien() {
        return nombre_bien;
    }

    public void setNombre_bien(String nombre_bien) {
        this.nombre_bien = nombre_bien;
    }

    @Override
    public String toString() {
        return "Asignacion{" + "cedulaAsinado=" + cedulaAsinado + ", codigoAsignadp=" + codigoAsignadp + ", nombre_persona=" + nombre_persona + ", nombre_bien=" + nombre_bien + '}';
    }

    



  
}
