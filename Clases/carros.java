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
        System.out.println("Tipo: " + tipo);
        System.out.println("Placa: " + placa);
        System.out.println("Cantidad de asientos: " + cantidadAsientos);
        System.out.println("Tarea asignada: " + tarea);
    }
}
