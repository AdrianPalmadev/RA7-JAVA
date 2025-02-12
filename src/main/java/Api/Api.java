package Api;

import java.util.Scanner;

public class Api {

    /**
     *
     * @param msg el mensaje principal con el que le pides el dato
     * @param error el mensaje en el caso que salga error
     * @return return del nombre lleno, para que nunca este vacio.
     */
    public static String noEnter(String msg, String error) {
        String nombre;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println(msg);
            nombre = input.nextLine();
            if (nombre.isEmpty()) {
                System.out.println(error);
            }
        } while (nombre.isEmpty());
        return nombre;
    }

    /**
     *
     * @param mayor el numero que deseas que sea mayor
     * @return devuelves el numero que sea mayor que la variable mayor
     */
    public static double Doublemayor(double mayor) {
        Scanner input = new Scanner(System.in);
        double numero;
        while (true) {
            System.out.println("Inserta un numero decimal mayor a " + mayor);
            try {
                numero = input.nextDouble();
                if (numero > mayor) {
                    return numero;
                }
            } catch (NumberFormatException e) {
                input.nextLine();
            }
        }
    }

    /**
     *
     * @param mayor numero que deseas que sea mayor
     * @return devuelve el numero que sea mayor que la variable mayor
     */
    public static int Intmayor(String msg, int mayor) {
        Scanner input = new Scanner(System.in);
        int numero;
        while (true) {
            System.out.println(msg);
            try {
                numero = Integer.parseInt(input.nextLine());
                if (numero > mayor) {
                    return numero;
                }
            } catch (NumberFormatException e) {
                input.nextLine();
            }
        }
    }

    /**
     *
     * @param min numero minimo
     * @param max numero maximo
     * @param msg mensaje con el que le pides el numero
     * @return return del numero entre el minimo y maximo
     */
    public static int askForIntBetween(int min, int max, String msg) {
        Scanner input = new Scanner(System.in);
        int number;

        do {
            System.out.println(msg);
            try {
                number = input.nextInt();
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println("Porfavor, inserta un numero entre " + min + " y " + max);
                }
            } catch (Exception e) {
                System.out.println("Porfavor, inserta un numero entero " + min + " y " + max);
                input.nextLine();
            }
        } while (true);
    }

    /**
     *
     * @param text para hacer print de cualquier menu que le pases por el metodo
     */
    public static void menu(String... text) {
        for (String t : text) {
            System.out.println(t);
        }

    }

    /**
     *
     * @param exit para salir de algun bucle o aplicacion
     * @return returnea true
     */
    public static boolean salir(boolean exit) {
        System.out.println("Saliendo...");
        return true;
    }

    /**
     *
     * @param msg el mensaje para si quiere hacer algo o no
     * @return return 's' o 'n'
     */
    public static boolean sn(String msg) {
        String sn;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println(msg + " S/N");
            sn = input.nextLine().toUpperCase();
            if (!sn.equals("S") && !sn.equals("N")) {
                System.out.println("Entrada no valida. Por favor, escribe S o N.");
            }
        } while (!sn.equals("S") && !sn.equals("N"));

        if (sn.equals("S")) {
            return true;
        } else {
            return false;
        }
    }

}
