
package com.mycompany.jueves2;



public class Vuelo {
    
    private String origen;
    private String destino;
    private int plazas;
    private String duracion;
    private String compania; 

    
    public Vuelo(String origen, String destino, int plazas, String duracion, String compania) { 
        this.origen = origen;
        this.destino = destino;
        this.plazas = plazas;
        this.duracion = duracion;
        this.compania = compania; 
    }

    
    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getCompania() {
        return compania; 
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

   
    public void mostrarInfo() {
        System.out.println("Origen: " + this.getOrigen());
        System.out.println("Destino: " + this.getDestino());
        System.out.println("Plazas: " + this.getPlazas());
        System.out.println("Duración: " + this.getDuracion());
        System.out.println("Compañía: " + this.getCompania()); 
        System.out.println(" ");
    }
}