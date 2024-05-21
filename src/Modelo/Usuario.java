package Modelo;

public abstract class Usuario {
    private String nombre;
    private String apellido;
    private int edad;
    private String direccion;
    private int telefono;
    private String correoElectronico;
    private String tipoDeIdentificacion;
    private int numeroDelIdentificacion;
    public Usuario(String nombre, String apellido, int edad, String direccion, int telefono, String correoElectronico, String tipoIdentificacion, int numeroDelIdentificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.tipoDeIdentificacion = tipoDeIdentificacion;
        this.numeroDelIdentificacion = numeroDelIdentificacion;
    }

}
