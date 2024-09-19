import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Ejercicio4 {

    /* Pide un número al usuario y lo retorna */
    public static int pedirNumero() {
        Scanner teclado = new Scanner(System.in);
        int num;
        System.out.print("Entero: ");
        num = teclado.nextInt();
        return num;
    }

    /* Inserto números en la lista mientras el número introducido sea positivo */
    public static void rellenarLista(ArrayList<Integer> lista) {
        int num;
        num = pedirNumero();
        /*
         * El usuario no tiene porqué querer introducir un número. Por eso he elegido el
         * bucle while
         */
        while (num > 0) {
            lista.add(num);
            num = pedirNumero();
        }
    }

    /*
     * Se recorre la lista poniendo a 0 todas las celdas que tengan el valor de
     * "num"
     */
    public static void sustituirRepetidosPorCero(ArrayList<Integer> lista, int num) {
        int primero, ultimo, i;

        primero = lista.indexOf(num);
        ultimo = lista.lastIndexOf(num);
        // Sé que sólo vamos a tener el número entre las posiciones "primero" y
        // "último".
        // También podríamos poner desde 0 a lista.size().
        for (i = primero; i <= ultimo; i++) {
            if (lista.get(i) == num) {
                lista.set(i, 0);
            }
        }
    }

    /* Retorna true si num está en la lista entre la posición pos y el final */
    public static boolean esRepetido(ArrayList<Integer> lista, int num) {
        int posIni = lista.indexOf(num);
        int posFin = lista.lastIndexOf(num);

        if (posIni == posFin) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * Se recorre la lista entera comprobando si el número es repetido. Si lo
     * está llama al método para que los sustituya por ceros.
     */
    public static void recorrerLista(ArrayList<Integer> lista) {
        int num;
        for (int i = 0; i < lista.size(); i++) {
            num = lista.get(i);
            if (num != 0) {
                if (esRepetido(lista, num)) {
                    sustituirRepetidosPorCero(lista, num);
                }
            }
        }
    }

    /* Muestra la lista */
    public static void mostrarLista(ArrayList<Integer> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.print("[" + lista.get(i) + "]");
        }
        System.out.print("\n");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        rellenarLista(lista);
        mostrarLista(lista);
        recorrerLista(lista);
        mostrarLista(lista);
    }

}
