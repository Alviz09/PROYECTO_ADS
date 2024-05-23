package Modelo;

import java.util.ArrayList;

public class Arrendador extends Usuario {


    public Arrendador(String nombre, String apellido, int edad, String direccion, long telefono, String correoElectronico, String tipoIdentificacion, int numeroDelIdentificacion) {
        super(nombre, apellido, edad, direccion, telefono, correoElectronico, tipoIdentificacion, numeroDelIdentificacion);

    }
    public Arrendador(String nombre, String apellido, int edad, String direccion, long telefono, String correoElectronico, String tipoIdentificacion, int numeroDelIdentificacion,  boolean licenciaConduccion, boolean preferencial, ArrayList<Vehiculo> vehiculos) {
        super(nombre, apellido, edad, direccion, telefono, correoElectronico, tipoIdentificacion, numeroDelIdentificacion, vehiculos);
    }
}
