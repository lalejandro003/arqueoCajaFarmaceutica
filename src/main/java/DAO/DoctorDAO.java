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
import modelos.Doctor;
import persistencia.Conexion;

/**
 *
 * @author HOME
 */
public class DoctorDAO implements IDoctorDAO{
    String tablaConsultar="medico";
    
    
    @Override
    public List<Doctor> mostrarInformacion() {
        Conexion conexion = new Conexion();
        List<Doctor> listaDoctores = new ArrayList<>();
 
        String sql = "SELECT * FROM " + tablaConsultar + ";";
        
        try {
            
            Connection conn = conexion.obtenerConexion();
            Statement sentencia = conn.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
           
                while(resultado.next())
                {
                    Doctor doctor = new Doctor();
                    doctor.setNombreDoctor(resultado.getString("nombreMedico"));
                    listaDoctores.add(doctor);
                
                }
            } catch (SQLException ex) {
            Logger.getLogger(ReporteCorteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaDoctores;
        
    }
        
    
}
