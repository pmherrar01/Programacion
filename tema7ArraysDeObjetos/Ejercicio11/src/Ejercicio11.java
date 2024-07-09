import java.util.InputMismatchException;
import java.util.Scanner;;

public class Ejercicio11 {

    final static int MAX = 4;
    final static Scanner ENTRADA = new Scanner(System.in);

    public static int pedirNum(String mensaje) {
        int num = 0;
        boolean error = false;

        try {
            System.out.print(mensaje);
            num = ENTRADA.nextInt();
            if (num >= 0) {
                error = true;
            } else {
                System.out.println("Error debes introducir un numoer psotivo");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error debes introducir un numero positivo");
            ENTRADA.next();
        } finally {
            ENTRADA.nextLine();
        }

        return num;
    }

    public static float pedirFloat(String mensaje) {
        float num = 0;
        boolean error = false;

        try {
            System.out.print(mensaje);
            num = ENTRADA.nextFloat();
            if (num >= 0) {
                error = true;
            } else {
                System.out.println("Error debes introducir un numoer psotivo");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error debes introducir un numero positivo");
            ENTRADA.next();
        } finally {
            ENTRADA.nextLine();
        }

        return num;
    }

    public static String pedirString(String mensaje) {
        System.out.print(mensaje);
        return ENTRADA.nextLine();
    }

    public static Mueble rellenarDatosMueble() {
        Mueble mueble;
        float precio;
        String descripcion;

        descripcion = pedirString("Descripcion: ");
        precio = pedirFloat("Precio: ");

        mueble = new Mueble(precio, descripcion);

        return mueble;
    }

    public static void rellenarMuebles(Mueble[] vMuebles) {
        int i = 0;
        for (Mueble mueble : vMuebles) {
            System.out.println("Mueble " + (i + 1));
            mueble = rellenarDatosMueble();

            vMuebles[i] = mueble;

            i++;
        }
    }

    public static void mostrarMuebles(Mueble[] vMuebles) {
        int i;

        for (i = 0; i < vMuebles.length; i++) {
            System.out.print("Mueble " + (i + 1));
            System.out.println(vMuebles[i].toString());
        }
    }

    public static void mostrarPorPrecio(Mueble[] vMuebles) {
        float precio;

        precio = pedirFloat("Introduce un precio para buscar productos con ese precio y inferior: ");

        for (Mueble mueble : vMuebles) {
            if (mueble.getPrecio() <= precio) {
                System.out.println(mueble.toString());
            }
        }
    }

    public static void menu(Mueble[] vMuebles) {
        int num;

        do {
            System.out.println("---------MENU---------");
            System.out.println("1- Rellenar Muebles");
            System.out.println("2- Mostrar Muebles");
            System.out.println("3- Mostrar muebles por precio");
            System.out.println("4- Salir");
            num = pedirNum("      Opcion:");

            switch (num) {
                case 1:
                    rellenarMuebles(vMuebles);
                    break;
                case 2:
                    mostrarMuebles(vMuebles);
                    break;
                case 3:
                    mostrarPorPrecio(vMuebles);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    break;
            }
        } while (num != 4);
    }

    public static void main(String[] args) throws Exception {
        Mueble[] vMuebles = new Mueble[MAX];
        menu(vMuebles);
    }
}
