package Controlador;

public class ComandoMenu {

    // Referencia al objeto ProgramaVehiculos que ejecutará el comando
    private ProgramaVehiculos programaVehiculos;

    /**
     * Constructor que recibe una instancia de ProgramaVehiculos.
     * @param programaVehiculos Objeto ProgramaVehiculos al cual se asociará el comando.
     */
    public ComandoMenu(ProgramaVehiculos programaVehiculos) {
        this.programaVehiculos = programaVehiculos;
    }
    
    /**
     * Método que ejecuta el comando asociado al menú del programa.
     */
    public void ejecutar() {
        programaVehiculos.menu();
    }
}
