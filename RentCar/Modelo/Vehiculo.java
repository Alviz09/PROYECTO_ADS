package Modelo;

import java.time.LocalDate;

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
   // private String autoManual;
    private LocalDate fechaVisita;
    private boolean disponibilidad=true;
    private int leaseDays=0;
    private int precioAdicional=0;


    public Vehiculo(int idTarjetaDePropiedad, int cantidadSillas, int numPuertas, float capacidadLitrosMotor, String color, String placa, String marca, String modelo, float precioPorDia, String tipoVehiculo, String ciudad, String pais, String categoria, boolean kitCarretera){
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
    }
    public int getLeaseDays(){
        return leaseDays;
    }
    public void increaseLeaseDays(){
        leaseDays++;
    }
    public int getPrecioAdicional(){return precioAdicional;}

    public int getIdTarjetaDePropiedad() {
        return idTarjetaDePropiedad;
    }

    public void setIdTarjetaDePropiedad(int idTarjetaDePropiedad) {
        this.idTarjetaDePropiedad = idTarjetaDePropiedad;
    }

    public int getCantidadSillas() {
        return cantidadSillas;
    }

    public void setCantidadSillas(int cantidadSillas) {
        this.cantidadSillas = cantidadSillas;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public float getCapacidadLitrosMotor() {
        return capacidadLitrosMotor;
    }

    public void setCapacidadLitrosMotor(float capacidadLitrosMotor) {
        this.capacidadLitrosMotor = capacidadLitrosMotor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getPrecioPorDia() {
        return precioPorDia;
    }

    public void setPrecioPorDia(float precioPorDia) {
        this.precioPorDia = precioPorDia;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isKitCarretera() {
        return kitCarretera;
    }

    public void setKitCarretera(boolean kitCarretera) {
        this.kitCarretera = kitCarretera;
    }
    public void setDisponibilidad(boolean disponibilidad){this.disponibilidad=disponibilidad;}

    public LocalDate getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(LocalDate fechaVisita) {
        this.fechaVisita = fechaVisita;
    }
    public String toString() {
        return "Vehiculo{" +
                "idTarjetaDePropiedad=" + idTarjetaDePropiedad +
                ", cantidadSillas=" + cantidadSillas +
                ", numPuertas=" + numPuertas +
                ", capacidadLitrosMotor=" + capacidadLitrosMotor +
                ", color='" + color + '\'' +
                ", placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precioPorDia=" + precioPorDia +
                ", tipoVehiculo='" + tipoVehiculo + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                ", categoria='" + categoria + '\'' +
                ", kitCarretera=" + kitCarretera +
                ", fechaVisita=" + fechaVisita +
                '}';
    }

    public boolean getdisponibilidad() {
        return disponibilidad;
    }
}
