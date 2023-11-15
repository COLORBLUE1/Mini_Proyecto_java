package Modelo;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class RastrearVehiculo {
    ArrayList<carros> vehiculos = new ArrayList<>();
    String[] ciudadesCali = { "Cali", "Yumbo", "Jamundí", "Palmira", "Buga", "Tuluá" };
    String[] estado = { "Viajando", "Detenido", "Recargando combustible", "Perdido", "En su destino" };

    // Generar un índice aleatorio para la ciudad y el estado
    Random random = new Random();
    int indiceAleatorio = random.nextInt(ciudadesCali.length);
    int estadoramdon = random.nextInt(estado.length);

    // Obtener la ciudad y el estado seleccionados aleatoriamente
    String ciudadSeleccionada = ciudadesCali[indiceAleatorio];
    String estadoramdonselecionada = estado[estadoramdon];

    // Constructor que recibe la lista de vehículos
    public RastrearVehiculo(ArrayList<carros> vehiculos) {
        this.vehiculos = vehiculos;
    }

    // Método para rastrear un vehículo por su placa
    public void rastrearVehiculo() {
        String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo que desea rastrear: ");

        // Buscar el vehículo por placa
        carros vehiculo = buscarVehiculoPorPlaca(placa);

        if (vehiculo != null) {
            // Mostrar información del vehículo y su ubicación
            JOptionPane.showMessageDialog(null, "El vehículo con placa " + vehiculo.getPlaca()
                    + " se encuentra actualmente en las siguientes coordenadas:\n" +
                    "\nLatitud: " + vehiculo.getLatitud() +
                    "\nLongitud: " + vehiculo.getLongitud() +
                    "\nRuta: " + ciudadSeleccionada +
                    "\nEstado: " + estadoramdonselecionada);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún vehículo con la placa " + placa);
        }
    }

    // Método para buscar un vehículo por su placa
    public carros buscarVehiculoPorPlaca(String placa) {
        for (carros vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                return vehiculo;
            }
        }
        return null;
    }
}
