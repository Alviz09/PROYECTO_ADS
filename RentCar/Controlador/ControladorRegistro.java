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

public class ControladorRegistro {
    @FXML
    private TextField eMail,arrendadorNombreTxtField,arrendadorApellitdoTxtField,arrendadorEdadTxtField,arrendadorDireccionTxtField,arrendadorCelularTxtField, arrendadorMailTxtField,arrendadorTipoDocTxtField,arrendadorIdTxtField;
    @FXML
    private PasswordField password;
    @FXML
    private Button registrarse,iniciarSesion,salir, volver,confirmarRegistroArrendador,registarArrendador;
    @FXML
    private Label mensajeInicioDeSesion;
    private Empresa empresa = Empresa.getInstance();



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
            mostrarMensaje("incio existoso");
            volverAMainView();
            // Muestra un mensaje de éxito si se agrega correctamente
        } catch (NumberFormatException e) {
            // Maneja errores de formato de número
            mostrarMensaje("Error en el formato de los datos");
        } catch (Exception e) {
            // Maneja otros posibles errores
            mostrarMensaje("Error en el registro de Arrendador");
        }
    }

    @FXML
    public void registrarUsuario(String tipoUsuario, String nombre, String apellido, int edad, String direccion, long telefono, String correoElectronico, String tipoIdentificacion, int numeroDelIdentificacion, boolean licencia, boolean preferencial) {
        Arrendatario nuevo = new Arrendatario(nombre, apellido, edad, direccion, telefono, correoElectronico, tipoIdentificacion, numeroDelIdentificacion, licencia, preferencial=false);
        empresa.getUsuarios().add(nuevo);
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
    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mensaje");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}

