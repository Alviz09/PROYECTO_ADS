package Modelo;

public class Arrendatario extends Usuario{
    private boolean licenciaConduccion;
    private boolean preferencial;
    private boolean contrato;

    public Arrendatario(String nombre, String apellido, int edad, String direccion, int telefono, String correoElectronico, String tipoIdentificacion, int numeroDelIdentificacion,  boolean licenciaConduccion, boolean preferencial, boolean contrato) {
        super(nombre, apellido, edad, direccion, telefono, correoElectronico, tipoIdentificacion, numeroDelIdentificacion);
        this.licenciaConduccion= licenciaConduccion;
        this.preferencial=preferencial;
        this.contrato=contrato;
    }
    public Arrendatario(String nombre, String apellido, int edad, String direccion, long telefono, String correoElectronico, String tipoIdentificacion, int numeroDelIdentificacion,  boolean licenciaConduccion, boolean preferencial) {
        super(nombre, apellido, edad, direccion, telefono, correoElectronico, tipoIdentificacion, numeroDelIdentificacion);
        this.licenciaConduccion= licenciaConduccion;
        this.preferencial=preferencial;
    }
    public boolean isLicenciaConduccion() {
        return licenciaConduccion;
    }

    public void setLicenciaConduccion(boolean licenciaConduccion) {
        this.licenciaConduccion = licenciaConduccion;
    }
    public boolean isPreferencial() {
        return preferencial;
    }

    public void setPreferencial(boolean preferencial) {
        this.preferencial = preferencial;
    }
    public boolean isContrato() {
        return contrato;
    }

    public void setContrato(boolean contrato) {
        this.contrato = contrato;
    }
    public String toString() {
        return  "Usuario: " +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", tipoDeIdentificacion='" + tipoDeIdentificacion + '\'' +
                ", numeroDelIdentificacion=" + numeroDelIdentificacion+ '\'' +
                "LicenciaConduccion "+licenciaConduccion+ '\'' +
                "Preferencial "+preferencial+ '\'';
    }

}
