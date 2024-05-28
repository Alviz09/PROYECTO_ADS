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
public class ControladorMenuPrincipal {
    public Button salir;
    public Label mensajeInicioDeSesion;
    public Button iniciarSesion;
    public Button registrarse;
    public PasswordField password;
    public TextField eMail;
    private Empresa empresa = Empresa.getInstance();
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

    public void salirOnAction(){
        Stage stage= (Stage) salir.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void validarRegistro() throws Exception{
        try {
            ArrayList<Usuario> users = empresa.getUsuarios();
            String correoElectronico = eMail.getText().trim();
            String contraseña = password.getText().trim();
            int contrasena = Integer.parseInt(contraseña);
            boolean existe = empresa.getUsuarios().stream().anyMatch(usuario -> usuario.getCorreoElectronico().equals(correoElectronico) && usuario.getNumeroDelIdentificacion() == contrasena);

            if (existe == true){
                mensajeInicioDeSesion.setText("inicio de sesion existoso");
                Usuario user = empresa.getUsuarios().stream().filter(usuario -> usuario.getCorreoElectronico().equals(correoElectronico)).limit(1).findFirst().orElse(null);
                empresa.setUsuarioEnElSistema(user);
                abrirBusqueda(user);
            }

            else
                mensajeInicioDeSesion.setText("Usuario o contraseña no existen, intente otra vez");
        }catch (NumberFormatException e){
            mostrarMensaje("Su contraseña es incorrecta");
        }
    }
    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mensaje");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    private void abrirBusqueda(Usuario user){
        if(user instanceof Arrendatario){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/MenuSearchRenterView.fxml"));
                Stage stage = (Stage) registrarse.getScene().getWindow();
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
                empresa.setContratos(Archivos.leerArchivosContratos(empresa.getUsuarioEnElSistema().getCorreoElectronico()));
                empresa.agregarContratos( user.getCorreoElectronico());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/MenuSearchTenantView.fxml"));
                Stage stage = (Stage) registrarse.getScene().getWindow();
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


