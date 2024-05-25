package Modelo;

import java.time.LocalTime;
import java.util.ArrayList;

public class Oficina {
    private int id;
    private String pais;
    private String ciudad;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private ArrayList<Vehiculo> vehiculos=new ArrayList<>();


    public Oficina(int id, String pais, String ciudad, LocalTime horaInicio, LocalTime horaFin) {
        this.id = id;
        this.pais = pais;
        this.ciudad = ciudad;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    public int getId() {
        return id;
    }
    public void crearVehiculo(int idTarjetaDePropiedad, int cantidadSillas, int numPuertas, float capacidadLitrosMotor, String color, String placa, String marca, String modelo, float precioPorDia, String tipoVehiculo, String ciudad, String pais, String categoria, boolean kitCarretera) {
        Vehiculo nuevo = new Vehiculo(idTarjetaDePropiedad, cantidadSillas, numPuertas, capacidadLitrosMotor, color, placa, marca, modelo, precioPorDia, tipoVehiculo, ciudad, pais, categoria, kitCarretera);
        vehiculos.add(nuevo);
    }


    public String getPais() {
        return pais;
    }

    public String getCiudad() {
        return  ciudad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public LocalTime getHoraInicioJornada() {
        return horaInicio;
    }

    public void setHoraInicioJornada(LocalTime horaInicioJornada) {
        this.horaInicio = horaInicioJornada;
    }

    public LocalTime getHoraFinJornada() {
        return horaFin;
    }

    public void setHoraFinJornada(LocalTime horaFinJornada) {
        this.horaFin = horaFinJornada;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}