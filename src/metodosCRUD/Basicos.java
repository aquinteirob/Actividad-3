package metodosCRUD;

import java.util.Scanner;

public class Basicos {

    /**
     * Metodo que permite ingresar un numero por pantalla
     * @param texto cadena de texto que se muestra en pantalla según la necesidad del programa.
     * @return entero que representa la opción que se le dio al usuario
     * @author Quinteiro_Adhemar
     */
    public static int numericos(String texto) {
        int numero = 0;
        Scanner lector = new Scanner(System.in);
        System.out.println(texto);
        numero = lector.nextInt();
        lector.nextLine();
        return numero;
    }

    /**
     * Metodo que permite ingresar una cadena de texto por pantalla
     * @param texto cadena de texto que se muestra en pantalla según la necesidad del programa.
     * @return cadena de texto que el usuario ingreso
     * @author Quinteiro_Adhemar
     */
    public static String caracteres(String texto) {
        String caracter = " ";
        Scanner lector = new Scanner(System.in);
        try {
            System.out.println(texto);
            caracter = lector.nextLine();
            return caracter;
        } catch (java.lang.NumberFormatException e) {
            System.out.println("error");
        }
        return caracter;
    }
}
