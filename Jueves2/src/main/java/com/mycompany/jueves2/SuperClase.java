/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jueves2;


public abstract class SuperClase {
    

    protected String nombre;
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
     public void mostrarInfo() {
        System.out.println("Nombre: " + this.getNombre());
    }

      public abstract void leerDatos();
     
   
}
