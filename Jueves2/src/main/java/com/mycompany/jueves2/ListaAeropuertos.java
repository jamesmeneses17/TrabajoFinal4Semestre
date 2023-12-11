
package com.mycompany.jueves2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ListaAeropuertos extends SuperClase {
   
    private List<Aeropuerto> listaAeropuertos;

    public ListaAeropuertos() {
        this.listaAeropuertos = new ArrayList<>();
    }

   
    public List<Aeropuerto> getListaAeropuertos() {
        return listaAeropuertos;
    }

 
    public void mostrarLista() {
        for (Aeropuerto aeropuerto : listaAeropuertos) {
            aeropuerto.mostrarInfo();
        }
    }

   
    public Aeropuerto getAeropuertoPorCodigo(String codigo) {
        for (Aeropuerto aeropuerto : listaAeropuertos) {
            if (codigo.equals(aeropuerto.getCodigo())) {
                return aeropuerto;
            }
        }
        return null;
    }

   
    public void leerDatos() {
        String linea;
        Aeropuerto aeropuerto = null;
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
                if ("#Aeropuertos".equals(seccion)) {
                    String[] tokens = linea.split(";");
                    if (tokens.length >= 5) {
                        String codigo = tokens[0];
                        String nombre = tokens[1];
                        String poblacion = tokens[2];
                        String pais = tokens[3];
                        double gmt = Double.parseDouble(tokens[4]);
                      
                        aeropuerto = new Aeropuerto(codigo, nombre, poblacion, pais, gmt);
                        listaAeropuertos.add(aeropuerto);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public void GenerarArchivoAeropuertos() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("ListadoAeropuertos.txt"))) {
            pw.println("Código\tnombre\tpoblacion\tPaís\tGMT");
            pw.println("------------------------------------------------------------------------");
            for (Aeropuerto aeropuerto : listaAeropuertos) {
                pw.println(aeropuerto.getCodigo() + "\t" + aeropuerto.getNombre() + "\t" + aeropuerto.getPoblacion() + "\t" + aeropuerto.getPais() + "\t" + aeropuerto.getGmt());
            }
            pw.println("------------------------------------------------------------------------");
            pw.println("Numero de Aeropuertos: " + listaAeropuertos.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




