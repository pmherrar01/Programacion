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
            this.vSocios[i] = new Socio();
        }
    }

    public Pelicula(String titulo, float precio) {
        this.titulo = titulo;
        this.precio = precio;
        this.vSocios = new Socio[4];

        for (int i = 0; i < this.vSocios.length; i++) {
            this.vSocios[i] = new Socio();
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

    public static float pedirFloat(String mensaje) {
        float num = 0;
        boolean error = false;

        do {
            try {
                System.out.print(mensaje);
                num = ENTRADA.nextFloat();
                if (num >= 0) {
                    error = false; // Salir del bucle si el número es positivo
                } else {
                    System.out.println("Error: el número debe ser positivo.");
                    error = true; // Continuar el bucle si el número es negativo
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: entrada inválida, por favor ingrese un número.");
                ENTRADA.next(); // Limpiar la entrada inválida
                error = true; // Continuar el bucle en caso de excepción
            } finally {
                ENTRADA.nextLine(); // Limpiar el buffer de entrada
            }
        } while (error);

        return num;
    }

    public static String pedirString(String mensaje) {
        System.out.print(mensaje);
        return ENTRADA.nextLine();
    }

    public void rellenarSocios() {
        String nombreSocio;
        float precioAbonado;

        for (int i = 0; i < this.vSocios.length; i++) {
            nombreSocio = pedirString("Nombre del socio: ");
            precioAbonado = pedirFloat("Precio: ");

            this.vSocios[i] = new Socio(nombreSocio, precioAbonado);
        }
    }

    public void mostrarSocio() {
        for (int i = 0; i < this.vSocios.length; i++) {
            System.out.println("    Socio " + (i + 1) + vSocios[i]);
        }
    }

    @Override
    public String toString() {
        return titulo + ", precio=" + precio;
    }

}
