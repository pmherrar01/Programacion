import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Pelicula {

    final static Scanner ENTRADA = new Scanner(System.in);

    private String titulo;
    private float precio;
    private Socio[] vSocios;

    public Pelicula() {
        this.titulo = "";
        this.precio = 0;
        this.vSocios = new Socio[4];
        for (int i = 0; i < this.vSocios.length; i++) {
            vSocios[i] = new Socio();
        }
    }

    public Pelicula(String titulo, float precio) {
        this.titulo = titulo;
        this.precio = precio;
        this.vSocios = new Socio[4];
        for (int i = 0; i < this.vSocios.length; i++) {
            vSocios[i] = new Socio();
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Socio[] getvSocios() {
        return vSocios;
    }

    public void setvSocios(Socio[] vSocios) {
        this.vSocios = vSocios;
    }

    public float pedirNum(String mensaje) {
        boolean error = false;
        float num = 0;

        try {
            System.out.print(mensaje);
            num = ENTRADA.nextFloat();

            if (num > 0) {
                error = true;
            } else {
                System.out.println("Error, tienes que introducir un numero positivo.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error, tienes que introducir un numero positivo.");
            ENTRADA.next();
        } finally {
            ENTRADA.nextLine();
        }

        return num;
    }

    public String pedirString(String mensaje) {
        System.out.println(mensaje);
        return ENTRADA.nextLine();
    }

    public Pelicula pedirDatosPelicula() {
        Pelicula pelicula;
        String nombre;
        float precio;

        nombre = pedirString("Nombre de la pelicula:");
        precio = pedirNum("Precio pelicula:");

        pelicula = new Pelicula(nombre, precio);

        return pelicula;
    }

    public void rellenarSocios() {
        String nombre;
        float precio;

        for (int i = 0; i < this.vSocios.length; i++) {
            nombre = pedirString("Nombre del socio");
            precio = pedirNum("Precio abonado");

            this.vSocios[i] = new Socio(nombre, precio);
        }
    }

    @Override
    public String toString() {
        return "Pelicula [titulo=" + titulo + ", precio=" + precio + ", vSocios=" + Arrays.toString(vSocios) + "]";
    }

}
