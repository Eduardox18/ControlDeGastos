/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author José Andrés Domínguez González
 */
public class ControlDeGastos extends Application {
    
    private static BorderPane root = new BorderPane();
    
    @Override
    public void start(Stage primaryStage) {
        
        AnchorPane panePrincipal = null;
        
        URL principal = getClass().getResource("/presentacion/Principal.fxml");
        try {
            panePrincipal = FXMLLoader.load(principal);
        } catch (IOException e) {
            //Error
        }
        
        root.setCenter(panePrincipal);
        
        Scene scene = new Scene(root, 410, 334);
        primaryStage.setTitle("Control de gastos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
