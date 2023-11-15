package Vista;

import javax.swing.SwingUtilities;

import pruebas.ProgramaVehiculos;

public class Main_interfaz {
    
 public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ProgramaVehiculos();
            }
        });
    }

}
