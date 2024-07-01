import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio9 {

    final static int MAX = 3;
    final static Scanner ENTRADA = new Scanner(System.in);
    final static String[] NOMBRESALUMNOS = { "Pepe", "Juan", "Marta" };

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

    public static String pedirString(String mensaje) {
        System.out.println(mensaje);
        return ENTRADA.nextLine();
    }

    public static Alumno rellenarDatosAlumno(String nombre) {

        return new Alumno(nombre);

    }

    public static void rellenarAlumnos(Alumno[] vAlumnos) {
        for (int i = 0; i < vAlumnos.length; i++) {
            vAlumnos[i] = rellenarDatosAlumno(NOMBRESALUMNOS[i]);

            System.out.println("Notas de " + vAlumnos[i].getNombreAlumno());
            vAlumnos[i].rellenarAsignaturas();
        }
    }

    public static void mostrarAlumnos(Alumno[] vAlumnos) {
        for (Alumno alumno : vAlumnos) {
            System.out.println(alumno.getNombreAlumno());
            alumno.mostrarAsignaturas();
        }
    }

    public static void notaMedia(Alumno[] vAlumnos) {
        int notaMediaMax = 0;
        for (Alumno alumno : vAlumnos) {
            if (alumno.getNotaMedia() > notaMediaMax) {
                notaMediaMax = alumno.getNotaMedia();
            }
        }

        for (Alumno alumno : vAlumnos) {
            if (notaMediaMax == alumno.getNotaMedia()) {
                System.out.println("El alumno con nota media mas alta es: " + alumno.getNombreAlumno()
                        + " con una nota media de " + notaMediaMax);
            }
        }
    }

    public static String alumnoMasSuspensos(Alumno[] vAlumnos) {
        Alumno alumnoAux = null;
        int suspensosMax = 0;
        for (Alumno alumno : vAlumnos) {
            int suspensos = alumno.asignaturasSuspensas();
            if (suspensos > suspensosMax) {
                suspensosMax = suspensos;
                alumnoAux = alumno;
            }
        }

        if (alumnoAux == null) {
            return "No hay slumnos con suspensos";
        } else {
            return alumnoAux.getNombreAlumno() + " con " + suspensosMax + " suspensos";
        }

    }

    public static String mostrarAsignaturaMasDificil(Alumno[] vAlumnos) {
        int[] suspensosPorAsignatura = new int[Alumno.MAX];
        for (Alumno alumno : vAlumnos) {
            for (int i = 0; i < Alumno.MAX; i++) {
                if (alumno.getvAsignaturas()[i].getNota() < 5) {
                    suspensosPorAsignatura[i]++;
                }
            }
        }

        int maxSuspensos = 0;
        String asignaturaMasDificil = "";
        for (int i = 0; i < Alumno.MAX; i++) {
            if (suspensosPorAsignatura[i] > maxSuspensos) {
                maxSuspensos = suspensosPorAsignatura[i];
                asignaturaMasDificil = Alumno.NOMBRESASIGNATURAS[i];
            }
        }

        return asignaturaMasDificil + " con " + maxSuspensos + " suspensos.";
    }

    public static void menu(Alumno[] vAlumnos) {
        int num;

        do {

            System.out.println("--------MENU--------");
            System.out.println("1- Rellenar notas alumnos");
            System.out.println("2- Mostrar notas de los alumnos.");
            System.out.println("3- Mostrar mejor alumno");
            System.out.println("4- Alumno con mas suspensos");
            System.out.println("5- Asignatura mas dificil");
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
                    notaMedia(vAlumnos);
                    break;
                case 4:
                    System.out.println("El alumno con mas suspensos es: " + alumnoMasSuspensos(vAlumnos));
                    break;
                case 5:
                    System.out.println("La asignatura mas dificel es:" + mostrarAsignaturaMasDificil(vAlumnos));
                    break;
                case 6:
                    System.out.print("Saliendo...");
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
