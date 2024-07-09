import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio14 {

    final static int MAX = 5;
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
                System.out.println("Error tienes que introducir un numero positivo");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error tienes que introducir un numero positivo");
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
                System.out.println("Error tienes que introducir un numero positivo");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error tienes que introducir un numero positivo");
            ENTRADA.next();
        } finally {
            ENTRADA.nextLine();
        }

        return num;
    }

    public static String pedirString(String mensaje) {
        System.out.println(mensaje);
        return ENTRADA.nextLine();
    }

    public static Alumno rellenarDatosAlumno() {
        Alumno alumno;
        String nombre;
        int edad;
        float notaMedia;

        nombre = pedirString("Nombre: ");
        edad = pedirNum("Edad: ");
        notaMedia = pedirFloat("Nota mdia: ");

        alumno = new Alumno(nombre, edad, notaMedia);

        return alumno;
    }

    public static void rellenarAlumnos(Alumno[] vAlumnos) {
        int i = 0;

        for (Alumno alumno : vAlumnos) {
            System.out.print("Alumno " + (i + 1));
            alumno = rellenarDatosAlumno();
            vAlumnos[i] = alumno;

            i++;
        }
    }

    public static void mostrarAlumnos(Alumno[] vAlumnos) {
        int i = 0;
        for (Alumno alumno : vAlumnos) {
            System.out.print("Alumno " + (i + 1));
            System.out.println(alumno.toString());

            i++;
        }
    }

    public static void menu(Alumno[] vAlumnos) {
        int num;
        do {
            System.out.println("------------MENU------------");
            System.out.println("1- Rellenar alumnos");
            System.out.println("2- Mostrar alumnos");
            System.out.println("3- Mostrar alumno con nota media superior a una nota");
            System.out.println("4- Mostrar alumnos con nota media suspensa");
            System.out.println("5- Buscar alumno");
            System.out.println("6- Salir");
            num = pedirNum("        Opcion: ");

            switch (num) {
                case 1:
                    rellenarAlumnos(vAlumnos);
                    break;
                case 2:
                    mostrarAlumnos(vAlumnos);
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

                default:
                    break;
            }
        } while (num != 6);
    }

    public static void main(String[] args) throws Exception {
        Alumno[] vAlumnos = new Alumno[MAX];
        menu(vAlumnos);
    }
}
