package Modelo;

public  class Usuario {
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

    public int getTelefono() {
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
        return numeroDelIdentificacion;
    }

    public void setNumeroDelIdentificacion(int numeroDelIdentificacion) {
        this.numeroDelIdentificacion = numeroDelIdentificacion;
    }
}
