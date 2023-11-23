package Controladores;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */


import Alertas.AlertaReporteExistente;
import DAO.ReporteCorteDAO;
import DAO.TicketDAO;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelos.Reporte;
import modelos.Ticket;

/**
 * FXML Controller class
 *
 * @author ll621
 */
public class arqueoCajaControlador implements Initializable {

    @FXML
    private TabPane panelPestanas;
    @FXML
    private Tab tabRemisiones;
    @FXML
    private TableView<Ticket> tablaPrincipal;
    @FXML
    private TableColumn columnaTicket;
    @FXML
    private TableColumn columnaPedido;
    @FXML
    private TableColumn columnaEmpleado;
    @FXML
    private TableColumn columnaMonto;
    @FXML
    private TableColumn columnaTarjeta;
    @FXML
    private TableColumn columnaAceptado;
    @FXML
    private Button btnEnviar;
    @FXML
    private Tab tabRemisiones1;
    @FXML
    private Tab tabCorte;
    @FXML
    private Label lblRemisiones;
    private Label lblNotas;
    @FXML
    private Label lblFacturaDirecta;
    @FXML
    private Label lblTotal;
    @FXML
    private Label lblEfectivo;
    @FXML
    private Label lblTarjeta;
    @FXML
    private Label lblTotalDinero;
    @FXML
    private Label lblCajachica;
    @FXML
    private Label lblGastos;
    @FXML
    private Label lblTotalEfectivo;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnImprimirComprobanteCorte;
    @FXML
    private Button btnCerrar;
    @FXML
    private Label lblFecha;
    @FXML
    private DatePicker calendarioBusqueda;
    @FXML
    private Button btnNuevaFactura;
    @FXML
    private Label lblIDTicket;
    @FXML
    private Button grafica;
    
    private ObservableList<Ticket> tickets;
    @FXML
    private Button btnCitas;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Este apartado es para guardar un objeto tipo Ticket en un arrayList sin conexion a base de datos
        /*Ticket ticket1=new Ticket("TV-001","EM-001","PDI-001",1002,0,"PÉNDIENTE");
        Ticket ticket2=new Ticket("TV-002","EM-002","PDI-002",350,0,"PENDIENTE");
        Ticket ticket3=new Ticket("TV-003","EM-002","PDI-003",0 ,560,"PENDIETE");
        
        tickets= FXCollections.observableArrayList(ticket1,ticket2,ticket3);
        tablaPrincipal.setItems(tickets);
        
        columnaTicket.setCellValueFactory(new PropertyValueFactory<>("identificadorTicket"));
        columnaEmpleado.setCellValueFactory(new PropertyValueFactory<>("identificadorEmpleado"));
        columnaPedido.setCellValueFactory(new PropertyValueFactory<>("identificadorPedido"));
        columnaMonto.setCellValueFactory(new PropertyValueFactory<>("mondo"));
        columnaTarjeta.setCellValueFactory(new PropertyValueFactory<>("tarjetaMonto"));
        */     
        //Mostrar la hora, inicializarla en el programa
        mostrarFecha();
        actualizarInfo();
       
      
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        double sumaObtenidaTarjeta=sumarTarjeta();
        lblTarjeta.setText(Double.toString(sumaObtenidaTarjeta));//Envio los datos de las ventas
        
        ///////////////////// INICIAMOS CON LOS DATOS DESDE EL INICO   ///////////////////////////////////////////////////////
        double sumaObtenida=sumarRemisiones();
     
        lblEfectivo.setText(Double.toString(sumaObtenida)); //Envio los datos de las ventas
        /////////////////////////////////////////////////////////////////////////////////////////////////  

        double sumaEfectivo=sumarEfecticoTotal();
        lblTotalEfectivo.setText(Double.toString(sumaEfectivo));
        
        
        double sumaDinero=sumarRecabado();
        lblTotalDinero.setText(Double.toString(sumaDinero));
        lblRemisiones.setText(Double.toString(sumaDinero));
        
