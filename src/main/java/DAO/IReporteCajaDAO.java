/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import modelos.Reporte;

/**
 *
 * @author ll621
 */
public interface IReporteCajaDAO {
    public void guardarCorteFinalCaja(Reporte corteFinal);
    public void imprimirCorteDia(Reporte reporteFinal,String fecha);
    public boolean verificarReporteDia(String fecha);
    public List<Reporte> consultarDatos();
    public List<Reporte> consultarFecha(String fechaInicio,String fechaFin);
}
