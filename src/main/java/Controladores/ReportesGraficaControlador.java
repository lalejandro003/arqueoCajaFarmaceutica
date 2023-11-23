/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controladores;

import DAO.ReporteCorteDAO;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import modelos.Reporte;


/**
 * FXML Controller class
 *
 * @author ll621
 */
public class ReportesGraficaControlador implements Initializable {

    @FXML
    private LineChart<String, Double> graficaVentas;
    private ObservableList<Reporte> reportes;
    @FXML
    private Label lblFecha;
    @FXML
    private Button btnActualizar;
    @FXML
    private DatePicker calendarioBusquedaInicio;
    @FXML
    private DatePicker calendarioBusquedaFinal;
    @FXML
    private Label lblprueba;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        generarDatosGrafica();
        mostrarFecha();
      
       
    }    
    
    public void generarDatosGrafica()
    {
        ReporteCorteDAO reporte = new ReporteCorteDAO();
        List<Reporte> reporteslista = reporte.consultarDatos();
        XYChart.Series<String, Double> series = new XYChart.Series<>();

        
        for (Reporte dato : reporteslista) {
        
            String categoria = dato.getFecha();
            double valor =dato.getTotalRemisiones();
            series.getData().add(new XYChart.Data<>(categoria, valor));
        }
            graficaVentas.getData().add(series);
    }
    
     public String mostrarFecha()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String horaActual = dateFormat.format(new Date());
        lblFecha.setText("" + horaActual);
        return horaActual;
    }
     
   public String recuperarFechaSeleccionadaInicio(DatePicker calendarioRecuperado)
   {
        LocalDate selectedDate = calendarioRecuperado.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = selectedDate.format(formatter);
        return formattedDate;
   }
  
 
    @FXML
    private void actualizarDatosFecha(ActionEvent event) {
        graficaVentas.getData().clear();//Primero limpiamos la grafica anterior
        String datoRecuperadoInicio=recuperarFechaSeleccionadaInicio(calendarioBusquedaInicio);
        String datoRecuperadoFinal=recuperarFechaSeleccionadaInicio(calendarioBusquedaFinal);
        
        ReporteCorteDAO reporte = new ReporteCorteDAO();
        List<Reporte> reporteslista = reporte.consultarFecha(datoRecuperadoInicio, datoRecuperadoFinal);
        XYChart.Series<String, Double> series = new XYChart.Series<>();
       
        for (Reporte dato : reporteslista) {
            String categoria = dato.getFecha();
            double valor =dato.getTotalRemisiones();
            series.getData().add(new XYChart.Data<>(categoria, valor));
        }
            graficaVentas.getData().add(series);
    }
}
