import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio8 {

    private final static Scanner ENTRADA = new Scanner(System.in);

    public static int pedirNum(String mensaje) {
        int num = 0;
        boolean error = false;

        while (!error) {
            try {
                System.out.println(mensaje);
                num = ENTRADA.nextInt();
                if (num >= 0) {
                    error = true;
                } else {
                    System.out.println("Error tienes que introducir un numero entero.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error debes introducri un numero entero");
                ENTRADA.next();
            } finally {
                ENTRADA.nextLine();
            }
        }
        return num;

    }

    public static float pedirFloat(String mensaje) {
        float num = 0;
        boolean error = false;

        while (!error) {
            try {
                System.out.println(mensaje);
                num = ENTRADA.nextFloat();
                if (num >= 0) {
                    error = true;
                } else {
                    System.out.println("Error tienes que introducir un numero entero.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error debes introducri un numero entero");
                ENTRADA.next();
            } finally {
                ENTRADA.nextLine();
            }
        }
        return num;

    }

    public static String pedirString(String mensaje) {

        System.out.println(mensaje);
        return ENTRADA.nextLine();

    }

    public static Producto datosProducto() {
        Producto producto;
        String nombre;
        float precio;
        int stock;

        nombre = pedirString("Introduzca el nombre del producto: ");
        precio = pedirFloat("Introduzca el precio del producto: ");
        stock = pedirNum("Introduzca el stock del producto:");

        producto = new Producto(nombre, precio, stock);

        return producto;

    }

    public static void rellenarVector(Producto[] vProductos) {
        int i;
        for (i = 0; i < vProductos.length; i++) {
            System.out.println("PRODUCTO" + (i + 1));
            vProductos[i].datosProducto();
        }
    }

    public static void menuAdministradcion() {
        int num, i = 1;
        do {
            System.out.println();
            num = ENTRADA.nextInt();

            i++;
        } while (i <= num);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("--BIENVENIDO A MI TIENDA DE DEPORTES--");
        int num = pedirNum("¿Cuantos productos deseas dar de alta?");
        Producto[] vProductos = new Producto[num];

    }
}
