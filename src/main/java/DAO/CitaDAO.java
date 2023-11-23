/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Cita;
import modelos.Doctor;
import persistencia.Conexion;

/**
 *
 * @author HOME
 */
public class CitaDAO implements ICitaDAO{
    String tablaConsultar="cita";

    @Override
    public void registrarCita(Cita cita, Doctor doctor) {
        Conexion conexion = new Conexion();
        String inserto = "INSERT INTO "+ tablaConsultar+" (nombrePaciente,"
                + "apellidoPaternoPaciente,"
                + "apellidoMaternoPaciente,"
                + "fechaCita,"
                + "horaCita,"
                + "nombreMedico,"
                + "constultorioCita,"
                + "analisisCita,"
                + "estatus) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";
       
        PreparedStatement almacenar = null;
        Connection conn = conexion.obtenerConexion();
        
        try {
            
            almacenar = conn.prepareStatement(inserto);
            almacenar.setString(1, cita.getNombrePaciente());
            almacenar.setString(2, cita.getApellidoPaterno());
            almacenar.setString(3, cita.getApellidoMaterno());
            almacenar.setString(4,cita.getFechaCita());
            almacenar.setString(5, cita.getHorario());
            almacenar.setString(6, doctor.getNombreDoctor());
            almacenar.setInt(7, cita.getConstultorioCita());
            almacenar.setString(8, cita.getAnalisisCita());
            almacenar.setString(9,cita.getEstatus());
            
            assert almacenar.executeUpdate() < 1 : almacenar.executeUpdate();
            System.out.println("stat.executeUpdate = " + almacenar.executeUpdate());
            
        } catch (SQLException ex) {
            Logger.getLogger(ReporteCorteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    @Override
    public boolean busquedaCita(String fecha,String horario) {
        Conexion conexion = new Conexion();
    

        String sql = "SELECT * FROM " + tablaConsultar + " WHERE fechaCita = ? AND horaCita = ?";

    try (
         Connection conn = conexion.obtenerConexion();
         PreparedStatement sentencia = conn.prepareStatement(sql)) {

        sentencia.setString(1, fecha);
        sentencia.setString(2, horario);
        

        try (
            ResultSet resultado = sentencia.executeQuery()) {
            return resultado.next();
        }

    } catch (SQLException ex) {
        Logger.getLogger(ReporteCorteDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
    }

    @Override
    public List<Cita> mostrarCitas(String nombreDoctor,String fecha) {
       
    Conexion conexion = new Conexion();
    List<Cita> reportes = new ArrayList<>();

    String sql = "SELECT * FROM " + tablaConsultar + " WHERE fechaCita = ? AND nombreMedico = ? AND estatus= ?";

    try (
         Connection conn = conexion.obtenerConexion();
         PreparedStatement sentencia = conn.prepareStatement(sql)) {

        sentencia.setString(1, fecha);
        sentencia.setString(2, nombreDoctor);
        sentencia.setString(3, "pendiente");

        try (ResultSet resultado = sentencia.executeQuery()) {
            while (resultado.next()) {
                Cita cita = new Cita();
                cita.setNombrePaciente(resultado.getString("nombrePaciente"));
                cita.setFechaCita(resultado.getString("fechaCita"));
                cita.setAnalisisCita(resultado.getString("analisisCita"));
                reportes.add(cita);
            }
        }

    } catch (SQLException ex) {
        Logger.getLogger(ReporteCorteDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return reportes;
    
    }
 }

        

