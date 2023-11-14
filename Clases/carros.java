import javax.swing.JOptionPane;

class carros {
    private String tipo;
    private String placa;
    private int cantidadAsientos;
    private String tarea;

    public carros(String tipo, String placa, int cantidadAsientos) {
        this.tipo = tipo;
        this.placa = placa;
        this.cantidadAsientos = cantidadAsientos;
        this.tarea = "";
    }

    public String getPlaca() {
        return placa;
    }

    public void asignarTarea(String tarea) {
        this.tarea = tarea;
    }


    
    public void imprimirInformacion() {
      
        JOptionPane.showMessageDialog(null, "Informacion de vehiculo:\n" +  "Tipo:" +tipo+ "\nPlaca:" + placa +"\nAsientos"+cantidadAsientos + "\nTarea:" + tarea );

    }

}
