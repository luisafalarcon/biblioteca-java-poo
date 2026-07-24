package com.biblioteca.UI;

import java.util.Scanner;
import com.biblioteca.Utils.Utilidades;

public class Menu {

    Utilidades utilidades = new Utilidades();

    public int mostrarMenu(Scanner scanner){

        System.out.println("========== MENU PRINCIPAL ==========");
        System.out.println("1. Mostrar Libros");
        System.out.println("2. Buscar un libro por ID");
        System.out.println("3. Buscar libro por Titulo");
        System.out.println("4. Organizar libros por Titulo");
        System.out.println("5. Organizar libros por Autor");
        System.out.println("6. Organizar libros por Año");
        System.out.println("7. Agregar libro");
        System.out.println("8. Editar Libro");
        System.out.println("9. Eliminar Libro");
        System.out.println("10. Salir");


       return  utilidades.leerEntero(scanner, "Ingrese una opcion");

    }
}
