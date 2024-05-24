package Modelo;

import java.util.ArrayList;

public class Oficina {
    private int id;
    private String pais;
    private String ciudad;
    private int horaInicioJornada;
    private int horaFinJornada;
    private ArrayList<Vehiculo> vehiculos;
/* este metodo sobra
    public Vehiculo buscarVehiculo( int idVehiculo){
        Vehiculo encontrado = null;
        return encontrado;
    }
*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getHoraInicioJornada() {
        return horaInicioJornada;
    }

    public void setHoraInicioJornada(int horaInicioJornada) {
        this.horaInicioJornada = horaInicioJornada;
    }

    public int getHoraFinJornada() {
        return horaFinJornada;
    }

    public void setHoraFinJornada(int horaFinJornada) {
        this.horaFinJornada = horaFinJornada;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}