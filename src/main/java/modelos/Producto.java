/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author HOME
 */
public class Producto {
    private int idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private double precio;
    private int numeroPiezas;
    private String estado;
    private String informacionAdicional;

    
    public Producto(int idProducto, String nombreProducto, String descripcionProducto, double precio, int numeroPiezas, String estado, String informacionAdicional) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precio = precio;
        this.numeroPiezas = numeroPiezas;
        this.estado = estado;
        this.informacionAdicional = informacionAdicional;
    }

    public int getIdProducto() {
        return idProducto;
    }

    
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getNumeroPiezas() {
        return numeroPiezas;
    }

    public void setNumeroPiezas(int numeroPiezas) {
        this.numeroPiezas = numeroPiezas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getInformacionAdicional() {
        return informacionAdicional;
    }

    public void setInformacionAdicional(String informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
    }
   
    
}
