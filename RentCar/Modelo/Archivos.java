package Modelo;

import java.io.*;
import java.lang.reflect.Array;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Archivos {
    public static ArrayList<Usuario> cargarUsuarios() {
        ArrayList<Usuario> usuarios= new ArrayList<>();
        try (BufferedReader entrada = new BufferedReader(new FileReader("out/production/PROYECTO_ADS/resource/usuarios.txt"))) {
            String linea;
            String total[];
            while ((linea = entrada.readLine()) != null) {
                total = linea.split("\\s+");
                String tipoUsuario = total[0];
                String nombre = total[1];
                String apellido = total[2];
                int edad = Integer.parseInt(total[3]);
                String direccion = total[4];
                long telefono = Long.parseLong(total[5]);
                String correoElectronico = total[6];
                String tipoDeIdentiicaion = total[7];
                int numeroDeIdentificacion = Integer.parseInt(total[8]);

                if (tipoUsuario.equals("Arrendatario")) {
                    Boolean licenciaConduccion = Boolean.valueOf(total[9]);
                    Boolean preferencial = Boolean.valueOf(total[10]);
                    Arrendatario nuevoArrendatario = new Arrendatario(nombre, apellido, edad, direccion, telefono, correoElectronico, tipoDeIdentiicaion, numeroDeIdentificacion, licenciaConduccion, preferencial);
                    usuarios.add(nuevoArrendatario);
                } else {
                    Arrendador nuevoArrendador = new Arrendador(nombre, apellido, edad, direccion, telefono, correoElectronico, tipoDeIdentiicaion, numeroDeIdentificacion);
                  usuarios.add(nuevoArrendador);
                }
            }
            entrada.close();
            if (!usuarios.isEmpty()) {
                return usuarios;
            }
            return null;

        } catch (Exception e) {
            throw new RuntimeException("No se encontro el archivo " + e.getMessage());
        }
    }
    public static ArrayList<Oficina> cargarOficinas() {
        ArrayList<Oficina> oficinas = new ArrayList<>();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm");
        try (BufferedReader entrada = new BufferedReader(new FileReader("out/production/PROYECTO_ADS/resource/oficinas.txt"))) {
            String linea;
            String total[];
            int id;
            String pais;
            String ciudad;
            while ((linea = entrada.readLine()) != null) {
                if (linea.isEmpty()){
                    return null;
                }
                linea.strip();
                total = linea.split("\\s+");
                id = Integer.parseInt(total[0]);
                pais = total[1];
                ciudad = total[2];
                LocalTime horaInicio = LocalTime.parse(total[3], timeFormatter);
                LocalTime horaFin = LocalTime.parse(total[4], timeFormatter);
                oficinas.add(new Oficina(id, pais, ciudad, horaInicio, horaFin));
            }
            return oficinas;
        } catch (Exception e) {
            throw new RuntimeException("No se encontro el archivo " + e.getMessage());
        }
    }

    public static HashMap<Integer, Vehiculo> cargarVehiculosPorUsuario() {
        HashMap<Integer, Vehiculo> vehiculosPorUsuario = new HashMap<>();
        try (BufferedReader entrada = new BufferedReader(new FileReader("out/production/PROYECTO_ADS/resource/vehiculos.txt"))) {
            String linea;
            String total[];
            while ((linea = entrada.readLine()) != null) {
                total = linea.split("\\s+");
                int idUser = Integer.parseInt(total[0]);
                int idTarjetaDePropiedad0 = Integer.parseInt(total[2]);
                int cantidadSillas = Integer.parseInt(total[3]);
                int numPuertas = Integer.parseInt(total[4]);
                float capacidadLitrosMoto = Float.parseFloat(total[5]);
                String color = total[6];
                String placa = total[7];
                String marca = total[8];
                String modelo = total[9];
                float precioPorDia = Float.parseFloat(total[10]);
                String tipoVehiculo = total[11];
                String ciudad = total[12];
                String pais = total[13];
                String categoria = total[14];
                boolean kitCarretera = Boolean.parseBoolean(total[15]);
                Vehiculo vehiculo = new Vehiculo(idTarjetaDePropiedad0, cantidadSillas, numPuertas, capacidadLitrosMoto, color, placa, marca, modelo, precioPorDia, tipoVehiculo, ciudad, pais, categoria, kitCarretera);
                vehiculosPorUsuario.put(idUser, vehiculo);
            }
            return vehiculosPorUsuario;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    private static Map<Integer, Arrendador> getUsuarioId(ArrayList<Usuario> usuarios) {
        ArrayList<Arrendador> filtrados = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Arrendador) {
                filtrados.add((Arrendador) usuario);
            }
        }
        Map<Integer, Arrendador> userById = new HashMap<>();
        filtrados.forEach(usuario -> {
            userById.put(usuario.getNumeroDelIdentificacion(), usuario);
        });
        return userById;
    }


}

