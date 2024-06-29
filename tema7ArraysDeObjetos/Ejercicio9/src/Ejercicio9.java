import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio9 {

    final static int MAX = 3;
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
                System.out.print("Error tienes que introducir un numero entero");
            }
        } catch (InputMismatchException e) {
            System.out.print("Error tienes que introducir un numero entero");
            ENTRADA.next();
        } finally {
            ENTRADA.nextLine();
        }
        return num;
    }

    public static void main(String[] args) throws Exception {
        Alumno[] vAlumnos = new Alumno[MAX];
    }
}
