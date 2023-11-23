/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controladores;

import DAO.ReporteCorteDAO;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import modelos.Reporte;


import javafx.event.ActionEvent;
import javafx.scene.control.Button;
/**
 * FXML Controller class
 *
 * @author ll621
 */
public class reporteCorteDiaControlador implements Initializable {

    @FXML
    private Label lblefectivoReporte;
    @FXML
    private Label lblTarjetaReporte;
    @FXML
    private Label lblRemisionesReporte;
    @FXML
    private Label lblCajaChicaReporte;
    @FXML
    private Label lblFecha;
    @FXML
    private Button btnImprimirCorte;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        String fecha=mostrarFecha();
        
        Reporte reporteNuevo=new Reporte();
        ReporteCorteDAO reporteDAO=new ReporteCorteDAO();
        reporteDAO.imprimirCorteDia(reporteNuevo,fecha);
       
        lblCajaChicaReporte.setText("" + reporteNuevo.getCajaChica());
       lblefectivoReporte.setText(""+reporteNuevo.getTotalEfectivo());
       lblTarjetaReporte.setText(""+reporteNuevo.getTotalTarjeta());
       lblRemisionesReporte.setText(""+reporteNuevo.getTotalRemisiones());
        
        
    }    
    
     public String mostrarFecha()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String horaActual = dateFormat.format(new Date());
        lblFecha.setText("" + horaActual);
        return horaActual;
    }

    @FXML
    private void guardarPDF(ActionEvent event) {
    }
    
}
