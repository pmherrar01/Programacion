import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio7 {

    private static int MAX = 30;
    private static Scanner entrada = new Scanner(System.in);
    private static String[] VNOMBRESSEMANA = { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado",
            "Domingo" };

    private static Random RANDOM = new Random();

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
                    System.out.println("Error debes introducir un numero entero. ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error debes introducir un numero entero. ");
                entrada.next();
            } finally {
                entrada.nextLine();
            }
        }
        return num;
    }

    public static void rellenarDias(Dia[] vDias) {
        int i;
        int diaSemana = RANDOM.nextInt(VNOMBRESSEMANA.length);
        for (i = 0; i < vDias.length; i++) {
            int temperatura;
            temperatura = RANDOM.nextInt(51) - 5;
            vDias[i] = new Dia(VNOMBRESSEMANA[diaSemana], temperatura);
            diaSemana = (diaSemana + 1) % VNOMBRESSEMANA.length;
        }
    }

    public static void mostrarMes(Dia[] vDias) {
        int i;
        for (i = 0; i < vDias.length; i++) {
            System.out.println(vDias[i].getNombreDia() + " " + (i + 1) + ": " + vDias[i].getTemperatura() + " grados");
        }
    }

    public static void temperaturaMedia(Dia[] vDias) {
        int media = 0;

        for (Dia dia : vDias) {
            media = media + dia.getTemperatura();
        }

        System.out.println("La temperatura media del mes es:" + (media / MAX) + "º");
    }

    public static void diaODiasCalurosos(Dia[] vDias) {
        int temperaturaMax = 0;

        for (int i = 0; i < vDias.length; i++) {
            if (vDias[i].getTemperatura() > temperaturaMax) {
                temperaturaMax = vDias[i].getTemperatura();
            }
        }

        System.out.println("Dia o dias mas calurosos fueron: ");
        for (int i = 0; i < vDias.length; i++) {
            if (vDias[i].getTemperatura() == temperaturaMax) {
                System.out.println("El " + vDias[i].getNombreDia() + " dia " + (i + 1) + " con una temperatura de "
                        + vDias[i].getTemperatura() + "º");
            }
        }
    }

    public static void menu(Dia[] vDias) {
        int num;

        do {
            System.out.println("-----------MENU-----------");
            System.out.println("1- Rellenar temepraturas de manera aleatoria.");
            System.out.println("2- Mostrar temperaturas");
            System.out.println("3- Mostrar temperatura media del mes");
            System.out.println("4- Dia o dias mas calurosos");
            System.out.println("5- Salir");
            num = pedirNum("        Opcion:");

            switch (num) {
                case 1:
                    rellenarDias(vDias);
                    break;
                case 2:
                    mostrarMes(vDias);
                    break;
                case 3:
                    temperaturaMedia(vDias);
                    break;
                case 4:
                    diaODiasCalurosos(vDias);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    break;
            }
        } while (num != 5);
    }

    public static void main(String[] args) throws Exception {
        Dia[] vDias = new Dia[MAX];
        menu(vDias);
    }
}
