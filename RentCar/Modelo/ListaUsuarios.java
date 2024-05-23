package Modelo;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class ListaUsuarios {
    ArrayList<Usuario> usuarios;

    public void cargarUsuarios(ArrayList<Usuario> usuarios) {
    }

    public ArrayList<Usuario> leerDeArchivos() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        URL resource = getClass().getClassLoader().getResource("usuarios.txt");
        File file = null;
        try {
            file = new File(resource.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        try (BufferedReader entrada = new BufferedReader(new FileReader(file))) {
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


    public void cargarVehiculosUsuarios(ArrayList<Usuario> usuarios) {
        Map<Integer, Arrendador> userById = new HashMap<>(this.getUsuarioId(usuarios));
        URL resource = getClass().getClassLoader().getResource("vehiculos.txt");
        File file = null;
        try {
            file = new File(resource.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        try (BufferedReader entrada = new BufferedReader(new FileReader(file))) {
            String linea;
            String total[];
            while ((linea = entrada.readLine()) != null) {
                total = linea.split("\\s+");
                int idUser = Integer.parseInt(total[0]);
                int idTarjetaDePropiedad0 = Integer.parseInt(total[1]);
                int cantidadSillas = Integer.parseInt(total[2]);
                int numPuertas = Integer.parseInt(total[3]);
                float capacidadLitrosMoto = Float.parseFloat(total[4]);
                String color = total[5];
                String placa = total[6];
                String marca = total[7];
                String modelo = total[8];
                float precioPorDia = Float.parseFloat(total[9]);
                String tipoVehiculo = total[10];
                String ciudad = total[11];
                String pais = total[12];
                String categoria = total[13];
                boolean kitCarretera = Boolean.parseBoolean(total[14]);
                userById.get(idUser).crearVehiculo(idTarjetaDePropiedad0, cantidadSillas, numPuertas, capacidadLitrosMoto, color, placa, marca, modelo, precioPorDia, tipoVehiculo, ciudad, pais, categoria, kitCarretera);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<Integer, Arrendador> getUsuarioId(ArrayList<Usuario> userList) {
        ArrayList<Arrendador> filtrados = new ArrayList<>();
        for (Usuario usuario : userList) {
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
    //    public static void imprimir(ArrayList<Usuario> usuarios) {
//        for (Usuario u : usuarios) {
//            if (u instanceof Arrendador)
//                System.out.println(((Arrendador) u).getVehiculos());
//        }
//    }

}