        double sumaVentas=sumarTotalVentas();
        lblTotal.setText(Double.toString(sumaVentas));
    }
    
    @FXML
    private void enviarRemisiones(ActionEvent event) throws IOException {
        String fecha=mostrarFecha();
        AlertaReporteExistente AlertaReporteExistente=new AlertaReporteExistente();
       //Habilitar y deshabilitar boton de envio de remisiones
       
        if(verificarTablaVacia()!=true)//PRIMERO VERIFICAMOS SI LA TABLA ESTA VACIA, MANDAMOS MENSAJE DE ALERTA
        {
            if(verificarEstadoTickets()!=true)//VERIFICAMOS TAMBIEN SI EXISTE UN REPORTE DE CORTE DE ACUERDO A LA FECHA ACTUAL
            {
                TicketDAO ticketDAO = new TicketDAO();
                ticketDAO.actualizarEstadoTicket(fecha);

                actualizarInfo();
                btnActualizar.setDisable(false);
                btnEnviar.setDisable(true);
            }
            else
            {
                AlertaReporteExistente.AlertaReporteExistente("ALERTA", "REPORTE EXISTENTE", "Ya se realizo el reporte del dia");
            }    
        }
        else
        {
            AlertaReporteExistente.AlertaReporteExistente("ALERTA", "TABLA VACIA", "No hay tickets por enviar");
            btnEnviar.setDisable(false);
        }
    }

    @FXML
    private void actualizarCorte(ActionEvent event) {
        
        btnImprimirComprobanteCorte.setDisable(false);
        btnActualizar.setDisable(true);
        
        double totalTarjeta=Double.parseDouble(lblTarjeta.getText());
        double totalEfectivo=Double.parseDouble(lblEfectivo.getText());
        double totalRemisiones=Double.parseDouble(lblRemisiones.getText());
        double cajaChica=Double.parseDouble(lblCajachica.getText());
        String fecha = lblFecha.getText();
        Reporte caja=new Reporte();
        caja.setCajaChica(cajaChica);
        caja.setTotalEfectivo(totalEfectivo);
        caja.setTotalRemisiones(totalRemisiones);
        caja.setTotalTarjeta(totalTarjeta);
        caja.setFecha(fecha);
        ReporteCorteDAO cierre=new ReporteCorteDAO();
        cierre.guardarCorteFinalCaja(caja);
        
    }

    @FXML
    private void imprimirComprobanteCorte(ActionEvent event) throws IOException {
        FXMLLoader loader =new FXMLLoader(App.class.getResource("/Controladores/reporteCorteDia.fxml"));//CREAMOS UN NUEVO OBJETO FXMLoader
        Pane panel=(Pane) loader.load();//CREAMOS UN NUEVO OBJETO PANE
        Scene escena =new Scene(panel);//CREAMOS UN NUEVO OBJETO SCENE
        Stage escenariosecundario=new Stage();//CREAMOS UN NUEVO OBJETO STAGE
        escenariosecundario.initModality(Modality.NONE);
        escenariosecundario.setScene(escena);//PASAMOS EL OBJETO SCENE CREADO ANTERIORMENTE, A LA PROPIEDAD DEL OBJETO escenariosecundario
        escenariosecundario.show();//MOSTRAMOS EL OBJETO
    }
    @FXML
      private void enviarGrafica(ActionEvent event) throws IOException {
          FXMLLoader loader =new FXMLLoader(App.class.getResource("/Controladores/reportesGrafica.fxml"));//CREAMOS UN NUEVO OBJETO FXMLoader
          Pane panel=(Pane) loader.load();//CREAMOS UN NUEVO OBJETO PANE
          Scene escena =new Scene(panel);//CREAMOS UN NUEVO OBJETO SCENE
          Stage escenariosecundario=new Stage();//CREAMOS UN NUEVO OBJETO STAGE
          escenariosecundario.initModality(Modality.NONE);
          escenariosecundario.setScene(escena);//PASAMOS EL OBJETO SCENE CREADO ANTERIORMENTE, A LA PROPIEDAD DEL OBJETO escenariosecundario
          escenariosecundario.show();//MOSTRAMOS EL OBJETO
      }
      
    @FXML
    private void cerrarpesta(ActionEvent event) {
          panelPestanas.getSelectionModel().select(tabRemisiones);
    }
    
    public boolean verificarTablaVacia()
    {
        return tablaPrincipal==null;
        
    }
    public void actualizarInfo()
    {
        String fecha=mostrarFecha();
        TicketDAO ticketDAO = new TicketDAO();
        
        List<Ticket> tickets = ticketDAO.consultarTicketsVenta(fecha);
        //Se crea una lista observable y agregar los datos de la base de datos
        ObservableList<Ticket> listaObservable = FXCollections.observableArrayList(tickets);

        // Configurar las columnas de la tabla
        columnaTicket.setCellValueFactory(new PropertyValueFactory<>("identificadorTicket"));
        columnaEmpleado.setCellValueFactory(new PropertyValueFactory<>("identificadorEmpleado"));
        columnaPedido.setCellValueFactory(new PropertyValueFactory<>("identificadorPedido"));
        columnaMonto.setCellValueFactory(new PropertyValueFactory<>("mondo"));
        columnaTarjeta.setCellValueFactory(new PropertyValueFactory<>("tarjetaMonto"));
        columnaAceptado.setCellValueFactory(new PropertyValueFactory<>("enviado") );

        // Establecer la lista observable como el contenido de la tabla
        tablaPrincipal.setItems(listaObservable);
   
    }
    
    public boolean verificarEstadoTickets()
    {
        String fecha=mostrarFecha();
        ReporteCorteDAO nuevoreporte=new ReporteCorteDAO();       
        boolean verificar=nuevoreporte.verificarReporteDia(fecha);

        if(verificar==true)
        {
            return verificar;
        }
        return false;
    }
   
    ////////////////////////////// SUMA DE DATOS //////////////////////////////////
    public double sumarRemisiones()//Sumar el monto total de la venta
    {
        double suma = 0;
        for (Ticket sumaTickets : tablaPrincipal.getItems()) {
            suma += sumaTickets.getMondo();
        }
        return suma;
    }

    public double sumarEfecticoTotal()
    {
        double efectivo=Double.parseDouble(lblEfectivo.getText());
        double cajaChica=Double.parseDouble(lblCajachica.getText());
       
        return cajaChica+efectivo;
    }
    
    public double sumarTotalVentas()
    {
        double remisiones=Double.parseDouble(lblRemisiones.getText());
       
        double factura=Double.parseDouble(lblFacturaDirecta.getText());
        
        return remisiones+factura;
    }
    
    public double sumarRecabado()
    {
        double efectivo=Double.parseDouble(lblEfectivo.getText());
        double tarjeta=Double.parseDouble(lblTarjeta.getText());
        
        return efectivo+tarjeta;
    }
    public double sumarTarjeta()
    {
        double suma = 0;
        for (Ticket sumaTickets : tablaPrincipal.getItems()) {
            suma += sumaTickets.getTarjetaMonto();
        }
        return suma;
    }
    public String mostrarFecha()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String horaActual = dateFormat.format(new Date());
        lblFecha.setText("" + horaActual);
        return horaActual;
    }

    @FXML
    private void enviarCitas(ActionEvent event) throws IOException {
        FXMLLoader loader =new FXMLLoader(App.class.getResource("/Controladores/citaPaciente.fxml"));//CREAMOS UN NUEVO OBJETO FXMLoader
          Pane panel=(Pane) loader.load();//CREAMOS UN NUEVO OBJETO PANE
          Scene escena =new Scene(panel);//CREAMOS UN NUEVO OBJETO SCENE
          Stage escenariosecundario=new Stage();//CREAMOS UN NUEVO OBJETO STAGE
          escenariosecundario.initModality(Modality.NONE);
          escenariosecundario.setScene(escena);//PASAMOS EL OBJETO SCENE CREADO ANTERIORMENTE, A LA PROPIEDAD DEL OBJETO escenariosecundario
          escenariosecundario.show();//MOSTRAMOS EL OBJETO
        
    }

    @FXML
    private void mostrarVentanaMedico(ActionEvent event) throws IOException {
        FXMLLoader loader =new FXMLLoader(App.class.getResource("/Controladores/medicoVentana.fxml"));//CREAMOS UN NUEVO OBJETO FXMLoader
        Pane panel=(Pane) loader.load();//CREAMOS UN NUEVO OBJETO PANE
        Scene escena =new Scene(panel);//CREAMOS UN NUEVO OBJETO SCENE
        Stage escenariosecundario=new Stage();//CREAMOS UN NUEVO OBJETO STAGE
        escenariosecundario.initModality(Modality.NONE);
        escenariosecundario.setScene(escena);//PASAMOS EL OBJETO SCENE CREADO ANTERIORMENTE, A LA PROPIEDAD DEL OBJETO escenariosecundario
        escenariosecundario.show();//MOSTRAMOS EL OBJETO
    }
 
}
