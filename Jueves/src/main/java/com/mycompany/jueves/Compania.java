/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jueves;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class Compania extends SuperClase {
   
    private List<Compania> listaCompanias; 

    public Compania(String nombre) {
        this.nombre = nombre;
       
    }

    public Compania() {
        this.listaCompanias = new ArrayList<>();
    }

    public List<Compania> getListaCompanias() {
        return listaCompanias;
    }

    public void setListaCompanias(List<Compania> listaCompanias) {
        this.listaCompanias = listaCompanias;
    }

   
    @Override
    public void mostrarInfo() {
       super.mostrarInfo();
    
    }
    
    public void mostrarListaCompanias(List<Compania> listaCompanias) {
    for (Compania c : listaCompanias) {
        c.mostrarInfo();
    }
}

  
    public void leerDatosCompanias() {
        String linea;
        Compania compania = null;
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
                    if (tokens.length >= 5) {
                        String nombre = tokens[4]; 
                        if (!existeCompania(nombre)) { 
                            compania = new Compania(nombre); 
                            listaCompanias.add(compania); 
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
    public boolean existeCompania(String nombre) {
        for (Compania compania : listaCompanias) {
            if (nombre.equals(compania.getNombre())) {
                return true; //El nombre ya existe
            }
        }
        return false;
    }

  
    public void GenerarArchivoCompanias() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("Listado_copañias.txt"))) {
            pw.println("LISTA DE COMPAÑIAS");
            pw.println("------------------------------------------------------------------------");
            for (Compania compania : listaCompanias) {
                pw.println("Nombre: " + compania.getNombre());
                pw.println(" ");
            }
            pw.println("------------------------------------------------------------------------");
            pw.println("Numero de Compañias: " + listaCompanias.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void leerDatos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}




