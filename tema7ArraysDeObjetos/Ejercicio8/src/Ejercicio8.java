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
            vProductos[i] = datosProducto();
        }
    }

    public static Producto[] menuAdministradcion() {
        Producto[] vProductos;
        int longitud;

        System.out.println("Acseso al menú de Administracion");

        longitud = pedirNum("Cuantos productos deseas dar de alta?");

        vProductos = new Producto[longitud];

        rellenarVector(vProductos);

        return vProductos;
    }

    public static void mostrarProductos(Producto[] vProductos) {
        int i;

        for (i = 0; i < vProductos.length; i++) {
            System.out.println("Pulse " + (i + 1) + "para comprar " + vProductos[i].getNombreProducto()
                    + " cuyo precio es de " + vProductos[i].getPrecio() + "€ y el stock es de "
                    + vProductos[i].getStock() + " unidades.");
        }
    }

    public static boolean actualizarStock(Producto productoActualizar, int unidades) {
        if (productoActualizar.getStock() < unidades) {

            System.out.println("Error quedan menos unidades que las selecionadas");
            return false;
        } else {
            productoActualizar.setStock(productoActualizar.getStock() - unidades);
            return true;
        }
    }

    public static void menuCompras(Producto[] vProductos) {
        int num, opcion;
        float subTotal = 0;
        String respuesta;

        System.out.println("Aceso al menu de compras");

        do {
            mostrarProductos(vProductos);
            opcion = pedirNum("Elija producto: ");
            System.out.println("Has elegido el producto: " + vProductos[opcion - 1].getNombreProducto());
            do {
                num = pedirNum("¿Cuantas unidades quieres?");
                if (actualizarStock(vProductos[opcion - 1], num)) {
                    subTotal += (num * vProductos[opcion - 1].getPrecio());
                    break;
                }

            } while (true);
            System.out.println("Subtotal de la cuenta: " + subTotal);
            respuesta = pedirString("¿Quieres comprar otro producto?");
        } while (respuesta.equalsIgnoreCase("si"));

        System.out.print("La cuenta final es de: " + subTotal + "€");

    }

    public static void main(String[] args) throws Exception {
        System.out.println("--BIENVENIDO A MI TIENDA DE DEPORTES--");
        Producto[] vProductos = menuAdministradcion();
        menuCompras(vProductos);

    }
}
