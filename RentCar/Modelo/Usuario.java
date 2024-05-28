package Modelo;

import java.util.ArrayList;

public class Usuario {

    protected String nombre;
    protected String apellido;
    protected int edad;
    protected String direccion;
    protected long telefono;
    protected String correoElectronico;
    protected String tipoDeIdentificacion;
    protected long numeroDelIdentificacion;
    private ArrayList<Vehiculo> vehiculos=new ArrayList<>();

    public Usuario(String nombre, String apellido, int edad, String direccion, long telefono, String correoElectronico, String tipoIdentificacion, Long numeroDelIdentificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.tipoDeIdentificacion = tipoIdentificacion;
        this.numeroDelIdentificacion = numeroDelIdentificacion;
    }

    public Usuario(String nombre, String apellido, int edad, String direccion, long telefono, String correoElectronico, String tipoIdentificacion, Long numeroDelIdentificacion, ArrayList<Vehiculo> vehiculos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.tipoDeIdentificacion = tipoDeIdentificacion;
        this.numeroDelIdentificacion = numeroDelIdentificacion;
        this.vehiculos = new ArrayList<>();
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTipoDeIdentificacion() {
        return tipoDeIdentificacion;
    }

    public void setTipoDeIdentificacion(String tipoDeIdentificacion) {
        this.tipoDeIdentificacion = tipoDeIdentificacion;
    }

    public int getNumeroDelIdentificacion() {
        return (int) numeroDelIdentificacion;
    }

    public void setNumeroDelIdentificacion(Long numeroDelIdentificacion) {
        this.numeroDelIdentificacion = numeroDelIdentificacion;
    }

    public void crearVehiculo(int idTarjetaDePropiedad, int cantidadSillas, int numPuertas, float capacidadLitrosMotor, String color, String placa, String marca, String modelo, float precioPorDia, String tipoVehiculo, String ciudad, String pais, String categoria, boolean kitCarretera) {
        Vehiculo nuevo = new Vehiculo(idTarjetaDePropiedad, cantidadSillas, numPuertas, capacidadLitrosMotor, color, placa, marca, modelo, precioPorDia, tipoVehiculo, ciudad, pais, categoria, kitCarretera);
        vehiculos.add(nuevo);
    }



    public String toString() {
        return "Usuario: " +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", tipoDeIdentificacion='" + tipoDeIdentificacion + '\'' +
                ", numeroDelIdentificacion=" + numeroDelIdentificacion;
    }
}
