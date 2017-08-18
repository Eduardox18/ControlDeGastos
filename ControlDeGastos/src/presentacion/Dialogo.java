package presentacion;

import javafx.scene.control.Alert;

/**
 * Clase que contiene las alertas que se utilizan en el programa, para mostrar información al
 * usuario.
 */
public class Dialogo {

    /**
     * Método que muestra un diálogo con información sobre campos faltantes por llenar.
     */
    public void alertaCamposVacios() {
        Alert alertaCampos = new Alert(Alert.AlertType.WARNING);
        alertaCampos.setTitle("Campos incompletos");
        alertaCampos.setHeaderText("Alerta");
        alertaCampos.setContentText("Por favor completa todos los campos");
        alertaCampos.showAndWait();
    }

    /**
     * Este método muestra un diálogo cuando se trata de seleccionar una fecha que aun no llega
     */
    public void alertarFechaFutura() {
        Alert alertaUsuario = new Alert(Alert.AlertType.WARNING);
        alertaUsuario.setTitle("Fecha erronea");
        alertaUsuario.setHeaderText("Alerta");
        alertaUsuario.setContentText("La fecha ingresada aún no llega");
        alertaUsuario.showAndWait();
    }

    /**
     * Método que muestra un diálogo cuando se produce algún error.
     */
    public void alertaError() {
        Alert alertaUsuario = new Alert(Alert.AlertType.ERROR);
        alertaUsuario.setTitle("Error");
        alertaUsuario.setHeaderText("Error inesperado");
        alertaUsuario.setContentText("Ha ocurrido un error inesperado, consulte "
            + "al programador del Sistema");
        alertaUsuario.showAndWait();
    }

    /**
     * Método que muestra un diálogo indicando que la operación se realizó de manera exitosa
     */
    public void alertaExito() {
        Alert alertaUsuario = new Alert(Alert.AlertType.INFORMATION);
        alertaUsuario.setTitle("Éxito");
        alertaUsuario.setHeaderText("Gasto guardado");
        alertaUsuario.setContentText("Se ha guardado con éxito su gasto.");
        alertaUsuario.showAndWait();
    }
}
