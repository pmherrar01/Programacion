import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio15 {

    final static Scanner ENTRADA = new Scanner(System.in);

    public static int pedirNum(String mensaje) {
        boolean error = false;
        int num = 0;

        try {
            System.out.print(mensaje);
            num = ENTRADA.nextInt();

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

    public static String pedirString(String mensaje){
        System.out.println(mensaje);
        return ENTRADA.nextLine();
    }

    public static void rellenarPeliculasYSocios(Pelicula[] vPeliculas) {
        String nombre;
        float precio;

        for(int i = 0; i < vPeliculas.length; i++){
            nombre = pedirString("Nombre de la pelicula")
        }
    }

    public static void menu(Pelicula[] vPeliculas) {
        int num;
        do {
            System.out.println("-----------MENU-----------");
            System.out.println("1- Rellenar peliculas y socios");
            System.out.println("2- Mostrar peliculas y socios que lo han visto");
            System.out.println("3- Mostrar peliculas mas rentables");
            System.out.println("4- Mostrar pelicula menos rentable");
            System.out.println("5- Mostrar informacion de un pelicula dada");
            System.out.println("6- Cantidad de socios que han abonado una cantidad supeiror a otra dada");
            System.out.println("7- Salir");
            num = pedirNum("      Opcion:");

            switch (num) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                case 7:

                    break;

                default:
                    break;
            }
        } while (num != 7);
    }

    public static void main(String[] args) throws Exception {
        Pelicula[] vPeliculas = new Pelicula[3];
    }
}
