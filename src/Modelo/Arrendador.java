package Modelo;

import java.util.ArrayList;

public class Arrendador extends Usuario {
    private ArrayList<Vehiculo> vehiculos;

    public Arrendador(String nombre, String apellido, int edad, String direccion, int telefono, String correoElectronico, String tipoIdentificacion, int numeroDelIdentificacion) {
        super(nombre, apellido, edad, direccion, telefono, correoElectronico, tipoIdentificacion, numeroDelIdentificacion);
    }
    public void automovilesEnPropiedad(){

    }
    public void crearVehiculo(){}
}
