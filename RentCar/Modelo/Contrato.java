package Modelo;

import java.util.Date;

public class Contrato {
    private int oficinaRecogida;
    private int oficinaDevolucion;
    private Date fechaEntrega; //el fecha tambien esta la hora
    private Date fechaDevolucion;
    private String placaCarro;
    private String emailUser;

    public Contrato(int id, Date todayDate, Date FinishDate, String placa, String correoElectronico) {
        this.oficinaRecogida = id;
        this.oficinaDevolucion = id; //se pone la misma de recogida por defecto cuando se busca el carro
        this.fechaEntrega = todayDate;
        this.fechaDevolucion = FinishDate;
        this.placaCarro = placa;
        this.emailUser = correoElectronico;
    }

    public void setOficinaRecogida(int oficinaRecogida) {
        this.oficinaRecogida = oficinaRecogida;
    }

    public void setOficinaDevolucion(int oficinaDevolucion) {
        this.oficinaDevolucion = oficinaDevolucion;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setPlacaCarro(String placaCarro){
        this.placaCarro = placaCarro;
    }

    public void setEmailUser(String emailUser){
        this.emailUser = emailUser;
    }

    // Getters
    public int getOficinaRecogida() {
        return oficinaRecogida;
    }

    public int getOficinaDevolucion() {
        return oficinaDevolucion;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }


    public String getPlacaCarro(){
        return placaCarro;
    }

    public String getEmailUser(){
        return emailUser;
    }

}
