/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author HOME
 */
public class Cliente {
    private String rfcCliente;	
    private String nombreCliente;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int numeroTelefono;
    private String correoElectronico;
    private String calleCliente;
    private int numeroExterior;
    private int numeroInterior;
    private int codigoPostal;
    private String colonia;
    private String municipio;
    private String estado;
    private String pais;
    private String fechaRegistro;
    private String estatus;

    public Cliente (){
        
    }
    public Cliente(String rfcCliente, String nombreCliente, String apellidoPaterno, String apellidoMaterno, int numeroTelefono, String correoElectronico, String calleCliente, int numeroExterior, int numeroInterior, int codigoPostal, String colonia, String municipio, String estado, String pais, String fechaRegistro, String estatus) {
        this.rfcCliente = rfcCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numeroTelefono = numeroTelefono;
        this.correoElectronico = correoElectronico;
        this.calleCliente = calleCliente;
        this.numeroExterior = numeroExterior;
        this.numeroInterior = numeroInterior;
        this.codigoPostal = codigoPostal;
        this.colonia = colonia;
        this.municipio = municipio;
        this.estado = estado;
        this.pais = pais;
        this.fechaRegistro = fechaRegistro;
        this.estatus = estatus;
    }

    public String getRfcCliente() {
        return rfcCliente;
    }

    public void setRfcCliente(String rfcCliente) {
        this.rfcCliente = rfcCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCalleCliente() {
        return calleCliente;
    }

    public void setCalleCliente(String calleCliente) {
        this.calleCliente = calleCliente;
    }

    public int getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(int numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public int getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumeroInterior(int numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
    
}
