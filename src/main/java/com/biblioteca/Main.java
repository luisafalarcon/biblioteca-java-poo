package com.biblioteca;


import java.util.ArrayList;
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
                    System.out.println("aqui mostramos Libros");
                    ArrayList<Libro> libromostrar = biblioteca.mostrarLibros();
                    for(Libro lib: libromostrar){
                        System.out.println(lib);
                    }
                    break;
                case 2:
                    System.out.println("aqui mostramos un Libro");
                    System.out.println("ingresa el id del libro");
                    System.out.println("id del libro");
                    int idBuscar = scanner.nextInt();
                    Libro buscarLibro = biblioteca.encontrarLibro(idBuscar);
                    System.out.println(buscarLibro);
                    break;
                case 3:
                    System.out.println("aqui editamos Libros");
                    System.out.println("ingresa los siguientes datos");
                    System.out.println("id del libro a editar");
                    int idEdit = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("titulo del libro");
                    String tituloEdit = scanner.nextLine();
                    System.out.println("autor del libro");
                    String autorEdit = scanner.nextLine();
                    System.out.println("año del libro");
                    int añoEdit = scanner.nextInt();

                    boolean editado = biblioteca.editarLibro(idEdit, tituloEdit, autorEdit,añoEdit);

                    if(editado){
                        System.out.println("Libro editado correctamente");
                    }else{
                        System.out.println("El libro no existe");
                    }
                    break;
                case 4:
                    System.out.println("aqui eliminamos Libros");
                    System.out.println("ingresa el id del libro");
                    System.out.println("id del libro");
                    int idEliminar = scanner.nextInt();
                    biblioteca.eliminarLibro(idEliminar);
                    break;
                case 5:
                    System.out.println("aqui agregamos Libros");
                    System.out.println("ingresa los siguientes datos");
                    System.out.println("id del libro");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("titulo del libro");
                    String titulo = scanner.nextLine();
                    System.out.println("autor del libro");
                    String autor = scanner.nextLine();
                    System.out.println("año del libro");
                    int año = scanner.nextInt();

                    Libro libro = new Libro(id, titulo, autor, año);

                    boolean agregado = biblioteca.agregarLibro(libro);

                    if(agregado){
                        System.out.println("Libro agregado correctamente");
                    }else{
                        System.out.println("El libro ya existe");
                    }
                    System.out.println(biblioteca.mostrarLibros().size());
                    break;
            }
        }
        while(opcion !=6);


    }
}
