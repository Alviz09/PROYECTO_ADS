package Modelo;

import java.util.ArrayList;

public class Arrendador extends Usuario {
    private ArrayList<Vehiculo> vehiculos;

    public Arrendador(String nombre, String apellido, int edad, String direccion, long telefono, String correoElectronico, String tipoIdentificacion, int numeroDelIdentificacion) {
        super(nombre, apellido, edad, direccion, telefono, correoElectronico, tipoIdentificacion, numeroDelIdentificacion);
        this.vehiculos=new ArrayList<>();
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void crearVehiculo(int idTarjetaDePropiedad, int cantidadSillas, int numPuertas, float capacidadLitrosMotor, String color, String placa, String marca, String modelo, float precioPorDia, String tipoVehiculo, String ciudad, String pais, String categoria, boolean kitCarretera){
        Vehiculo nuevo = new Vehiculo(idTarjetaDePropiedad,cantidadSillas,numPuertas,capacidadLitrosMotor,color,placa,marca,modelo,precioPorDia,tipoVehiculo,ciudad,pais,categoria,kitCarretera);
            vehiculos.add(nuevo);
    }
}
