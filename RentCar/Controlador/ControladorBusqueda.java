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
    public Button volverBuscador;
    public TextField ingresoVehiculo;
    public TextField ingresoOficina;
    public Button mostrarVehiculosOficina;
    public Button mostrarOficinas;
    public Button buscarVehiculo;
    public Button pagar;
    public Button finViaje;
    public Button adicionarTiempo;
    public Button cerrarSesionArrendador;
    public TextArea txtMostrador1;
    public TextArea txtPlacaVehiculo;
    public Button volverFinViaje;
    public Button mostrarVehiculosEnPropiedad;
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
    }

    public void ejecutarBuscadorArrendatario(javafx.event.ActionEvent actionEvent) {

    }

    public void PagarViaje(javafx.event.ActionEvent actionEvent) {
    }

    public void finViaje(javafx.event.ActionEvent actionEvent) {
    }

    public void AdicionarTiempo(javafx.event.ActionEvent actionEvent) {
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
}
/*
    public Vehiculo buscarVehiculo(int n ){
        Vehiculo encontrado ;
        return encontrado;
    }
    public Usuario buscarUsuario(String correoElectronico, String tipoUsuario){
        Usuario usuarioEncontrado;
        return usuarioEncontrado;
    }
    public Oficina buscarOficina(int id ){
        Oficina oficinaEncontrada;
        return oficinaEncontrada;
    }
    public boolean validarUsuario(){
        boolean preferencial=false;
        return preferencial;
    }
    public Date organizarVisitaCarro(){
        Date fehcaVIsita;
        return fehcaVIsita;
    }


    public void añadirServicioAdicional(){

    }
    public Date guardarInformacion(){

        Date infoGuardada;
        return infoGuardada;
    }
 */
