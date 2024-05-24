package Modelo;

import java.time.LocalTime;
import java.util.ArrayList;

public class Oficina {
    private int id;
    private String pais;
    private String ciudad;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private ArrayList<Vehiculo> vehiculos;


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