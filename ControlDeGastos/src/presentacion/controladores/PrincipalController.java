/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author José Andrés Domínguez González
 */
public class PrincipalController implements Initializable {

    @FXML
    private Tab pestaniaAgregar;
    @FXML
    private Tab pestaniaConsultar;
    @FXML
    private DatePicker fechaAgregar;
    @FXML
    private DatePicker fechaConsultar;
    @FXML
    private TextField gastoAgregar;
    @FXML
    private TextField descripcionAgregar;
    @FXML
    private TableView tablaGastos;
    @FXML
    private TableColumn columnaGasto;
    @FXML
    private TableColumn columnaDescripcion;
    @FXML
    private Label etiquetaGranTotal;
    @FXML
    private Label granTotal;
    @FXML
    private Button botonGuardar;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    private int llenarTabla() {
        columnaGasto.setCellValueFactory(new PropertyValueFactory<>("gasto"));
        columnaDescripcion.setCellFactory(new PropertyValueFactory<>("descripcion"));
        
   
    }
    
}
