import java.util.Scanner;
import java.util.InputMismatchException;

public class Ejercicio15 {

    final static Scanner ENTRADA = new Scanner(System.in);

    public static int pedirNum(String mensaje) {
        int num = 0;
        boolean error = false;

        do {
            try {
                System.out.print(mensaje);
                num = ENTRADA.nextInt();
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

    public static void rellenarPeliculas(Pelicula[] vPeliculas) {
        String nombrePelicula;
        float precioPelicula;

        for (int i = 0; i < vPeliculas.length; i++) {
            nombrePelicula = pedirString("Nombre pelicula: ");
            precioPelicula = pedirFloat("Precio de la pelicula: ");

            vPeliculas[i] = new Pelicula(nombrePelicula, precioPelicula);
            vPeliculas[i].rellenarSocios();

        }
    }

    public static void mostrarPeliculas(Pelicula[] vPeliculas) {
        int i;

        for (i = 0; i < vPeliculas.length; i++) {
            System.out.println("Pelicula " + (i + 1) + "\n" + vPeliculas[i]);
            vPeliculas[i].mostrarSocio();
        }
    }

    public static void menu(Pelicula[] vPeliculas) {
        int num;
        do {
            System.out.println("1. Rellenar peliculas");
            System.out.println("2. Mostrar peliculas");
            System.out.println("3. Mostrar pelicula más rentable");
            System.out.println("4. Mostrar pelicula menos rentable");
            System.out.println("5. Mostrar beneficio dada una película");
            System.out.println("6. Contar socios por precio abonado");
            System.out.println("7. Salir");
            num = pedirNum("        Opcion: ");

            switch (num) {
                case 1:
                    rellenarPeliculas(vPeliculas);
                    break;
                case 2:
                    mostrarPeliculas(vPeliculas);
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;

                default:
                    break;
            }
        } while (num <= 7);
    }

    public static void main(String[] args) throws Exception {
        Pelicula[] vPeliculas = new Pelicula[3];

        menu(vPeliculas);
    }
}
