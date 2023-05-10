package metodosCRUD;

import java.util.Scanner;

public class Basicos {
    public static int numericos(String texto) {
        int numero = 0;
        Scanner lector = new Scanner(System.in);
        System.out.println(texto);
        numero = lector.nextInt();
        lector.nextLine();
        return numero;
    }

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
