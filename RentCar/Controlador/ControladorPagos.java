package Controlador;

import Modelo.Empresa;
import Modelo.Vehiculo;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class ControladorPagos {
    private Empresa empresa = Empresa.getInstance();
    @FXML
    private Button verValorTotal;

    public float consultarPrecioServiciosAdicionales(){
        float preciosAdicionales=0;

        return preciosAdicionales;
    }
    public float calcularValorTotal(){
        ArrayList<Vehiculo> rentados=empresa.getUsuarioEnElSistema().getVehiculos();
        float valorTotal=0;
        for(Vehiculo v:rentados){
            valorTotal+=(v.getLeaseDays()*v.getPrecioPorDia());
        }
        valorTotal+=consultarPrecioServiciosAdicionales();
        mostrarMensaje("EL valor total a pagar es:"+valorTotal);
        return valorTotal;
    }
    public void realizarPago(){
        float saldo=2000000;
        if((saldo-calcularValorTotal())>0){
            mostrarMensaje("!Pago exitoso");
        }
        else
            mostrarMensaje("Fondos Insuficientes");
    }
    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mensaje");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
