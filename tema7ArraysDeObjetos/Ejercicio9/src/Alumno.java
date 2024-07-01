import java.util.InputMismatchException;

import java.util.Scanner;

public class Alumno {

    final static Scanner ENTRADA = new Scanner(System.in);
    final static String[] NOMBRESASIGNATURAS = { "Lengua", "Mates", "Historia", "Fisica" };
    final static int MAX = 4;

    private String nombreAlumno;
    private Asignatura[] vAsignaturas;

    public Alumno() {
        this.nombreAlumno = "";
        this.vAsignaturas = new Asignatura[MAX];
    }

    public Alumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
        this.vAsignaturas = new Asignatura[MAX];
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public Asignatura[] getvAsignaturas() {
        return vAsignaturas;
    }

    public void setvAsignaturas(Asignatura[] vAsignaturas) {
        this.vAsignaturas = vAsignaturas;
    }

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

    public Asignatura rellenarDatoAsignatura(String nombre, int num) {
        Asignatura asignatura;

        asignatura = new Asignatura(nombre, num);

        return asignatura;
    }

    public void rellenarAsignaturas() {

        int i;

        for (i = 0; i < vAsignaturas.length; i++) {
            System.out.println(NOMBRESASIGNATURAS[i]);
            vAsignaturas[i] = rellenarDatoAsignatura(NOMBRESASIGNATURAS[i], pedirNum(" Nota:"));
        }

    }

    public void mostrarAsignaturas() {
        for (Asignatura asignatura : vAsignaturas) {
            System.out.println("    " + asignatura.getNombreAsignatura() + ": " + asignatura.getNota());
        }
    }

    public int getNotaMedia() {
        int notaMedia = 0;
        for (Asignatura asignatura : vAsignaturas) {
            notaMedia += asignatura.getNota();
        }

        return notaMedia / MAX;
    }

    public int asignaturasSuspensas() {
        int suspensos = 0;

        for (Asignatura asignatura : vAsignaturas) {
            if (asignatura.getNota() < 5) {
                suspensos++;
            }
        }

        return suspensos;
    }
}
