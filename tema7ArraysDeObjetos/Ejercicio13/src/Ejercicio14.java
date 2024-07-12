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

    public static int pedirPosicion(){
        Scanner teclado = new Scanner(System.in);
        int posicion;
        System.out.print("Introduzca posicion: ");
        posicion = teclado.nextInt();
        posicion--;  //Tener en cuenta que para el usuario las posiciones NO empiezan en cero.
        return posicion;
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

    public static void insertarUnAlumno(Alumno[] vAlumnos){
        Alumno alumno;
        int posicion;
        boolean posicionVacia;
        
        do{
            posicionVacia = true;
            posicion = pedirPosicion();
            try{
                if  (vAlumnos[posicion] != null){
                    posicionVacia = false;
                    System.out.println("Celda ocupada por el alumno "+vAlumnos[posicion].getNombre());
                }
            }
            catch(ArrayIndexOutOfBoundsException e){
                posicionVacia = false;
                System.out.println("La posición debe estar comprendida entre 1 y "+vAlumnos.length);
            }
        }while(!posicionVacia);  //es lo mismo que poner (posicionVacia == false)
        
        alumno = rellenarDatosAlumno();
        vAlumnos[posicion] = alumno;
        System.out.println("Alumno insertado correctamente.");
    }

    public static void mostrarAlumnos(Alumno[] vAlumnos) {
        int i;

        for(i = 0; i < vAlumnos.length; i++){
            if (vAlumnos[i] == null) {
                System.out.print("\n");
            } else {
                System.out.println("Posicion "+ (i+1) + ": " + "\n" + vAlumnos[i]);
            }
        }
    }

    public static void mostrarAlumnoPorNota(Alumno[] vAlumnos){
        int num;

        num = pedirNum("Introduce el numero para mostrar los alumnos con nota media superior: ");

        for(int i = 0; i < vAlumnos.length; i++){
            if (vAlumnos[i] == null) {
                System.out.print("\n");

            }else{
                if(vAlumnos[i].getNotaMedia() >= num){
                    System.out.println(vAlumnos[i]);
                }
            }
            
        }
    }

    public static void mostrarAlumnoNotaMediaSuspensa(Alumno[] vAlumnos){
        for(Alumno alumno : vAlumnos){
            if (alumno == null) {
                System.out.println("");
            } else {
                if(alumno.getNotaMedia() < 5){
                    System.out.println(alumno);
                }   
            }
        }
    }

    public static void buscarAlumno(Alumno[] vAlumnos){
        String nombre;

        nombre = pedirString("Alumno que quieres buscar:");

        for(Alumno  alumno : vAlumnos){
            if (alumno == null) {
                System.out.println("");
            } else {
                if(alumno.getNombre().equalsIgnoreCase(nombre)){
                    System.out.println("El alumno si esta matriculado.");
                    System.out.println(alumno);
                }else{
                    System.out.println("El alumno no es matriculado.");
                }   
            }
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
                    insertarUnAlumno(vAlumnos);
                    break;
                case 2:
                    mostrarAlumnos(vAlumnos);
                    break;
                case 3:
                    mostrarAlumnoPorNota(vAlumnos);
                    break;
                case 4:
                    mostrarAlumnoNotaMediaSuspensa(vAlumnos);
                    break;
                case 5:
                    buscarAlumno(vAlumnos);
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
