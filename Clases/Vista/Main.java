package Vista;

import Controlador.ComandoMenu;
import Controlador.ProgramaVehiculos;

public class Main {

    /* EJECUCION DEL PROGRAMA (NO INTERFAZ) */  
    public static void main(String[] args) {
        ProgramaVehiculos programaVehiculos = new ProgramaVehiculos();

        // Crear comandos para el menú
        ComandoMenu menu = new ComandoMenu(programaVehiculos);

        // Ejecutar el comando del menú
        menu.ejecutar();
    }
}
