package Modelo;

import java.util.ArrayList;

public class Arrendador extends Usuario {
    private ArrayList<Vehiculo> vehiculos;

    public Arrendador(String nombre, String apellido, int edad, String direccion, int telefono, String correoElectronico, String tipoIdentificacion, int numeroDelIdentificacion, ArrayList<Vehiculo> vehiculos) {
        super(nombre, apellido, edad, direccion, telefono, correoElectronico, tipoIdentificacion, numeroDelIdentificacion);
        this.vehiculos=new ArrayList<>();
    }
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    public void automovilesEnPropiedad(){

    }
    public void crearVehiculo(){}
}
