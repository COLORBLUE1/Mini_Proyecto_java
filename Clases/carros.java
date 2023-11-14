import javax.swing.JOptionPane;

class carros {
    private String tipo;
    private String placa;
    private int cantidadAsientos;
    private String tarea;
    private int id;
    private double latitud;
    private double longitud;

    public carros(String tipo, String placa, int cantidadAsientos) {
        this.tipo = tipo;
        this.placa = placa;
        this.cantidadAsientos = cantidadAsientos;
        this.tarea = "";
        this.id = (int) (Math.random() * 1000000);
    }

    public String getPlaca() {
        return placa;
    }

    public void asignarTarea(String tarea) {
        this.tarea = tarea;
    }

    public void imprimirInformacion() {

        JOptionPane.showMessageDialog(null, "Informacion de vehiculo:\n" + "Tipo:" + tipo + "\nPlaca:" + placa
                + "\nAsientos" + cantidadAsientos + "\nTarea:" + tarea);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "carros{" +
                "tipo='" + tipo + '\'' +
                ", placa='" + placa + '\'' +
                ", cantidadAsientos=" + cantidadAsientos +
                ", id=" + id +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                '}';
    }

}
