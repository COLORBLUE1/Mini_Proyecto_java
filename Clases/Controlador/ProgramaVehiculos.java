package Controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Modelo.RastrearVehiculo;
import Modelo.carros;

public class ProgramaVehiculos {

    public void menu() {
        ArrayList<carros> vehiculos = new ArrayList<>();
        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "Menú:\n1. Agregar vehículo\n2. Imprimir información de vehículos\n3. Asignar conductor y tarea a vehículo\n4. Rastreas\n5. Salir");

            if (opcion.equals("1")) {
                String tipo = JOptionPane.showInputDialog("Ingrese el tipo de vehículo:");
                String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo:");
                int cantidadAsientos = Integer
                        .parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de asientos del vehículo:"));

                carros vehiculo = new carros(tipo, placa, cantidadAsientos);
                vehiculos.add(vehiculo);

                JOptionPane.showMessageDialog(null, "Vehículo agregado exitosamente.");
            } else if (opcion.equals("2")) {
                String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo a buscar:");

                boolean encontrado = false;
                for (carros vehiculo : vehiculos) {
                    if (vehiculo.getPlaca().equals(placa)) {
                        vehiculo.imprimirInformacion();
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    JOptionPane.showMessageDialog(null, "No se encontró ningún vehículo con esa placa.");
                }
            } else if (opcion.equals("3")) {
          
                String placa = JOptionPane
                        .showInputDialog("Ingrese la placa del vehículo al que desea asignar una tarea:");

                String conductor = JOptionPane.showInputDialog("Ingrese la conductor a asignar:");
                String tarea = JOptionPane.showInputDialog("Ingrese la tarea a asignar:");

                boolean encontrado = false;
                for (carros vehiculo : vehiculos) {
                    if (vehiculo.getPlaca().equals(placa)) {
                        vehiculo.asignaronductor(conductor);
                        vehiculo.asignarTarea(tarea);
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    JOptionPane.showMessageDialog(null, "No se encontró ningún vehículo con esa placa.");
                }
            } else if (opcion.equals("4")) {

                RastrearVehiculo rastrear = new RastrearVehiculo(vehiculos);
                rastrear.rastrearVehiculo();
            } else if (opcion.equals("5")) {
                JOptionPane.showMessageDialog(null, "Hasta luego.");

                break;
            } else {
                JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, ingrese una opción válida.");
            }

        }
    }
}
