/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controladores;


import Alertas.AlertaReporteExistente;
import Alertas.NotificacionExitosa;
import DAO.CitaDAO;
import DAO.ClienteDAO;
import DAO.DoctorDAO;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import modelos.Cita;
import modelos.Cliente;
import modelos.Doctor;

/**
 * FXML Controller class
 *
 * @author HOME
 */
public class CitaPacienteControlador implements Initializable {

    @FXML
    private Button btnAfiliado;
    @FXML
    private Button btnNuevo;
    @FXML
    private Pane panelBusqueda;
    @FXML
    private Pane panelGenerarCita;
    @FXML
    private Button btnBuscarPaciente;
    @FXML
    private ComboBox<String> cbxHora;
    @FXML
    private ComboBox<Doctor> cbxDoctor;
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblApellidoP;
    @FXML
    private Label lblApellidoM;
    @FXML
    private DatePicker fechaSeleccionada;
    @FXML
    private TextArea lblAnalisis;
    @FXML
    private ComboBox<String> cbxConsultorio;
    @FXML
    private TextField txtPaciente;
    @FXML
    private TableView<Cliente> tablaClientes;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApellidoPaterno;
    @FXML
    private TableColumn colApellidoMaterno;
    @FXML
    private TableColumn colBotones;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnNuevo.setVisible(true);
        btnAfiliado.setVisible(true);
        
        generarHorarioCita();
        mostrarDoctores();
        ingresarConsultorio();
        
        // TODO
    }    

    @FXML
    private void busquedaPaciente(ActionEvent event) {
        panelBusqueda.setVisible(true);
    }

    @FXML
    private void generarCita(ActionEvent event) {
        
        String nombre=txtPaciente.getText();
        AlertaReporteExistente AlertaVacio=new AlertaReporteExistente();
        if(nombre!="")
        {
            btnNuevo.setVisible(false);
            btnAfiliado.setVisible(false);
            ClienteDAO clientes=new ClienteDAO();


            List<Cliente> clientesLista =  clientes.buscarCliente(nombre);

            ObservableList<Cliente> listaObservable = FXCollections.observableArrayList(clientesLista);


            colNombre.setCellValueFactory(new PropertyValueFactory<>("nombreCliente"));
            colApellidoPaterno.setCellValueFactory(new PropertyValueFactory<>("apellidoPaterno"));
            colApellidoMaterno.setCellValueFactory(new PropertyValueFactory<>("apellidoMaterno"));
            colBotones.setCellFactory(param -> new TableCell<Cliente, Void>() {//AGREGAR BOTON DENTRO DE LA TABLA
            private final Button btn = new Button("AGREGAR");
            
             {
            btn.setOnAction(event -> {//LA ACCION QUE REALIZARA AL DAR CLICK, PUEDE DARLE VALORES A DATOS, ETC
                    panelGenerarCita.setVisible(true);
                    panelBusqueda.setVisible(false);
                    Cliente clienteEncontrado = getTableView().getItems().get(getIndex());
                    lblNombre.setText(clienteEncontrado.getNombreCliente());
                    lblApellidoP.setText(clienteEncontrado.getApellidoPaterno());
                    lblApellidoM.setText(clienteEncontrado.getApellidoMaterno());
                   
            });
             }
            

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : btn);
            }
        });
            tablaClientes.setItems(listaObservable);
            
        }
        else
        {
             AlertaVacio.AlertaReporteExistente("ERROR", "Campos Vacios", "No puedes dejar campos Vacios");
        }
       
    
    }
    public void generarHorarioCita()
            
    {
        cbxHora.getItems().addAll("10:00 am",
                "11:00 am", 
                "12:00 pm", 
                "1:00 pm", 
                "2:00 pm", 
                "3:00 pm", 
                "4:00 pm", 
                "5:00 pm", 
                "6:00 pm");

        cbxHora.getSelectionModel().selectFirst();
    }
    
    public String recuperarFechaSeleccionadaInicio(DatePicker calendarioRecuperado)
   {
        LocalDate selectedDate = calendarioRecuperado.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = selectedDate.format(formatter);
        return formattedDate;
   }
    public void mostrarDoctores()
    {
        DoctorDAO doctores= new DoctorDAO();
        List<Doctor> listaDoctores = doctores.mostrarInformacion();

        cbxDoctor.getItems().addAll(listaDoctores);
    }

    public void ingresarConsultorio()
    {
        cbxConsultorio.getItems().addAll("1","2");
        cbxConsultorio.getSelectionModel().selectFirst();
    }
    @FXML
    private void guardarCita(ActionEvent event) {
        NotificacionExitosa NotificacionExitosa=new NotificacionExitosa();
        
        CitaDAO registrar=new CitaDAO();
        String nombrePaciente=lblNombre.getText();
        String apellidoPaterno=lblApellidoP.getText();
        String apellidoMaterno=lblApellidoM.getText();
        String fecha=recuperarFechaSeleccionadaInicio(fechaSeleccionada);
        String horario=cbxHora.getSelectionModel().getSelectedItem();
        String medico=String.valueOf(cbxDoctor.getSelectionModel().getSelectedItem());
        String consultorio=cbxConsultorio.getSelectionModel().getSelectedItem();
        String analisis=lblAnalisis.getText();
        
        Doctor doctor=new Doctor();
        doctor.setNombreDoctor(medico);
        
        Cita cita =new Cita(nombrePaciente,
        apellidoPaterno,
        apellidoMaterno,
        fecha,
        horario,
        doctor,
        Integer.parseInt(consultorio),
        analisis,"pendiente");
        registrar.registrarCita(cita, doctor);
        
        NotificacionExitosa.NotificacionExitosa("Notificacion", "Registro Completo", "Se registro la cita correctamente");
        panelGenerarCita.setVisible(false);
        btnNuevo.setVisible(true);
        btnAfiliado.setVisible(true);
    }
}
