package Controlador;


import Excepciones.ExcepcionLogica;
import Excepciones.ExcepcionRango;
import Excepciones.ExcepcionRepeticion;
import Excepciones.ExceptionContenedor;
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
            if(edad<18){
                throw new ExcepcionRango();
            }
            String direccion = arrendadorDireccionTxtField.getText().trim();
            long telefono = Long.parseLong(arrendadorCelularTxtField.getText().trim());
            if((telefono< Long.parseLong("3000000000"))||(telefono>Long.parseLong("4000000000"))){
                throw new ExcepcionRango();
            }
            String correoElectronico = arrendadorMailTxtField.getText().trim();
            if(!(correoElectronico.contains("@"))){
                throw new ExceptionContenedor();
            }
            if(empresa.getUsuarios().stream().anyMatch(usuario -> usuario.getCorreoElectronico().equals(correoElectronico))){
                throw new ExcepcionRepeticion();
            }
            String tipoIdentificacion = arrendadorTipoDocTxtField.getText().trim();
            if(!(tipoIdentificacion.length()==2)){
                throw new ExcepcionRango();
            }
            Long numeroDelIdentificacion = Long.parseLong(arrendadorIdTxtField.getText().trim());
            if((numeroDelIdentificacion > Long.parseLong("9999999999"))||(numeroDelIdentificacion < Long.parseLong("10000000"))){
                throw new ExcepcionRango();
            }

            Arrendador nuevo = new Arrendador(nombre, apellido, edad, direccion, telefono, correoElectronico, tipoIdentificacion, numeroDelIdentificacion);
            empresa.getUsuarios().add(nuevo);
            mostrarMensaje("Registro existoso");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/MainView.fxml"));
            Scene mainScene = new Scene(loader.load());Stage stage = (Stage) confirmarRegistroArrendador.getScene().getWindow();
            stage.setScene(mainScene);
            stage.show();

        } catch  (ExcepcionRepeticion e){
            mostrarMensaje("Correo ya existe");
        } catch (ExceptionContenedor e){
            mostrarMensaje("el correo debe tener un @");
        }catch (ExcepcionRango e){
            mostrarMensaje("error en los valores ingresados (por su rango, es decir numeros negativos y la cantidad de numeros o cadena de carecteres con cierta longitud");
        }catch (NumberFormatException e) {

            mostrarMensaje("Ingrese bien los dsatos de su celular y ID");
        } catch (Exception e) {
            e.printStackTrace();
            mostrarMensaje("Error en el registro de Arrendador");
        }
    }


    @FXML
    public void registrarArrendatario() {
        try {
            String nombre = arrendadorNombreTxtField.getText().trim();
            String apellido = arrendadorApellitdoTxtField.getText().trim();
            int edad = Integer.parseInt(arrendadorEdadTxtField.getText().trim());
            if(edad<18){
                throw new ExcepcionRango();
            }
            String direccion = arrendadorDireccionTxtField.getText().trim();
            long telefono = Long.parseLong(arrendadorCelularTxtField.getText().trim());

            if((telefono< Long.parseLong("3000000000"))||(telefono>Long.parseLong("4000000000"))){
                throw new ExcepcionRango();
            }
            String correoElectronico = arrendadorMailTxtField.getText().trim();
            if(!(correoElectronico.contains("@"))){
                throw new ExceptionContenedor();
            }
            if(empresa.getUsuarios().stream().anyMatch(usuario -> usuario.getCorreoElectronico().equals(correoElectronico))){
                throw new ExcepcionRepeticion();
            }
            String tipoIdentificacion = arrendadorTipoDocTxtField.getText().trim();
            if(!(tipoIdentificacion.length()==2)){
                throw new ExcepcionRango();
            }
            Long numeroDelIdentificacion = Long.parseLong(arrendadorIdTxtField.getText().trim());
            if((numeroDelIdentificacion > Long.parseLong("9999999999"))||(numeroDelIdentificacion < Long.parseLong("10000000"))){
                throw new ExcepcionRango();
            }
            String licencia=existenciaLicencia.getText().trim();
            boolean tieneLicencia;
            if(licencia.equals("si")){
                tieneLicencia=true;
            }else if(licencia.equals("no")){
                tieneLicencia=false;
            }else{
                throw new ExcepcionLogica();
            }
            boolean preferencial=false;
            Arrendatario nuevo = new Arrendatario(nombre, apellido, edad, direccion, telefono, correoElectronico, tipoIdentificacion, numeroDelIdentificacion,tieneLicencia,preferencial);
            empresa.getUsuarios().add(nuevo);
            for(Usuario u : empresa.getUsuarios()){
                System.out.println(u.getNombre()+"\n");
            }
            empresa.guardarArchivo();
            mostrarMensaje("Registro existoso");
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/MainView.fxml"));
                Stage stage = (Stage) registrarArrendatario.getScene().getWindow();
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }catch  (ExcepcionRepeticion e){
            mostrarMensaje("Correo ya existe");
        } catch (ExceptionContenedor e){
            mostrarMensaje("el correo debe tener un @");
        }catch (ExcepcionRango e){
            mostrarMensaje("error en los valores ingresados (por su rango, es decir numeros negativos y la cantidad de numeros o cadena de carecteres con cierta longitud");
        }catch (ExcepcionLogica e){
            mostrarMensaje("en apartado de licencia debe decir si o no, elija por favor");
        }catch (NumberFormatException e) {

            mostrarMensaje("Ingrese bien los dsatos de su celular y ID");
        } catch (Exception e) {
            e.printStackTrace();
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

