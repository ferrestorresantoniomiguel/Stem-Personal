public class Animal {
    private String nombre;
    private String codigo;
    private int cantidad;
    private double precio;

    public Animal(String nombre, String codigo, int cantidad, double precio) {
        this.nombre = nombre;
        this.codigo = codigo;
        setGenerarCantidad(cantidad);
        setGenerarPrecio(precio);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setGenerarCantidad(int cantidad) {
        this.cantidad = -1;
        if (cantidad > 0) {
            this.cantidad = cantidad;
        }
    }

    private void setGenerarPrecio(double precio) {
        this.precio = -1;
        if (precio > 0) {
            this.precio = precio;
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public String consultarCantidad() {
        String mensajeCantidad = "";
        if (cantidad != -1) {
            mensajeCantidad= "Cantidad: " + cantidad;
        } else {
            mensajeCantidad= "CANTIDAD ERRONEA: Vuelve a cambiarla cuando sea posible";
        }
        return mensajeCantidad;
    }

    public String consultarPrecio() {
        String mensajePrecio = "";
        if (precio != -1) {
            mensajePrecio= "Precio: " + cantidad + "€";
        } else {
            mensajePrecio= "PRECIO ERRONEO: Vuelve a cambiarlo cuando sea posible";
        }
        return mensajePrecio;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + " | Nombre: " + nombre + " | " + consultarCantidad() + " | " + consultarPrecio();
    }

}
