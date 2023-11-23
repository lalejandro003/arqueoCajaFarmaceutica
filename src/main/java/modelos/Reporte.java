/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author ll621
 */
public class Reporte {
    private double totalTarjeta;
    private double totalEfectivo;
    private double totalRemisiones;
    private double cajaChica;
    private String fecha;


    public Reporte(double totalTarjeta, double totalEfectivo, double totalRemisiones, double cajaChica,String fecha) {
        this.totalTarjeta = totalTarjeta;
        this.totalEfectivo = totalEfectivo;
        this.totalRemisiones = totalRemisiones;
        this.cajaChica = cajaChica;
        this.fecha=fecha;
    }
    public Reporte()
    {
        
    }

    public double getTotalTarjeta() {
        return totalTarjeta;
    }

    public void setTotalTarjeta(double totalTarjeta) {
        this.totalTarjeta = totalTarjeta;
    }

    public double getTotalEfectivo() {
        return totalEfectivo;
    }

    public void setTotalEfectivo(double totalEfectivo) {
        this.totalEfectivo = totalEfectivo;
    }

    public double getTotalRemisiones() {
        return totalRemisiones;
    }

    public void setTotalRemisiones(double totalRemisiones) {
        this.totalRemisiones = totalRemisiones;
    }

    public double getCajaChica() {
        return cajaChica;
    }

    public void setCajaChica(double cajaChica) {
        this.cajaChica = cajaChica;
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
