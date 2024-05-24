package Controlador;

import Modelo.Arrendador;
import Modelo.Arrendatario;
import Modelo.Empresa;
import Modelo.Usuario;
import javafx.fxml.FXML;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ControladorRegistro {
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

    @FXML
    public boolean validarRegistro(String correoElectronico, int paswsword) {
        validarExistenciaUsuario(correoElectronico);
        validarContraseñaUsuario(paswsword);
    }

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

    private boolean validarExistenciaUsuario(String correoElectronico) {
        Map<String, Usuario> userByname = new HashMap<>();
        empresa.getUsuarios().forEach(usuario -> {
            userByname.put(usuario.getCorreoElectronico(), usuario);
        });
        if ((userByname.get(correoElectronico)) != null) {
            return true;
        } else {
            return false;
        }

    }

    private boolean validarContraseñaUsuario(int numeroId) {
        Map<Integer, Usuario> userBypassword = new HashMap<>();
        empresa.getUsuarios().forEach(usuario -> {
            userBypassword.put(usuario.getNumeroDelIdentificacion(), usuario);
        });
        if ((userBypassword.get(numeroId)) != null) {
            return true;
        } else {
            return false;
        }

    }
}
