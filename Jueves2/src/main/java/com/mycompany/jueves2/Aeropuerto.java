/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jueves2;


public class Aeropuerto extends SuperClase{

    private String codigo;
    private String poblacion;
    private String pais;
    private double gmt;



    public Aeropuerto(String codigo, String nombre, String poblacion, String pais, double gmt) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.pais = pais;
        this.gmt = gmt;
    }
   

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getGmt() {
        return gmt;
    }

    public void setGmt(double gmt) {
        this.gmt = gmt;
    }
    

    @Override
    public void mostrarInfo() {
        System.out.println("Código: " + this.getCodigo());
       super.mostrarInfo();
        System.out.println("Población: " + this.getPoblacion());
        System.out.println("País: " + this.getPais());
        System.out.println("GMT: " + this.getGmt());
        System.out.println(" ");
    }

    @Override
    public void leerDatos() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}



