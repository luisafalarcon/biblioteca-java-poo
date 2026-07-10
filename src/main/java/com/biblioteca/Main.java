package com.biblioteca;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        Scanner scanner = new Scanner(System.in);



        int opcion;

        do {
            System.out.println("--- MENÚ PRINCIPAL ---");
            System.out.println("1. Opción 1: Mostrar Libros");
            System.out.println("2. Opción 2: Buscar un libro");
            System.out.println("3. Editar Libro");
            System.out.println("4. Eliminar Libro");
            System.out.println("5. Agregar libro");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("=== Mostrar Libros ===");
                    ArrayList<Libro> libromostrar = biblioteca.mostrarLibros();
                    for(Libro lib: libromostrar){
                        System.out.println(lib);
                    }
                    break;
                case 2:
                    System.out.println("=== Encontrar Libro ===");
                    System.out.println("ingresa el id del libro");
                    System.out.println("id del libro");
                    int idBuscar= leerEntero(scanner, "id del libro");
                    Libro buscarLibro = biblioteca.encontrarLibro(idBuscar);
                    if(buscarLibro != null) {
                        System.out.println(buscarLibro);
                    }else{
                        System.out.println("No se encontro ningun libro");
                    }
                    break;
                case 3:
                    System.out.println("=== Editar Libro ===");
                    System.out.println("ingresa los siguientes datos");
                    int idEdit= leerEntero(scanner, "id del libro");
                    String tituloEdit =leerTexto(scanner, "titulo");
                    String autorEdit = leerTexto(scanner, "autor");
                    int añoEdit = leerEntero(scanner, "Año");

                    boolean editado = biblioteca.editarLibro(idEdit, tituloEdit, autorEdit,añoEdit);

                    if(editado){
                        System.out.println("Libro editado correctamente");
                    }else{
                        System.out.println("El libro no existe");
                    }
                    break;
                case 4:
                    System.out.println("=== Eiminar Libro ===");
                    System.out.println("ingresa el id del libro");
                    System.out.println("id del libro");
                    int idEliminar= leerEntero(scanner, "id del libro");
                    biblioteca.eliminarLibro(idEliminar);
                    break;
                case 5:
                    System.out.println("=== Agregar Libro ===");
                    System.out.println("ingresa los siguientes datos");
                    int id= leerEntero(scanner, "id del libro");
                    String titulo =leerTexto(scanner, "titulo");
                    String autor = leerTexto(scanner, "autor");
                    int año = leerEntero(scanner, "Año");

                    try{
                        Libro libro = new Libro(id, titulo, autor, año);

                        boolean agregado = biblioteca.agregarLibro(libro);

                        if(agregado){
                            System.out.println("Libro agregado correctamente");
                        }else{
                            System.out.println("El libro ya existe");
                        }
                        System.out.println(biblioteca.mostrarLibros().size());
                    }catch (IllegalArgumentException e){
                        System.out.println("Debe ingresar un numero entero");
                    }
                    break;
            }
        }
        while(opcion !=6);


    }
    public static String leerTexto(Scanner scanner, String mensaje){
        System.out.println(mensaje);
        String texto = scanner.nextLine();
        return texto;
    }

    public static int leerEntero(Scanner scanner, String mensaje){
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
                System.out.println(e.getMessage());
            }
        }while(!valido);

        return entero;
    }
}
