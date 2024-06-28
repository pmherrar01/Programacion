
public class Empleado {
    private String nombreEmpleado;
    private int horasTrabajadas;
    private int tarifa;

    public Empleado() {
        this.nombreEmpleado = "";
        this.horasTrabajadas = 0;
        this.tarifa = 0;
    }

    public Empleado(String nombreEmpleado, int horasTrabajadas, int tarifa) {
        this.nombreEmpleado = nombreEmpleado;
        this.horasTrabajadas = horasTrabajadas;
        this.tarifa = tarifa;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public String toString() {
        return "Empleado [nombreEmpleado=" + nombreEmpleado + ", horasTrabajadas=" + horasTrabajadas + ", tarifa="
                + tarifa + "]";
    }

}
