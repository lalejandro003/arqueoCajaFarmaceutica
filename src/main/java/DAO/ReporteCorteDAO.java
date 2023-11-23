/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Reporte;
import persistencia.Conexion;

/**
 *
 * @author ll621
 */
public class ReporteCorteDAO implements IReporteCajaDAO{

    String tablaConsultar="reportes";
    
    @Override
    public void guardarCorteFinalCaja(Reporte cierreCaja) {
       
        Conexion conexion = new Conexion();
        String inserto = "INSERT INTO "+ tablaConsultar+" (totaTarjeta,totalEfectivo,totalRemisiones,cajaChica,fecha) VALUES (?,?,?,?,?)";
       
        PreparedStatement almacenar = null;
        Connection conn = conexion.obtenerConexion();
        
        try {
            
            almacenar = conn.prepareStatement(inserto);
            almacenar.setDouble(1, cierreCaja.getTotalTarjeta());
            almacenar.setDouble(2, cierreCaja.getTotalEfectivo());
            almacenar.setDouble(3, cierreCaja.getTotalRemisiones()); 
            almacenar.setDouble(4, cierreCaja.getCajaChica()); 
            almacenar.setString(5, cierreCaja.getFecha());
            
            assert almacenar.executeUpdate() < 1 : almacenar.executeUpdate();
            System.out.println("stat.executeUpdate = " + almacenar.executeUpdate());
            
        } catch (SQLException ex) {
            Logger.getLogger(ReporteCorteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            almacenar.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReporteCorteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void imprimirCorteDia(Reporte reporte,String fecha) {
        Conexion conexion = new Conexion();
 
        String sql = "SELECT * FROM " + tablaConsultar+ " WHERE fecha = '" + fecha + "'";
        
        try {
            
            Connection conn = conexion.obtenerConexion();
            Statement sentencia = conn.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
           
                while(resultado.next())
                {
                reporte.setCajaChica(resultado.getDouble("cajaChica"));
                reporte.setTotalEfectivo(resultado.getDouble("totalEfectivo"));
                reporte.setTotalRemisiones(resultado.getDouble("totalRemisiones"));
                reporte.setTotalTarjeta(resultado.getDouble("totaTarjeta"));
                reporte.setFecha(resultado.getString("fecha"));
                
                }
            } catch (SQLException ex) {
            Logger.getLogger(ReporteCorteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

     }

    @Override
    public boolean verificarReporteDia(String fecha) {
        Conexion conexion = new Conexion();
        
        String sql = "SELECT * FROM " + tablaConsultar+ " WHERE fecha = '" + fecha + "'";
        try
        {
            Connection conn = conexion.obtenerConexion();
            Statement sentencia = conn.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            
            if(resultado.next())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ReporteCorteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Reporte> consultarDatos() {

       Conexion conexion = new Conexion();
       List<Reporte> Reportes = new ArrayList<>();
 
        String sql = "SELECT * FROM " + tablaConsultar;
        
        try {
            
            Connection conn = conexion.obtenerConexion();
            Statement sentencia = conn.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
           
                while(resultado.next())
                {
                Reporte reporte = new Reporte();
                reporte.setFecha(resultado.getString("fecha"));
                reporte.setTotalRemisiones(resultado.getDouble("totalRemisiones"));
                 Reportes.add(reporte);
                
                }
            } catch (SQLException ex) {
            Logger.getLogger(ReporteCorteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Reportes;
    }

    @Override
    public List<Reporte> consultarFecha(String fechaInicio,String fechaFin) {
       Conexion conexion = new Conexion();
       List<Reporte> Reportes = new ArrayList<>();
 
        String sql = "SELECT * FROM " + tablaConsultar +" WHERE fecha >= '" + fechaInicio + "' AND fecha <= '" + fechaFin + "'";
        
        try {
            
            Connection conn = conexion.obtenerConexion();
            Statement sentencia = conn.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
           
                while(resultado.next())
                {
                Reporte reporte = new Reporte();
                reporte.setFecha(resultado.getString("fecha"));
                reporte.setTotalRemisiones(resultado.getDouble("totalRemisiones"));
                Reportes.add(reporte);
                
                }
            } catch (SQLException ex) {
            Logger.getLogger(ReporteCorteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Reportes;
    }

    }
    
    

