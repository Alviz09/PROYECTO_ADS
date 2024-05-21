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

}
