package Modelo;

import javax.swing.JOptionPane;

public class carros {
    public String tipo;
    public String placa;
    public int cantidadAsientos;
    public String tarea;
    public String conductor;
    public int id;
    public double latitud;
    public double longitud;

    public carros(String tipo, String placa, int cantidadAsientos) {
        this.tipo = tipo;
        this.placa = placa;
        this.cantidadAsientos = cantidadAsientos;
        this.tarea = "";
        this.conductor = "";
        this.id = (int) (Math.random() * 100);
        this.longitud = (id * Math.random());
        this.latitud = (id * Math.random());
    }

    public String getPlaca() {
        return placa;
    }

    public void asignarTarea(String tarea) {
        this.tarea = tarea;
    }

    public void asignaronductor(String conductor) {
        this.conductor = conductor;
    }

    public void imprimirInformacion() {

        JOptionPane.showMessageDialog(null, "Informacion de vehiculo: \n" + "Tipo: " + tipo + "\nPlaca: " + placa
                + "\nAsientos: " + cantidadAsientos  +"\nConductor asignado: " + conductor+ "\nTarea asignada: " + tarea);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "carros [tipo=" + tipo + ", placa=" + placa + ", cantidadAsientos=" + cantidadAsientos + ", tarea="
                + tarea + ", conductor=" + conductor + ", id=" + id + ", latitud=" + latitud + ", longitud=" + longitud
                + "]";
    }

}
