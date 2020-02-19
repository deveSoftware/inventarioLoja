package com.solsoftware.modelos;

import java.io.File;
import java.sql.Date;

/**
 *
 * @author CRISTIAN
 */
public class Bien {

    private String  codigo_barra, codigo_anterior, nombre,bld_bca, serie, modelo, marca, color,valor_contable,acta_matriz, fecha_depresiacion,
            material, dimension, descripcion, ubicacion, observacion, conciliacion, cuenta_contable, bien_noconstatado, total;

    private int estado;
    private Date fecha_ingreso;

    public String getTotal() {
        return total;
    }
    public void setTotal(String total) {
        this.total = total;
    }  
 
    public String getBien_noconstatado() {
        return bien_noconstatado;
    }

    public void setBien_noconstatado(String bien_noconstatado) {
        this.bien_noconstatado = bien_noconstatado;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getFecha_depresiacion() {
        return fecha_depresiacion;
    }

    public void setFecha_depresiacion(String fecha_depresiacion) {
        this.fecha_depresiacion = fecha_depresiacion;
    }

    public String getCodigo_barra() {
        return codigo_barra;
    }

    public void setCodigo_barra(String codigo_barra) {
        this.codigo_barra = codigo_barra;
    }

    public String getCodigo_anterior() {
        return codigo_anterior;
    }

    public void setCodigo_anterior(String codigo_anterior) {
        this.codigo_anterior = codigo_anterior;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getActa_matriz() {
        return acta_matriz;
    }

    public void setActa_matriz(String acta_matriz) {
        this.acta_matriz = acta_matriz;
    }  

    public String getBld_bca() {
        return bld_bca;
    }

    public void setBld_bca(String bld_bca) {
        this.bld_bca = bld_bca;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getConciliacion() {
        return conciliacion;
    }

    public void setConciliacion(String conciliacion) {
        this.conciliacion = conciliacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    public String getValor_contable() {
        return valor_contable;
    }

    public void setValor_contable(String valor_contable) {
        this.valor_contable = valor_contable;
    } 

    public String getCuenta_contable() {
        return cuenta_contable;
    }

    public void setCuenta_contable(String cuenta_contable) {
        this.cuenta_contable = cuenta_contable;
    }


}
