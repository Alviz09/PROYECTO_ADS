package Modelo;

import java.util.ArrayList;

public class ListaUsuarios {
    private ArrayList<Arrendador> arrendadores;
    private ArrayList<Arrendatario> arrendatarios;

    public void guardarEnArchivos(ArrayList<Usuario> usuarios){
    }
    public void leerDeArchivos(ArrayList<Usuario> usuarios){

    }
    public ListaUsuarios() {
        this.arrendadores = new ArrayList<>();
        this.arrendatarios = new ArrayList<>();
    }

    // Getters y Setters para arrendadores
    public ArrayList<Arrendador> getArrendadores() {
        return arrendadores;
    }

    public void setArrendadores(ArrayList<Arrendador> arrendadores) {
        this.arrendadores = arrendadores;
    }

    // Getters y Setters para arrendatarios
    public ArrayList<Arrendatario> getArrendatarios() {
        return arrendatarios;
    }

    public void setArrendatarios(ArrayList<Arrendatario> arrendatarios) {
        this.arrendatarios = arrendatarios;
    }
}
