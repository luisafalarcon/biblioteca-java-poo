package com.biblioteca.UI;

import com.biblioteca.Model.Libro;
import com.biblioteca.Service.Biblioteca;
import com.biblioteca.Utils.Utilidades;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        Utilidades utilidades = new Utilidades();

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
                    mostrarLibros(biblioteca);
                    break;
                case 2:
                    buscarLibro(scanner, biblioteca, utilidades);
                    break;
                case 3:
                    editarLibro(scanner, biblioteca, utilidades);
                    break;
                case 4:
                    eliminarLibro(scanner, biblioteca, utilidades);
                    break;
                case 5:
                    agregarLibro(scanner, biblioteca, utilidades);
                    break;
            }
        }
        while(opcion !=6);


    }

    public static void agregarLibro(Scanner scanner, Biblioteca biblioteca, Utilidades utilidades){
        System.out.println("=== Agregar Libro ===");
        System.out.println("ingresa los siguientes datos");
        int id= utilidades.leerEntero(scanner, "id del libro");
        String titulo = utilidades.leerTexto(scanner, "titulo");
        String autor = utilidades.leerTexto(scanner, "autor");
        int año = utilidades.leerEntero(scanner, "Año");

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
            System.out.println(e.getMessage());
        }
    }

    public static void mostrarLibros(Biblioteca biblioteca){
        System.out.println("=== Mostrar Libros ===");
        ArrayList<Libro> libromostrar = biblioteca.mostrarLibros();

        if(libromostrar.isEmpty()){
            System.out.println("No hay libros registrados");
        }else {
            for (Libro lib : libromostrar) {
                System.out.println(lib);
            }
        }
    }

    public static void buscarLibro(Scanner scanner, Biblioteca biblioteca, Utilidades utilidades){
        System.out.println("=== Encontrar Libro ===");
        int idBuscar= utilidades.leerEntero(scanner, "Ingrese id del libro");
        Libro buscarLibro = biblioteca.encontrarLibro(idBuscar);
        if(buscarLibro != null) {
            System.out.println(buscarLibro);
        }else{
            System.out.println("No se encontro ningun libro");
        }
    }

    public static void editarLibro(Scanner scanner, Biblioteca biblioteca, Utilidades utilidades){
        System.out.println("=== Editar Libro ===");
        System.out.println("ingresa los siguientes datos");
        int idEdit= utilidades.leerEntero(scanner, "id del libro");
        String tituloEdit = utilidades.leerTexto(scanner, "titulo");
        String autorEdit = utilidades.leerTexto(scanner, "autor");
        int añoEdit = utilidades.leerEntero(scanner, "Año");

        boolean editado = biblioteca.editarLibro(idEdit, tituloEdit, autorEdit,añoEdit);

        if(editado){
            System.out.println("Libro editado correctamente");
        }else{
            System.out.println("El libro no existe");
        }
    }

    public static void eliminarLibro(Scanner scanner, Biblioteca biblioteca, Utilidades utilidades){
        System.out.println("=== Eiminar Libro ===");
        int idEliminar= utilidades.leerEntero(scanner, "Ingrese id del libro");
        biblioteca.eliminarLibro(idEliminar);
    }


}
