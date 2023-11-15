package pruebas;



public class ComandoInterfaz implements Runnable {

    /**
     * Método que ejecuta la lógica de inicialización de la interfaz gráfica del programa.
     */
    public void run() {
        new ProgramaVehiculos();
    }
}