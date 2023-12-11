/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.jueves2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int opcion; 
        boolean opcionsalida=false;

        System.out.println("Bienvenid@ Gestion de Aeropuertos y vuelos ");
        System.out.println("1.  Cargar los datos de aeropuertos, vuelos y compañías desde el archivo proporcionado.");
        System.out.println("2. Mostrar la lista de vuelos de salida desde cada aeropuerto// en consola "); 
        System.out.println("3. Mostrar la lista de vuelos de llegada a cada aeropuerto// en consola");
        System.out.println("4. Salir"); // Agregar una opción para salir

        while (true) { 
            System.out.println("Ingrese el número de la opción que desea elegir:");
            opcion = sc.nextInt();

            switch (opcion) {
                 case 1: 
                    ListaAeropuertos aeropuertos = new ListaAeropuertos();
                    aeropuertos.leerDatos();
                    aeropuertos.GenerarArchivoAeropuertos();

                    ListaVuelos vuelos = new ListaVuelos(new ArrayList<>());
                    vuelos.leerDatos();
                    vuelos.GenerarArchivoVuelos();
                 
                    
                    Compania companias = new Compania();
                    companias.leerDatosCompanias();
                    companias.GenerarArchivoCompanias();
                    
                    System.out.println("Se ha ejecutado todo el código de aeropuertos, vuelos y compañías con éxito.");
                    break;
                case 2: 
                    
                    ListaVuelos vuelo = new ListaVuelos(new ArrayList<>());                 
                    vuelo.leerDatos();
                    vuelo.ConsolaVuelosSalida();
               
                    break;
                case 3: 
                    
                    ListaVuelos vuelo2 = new ListaVuelos(new ArrayList<>());
                    vuelo2.leerDatos();  
                    vuelo2.ConsolaVuelosLlegada();
                case 4: 
                    System.out.println("Gracias por usar el programa. Hasta pronto."); 
                    System.exit(0); // Terminar el programa
                default: 
                    System.out.println("La opción ingresada es inválida. Por favor, elija una opción del 1 al 4."); 
                    break;
            }
          
            System.out.println("¿Desea realizar otra operacion? (S/N)");
            char respuesta = sc.next().charAt(0); 
            if (respuesta == 'N' || respuesta == 'n') { 
                opcionsalida = true; 
                System.out.println("Hasta pronto.!!"); 
            }
            
        }
    }
}


















