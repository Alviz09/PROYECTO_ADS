package Controlador;

import Modelo.Arrendador;
import Modelo.Arrendatario;
import Modelo.Empresa;
import Modelo.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ControladorBusqueda {

    public Button mostrarOficinas, mostrarVehiculos;
    public Button pagar;
    public Button buscarVehiculo;
    public Button finViaje;
    public Button adicionarTiempo;
    private Empresa empresa = Empresa.getInstance();

    @FXML
    private TextField ingresoVehiculo,ingresoOficina;
    @FXML
    private PasswordField password;
    @FXML
    private Button registrarse,iniciarSesion,salir, volver,confirmarRegistroArrendador,registarArrendador;
    @FXML
    private Label mensajeInicioDeSesion;


    public void PagarViaje(ActionEvent actionEvent) {
    }

    public void finViaje(ActionEvent actionEvent) {
    }

    public void AdicionarTiempo(ActionEvent actionEvent) {
    }

    public void ejecutarBuscadorArrendatario(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/RegistroArrendadorView.fxml"));
            Stage stage = (Stage) buscarVehiculo.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void PagarViaje(javafx.event.ActionEvent actionEvent) {
    }

    public void finViaje(javafx.event.ActionEvent actionEvent) {
    }

    public void AdicionarTiempo(javafx.event.ActionEvent actionEvent) {
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