package Vistas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class InterfazApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root= FXMLLoader.load(getClass().getResource("MainView.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        //primaryStage.setTitle("porfabor funciona");
        primaryStage.setScene(new Scene(root, 520,400));
        primaryStage.show();
    }
}
