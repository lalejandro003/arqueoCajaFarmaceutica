/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controladores;

import DAO.CitaDAO;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import modelos.Cita;

/**
 * FXML Controller class
 *
 * @author ll621
 */
public class MedicoVentanaControlador implements Initializable {

    @FXML
    private ComboBox<?> cbxSexo;
    @FXML
    private TextField txtEstatura;
    @FXML
    private TextField txtPeso;
    @FXML
    private TextField txtEstatura1;
    @FXML
    private Button btnAgregar;
    @FXML
    private Pane panelMediacamentos;
    @FXML
    private Button btnCerrarVentana;
    @FXML
    private TextField txtTemperatura;
    @FXML
    private ComboBox<?> cbxSexo1;
    @FXML
    private Pane panelNotifiaciones;
    @FXML
    private TableColumn colFecha;
    @FXML
    private TableColumn colInformacion;
    @FXML
    private TableColumn colBotones;

    private ObservableList<Cita> Citas;
    @FXML
    private Label nombreMedico;
    @FXML
    private Label cedulaMedico;
    @FXML
    private TableColumn colNombre;
    @FXML
    private Label lblFecha;
    @FXML
    private TableView<Cita> tablaCitas;
    @FXML
    private Label lblNombrePaciente;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void agregarNuevoMedicamento(ActionEvent event) {
        panelMediacamentos.setVisible(true);
    }

    @FXML
    private void CerrarVentana(ActionEvent event) {
        panelMediacamentos.setVisible(false);
    }

    @FXML
    private void mostrarNotificaciones(ActionEvent event) {
        panelNotifiaciones.setVisible(true);
        CitaDAO citas=new CitaDAO();
        String fecha=mostrarFecha();
        String nombreDoctor=nombreMedico.getText();
       
        List<Cita> Citas =  citas.mostrarCitas(nombreDoctor, fecha);
        
        ObservableList<Cita> listaObservable = FXCollections.observableArrayList(Citas);
        
        
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombrePaciente"));
        colInformacion.setCellValueFactory(new PropertyValueFactory<>("analisisCita"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaCita"));
        colBotones.setCellFactory(param -> new TableCell<Cita, Void>() {//AGREGAR BOTON DENTRO DE LA TABLA
            private final Button btn = new Button("ACEPTAR");
            
             {
            btn.setOnAction(event -> {
                    Cita citaPaciente = getTableView().getItems().get(getIndex());
                    lblNombrePaciente.setText(citaPaciente.getNombrePaciente());
                    panelNotifiaciones.setVisible(false);
            });
             }
            

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : btn);
            }
        });

        // Establecer la lista observable como el contenido de la tabla
        tablaCitas.setItems(listaObservable);
    }

    @FXML
    private void regresarVentanaPrincipal(ActionEvent event) {
        panelNotifiaciones.setVisible(false);
    }
    public String mostrarFecha()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String horaActual = dateFormat.format(new Date());
        lblFecha.setText("" + horaActual);
        return horaActual;
    }
}
