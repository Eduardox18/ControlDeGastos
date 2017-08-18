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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import presentacion.Dialogo;

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
    private TableView<Gasto> tablaGastos;
    @FXML
    private TableColumn<Gasto, Double> columnaGasto;
    @FXML
    private TableColumn<Gasto, String> columnaDescripcion;
    @FXML
    private Label etiquetaGranTotal;
    @FXML
    private Label granTotal;
    @FXML
    private Button botonGuardar;
    
    Dialogo dialogo = new Dialogo();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Gasto gasto = new Gasto();
        granTotal.setText("0.00");
        
        fechaConsultar.valueProperty().addListener((ov, oldValue, newValue) -> {
            llenarTabla();
            granTotal.setText(gasto.sumarTotal(tablaGastos.getItems()));
        });
        
        gastoAgregar.textProperty().addListener((ObservableValue<? extends String> observable, 
            String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                gastoAgregar.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }    
    
    private void llenarTabla() {
        Gasto gasto = new Gasto();
        columnaGasto.setCellValueFactory(new PropertyValueFactory<>("gasto"));
        columnaDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        Date fecha = Date.valueOf(fechaConsultar.getValue());
        try{
            tablaGastos.setItems(gasto.consultarGasto(fecha));
        } catch(NullPointerException e) {
            dialogo.alertaError();
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
            
            gasto.agregarGasto(gasto);
            dialogo.alertaExito();
            limpiarCampos();
        } catch (NullPointerException e) {
            dialogo.alertaCamposVacios();
        } catch (LinkageError ed) {
            dialogo.alertarFechaFutura();
        }
    }
    
    public void limpiarCampos() {
        gastoAgregar.setText("");
        descripcionAgregar.setText("");
        fechaAgregar.setValue(null);
    }
    
}
