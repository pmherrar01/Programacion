import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio2 {

    final static Scanner ENTRADA = new Scanner(System.in);

    public static int pedirNum(String mensaje) {
        int num = 0;
        boolean error = false;
        try {
            System.out.println(mensaje);
            num = ENTRADA.nextInt();
            if (num >= 0) {
                error = true;
            } else {
                System.out.println("Elementos añadidos a la lista");
            }
        } catch (InputMismatchException e) {
            System.out.println("Elementos añadidos a la lista");
            ENTRADA.next();
        } finally {
            ENTRADA.nextLine();
        }

        return num;
    }

    public static void rellenarLista(ArrayList<Integer> lNumeros) {
        int num;

        do {
            num = pedirNum("Introduce numeros hasta que nio quieras mas y en ese caso introduce un numero negativo");
            if (num > 0) {
                lNumeros.add(num);
            }
        } while (num > 0);
    }

    public static void mostrarLista(ArrayList<Integer> lNumeros) {
        for (Integer num : lNumeros) {
            if (num > 0) {
                System.out.print(num + ", ");
            }

        }
    }

    public static void mostrarNumeroMayor(ArrayList<Integer> lNumeros) {

        int mayor = lNumeros.get(0);

        for (int numero : lNumeros) {
            if (numero > mayor) {
                mayor = numero;
            }
        }

        System.out.println("\n El numero mayor es: " + mayor);
    }

    public static void mostrarNumeroMenor(ArrayList<Integer> lNumeros) {

        int n, menor = lNumeros.get(0);

        for (int i = 0; i < lNumeros.size(); i++) {
            n = lNumeros.get(i);
            if (n < menor) {
                menor = n;
            }
        }

        System.out.println("El numero menor es el: " + menor);

    }

    public static void sumaDeLosNumeros(ArrayList<Integer> lNumeros) {
        int suma = 0;

        for (int num : lNumeros) {
            suma += num;
        }

        System.out.println("La suma de los numero es de: " + suma);
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> lNumeros = new ArrayList<>();

        rellenarLista(lNumeros);
        mostrarLista(lNumeros);
        mostrarNumeroMayor(lNumeros);
        mostrarNumeroMenor(lNumeros);
        sumaDeLosNumeros(lNumeros);
    }
}
