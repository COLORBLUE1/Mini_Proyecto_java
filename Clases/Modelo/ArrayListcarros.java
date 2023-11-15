package Modelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ArrayListcarros {

    private ArrayList<carros> carros; // Lista de objetos carros

    // Constructor que inicializa la lista de carros
    public ArrayListcarros() {
        this.carros = new ArrayList<>();
    }

    // Método para agregar un objeto carros a la lista
    public void agregarcarros(carros carros) {
        this.carros.add(carros);
    }

    // Método para buscar un objeto carros por su placa
    public carros buscarcarrosPorPlaca(String placa) {
        for (carros carros : carros) {
            if (carros.getPlaca().equals(placa)) {
                return carros;
            }
        }
        return null;
    }

    // Método para imprimir la información de todos los carros en la lista
    public void imprimircarross() {
        for (carros carros : carros) {
            System.out.println(carros); // Imprimir en la consola la representación de cadena del objeto carros
            JOptionPane.showMessageDialog(null, carros, null, 0); // Mostrar un cuadro de diálogo con la información del
                                                                  // carro
        }
    }
}
