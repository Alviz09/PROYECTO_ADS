package Modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Empresa {
    private static final Empresa EMPRESA = new Empresa();
    private static ArrayList<Usuario> usuarios = new ArrayList<>(Archivos.cargarUsuarios());
    private static ArrayList<Oficina> oficinas  = new ArrayList<>(Archivos.cargarOficinas());
    private static ArrayList<Vehiculo> vehiculos  = new ArrayList<>(Archivos.cargarVehiculosUsuarios(usuarios,oficinas));

    private Empresa(){}

    public static Empresa getInstance(){
        return EMPRESA;
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
}
