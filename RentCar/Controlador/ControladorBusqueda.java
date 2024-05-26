package Controlador;

import Modelo.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ControladorBusqueda {


    public TextArea txtMostradorFinViaje;
    public TextField ingresoVehiculo;
    public TextField ingresoOficina;
    public Button mostrarVehiculosOficina;
    public Button mostrarOficinas;
    public Button buscarVehiculo;
    public Button pagar;
    public Button finViaje;
    public Button adicionarTiempo;
    public Button cerrarSesionArrendador;
    public TextField txtMostrador1;
    public TextArea txtPlacaVehiculo;
    public Button mostrarVehiculosEnPropiedad;
    public Button volver;
    public CheckBox getVentanas;
    public CheckBox getLlantas;
    public CheckBox getSeguroTotal;
    public TextField sillaBebe;
    public TextField disGPS;
    public TextField conductorAdicional;
    public Button registrarUsuario;
    public TextField maletero;
    private Empresa empresa = Empresa.getInstance();





    public void mostrarPantalla(javafx.event.ActionEvent actionEvent) {
    }

    public void mostrarOficinas(javafx.event.ActionEvent actionEvent) {
        txtMostrador1.setText("");
        for(Oficina s : empresa.getOficinas()){

            txtMostrador1.appendText("id: " + s.getId() + " \nPais: "+ s.getPais()+ " \nCiudad: "+ s.getCiudad() +"\n");
        }
    }

    public void mostrarVehiculos(javafx.event.ActionEvent actionEvent) {
    }

    public void datoIdOficina(javafx.event.ActionEvent actionEvent) {
    }

    public void datoIdVehiculo(javafx.event.ActionEvent actionEvent) {
    }

    public void volverMenuArrendador(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/MenuSearchRenterView.fxml"));
            Stage stage = (Stage) cerrarSesionArrendador.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ejecutarBuscadorArrendatario(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/RenterSearchView.fxml"));
            Stage stage = (Stage) buscarVehiculo.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void finViaje(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/EndTripView.fxml"));
            Stage stage = (Stage) finViaje.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AdicionarTiempo(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/MoreTimeView.fxml"));
            Stage stage = (Stage) adicionarTiempo.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cerrarSesion(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/MainView.fxml"));
            Stage stage = (Stage) cerrarSesionArrendador.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void datoPlacaVehiculo(ActionEvent actionEvent) {
    }

    public void eliminarVehiculo(ActionEvent actionEvent) {
    }

    public void ejecutarBuscadorVehiculos(ActionEvent actionEvent) {
    }
    public void volverMenuPrincipal(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/MenuSearchRenterView.fxml"));
            Stage stage = (Stage) volver.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
