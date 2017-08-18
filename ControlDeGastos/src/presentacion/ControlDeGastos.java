/**
 * Nombre del programa: Control de Gastos
 * Versión: 0.1
 * Autores:
 *          Domínguez Delgado Ángel Eduardo
 *          Domínguez González José Andrés
 * Fecha de inicio del desarrollo: 18 de Agosto de 2017
 * Descripción: Programa que permite llevar el control de gastos de un usuario.
 */
package presentacion;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Clase principal que permite ejecutar la ventana principal del programa.
 */
public class ControlDeGastos extends Application {

    private static BorderPane root = new BorderPane();

    /**
     * Función que ejecuta la ventana principal del sistema y define todos sus atributos.
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {

        AnchorPane panePrincipal = null;
        Dialogo dialogo = new Dialogo();

        URL principal = getClass().getResource("/presentacion/Principal.fxml");
        try {
            panePrincipal = FXMLLoader.load(principal);
        } catch (IOException e) {
            dialogo.alertaError();
        }

        root.setCenter(panePrincipal);

        Scene scene = new Scene(root, 410, 334);
        primaryStage.setTitle("Control de gastos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Función main del programa.
     */
    public static void main(String[] args) {
        launch(args);
    }

}
