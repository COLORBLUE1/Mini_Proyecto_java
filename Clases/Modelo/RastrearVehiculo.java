package Modelo;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class RastrearVehiculo {
    ArrayList<carros> vehiculos = new ArrayList<>();

    public RastrearVehiculo(ArrayList<carros> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void rastrearVehiculo() {
        String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo que desea rastrear: ");

        carros vehiculo = buscarVehiculoPorPlaca(placa);

        if (vehiculo != null) {
            JOptionPane.showMessageDialog(null, "El vehículo con placa " + vehiculo.getPlaca()
                    + " se encuentra actualmente en las siguientes coordenadas:\n"+ 
                            "\nLatitud: " + vehiculo.getLatitud()+
                            "\nLongitud: " + vehiculo.getLongitud());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún vehículo con la placa" + placa);
        }
    }

    public carros buscarVehiculoPorPlaca(String placa) {
        for (carros vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                return vehiculo;
            }
        }

        return null;
    }

}
