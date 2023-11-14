import java.util.ArrayList;

import javax.swing.JOptionPane;

 public class ArrayListcarros {

    private ArrayList<carros> carros;

    public ArrayListcarros() {
        this.carros = new ArrayList<>();
    }

    public void agregarcarros(carros carros) {
        this.carros.add(carros);
    }

    public carros buscarcarrosPorPlaca(String placa) {
        for (carros carros : carros) {
            if (carros.getPlaca().equals(placa)) {
                return carros;
            }
        }
        return null;
    }

    public void imprimircarross() {
        for (carros carros : carros) {
            System.out.println(carros);
            JOptionPane.showMessageDialog(null, carros, null, 0);
        }
    }
}
