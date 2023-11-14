import java.util.ArrayList;

import javax.swing.JOptionPane;

public class RastrearVehiculo {

    private ArrayList<carros> vehiculos;

    public RastrearVehiculo(ArrayList<carros> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void rastrearVehiculo() {
        String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo que desea rastrear: ");
        carros vehiculo = vehiculos.buscarVehiculoPorPlaca(placa);

        if (vehiculo != null) {
            System.out.println("El vehículo con placa " + vehiculo.getPlaca() + " se encuentra actualmente en las siguientes coordenadas:");
            System.out.println("Latitud: " + vehiculo.getLatitud());
            System.out.println("Longitud: " + vehiculo.getLongitud());
        } else {
            System.out.println("No se encontró ningún vehículo con la placa " + placa);
        }
    }
}
