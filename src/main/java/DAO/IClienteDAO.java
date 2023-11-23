/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import modelos.Cliente;

/**
 *
 * @author HOME
 */
public interface IClienteDAO {
    public List<Cliente> buscarCliente(String nombre);
}
