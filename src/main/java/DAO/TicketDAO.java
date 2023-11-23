/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Ticket;
import persistencia.Conexion;

/**
 *
 * @author ll621
 */
public class TicketDAO implements ITicketDAO{//Implementamos la interface creada previamente
    String tablaConsultar="ticket";
    
    @Override
    public List<Ticket> consultarTicketsVenta(String fecha) {
        
        Conexion conexion = new Conexion();
        List<Ticket> Tickets = new ArrayList<>();
        Ticket ticket=null;
 
        String sql = "SELECT * FROM " + tablaConsultar + " WHERE fecha = '" + fecha + "'";
        
        try {
            
            Connection conn = conexion.obtenerConexion();
            Statement sentencia = conn.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            
                while(resultado.next())
                {
                    // String sql = "SELECT * FROM producto WHERE nombreProducto like '%"+nombre+"%'";
                Ticket nuevoTicket=new Ticket();
                nuevoTicket.setIdentificadorTicket(resultado.getString("idticket"));
                nuevoTicket.setIdentificadorPedido(resultado.getString("idPedido"));
                nuevoTicket.setIdentificadorEmpleado(resultado.getString("idVendedor"));
                nuevoTicket.setMondo(resultado.getDouble("montoEfectivo"));
                nuevoTicket.setTarjetaMonto(resultado.getDouble("montoTarjeta"));
                nuevoTicket.setEnviado(resultado.getString("estatus"));
                Tickets.add(nuevoTicket);
                }
            } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      return Tickets;
      
     }

    @Override
    public void actualizarEstadoTicket(String fecha) {
        Conexion conexion = new Conexion();
        Ticket ticket=null;
 
        String sql = "UPDATE " + tablaConsultar + " SET estatus='ENVIADO' WHERE estatus='PENDIENTE' and fecha = '" + fecha + "';";
        
        try {
        Connection conn = conexion.obtenerConexion();
        Statement sentencia = conn.createStatement();
        int filasActualizadas = sentencia.executeUpdate(sql);

        if (filasActualizadas > 0) {
            System.out.println("Actualización exitosa: " + filasActualizadas + " registros actualizados.");
        } else {
            System.out.println("Ningún registro actualizado.");
        }
    } catch (SQLException ex) {
        Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    
      
    }
}
       
