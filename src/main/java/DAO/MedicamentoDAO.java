/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.Conexion;

/**
 *
 * @author HOME
 */
public class MedicamentoDAO implements IMedicamentoDAO {

    @Override
    public void busquedaMedicamento(String nombre) {
        Conexion conexion =new Conexion();
        String sql = "SELECT * FROM producto WHERE nombreProducto LIKE '%" + nombre + "%'";
        try
                {
                    Connection con=conexion.obtenerConexion();
                    Statement sentencia = con.createStatement();
                    ResultSet resultado=sentencia.executeQuery(sql);
                    while(resultado.next())
                            {
                                
                            }
                    
                    
                } catch (SQLException ex) {
            Logger.getLogger(MedicamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
