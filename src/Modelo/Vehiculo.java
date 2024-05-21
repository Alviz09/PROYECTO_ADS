package Modelo;

import java.util.Date;

public class Vehiculo {
    private int idTarjetaDePropiedad;
    private int cantidadSillas;
    private int numPuertas;
    private float capacidadLitrosMotor;
    private String color;
    private String placa;
    private String marca;
    private String modelo;
    private float precioPorDia;
    private String tipoVehiculo;
    private String ciudad;
    private String pais;
    private String categoria;
    private boolean kitCarretera;
    private Date fechaVisita;

    public Vehiculo(int idTarjetaDePropiedad, int cantidadSillas, int numPuertas, float capacidadLitrosMotor, String color, String placa, String marca, String modelo, float precioPorDia, String tipoVehiculo, String ciudad, String pais, String categoria, boolean kitCarretera, Date fechaVisita) {
        this.idTarjetaDePropiedad = idTarjetaDePropiedad;
        this.cantidadSillas = cantidadSillas;
        this.numPuertas = numPuertas;
        this.capacidadLitrosMotor = capacidadLitrosMotor;
        this.color = color;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.precioPorDia = precioPorDia;
        this.tipoVehiculo = tipoVehiculo;
        this.ciudad = ciudad;
        this.pais = pais;
        this.categoria = categoria;
        this.kitCarretera = kitCarretera;
        this.fechaVisita = fechaVisita;
    }

}
