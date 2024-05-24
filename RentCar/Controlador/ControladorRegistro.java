package Controlador;

import Modelo.Arrendador;
import Modelo.Arrendatario;
import Modelo.Empresa;
import Modelo.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ControladorRegistro {
    @FXML
    private TextField eMail;
    @FXML
    private PasswordField password;
    @FXML
    private Button registrarse,iniciarSesion,salir;
    @FXML
    private Label mensajeInicioDeSesion;
    private Empresa empresa = Empresa.getInstance();

    public void salirOnAction(){
        Stage stage= (Stage) salir.getScene().getWindow();
        stage.close();
    }

    public void registrarUsuario(String tipoUsuario, String nombre, String apellido, int edad, String direccion, long telefono, String correoElectronico, String tipoIdentificacion, int numeroDelIdentificacion) {
        Arrendador nuevo = new Arrendador(nombre, apellido, edad, direccion, telefono, correoElectronico, tipoIdentificacion, numeroDelIdentificacion);
        empresa.getUsuarios().add(nuevo);
    }

    @FXML
    public void registrarUsuario(String tipoUsuario, String nombre, String apellido, int edad, String direccion, long telefono, String correoElectronico, String tipoIdentificacion, int numeroDelIdentificacion, boolean licencia, boolean preferencial) {
        Arrendatario nuevo = new Arrendatario(nombre, apellido, edad, direccion, telefono, correoElectronico, tipoIdentificacion, numeroDelIdentificacion, licencia, preferencial);
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
    public void validarRegistro() throws Exception{
        String correoElectronico = eMail.getText().trim();
        String contraseña = password.getText().trim();
        int contrasena = Integer.parseInt(contraseña);
        boolean existe= empresa.getUsuarios().stream().anyMatch(usuario -> usuario.getCorreoElectronico().equals(correoElectronico) && usuario.getNumeroDelIdentificacion() == contrasena);

        if(existe==true)
            mensajeInicioDeSesion.setText("inicio de sesion existoso");
        else
            mensajeInicioDeSesion.setText("inicio de sesion fallido, intente otra vez");
    }

}