public class Socio {
    private String nombreSocio;
    private float precioAbonado;

    public Socio() {
        this.nombreSocio = "";
        this.precioAbonado = 0;
    }

    public Socio(String nombreSocio, float precioAbonado) {
        this.nombreSocio = nombreSocio;
        this.precioAbonado = precioAbonado;
    }

    public String getNombreSocio() {
        return nombreSocio;
    }

    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }

    public float getPrecioAbonado() {
        return precioAbonado;
    }

    public void setPrecioAbonado(float precioAbonado) {
        this.precioAbonado = precioAbonado;
    }

    @Override
    public String toString() {
        return nombreSocio + ", precioAbonado: " + precioAbonado;
    }

}
