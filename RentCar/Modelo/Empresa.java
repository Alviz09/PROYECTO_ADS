package Modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Empresa {
    private static final Empresa EMPRESA = new Empresa();
    private static HashMap<Integer, Vehiculo> vehiculosPorUsuario = Archivos.cargarVehiculosPorUsuario();
    private static ArrayList<Usuario> usuarios = new ArrayList<>(Archivos.cargarUsuarios());
    private static ArrayList<Vehiculo> vehiculos  = new ArrayList<>();
    private static ArrayList<Oficina> oficinas  = new ArrayList<>(Archivos.cargarOficinas());

    private Empresa(){
        for(int idUsuario : vehiculosPorUsuario.keySet()) {
            for(Usuario usuario : usuarios) {
                if(idUsuario == usuario.getNumeroDelIdentificacion()) {
                    usuario.getVehiculos().add(vehiculosPorUsuario.get(idUsuario));
                    vehiculos.add(vehiculosPorUsuario.get(idUsuario));
                }
            }
        }
        for(Vehiculo vehiculo : vehiculos) {
            for(Oficina oficina : oficinas) {
                if(vehiculo.getCiudad() == oficina.getCiudad()) {
                    oficina.getVehiculos().add(vehiculo);
                }
            }
        }
    }

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
