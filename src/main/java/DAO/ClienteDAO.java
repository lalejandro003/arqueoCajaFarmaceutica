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
import modelos.Cliente;
import persistencia.Conexion;

/**
 *
 * @author HOME
 */
public class ClienteDAO implements IClienteDAO {

    @Override
    public List<Cliente> buscarCliente(String nombre) {
        
    Conexion conexion = new Conexion();
    List<Cliente> clientes = new ArrayList<>();

    String sql = "SELECT * FROM cliente WHERE nombreCliente LIKE '%" + nombre + "%'";
    
    try (Connection conn = conexion.obtenerConexion();
         Statement sentencia = conn.createStatement();
         ResultSet resultado = sentencia.executeQuery(sql)) {

        while (resultado.next()) {
            Cliente clienteNuevo = new Cliente();
            clienteNuevo.setNombreCliente(resultado.getString("nombreCliente"));
            clienteNuevo.setApellidoPaterno(resultado.getString("apellidoPaterno"));
            clienteNuevo.setApellidoMaterno(resultado.getString("apellidoMaterno"));
            
            
            clientes.add(clienteNuevo);
        }

    } catch (SQLException ex) {
        Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
    }

    
    return clientes;
}
}

    

