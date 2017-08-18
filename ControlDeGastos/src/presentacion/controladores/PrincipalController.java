/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.controladores;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
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
import logica.Gasto;

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
        fechaConsultar.valueProperty().addListener((ov, oldValue, newValue) -> {
            llenarTabla();
        });
    }    
    
    private void llenarTabla() {
        Gasto gasto = new Gasto();
        columnaGasto.setCellValueFactory(new PropertyValueFactory<>("gasto"));
        columnaDescripcion.setCellFactory(new PropertyValueFactory<>("descripcion"));
        
        LocalDate fecha;
        Date fechaSQL;
        try{
            //tablaGastos.setItems(gasto.consultarGasto(fechaConsultar.getValue()));
        } catch(NullPointerException e) {
            //se va a lanzar diálogo
        }
    }
    
    @FXML
    public void guardarGasto () {
        Gasto gasto = new Gasto();
        
        try {
            if (gastoAgregar.getText().trim().isEmpty()) {
                throw new NullPointerException();
            }
            if (descripcionAgregar.getText().trim().isEmpty()) {
                throw new NullPointerException();
            }
            if (fechaAgregar.getValue().isAfter(LocalDate.now())) {
                throw new LinkageError();
            }
            
            Date fechaSQL = Date.valueOf(fechaAgregar.getValue());
            gasto.setGasto(Double.valueOf(gastoAgregar.getText()));
            gasto.setDescripcion(descripcionAgregar.getText());
            gasto.setFecha(fechaSQL);
            boolean flag = gasto.agregarGasto(gasto);
            System.out.println(flag);
        } catch (NullPointerException e) {
            System.out.println("2");
        } catch (LinkageError ed) {
            System.out.println("1");
        }
    }
    
}
