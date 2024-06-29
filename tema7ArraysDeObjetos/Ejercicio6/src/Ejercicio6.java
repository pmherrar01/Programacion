import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio6 {

    private static Scanner entrada = new Scanner(System.in);

    public static int pedirNum(String mensaje) {
        int num = 0;
        boolean error = false;

        while (!error) {

            try {

                System.out.print(mensaje);
                num = entrada.nextInt();
                if (num >= 0) {
                    error = true;
                } else {
                    System.out.println("Error debeds introducir un numero entero");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error debeds introducir un numero entero");
                entrada.next();
            } finally {
                entrada.nextLine();
            }
        }
        return num;

    }

    public static String pedirString(String mensaje) {

        System.out.print(mensaje);
        return entrada.nextLine();

    }

    public static Empleado datosEmpleado() {
        Empleado empleado;
        String nombre = pedirString("   Introduzca el nombre del empleado: ");
        int tarifa = pedirNum("    ¿Cual es su tarifa por hora trabajada?");
        int horasTrabajadas = pedirNum("    ¿Cuantas horas trabajo este mes?");

        empleado = new Empleado(nombre, horasTrabajadas, tarifa);

        return empleado;
    }

    public static void rellenarVector(Empleado[] vEmpleados) {
        int i;
        for (i = 0; i < vEmpleados.length; i++) {
            System.out.println("EMPLEADO " + (i + 1) + "\n");
            vEmpleados[i] = datosEmpleado();
            System.out.println("EMPLEADO " + (i + 1) + " ALMACENADO CON EXITO");
        }
    }

    public static void calcularSueldo(Empleado[] vEmpleados) {
        int sueldo = 0, i;

        for (i = 0; i < vEmpleados.length; i++) {
            sueldo = vEmpleados[i].getHorasTrabajadas() * vEmpleados[i].getTarifa();
            System.out.println(vEmpleados[i].getNombreEmpleado() + " trabajó " + vEmpleados[i].getHorasTrabajadas()
                    + " horas, cobra " + vEmpleados[i].getTarifa() + " la hora por lo que le corresponde un sueldo de "
                    + sueldo + "euros");
        }
    }

    public static void main(String[] args) throws Exception {
        try {
            Empleado[] vEmpleados = new Empleado[pedirNum("¿Cuántos empleados deseas introducir?" + "\n")];
            rellenarVector(vEmpleados);
            calcularSueldo(vEmpleados);

        } catch (Exception e) {
            System.out.print("Error:" + e.getMessage());
        }
    }
}
