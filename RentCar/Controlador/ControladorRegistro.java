package Controlador;

import Modelo.Arrendador;
import Modelo.Arrendatario;
import Modelo.Empresa;
import Modelo.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;

public class ControladorRegistro  {
    @FXML
    private TextField eMail, arrendadorNombreTxtField, arrendadorApellitdoTxtField, arrendadorEdadTxtField, arrendadorDireccionTxtField, arrendadorCelularTxtField, arrendadorMailTxtField, arrendadorTipoDocTxtField, arrendadorIdTxtField,existenciaLicencia;
    @FXML
    private PasswordField password;
    @FXML
    private Button registrarse, iniciarSesion, salir, volver, confirmarRegistroArrendador, registarArrendador,registrarArrendatario;
    @FXML
    private Label mensajeInicioDeSesion;
    private Empresa empresa = Empresa.getInstance();

    public void salirOnAction() {
        Stage stage = (Stage) salir.getScene().getWindow();
        stage.close();
    }

    public void registrarArrendador() {
        try {
            String nombre = arrendadorNombreTxtField.getText().trim();
            String apellido = arrendadorApellitdoTxtField.getText().trim();
            int edad = Integer.parseInt(arrendadorEdadTxtField.getText().trim());
            String direccion = arrendadorDireccionTxtField.getText().trim();
            long telefono = Long.parseLong(arrendadorCelularTxtField.getText().trim());
            String correoElectronico = arrendadorMailTxtField.getText().trim();
            String tipoIdentificacion = arrendadorTipoDocTxtField.getText().trim();
            int numeroDelIdentificacion = Integer.parseInt(arrendadorIdTxtField.getText().trim());

            Arrendador nuevo = new Arrendador(nombre, apellido, edad, direccion, telefono, correoElectronico, tipoIdentificacion, numeroDelIdentificacion);
            empresa.getUsuarios().add(nuevo);
            mostrarMensaje("Registro existoso");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/MainView.fxml"));
            Scene mainScene = new Scene(loader.load());Stage stage = (Stage) confirmarRegistroArrendador.getScene().getWindow();
            stage.setScene(mainScene);
            stage.show();

        } catch (NumberFormatException e) {

            mostrarMensaje("Error en el formato de los datos");
        } catch (Exception e) {

            mostrarMensaje("Error en el registro de Arrendador");
        }
    }


    @FXML
    public void registrarArrendatario() {
        try {
            String nombre = arrendadorNombreTxtField.getText().trim();
            String apellido = arrendadorApellitdoTxtField.getText().trim();
            int edad = Integer.parseInt(arrendadorEdadTxtField.getText().trim());
            String direccion = arrendadorDireccionTxtField.getText().trim();
            long telefono = Long.parseLong(arrendadorCelularTxtField.getText().trim());
            String correoElectronico = arrendadorMailTxtField.getText().trim();
            String tipoIdentificacion = arrendadorTipoDocTxtField.getText().trim();
            int numeroDelIdentificacion = Integer.parseInt(arrendadorIdTxtField.getText().trim());
            String licencia=existenciaLicencia.getText().trim();
            boolean tieneLicencia;
            if(licencia.equals("no"))
                tieneLicencia=true;
            else
                tieneLicencia=false;
            boolean preferencial=false;
            Arrendatario nuevo = new Arrendatario(nombre, apellido, edad, direccion, telefono, correoElectronico, tipoIdentificacion, numeroDelIdentificacion,tieneLicencia,preferencial);
            empresa.getUsuarios().add(nuevo);
            mostrarMensaje("Registro existoso");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/MainView.fxml"));
            Scene mainScene = new Scene(loader.load());Stage stage = (Stage) confirmarRegistroArrendador.getScene().getWindow();
            stage.setScene(mainScene);
            stage.show();

        } catch (NumberFormatException e) {

            mostrarMensaje("Ingrese bien los dsatos de su celular y ID");
        } catch (Exception e) {

            mostrarMensaje("Error en el registro de Arrendador");
        }
    }

    @FXML
    private LocalDate darFechaEvaluacion() {
        LocalDate actual = LocalDate.now();
        LocalDate fin = actual.plusWeeks(2);
        long startEpochDay = actual.toEpochDay();
        long endEpochDay = fin.toEpochDay();
        long f = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay + 1);
        LocalDate fechaVisita = LocalDate.ofEpochDay(f);
        return fechaVisita;
    }

    public void setFechaEvaluacion(ArrayList<Usuario> usuarios) {
        usuarios.forEach(usuario -> {
            if (usuario instanceof Arrendador) {
                usuario.getVehiculos().forEach(vehiculo -> {
                    LocalDate fechaEvaluacion = darFechaEvaluacion();
                    if (fechaEvaluacion != null) {
                        vehiculo.setFechaVisita(fechaEvaluacion);
                    }
                });
            }
        });
    }

    @FXML
    public void validarRegistro() throws Exception {
        try {
            String correoElectronico = eMail.getText().trim();
            String contraseña = password.getText().trim();
            int contrasena = Integer.parseInt(contraseña);
            boolean existe = empresa.getUsuarios().stream().anyMatch(usuario -> usuario.getCorreoElectronico().equals(correoElectronico) && usuario.getNumeroDelIdentificacion() == contrasena);

            if (existe == true)
                mensajeInicioDeSesion.setText("inicio de sesion existoso");
            else
                mensajeInicioDeSesion.setText("Usuario o contrasñea no existen, intente otra vez");
        } catch (NumberFormatException e) {
            mostrarMensaje("intete ingresar su contraseña denuevo, su contraseña es su ID");
        }
        catch (Exception e ){
            mostrarMensaje("intete ingresar su contraseña denuevo, su contraseña es su ID");
        }
    }

    @FXML
    public void registroOnAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/RegisterView.fxml"));
            Stage stage = (Stage) registrarse.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void registroArrendadorOnAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/RegistroArrendadorView.fxml"));
            Stage stage = (Stage) registarArrendador.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void registroArrendatarioOnAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/RegistroArrendatarioView.fxml"));
            Stage stage = (Stage) registrarArrendatario.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void volverAMainView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/MainView.fxml"));
            Stage stage = (Stage) volver.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void volverARegisterView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/RegisterView.fxml"));
            Stage stage = (Stage) volver.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mensaje");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}

