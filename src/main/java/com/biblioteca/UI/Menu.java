package com.biblioteca.UI;

import java.util.Scanner;
import com.biblioteca.Utils.Utilidades;

public class Menu {

    Utilidades utilidades = new Utilidades();

    public int mostrarMenu(Scanner scanner){

        System.out.println("--- MENÚ PRINCIPAL ---");
        System.out.println("1. Mostrar Libros");
        System.out.println("2. Buscar un libro");
        System.out.println("3. Buscar libro por titulo");
        System.out.println("4. Editar Libro");
        System.out.println("5. Eliminar Libro");
        System.out.println("6. Agregar libro");
        System.out.println("7. Salir");
        System.out.println("8. Organizar por titulo");

       return  utilidades.leerEntero(scanner, "Ingrese una opcion");

    }
}
