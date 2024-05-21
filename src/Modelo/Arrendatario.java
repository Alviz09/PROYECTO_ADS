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
}
