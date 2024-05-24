package Controlador;

import Modelo.Arrendador;
import Modelo.Arrendatario;
import Modelo.Empresa;
import Modelo.Usuario;
import javafx.fxml.FXML;

import java.awt.*;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ControladorRegistro {
    @FXML
    private Button login,register;
    @FXML
    private TextField eMail, password;
    private  Empresa empresa = Empresa.getInstance();

    @FXML
    public  void registrarUsuario(String tipoUsuario, String nombre, String apellido, int edad, String direccion, long telefono, String correoElectronico, String tipoIdentificacion, int numeroDelIdentificacion) {
        if (tipoUsuario.equals("Arrendador")) {
            Arrendador nuevo = new Arrendador(nombre, apellido, edad, direccion, telefono, correoElectronico, tipoIdentificacion, numeroDelIdentificacion);
            empresa.getUsuarios().add(nuevo);
        }
        //aca va una excepcion creo
    }

    @FXML
    public void registrarUsuario(String tipoUsuario, String nombre, String apellido, int edad, String direccion, long telefono, String correoElectronico, String tipoIdentificacion, int numeroDelIdentificacion, boolean licencia, boolean preferencial) {
        if (tipoUsuario.equals("Arrendatario")) {
            Arrendatario nuevo = new Arrendatario(nombre, apellido, edad, direccion, telefono, correoElectronico, tipoIdentificacion, numeroDelIdentificacion, licencia, preferencial);
            empresa.getUsuarios().add(nuevo);
        }
        //aca va una excepcion creo
    }

   // @FXML


//    private LocalDate darFechaEvaluacion() {
//        LocalDate actual = LocalDate.now();
//        LocalDate fin = actual.plusWeeks(2);
//        long startEpochDay = actual.toEpochDay();
//        long endEpochDay = fin.toEpochDay();
//        long f = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay + 1);
//        LocalDate fechaVisita = LocalDate.ofEpochDay(f);
//        return fechaVisita;
//    }
//
//    public void setFechaEvaluacion(ArrayList<Usuario> usuarios) {
//        usuarios.forEach(usuario -> {
//            if (usuario instanceof Arrendador) {
//                usuario.getVehiculos().forEach(vehiculo -> {
//                    LocalDate fechaEvaluacion = darFechaEvaluacion();
//                    if (fechaEvaluacion != null) {
//                        vehiculo.setFechaVisita(fechaEvaluacion);
//                    }
//                });
//            }
//        });
//    }
    public boolean validarRegistro( ) {
        String correoElectronico= eMail.getText().trim();
        String contraseña= password.getText().trim();
        int contrasena=Integer.parseInt(contraseña);
        return empresa.getUsuarios().stream()
                .anyMatch(usuario -> usuario.getCorreoElectronico().equals(correoElectronico) &&
                        usuario.getNumeroDelIdentificacion() == contrasena);
    }

}
