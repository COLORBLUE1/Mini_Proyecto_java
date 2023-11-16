package pruebas;

import javax.swing.*;


import Modelo.carros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ProgramaVehiculos {
    private ArrayList<carros> vehiculos;
    public JTextArea outputTextArea;

    // Constructor de la clase
    public ProgramaVehiculos() {
        this.vehiculos = new ArrayList<>();
        crearInterfaz();
    }

    // Método para crear la interfaz gráfica
    private void crearInterfaz() {
        JFrame frame = new JFrame("Programa de Vehículos");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla

        JPanel panel = new JPanel();
        frame.add(panel);
        colocarComponentes(panel);

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        scrollPane.setBounds(10, 60, 360, 180);
        panel.add(scrollPane);

        frame.setVisible(true);
    }

    // Método para colocar componentes en el panel
    private void colocarComponentes(JPanel panel) {
        panel.setLayout(null);

        JLabel label = new JLabel("Menú:");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);

        String[] opciones = { "Seleccione una opción", "Agregar vehículo", "Imprimir información de vehículos",
                "Asignar conductor y tarea a vehículo", "Rastrear", "Salir" };
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        comboBox.setBounds(100, 20, 165, 25);
        panel.add(comboBox);

        JButton button = new JButton("Aceptar");
        button.setBounds(275, 20, 80, 25);
        panel.add(button);

        // Configuración del ActionListener para el botón
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String opcion = (String) comboBox.getSelectedItem();
                procesarOpcion(opcion);
            }
        });
    }

    // Método para procesar la opción seleccionada en el menú
    private void procesarOpcion(String opcion) {
        switch (opcion) {
            case "Agregar vehículo":
                agregar();
                break;
            case "Imprimir información de vehículos":
                imprimir();
                break;
            case "Asignar conductor y tarea a vehículo":
                asignar();
                break;
            case "Rastrear":
                rastrearVehiculointer();
                break;
            case "Salir":
                JOptionPane.showMessageDialog(null, "Hasta luego.");
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, ingrese una opción válida.");
        }
    }

    // Método para agregar un vehículo a la lista
    public void agregar() {
        String tipo1 = JOptionPane.showInputDialog("Ingrese el tipo de vehículo:");
        String placa1 = JOptionPane.showInputDialog("Ingrese la placa del vehículo:");
        int cantidadAsientos = Integer
                .parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de asientos del vehículo:"));

        carros vehiculo = new carros(tipo1, placa1, cantidadAsientos);
        vehiculos.add(vehiculo);
        JOptionPane.showMessageDialog(null, "Vehículo agregado exitosamente.");
    }

    // Método para imprimir información de un vehículo
    public void imprimir() {
        String placa2 = JOptionPane.showInputDialog("Ingrese la placa del vehículo a buscar:");

        boolean encontrado = false;
        for (carros vehiculo1 : vehiculos) {
            if (vehiculo1.getPlaca().equals(placa2)) {
                imprimirInformacioninter();
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún vehículo con esa placa.");
        }
    }

    // Método para rastrear un vehículo
    public void rastrearVehiculointer() {
        String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo que desea rastrear: ");
        String[] ciudadesCali = { "Cali", "Yumbo", "Jamundí", "Palmira", "Buga", "Tuluá" };
        String[] estado = { "Viajando", "Detenido", "Recargando combustible", "Perdido", "En su destino" };

        // Generar un índice aleatorio
        Random random = new Random();
        int indiceAleatorio = random.nextInt(ciudadesCali.length);
        int estadoramdon = random.nextInt(estado.length);

        String ciudadSeleccionada = ciudadesCali[indiceAleatorio];
        String estadoramdonselecionada = estado[estadoramdon];
        carros vehiculo = buscarVehiculoPorPlaca(placa);

        if (vehiculo != null) {
            outputTextArea.setText("El vehículo con placa " + vehiculo.getPlaca()
                    + " se encuentra actualmente en las siguientes coordenadas:\n" +
                    "\nLatitud: " + vehiculo.getLatitud() +
                    "\nLongitud: " + vehiculo.getLongitud() +
                    "\nRuta: " + ciudadSeleccionada +
                    "\nEstado: " + estadoramdonselecionada);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún vehículo con la placa " + placa);
        }
    }

    // Método para buscar un vehículo por placa
    public carros buscarVehiculoPorPlaca(String placa) {
        for (carros vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                return vehiculo;
            }
        }

        return null;
    }

    // Método para imprimir información de un vehículo (interfaz)
    public void imprimirInformacioninter() {
        String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo a buscar:");

        boolean encontrado = false;
        for (carros vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                outputTextArea.setText("Información de vehículo:\n" + "Tipo: " + vehiculo.tipo + "\nPlaca: "
                        + vehiculo.getPlaca() + "\nCapacidad: " + vehiculo.cantidadAsientos + "\nDisponibilidad: "
                        + "Disponible" + "\nConductor asignado: " + vehiculo.conductor + "\nTarea asignada: "
                        + vehiculo.tarea);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún vehículo con esa placa.");
        }
    }

    // Método para asignar conductor y tarea a un vehículo
    public void asignar() {
        String placa3 = JOptionPane
                .showInputDialog("Ingrese la placa del vehículo al que desea asignar una tarea:");

        boolean encontrado = false;
        for (carros vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa3)) {
                String conductor = JOptionPane.showInputDialog("Ingrese la conductor a asignar:");
                String tarea = JOptionPane.showInputDialog("Ingrese la tarea a asignar:");
                vehiculo.asignaronductor(conductor);
                vehiculo.asignarTarea(tarea);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún vehículo con esa placa.");
        }
    }
   
}
