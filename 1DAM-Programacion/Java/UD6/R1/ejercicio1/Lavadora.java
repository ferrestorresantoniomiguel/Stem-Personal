public class Lavadora extends Electrodomestico {
    private double capacidadCarga;

    public Lavadora(String nombre, String modelo, double capacidadCarga) {
        super(nombre, modelo);
        this.capacidadCarga = capacidadCarga;
        System.out.println("Constructor de lavadora");
    }

    @Override
    public String toString() {
        return "Electrodomestico: " + getNombre() + " | Modelo: " + getModelo() + " | Capacidad de Carga: " + capacidadCarga;
    }

    

}
