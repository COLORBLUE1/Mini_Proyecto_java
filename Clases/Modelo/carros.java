package Modelo;

import javax.swing.JOptionPane;

public class carros {
    public String tipo;
    public String placa;
    public int cantidadAsientos;
    public String tarea;
    public String conductor;
    public double latitud;
    public double longitud;

    public carros(String tipo, String placa, int cantidadAsientos) {
        this.tipo = tipo;
        this.placa = placa;
        this.cantidadAsientos = cantidadAsientos;
        this.tarea = "";
        this.conductor = "";
        this.longitud = (Math.random()* 10000);
        this.latitud = (Math.random()* 20000);
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
        if(conductor==""){
 JOptionPane.showMessageDialog(null, "Informacion de vehiculo: \n" + "Tipo: " + tipo + "\nPlaca: " + placa
                + "\nCapacidad: " + cantidadAsientos  + "\nDisponibilidad: Disponible" +"\nConductor asignado: " + conductor+ "\nTarea asignada: " + tarea);

        }else{
             JOptionPane.showMessageDialog(null, "Informacion de vehiculo: \n" + "Tipo: " + tipo + "\nPlaca: " + placa
                + "\nCapacidad: " + cantidadAsientos  +"\nConductor asignado: "  + conductor + "\nDisponibilidad: Ocupado" + "\nTarea asignada: " + tarea);

        }
       
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
                + tarea + ", conductor=" + conductor +  ", latitud=" + latitud + ", longitud=" + longitud
                + "]";
    }

}
