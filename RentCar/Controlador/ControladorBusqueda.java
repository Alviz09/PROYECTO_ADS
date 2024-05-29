package Controlador;

import Excepciones.*;
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
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class ControladorBusqueda {



    public TextField ingresoVehiculo;
    public TextField ingresoOficina;
    public Button mostrarVehiculosOficina;
    public Button mostrarOficinas;
    public Button buscarVehiculo;
    public Button finViaje;
    public Button adicionarTiempo;
    public Button cerrarSesionArrendador;
    public TextArea txtMostrador1;
    public TextField txtPlacaVehiculo;
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
    public Button terminarViaje;
    public Button verValorTotal;
    public Button realizarPago;
    public TextField txtNumTarjeta;
    public TextField txtCSV;
    public Button recibirPago;
    public Button botonAgregar;
    public Button salirTenant;
    public TextField cantiSillas;
    public TextField litrosMotor;
    public TextField numPuertas;
    public TextField color;
    public TextField idOficina;
    public TextField marca;
    public TextField precioDia;
    public TextField modelo;
    public TextField tipoVehiculo;
    public TextField placa;
    public TextField categoria;
    public TextField ciudad;
    public TextField tarjetaPropiedad;
    public CheckBox kitCarretera;
    public TextField pais;
    private Empresa empresa = Empresa.getInstance();
    private Contrato contratoActual;


    public void mostrarOficinas(javafx.event.ActionEvent actionEvent) {
        for(Oficina s : empresa.getOficinas()){
            txtMostrador1.appendText("id: " + s.getId() + " \nPais: "+ s.getPais()+ " \nCiudad: "+ s.getCiudad() +"\n\n");
        }
    }

    public void mostrarVehiculos(javafx.event.ActionEvent actionEvent) {
        try{
            String idOficina = ingresoOficina.getText().trim();
            if(idOficina==""){
                throw new ExceptionContenedor();
            }
            if(empresa.getOficinas().stream().anyMatch(of -> of.getId()  == Integer.parseInt(idOficina))){
                Oficina ofi = empresa.getOficinas().stream().filter(o -> o.getId()  == Integer.parseInt(idOficina)).limit(1).findFirst().orElse(null);
                for(Vehiculo v: ofi.getVehiculos()){
                    txtMostrador1.appendText("\nPrecio por dia: :"+v.getPrecioPorDia()+"\tCategoria: "+v.getCategoria()+"\nPlaca: "+v.getPlaca()+"\tModelo: "+v.getModelo()+"\nCantidad sillas: "+v.getCantidadSillas()+"\tMarca: "+v.getMarca()+"\nPais: "+v.getPais()+"\tCiudad: "+v.getCiudad()+"\n");
                }
            }else{
                throw new ExceptionContenedor();
            }
        }catch(ExceptionContenedor e ){
            mostrarMensaje("no existe oficina");

        }catch (NumberFormatException e){
            mostrarMensaje("no existe oficina");
        }

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


    public void eliminarVehiculo(ActionEvent actionEvent) {
        String placa = txtPlacaVehiculo.getText().trim();
        if (empresa.getContratos().stream().anyMatch(contrato -> contrato.getPlacaCarro().equals(placa))){
            empresa.setContratoEnELSistema(empresa.getContratos().stream().filter(contrato1 -> contrato1.getPlacaCarro().equals(placa)).limit(1).findFirst().orElse(null));
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/PagarView.fxml"));
                Stage stage = (Stage) terminarViaje.getScene().getWindow();
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }else{
            mostrarMensaje("esa placa no existe en sus vehiculos");
        }
    }


    public void arrendar(ActionEvent actionEvent) {
        try {
            String idOficina = ingresoOficina.getText().trim();
            String placaVehivulo = ingresoVehiculo.getText().trim();
            if (empresa.getOficinas().stream().anyMatch(of -> of.getId() == Integer.parseInt(idOficina))) {

                Oficina ofi = empresa.getOficinas().stream().filter(o -> o.getId() == Integer.parseInt(idOficina)).limit(1).findFirst().orElse(null);
                if (ofi.getVehiculos().stream().anyMatch(vehi -> vehi.getPlaca().equals(placaVehivulo))) {

                    float precio = 0;
                    Vehiculo v = empresa.getVehiculos().stream().filter(vehi -> vehi.getPlaca().equals(placaVehivulo)).limit(1).findFirst().orElse(null);
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
                    empresa.getContratos().add(contrato);
                    empresa.getUsuarioEnElSistema().getVehiculos().add(v);
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
            e.printStackTrace();
        }

    }

    public  void agregarTiempo(ActionEvent actionEvent) {
        try{
            String placa = ingresoPlaca.getText().trim();
            String dias = diasAgregar.getText().trim();
            if((Integer.parseInt(dias)<1)){
                throw new ExcepcionRango();
            }
            // no se hace instance of porque se hizo cuando se ingreso a la vista
            if (empresa.getUsuarioEnElSistema().getVehiculos().stream().anyMatch(vehi -> vehi.getPlaca().equals(placa))){
                System.out.println(placa+"\n");
                for(Contrato c: empresa.getContratos()){
                    System.out.println(c.getPlacaCarro());
                }

                Contrato contrato = empresa.getContratos().stream().filter(c -> c.getPlacaCarro().equals(placa)).limit(1).findFirst().orElse(null);
                Vehiculo vehiculo = empresa.getUsuarioEnElSistema().getVehiculos().stream().filter(v -> v.getPlaca().equals(placa)).limit(1).findFirst().orElse(null);
                contrato.setFechaDevolucion(sumarDiasAFecha(contrato.getFechaDevolucion(), Integer.parseInt(dias)));
                contrato.setValorArriendo((contrato.getValorArriendo())+(vehiculo.getPrecioPorDia()*Integer.parseInt(dias)));

                mostrarMensaje("se realizo la amplitud de tiempo, en el contrato se hicieron los cambios correspondientes");

            }else{
                mostrarMensaje("esa placa no se encuentra registrada en sus arriendos");
            }

        }catch(ExcepcionRango e){
            mostrarMensaje("dias mal ingresados");
        }
        catch (NumberFormatException e){
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
    public Date sumarDiasAFecha(Date fecha, int dias) {

        long milisegundosPorDia = 24 * 60 * 60 * 1000L;
        long milisegundosASumar = dias * milisegundosPorDia;
        Date fechaFinal = new Date(fecha.getTime() + milisegundosASumar);
        return fechaFinal ;
    }

    public void calcularValorTotal(ActionEvent actionEvent) {
            mostrarMensaje("se va a realizar el pago de : " + empresa.getContratoEnELSistema().getValorArriendo() + " pesos, ingrese su tarjeta");
    }

    public void realizarPago(ActionEvent actionEvent) {
        try{
            String tarjeta = (txtNumTarjeta.getText().trim());
            String csv = (txtCSV.getText().trim());
            Long tarjetaComprobacion= Long.parseLong(tarjeta);
            int csvComprobacion= Integer.parseInt(csv);
            if((!( tarjeta.length() == 16 ))||(!(csv.length() == 3))){
                throw new ExcepcionRango();
            }
            mostrarMensaje("se realizo pago");
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/MenuSearchRenterView.fxml"));
                Stage stage = (Stage) realizarPago.getScene().getWindow();
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch (ExcepcionRango e){
            mostrarMensaje(" la tarjeta no tiene 16 caracteres o el csv no tiene 3 caracteres");
        }catch (NumberFormatException e){
            mostrarMensaje(" no se ingreso la informacion como informacion numerica");
        }

    }

    public void recibirPago(ActionEvent actionEvent) {
    }

    public void informacionVehiculos(ActionEvent actionEvent) {
    }
    
    public void agregar(ActionEvent actionEvent) {
        try{
            String placa = ingresoPlaca.getText().trim();
            String marcaa = marca.getText().trim();
            String modeloo = modelo.getText().trim();
            float precioDiaa= Float.parseFloat(precioDia.getText().trim());
            String tipoVehiculoo= tipoVehiculo.getText().trim();
            String ciudadd= ciudad.getText().trim();
            int oficinaa= Integer.parseInt(idOficina.getText().trim());
            int cantiSillass= Integer.parseInt(cantiSillas.getText().trim());
            int numPuertass= Integer.parseInt(numPuertas.getText().trim());
            float litrosMotorr = Float.parseFloat(litrosMotor.getText().trim());
            String colorr= color.getText().trim();
            String categoriaa= categoria.getText().trim();
            String paiss = pais.getText().trim();
            int tarjetaPropiedadd = Integer.parseInt(tarjetaPropiedad.getText().trim());
            Vehiculo v = new Vehiculo(tarjetaPropiedadd,cantiSillass,numPuertass, litrosMotorr, colorr, placa, marcaa, modeloo, precioDiaa, tipoVehiculoo, ciudadd, paiss, categoriaa, kitCarretera.isSelected());
            empresa.getVehiculos().add(v);
            empresa.getUsuarioEnElSistema().getVehiculos().add(v);
        } catch (NumberFormatException e) {

            mostrarMensaje("Ingrese bien los dsatos de su celular y ID");
        } catch (Exception e) {
            e.printStackTrace();
            mostrarMensaje("Error en el registro de Arrendador");
        }
    }

    public void salirTenant(ActionEvent actionEvent) {
    }
}
