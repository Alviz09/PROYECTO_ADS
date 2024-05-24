package Modelo;

import java.util.ArrayList;

public class Empresa {
    private static final Empresa EMPRESA = new Empresa();
    private  ArrayList<Usuario> usuarios= new ArrayList<>(Archivos.cargarUsuarios());
    private  ArrayList<Oficina> oficinas= new ArrayList<>();
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
}
