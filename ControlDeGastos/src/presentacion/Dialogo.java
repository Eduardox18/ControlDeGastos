/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import javafx.scene.control.Alert;

/**
 *
 * @author José Andrés Domínguez González
 */
public class Dialogo {
    
    public void alertaCamposVacios() {
        Alert alertaCampos = new Alert(Alert.AlertType.WARNING);
        alertaCampos.setTitle("Campos incompletos");
        alertaCampos.setHeaderText("Alerta");
        alertaCampos.setContentText("Por favor completa todos los campos");
        alertaCampos.showAndWait();
    }
    
    public void alertarFechaFutura() {
        Alert alertaUsuario = new Alert(Alert.AlertType.WARNING);
        alertaUsuario.setTitle("Fecha erronea");
        alertaUsuario.setHeaderText("Alerta");
        alertaUsuario.setContentText("La fecha ingresada aun no llega");
        alertaUsuario.showAndWait();
    }
    
    public void alertaError() {
        Alert alertaUsuario = new Alert(Alert.AlertType.ERROR);
        alertaUsuario.setTitle("Error");
        alertaUsuario.setHeaderText("Error inesperado");
        alertaUsuario.setContentText("Ha ocurrido un error inesperado, consulte "
            + "al programador del Sistema SIGA");
        alertaUsuario.showAndWait();
    }
}
