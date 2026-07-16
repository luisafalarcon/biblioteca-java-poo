package com.biblioteca.Utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilidades {

    public String leerTexto(Scanner scanner, String mensaje){
        System.out.println(mensaje);
        String texto = scanner.nextLine();
        return texto;
    }

    public int leerEntero(Scanner scanner, String mensaje){
        boolean valido = false;
        int entero = 0;
        do{
            try {
                System.out.println(mensaje);
                entero = scanner.nextInt();
                scanner.nextLine();
                valido= true;

            }catch (InputMismatchException e){
                valido = false;
                scanner.nextLine();
                System.out.println("Ingrese un numero entero");
            }
        }while(!valido);

        return entero;
    }
}
