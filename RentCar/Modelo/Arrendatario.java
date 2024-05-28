package Modelo;

import java.util.ArrayList;

public class Arrendatario extends Usuario{
    private boolean licenciaConduccion;
    private boolean preferencial;
    private boolean contrato;
    private int leaseNumber=0;
    private ArrayList<Contrato> contratosVehiculos = new ArrayList<Contrato>() ;



//    public Arrendatario(String nombre, String apellido, int edad, String direccion, int telefono, String correoElectronico, String tipoIdentificacion, int numeroDelIdentificacion,  boolean licenciaConduccion, boolean preferencial, boolean contrato) {
//        super(nombre, apellido, edad, direccion, telefono, correoElectronico, tipoIdentificacion, numeroDelIdentificacion);
//        this.licenciaConduccion= licenciaConduccion;
//        this.preferencial=preferencial;
//        this.contrato=contrato;
//    }
public Arrendatario(String nombre, String apellido, int edad, String direccion, long telefono, String correoElectronico, String tipoIdentificacion, Long numeroDelIdentificacion,  boolean licenciaConduccion, boolean preferencial) {
    super(nombre, apellido, edad, direccion, telefono, correoElectronico, tipoIdentificacion, numeroDelIdentificacion);
    this.licenciaConduccion= licenciaConduccion;
    this.preferencial=preferencial;
}
    public Arrendatario(String nombre, String apellido, int edad, String direccion, long telefono, String correoElectronico, String tipoIdentificacion, Long numeroDelIdentificacion,  boolean licenciaConduccion, boolean preferencial, ArrayList<Vehiculo> vehiculos) {
        super(nombre, apellido, edad, direccion, telefono, correoElectronico, tipoIdentificacion, numeroDelIdentificacion, vehiculos);
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
    public int getLeaseNumber(){
        return leaseNumber;
    }
    public void cambiarDisponibilida(){
        this.getVehiculos().forEach(vehiculo -> {
            vehiculo.setDisponibilidad(false);
        });
    }
    public void increaseLeaseNumber(){
        this.getVehiculos().forEach(vehiculo -> {
            vehiculo.setDisponibilidad(true);
        });
        this.leaseNumber++;
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

    public ArrayList<Contrato> getContratosVehiculos() {
        return contratosVehiculos;
    }

    public void setContratosVehiculos(ArrayList<Contrato> contratosVehiculos) {
        this.contratosVehiculos = contratosVehiculos;
    }
}
