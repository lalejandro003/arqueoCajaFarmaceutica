/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author ll621
 */
public class Ticket {
    private String identificadorTicket;
    private String identificadorEmpleado;
    private String identificadorPedido;
    private double mondo;
    private double tarjetaMonto;
    private String enviado;

  
    
    public Ticket(String identificadorTicket, String identificadorEmpleado, String identificadorPedido, double mondo,double tarjetaMonto,String enviado) {
        this.identificadorTicket = identificadorTicket;
        this.identificadorEmpleado = identificadorEmpleado;
        this.identificadorPedido = identificadorPedido;
        this.mondo = mondo;
        this.tarjetaMonto=tarjetaMonto;
        this.enviado=enviado;
    }
      public Ticket() {
    }   

    public String getIdentificadorTicket() {
        return identificadorTicket;
    }

    public void setIdentificadorTicket(String identificadorTicket) {
        this.identificadorTicket = identificadorTicket;
    }

    public String getIdentificadorEmpleado() {
        return identificadorEmpleado;
    }

    public void setIdentificadorEmpleado(String identificadorEmpleado) {
        this.identificadorEmpleado = identificadorEmpleado;
    }

    public String getIdentificadorPedido() {
        return identificadorPedido;
    }

    public void setIdentificadorPedido(String identificadorPedido) {
        this.identificadorPedido = identificadorPedido;
    }

    public double getMondo() {
        return mondo;
    }

    public void setMondo(double mondo) {
        this.mondo = mondo;
    }
     public String getEnviado() {
        return enviado;
    }

    public void setEnviado(String enviado) {
        this.enviado = enviado;
    }
    
    public double getTarjetaMonto() {
        return tarjetaMonto;
    }

    public void setTarjetaMonto(double tarjetaMonto) {
        this.tarjetaMonto = tarjetaMonto;
    }

}
