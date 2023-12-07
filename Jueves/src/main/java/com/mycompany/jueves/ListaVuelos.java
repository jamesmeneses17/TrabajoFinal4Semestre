
package com.mycompany.jueves;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class ListaVuelos {
    private List<Vuelo> listaVuelos;
    public ListaVuelos(List<Vuelo> listaVuelos) {
        this.listaVuelos = listaVuelos;
    }

    public List<Vuelo> getListaVuelos() {
        return listaVuelos;
    }
    public void mostrarLista() {
        for (Vuelo vuelo : listaVuelos) {
            vuelo.mostrarInfo();
        }
    }
    public List<Vuelo> getVuelosPorOrigen(String origen) {
        List<Vuelo> vuelosOrigen = new ArrayList<>();
        for (Vuelo vuelo : listaVuelos) {
            if (origen.equals(vuelo.getOrigen())) {
                vuelosOrigen.add(vuelo);
            }
        }
        return vuelosOrigen;
    }

    public List<Vuelo> getVuelosPorDestino(String destino) {
        List<Vuelo> vuelosDestino = new ArrayList<>();
        for (Vuelo vuelo : listaVuelos) {
            if (destino.equals(vuelo.getDestino())) {
                vuelosDestino.add(vuelo);
            }
        }
        return vuelosDestino;
    }
    public void leerDatos() {
        String linea;
        Vuelo vuelo = null;
        String seccion = null;

        try (BufferedReader br = new BufferedReader(new FileReader("vuelos.txt"))) {
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();

                if (linea.isEmpty()) {
                    continue;
                }
                if (linea.startsWith("#")) {
                    seccion = linea;
                    continue;
                }
                if ("#Vuelos".equals(seccion)) {
                    String[] tokens = linea.split(";");
                    if (tokens.length >= 4) {
                        String origen = tokens[1];
                        String destino = tokens[2];
                        int plazas = Integer.parseInt(tokens[6]);
                        String duracion = tokens[3];
                        String compania = tokens[4]; 
                        vuelo = new Vuelo(origen, destino, plazas, duracion, compania); 
                        listaVuelos.add(vuelo);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void GenerarArchivoVuelos() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("Listado_vuelos.txt"))) {
            pw.println("LISTA DE VUELOS");
            pw.println("---------------------------------------------");
            for (Vuelo vuelo : listaVuelos) {
                pw.println("AEROPUERTO: " + vuelo.getOrigen());
                pw.println("COMPAÑIA: " + vuelo.getCompania());
                pw.println("SALIDAS");
                pw.println("origen\tdestino\tPlazas\tduracion");
                List<Vuelo> salidas = getVuelosPorOrigen(vuelo.getOrigen());
                for (Vuelo salida : salidas) {
                    pw.println(salida.getOrigen() + "\t" + salida.getDestino() + "\t" + salida.getPlazas() + "\t" + salida.getDuracion());
                }
                pw.println("LLEGADAS");
                pw.println("origen\tdestino\tPlazas\tduracion");
                List<Vuelo> llegadas = getVuelosPorDestino(vuelo.getDestino());
                for (Vuelo llegada : llegadas) {
                    pw.println(llegada.getOrigen() + "\t" + llegada.getDestino() + "\t" + llegada.getPlazas() + "\t" + llegada.getDuracion());
                }
                pw.println("------------------------------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }  

public void ConsolaVuelosSalida() {
    
    for (Vuelo vuelo : listaVuelos) { 
        String codigo = vuelo.getOrigen(); 
        System.out.println("AEROPUERTO: " + codigo);     
        List<Vuelo> vuelosSalida = this.getVuelosPorOrigen(codigo);      
        System.out.println("Número de vuelos de salida: " + vuelosSalida.size());
       
        for (Vuelo v : vuelosSalida) {
            v.mostrarInfo();
        }     
        System.out.println("-----------------------------");
    }
}

    public void ConsolaVuelosLlegada() {
    for (Vuelo vuelo : listaVuelos) { 
        String codigo = vuelo.getOrigen(); 
        System.out.println("AEROPUERTO: " + codigo);     
        List<Vuelo> vuelosLlegada = this.getVuelosPorDestino(codigo);
        System.out.println("Número de vuelos de llegada: " + vuelosLlegada.size());
       
        for (Vuelo v : vuelosLlegada) {
            v.mostrarInfo();
        }     
        System.out.println("------------------------------------");
    }
}


}

