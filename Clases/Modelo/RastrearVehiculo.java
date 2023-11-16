package Modelo;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;


public class RastrearVehiculo {
    private static RastrearVehiculo instancia = null; // Instancia única
    
    private ArrayList<carros> vehiculos = new ArrayList<>();
    
    private String[] ciudadesCali = { "Cali", "Yumbo", "Jamundí", "Palmira", "Buga", "Tuluá" };
    private String[] estado = { "Viajando", "Detenido", "Recargando combustible", "Perdido", "En su destino" };

    // Generar un índice aleatorio para la ciudad y el estado
    private Random random = new Random();
    private int indiceAleatorio = random.nextInt(ciudadesCali.length);
    private int estadoRandom = random.nextInt(estado.length);

    // Obtener la ciudad y el estado seleccionados aleatoriamente
    private String ciudadSeleccionada = ciudadesCali[indiceAleatorio];
    private String estadoRandomSeleccionado = estado[estadoRandom];

    // Constructor privado para evitar instanciación directa
    public RastrearVehiculo(ArrayList<carros> vehiculos) {
        this.vehiculos = vehiculos;
    }

    // Método estático para obtener la instancia única
    public static RastrearVehiculo obtenerInstancia(ArrayList<carros> vehiculos) {
        if (instancia == null) {
            instancia = new RastrearVehiculo(vehiculos);
        }
        return instancia;
    }

    // Método para rastrear un vehículo por su placa
    public void rastrearVehiculo() {
        String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo que desea rastrear: ");

        // Buscar el vehículo por placa
        carros vehiculo = buscarVehiculoPorPlaca(placa);

        if (vehiculo != null) {
            // Mostrar información del vehículo y su ubicación
            JOptionPane.showMessageDialog(null, "El vehículo con placa " + vehiculo.getPlaca()
                    + " se encuentra actualmente en las siguientes coordenadas:\n" + "\nLatitud: "
                    + vehiculo.getLatitud() + "\nLongitud: " + vehiculo.getLongitud() + "\nRuta: "
                    + ciudadSeleccionada + "\nEstado: " + estadoRandomSeleccionado);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún vehículo con la placa " + placa);
        }
        
    }

    // Método para buscar un vehículo por su placa
    private carros buscarVehiculoPorPlaca(String placa) {
        for (carros vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                return vehiculo;
            }
        }
        return null;
    }

 
}
