package Modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Empresa {
    private static final Empresa EMPRESA = new Empresa();
    private static ArrayList<Usuario> usuarios = new ArrayList<>(Archivos.cargarUsuarios());
    private static ArrayList<Oficina> oficinas  = new ArrayList<>(Archivos.cargarOficinas());
    private static ArrayList<Vehiculo> vehiculos  = new ArrayList<>(Archivos.cargarVehiculosUsuarios(usuarios,oficinas));
    private Usuario usuarioEnElSistema;
    private ArrayList<Contrato> contratos = null ;

    public ArrayList<Contrato> getContratos(){
        return contratos;
    }
    public void setContratos(ArrayList<Contrato> contratos){
        this.contratos= contratos;
    }
    private Empresa(){
    }

    public static Empresa getInstance(){

        return EMPRESA;
    }
    public void guardarArchivo() {
        Archivos.escribirArchivos(usuarios);
        if(usuarioEnElSistema instanceof Arrendatario){
            Arrendatario arrendatario = (Arrendatario) usuarioEnElSistema;
            Archivos.escribirArchivosContratos(arrendatario.getContratosVehiculos(), arrendatario.getCorreoElectronico());
        }

    }
    public  ArrayList<Usuario> getUsuarios(){
        return usuarios;
    }
    public ArrayList<Oficina> getOficinas(){
        return oficinas;
    }
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    public Usuario getUsuarioEnElSistema() {
        return usuarioEnElSistema;
    }

    public void setUsuarioEnElSistema(Usuario usuarioEnElSistema) {
        this.usuarioEnElSistema = usuarioEnElSistema;
    }

    public void agregarContratos( String gmailUsuario){
        this.contratos = new ArrayList<>((Archivos.leerArchivosContratos( gmailUsuario)));
    }
}
