/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import modelos.Ticket;

/**
 *
 * @author ll621
 */
public interface ITicketDAO {
    public  List<Ticket> consultarTicketsVenta(String fecha);
    public void actualizarEstadoTicket(String fecha);
}
