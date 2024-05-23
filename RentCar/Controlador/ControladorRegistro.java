package Controlador;

import Modelo.Arrendador;
import Modelo.Arrendatario;
import Modelo.ListaUsuarios;
import Modelo.Usuario;
import javafx.fxml.FXML;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.concurrent.ThreadLocalRandom;

public class ControladorRegistro {
    private ListaUsuarios usuarios = new ListaUsuarios();
    @FXML
    public void registrarUsuario(String tipoUsuario, String nombre, String apellido, int edad, String direccion, long telefono, String correoElectronico, String tipoIdentificacion, int numeroDelIdentificacion) {
        if (tipoUsuario.equals("Arrendador")) {
            Arrendador nuevo = new Arrendador(nombre, apellido, edad, direccion, telefono, correoElectronico, tipoIdentificacion, numeroDelIdentificacion);
            usuarios.getUsuarios().add(nuevo);
        }
        //aca va una excepcion creo
    }
    @FXML
    public void registrarUsuario(String tipoUsuario, String nombre, String apellido, int edad, String direccion, long telefono, String correoElectronico, String tipoIdentificacion, int numeroDelIdentificacion, boolean licencia, boolean preferencial) {
        if (tipoUsuario.equals("Arrendatario")) {
            Arrendatario nuevo = new Arrendatario(nombre, apellido, edad, direccion, telefono, correoElectronico, tipoIdentificacion, numeroDelIdentificacion, licencia, preferencial);
            usuarios.getUsuarios().add(nuevo);
        }
        //aca va una excepcion creo
    }

    public void cargarBaseDeDatos() {
        usuarios.leerDeArchivos();
        usuarios.cargarVehiculosUsuarios();
    }
    @FXML
    public boolean validarRegistro(String correoElectronico) {
        boolean validar;
        if ((usuarios.validarExistenciaUsuario(correoElectronico)) != null)
            validar = true;
        else validar = false;
        return validar;
    }
    @FXML
    public LocalDate darFechaEvaluacion() {
        LocalDate actual = LocalDate.now();
        LocalDate fin = actual.plusWeeks(2);
        long startEpochDay = actual.toEpochDay();
        long endEpochDay = fin.toEpochDay();
        long f = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay + 1);
        LocalDate fechaVisita = LocalDate.ofEpochDay(f);
        return fechaVisita;
    }
    public void setFechaEvaluacion(){
        usuarios.getUsuarios().forEach(usuario -> {
            if(usuario instanceof Arrendador){
                usuario.getVehiculos().forEach(vehiculo -> {
                    vehiculo.setFechaVisita(darFechaEvaluacion());
                });
            }
        });


    }

    public void imprimir() {
        System.out.println(usuarios.getUsuarios());
        usuarios.getUsuarios().forEach(usuario -> System.out.println(usuario.getVehiculos()));
    }
}
