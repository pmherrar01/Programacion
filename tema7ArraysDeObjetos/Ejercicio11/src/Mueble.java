public class Mueble {
    private float Precio;
    private String Descripcion;

    public Mueble() {
        this.Precio = '0';
        this.Descripcion = "";
    }

    public Mueble(float precio, String descripcion) {
        this.Precio = precio;
        this.Descripcion = descripcion;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float precio) {
        Precio = precio;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    @Override
    public String toString() {
        return ": " + Descripcion + ", precio: " + Precio;
    }

}
