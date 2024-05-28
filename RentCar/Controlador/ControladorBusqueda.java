package Controlador;

import Excepciones.ExcepcionDisponibilidad;
import Excepciones.ExcepcionLogica;
import Modelo.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class ControladorBusqueda {


    public TextArea txtMostradorFinViaje;
    public TextField ingresoVehiculo;
    public TextField ingresoOficina;
    public Button mostrarVehiculosOficina;
    public Button mostrarOficinas;
    public Button buscarVehiculo;
    public Button finViaje;
    public Button adicionarTiempo;
    public Button cerrarSesionArrendador;
    public TextArea txtMostrador1;
    public TextArea txtPlacaVehiculo;
    public Button mostrarVehiculosEnPropiedad;
    public Button volver;
    public CheckBox getVentanas;
    public CheckBox getLlantas;
    public CheckBox getSeguroTotal;
    public TextField sillaBebe;
    public TextField disGPS;
    public TextField conductorAdicional;
    public Button arrendarVehiculo;
    public TextField maletero;
    public TextArea txtMostrador;
    public Button agregarTiempo;
    public TextField ingresoPlaca;
    public TextField diasRequeridos;
    public TextField diasAgregar;
    private Empresa empresa = Empresa.getInstance();





    public void mostrarOficinas(javafx.event.ActionEvent actionEvent) {
        for(Oficina s : empresa.getOficinas()){
            txtMostrador1.appendText("id: " + s.getId() + " \nPais: "+ s.getPais()+ " \nCiudad: "+ s.getCiudad() +"\n\n");
        }
    }

    public void mostrarVehiculos(javafx.event.ActionEvent actionEvent) {
        String idOficina = ingresoOficina.getText().trim();
        if(empresa.getOficinas().stream().anyMatch(of -> of.getId()  == Integer.parseInt(idOficina))){
            Oficina ofi = empresa.getOficinas().stream().filter(o -> o.getId()  == Integer.parseInt(idOficina)).limit(1).findFirst().orElse(null);
            for(Vehiculo v: ofi.getVehiculos()){
                txtMostrador1.appendText("\nPrecio por dia: :"+v.getPrecioPorDia()+"\tCategoria: "+v.getCategoria()+"\nPlaca: "+v.getPlaca()+"\tModelo: "+v.getModelo()+"\nCantidad sillas: "+v.getCantidadSillas()+"\tMarca: "+v.getMarca()+"\nPais: "+v.getPais()+"\tCiudad: "+v.getCiudad()+"\n");
            }
        }
    }

    public void datoIdOficina(javafx.event.ActionEvent actionEvent) {
    }


    public void volverMenuArrendador(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/MenuSearchRenterView.fxml"));
            Stage stage = (Stage) volver.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void ejecutarBuscadorArrendatario(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/RenterSearchView.fxml"));
            Stage stage = (Stage) buscarVehiculo.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void finViaje(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/EndTripView.fxml"));
            Stage stage = (Stage) finViaje.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AdicionarTiempo(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/MoreTimeView.fxml"));
            Stage stage = (Stage) adicionarTiempo.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cerrarSesion(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/MainView.fxml"));
            Stage stage = (Stage) cerrarSesionArrendador.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void datoPlacaVehiculo(ActionEvent actionEvent) {
    }

    public void eliminarVehiculo(ActionEvent actionEvent) {
    }

    public void ejecutarBuscadorVehiculos(ActionEvent actionEvent) {
    }

    public void arrendar(ActionEvent actionEvent) {
        try {
            String idOficina = ingresoOficina.getText().trim();
            String placaVehivulo = ingresoVehiculo.getText().trim();
            if (empresa.getOficinas().stream().anyMatch(of -> of.getId() == Integer.parseInt(idOficina))) {

                Oficina ofi = empresa.getOficinas().stream().filter(o -> o.getId() == Integer.parseInt(idOficina)).limit(1).findFirst().orElse(null);
                if (ofi.getVehiculos().stream().anyMatch(vehi -> vehi.getPlaca().equals(placaVehivulo))) {

                    float precio = 0;
                    Vehiculo v = ofi.getVehiculos().stream().filter(vehi -> vehi.getPlaca().equals(placaVehivulo)).limit(1).findFirst().orElse(null);
                    if(!(v.getdisponibilidad())){
                        throw new ExcepcionDisponibilidad();
                    }
                    if (((getLlantas.isSelected()) && (getSeguroTotal.isSelected())) || ((getVentanas.isSelected()) && (getSeguroTotal.isSelected())) || ((getVentanas.isSelected()) && (getLlantas.isSelected()))) {
                        throw new ExcepcionLogica();
                    } else if (getLlantas.isSelected()) {
                        precio += 300000;
                    } else if (getVentanas.isSelected()) {
                        precio += 100000;
                    } else if (getSeguroTotal.isSelected()) {
                        precio += 500000;
                    }
                    precio += 100000 * Integer.parseInt(sillaBebe.getText().trim());
                    precio += 80000 * Integer.parseInt(maletero.getText().trim());
                    precio += 50000 * Integer.parseInt(conductorAdicional.getText().trim());
                    precio += 30000 * Integer.parseInt(disGPS.getText().trim());
                    Date todayDate = new Date();
                    //se crea contrato
                    Contrato contrato = new Contrato(ofi.getId(), todayDate, sumarDiasAFecha(todayDate, Integer.parseInt(diasRequeridos.getText().trim())), v.getPlaca(), empresa.getUsuarioEnElSistema().getCorreoElectronico());
                    v.setDisponibilidad(false);
                    contrato.setValorArriendo(precio);
                    Arrendatario arrendatario = (Arrendatario) empresa.getUsuarioEnElSistema();
                    arrendatario.getContratosVehiculos().add(contrato);
                    empresa.guardarArchivo();
                    mostrarMensaje("se creo el cotrato con la informacion, paguelo cuando pueda\n");
                }else{
                    mostrarMensaje("esa placa no existe");
                }
            }else{
                mostrarMensaje("esa oficina no existe");
            }
        } catch (NumberFormatException e) {
            mostrarMensaje("no se ingresaron los valores numericos bien");
        } catch (ExcepcionDisponibilidad e) {
            mostrarMensaje(" no esta disponible el vehiculo");
        } catch (ExcepcionLogica e) {
            mostrarMensaje("solo puede tener un seguro");
        }
    }

    public void mostrarVehiculosPropiedad(ActionEvent actionEvent) {
        try {
            for (Vehiculo v : empresa.getUsuarioEnElSistema().getVehiculos()) {
                txtMostrador.appendText("Precio por dia: :" + v.getPrecioPorDia() + "\tCategoria: " + v.getCategoria() + "\nPlaca: " + v.getPlaca() + "\tModelo: " + v.getModelo() + "\nCantidad sillas: " + v.getCantidadSillas() + "\tMarca: " + v.getMarca() + "\nPais: " + v.getPais() + "\tCiudad: " + v.getCiudad());

            }
        }catch (NullPointerException e){
            mostrarMensaje("no tiene vehiculos en uso este usuario");
        }

    }

    public  void agregarTiempo(ActionEvent actionEvent) {
        try{
            String placa = ingresoPlaca.getText().trim();
            String dias = diasAgregar.getText().trim();
            // no se hace instance of porque se hizo cuando se ingreso a la vista
            if (empresa.getUsuarioEnElSistema().getVehiculos().stream().anyMatch(vehi -> vehi.getPlaca().equals(placa))){
                Arrendatario arrendatario = (Arrendatario) empresa.getUsuarioEnElSistema();

                Contrato contrato = arrendatario.getContratosVehiculos().stream().filter(c -> c.getPlacaCarro().equals(placa)).limit(1).findFirst().orElse(null);
                Vehiculo vehiculo = arrendatario.getVehiculos().stream().filter(v -> v.getPlaca().equals(placa)).limit(1).findFirst().orElse(null);
                contrato.setFechaDevolucion(sumarDiasAFecha(contrato.getFechaDevolucion(), Integer.parseInt(dias)));
                contrato.setValorArriendo((contrato.getValorArriendo())+(vehiculo.getPrecioPorDia()*Integer.parseInt(dias)));
                empresa.guardarArchivo();
                mostrarMensaje("se realizo la amplitud de tiempo, en el contrato se hicieron los cambios correspondientes");

            }else{
                mostrarMensaje("esa placa no se encuentra registrada en sus arriendos");
            }



        }catch (NumberFormatException e){
            mostrarMensaje("no ingreso en el formato debido (solo numeros enteros)");
        }

    }
    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mensaje");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    public Date sumarDiasAFecha(Date fecha, int dias){
        if (dias==0) return fecha;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
    }
}
