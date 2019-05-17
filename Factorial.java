package factorial;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 *
 * @author eri
 */
public class Factorial extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        Button btn = new Button();
        Label numero = new Label("NÚMERO");
        Label resultado = new Label();
        Label palabra = new Label("RESULTADO: ");
        TextField cajaNumero = new TextField();
        
        palabra.setVisible(false);
        numero.setAlignment(Pos.CENTER);
        
        btn.setText("FACTORIAL");
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try{
                    int numeroFac = Integer.parseInt(cajaNumero.getText());
                    double suma = 1;
                    for(int i = numeroFac; i>=1; i--){
                        suma *= i;
                    }
                    String res = String.valueOf(suma);
                    palabra.setVisible(true);
                    resultado.setText(res);
                }
                catch(Exception e){
                    Alert dialogoAlerta = new Alert(AlertType.ERROR); //Se crea el tipo de dialogoAlerta Simple
                    dialogoAlerta.setTitle("¡ERROR!");
                    dialogoAlerta.setHeaderText(null); //Sin título interno
                    dialogoAlerta.setContentText("Contenido en el campo no aceptado.");
                    dialogoAlerta.initStyle(StageStyle.UTILITY);
                    dialogoAlerta.showAndWait(); //Se muestra la ventana
                }
            }
        });
        
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(numero, 0, 2);
        
        grid.add(cajaNumero, 1, 2);
        
        grid.add(btn, 1, 4);
        grid.add(palabra, 0, 10);
        grid.add(resultado, 1, 10);
        
        
        Scene scene = new Scene(grid, 300, 250);
        
        primaryStage.setTitle("Factorial!");
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
