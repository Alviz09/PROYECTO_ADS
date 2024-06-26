package Modelo;

import java.util.Date;

public class Contrato {
    private int oficinaRecogida;
    private int oficinaDevolucion;
    private Date fechaEntrega;
    private Date fechaDevolucion;
    private int horaEntrega;
    private int horaDevolucion;
    private int nCarro;

    public void Contrarto(int nCarro, int nOficina){
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

    public void setHoraEntrega(int horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public void setHoraDevolucion(int horaDevolucion) {
        this.horaDevolucion = horaDevolucion;
    }

    public void setNCarro(int nCarro) {
        this.nCarro = nCarro;
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

    public int getHoraEntrega() {
        return horaEntrega;
    }

    public int getHoraDevolucion() {
        return horaDevolucion;
    }

    public int getNCarro() {
        return nCarro;
    }

}
