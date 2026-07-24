package com.biblioteca.UI;

import com.biblioteca.Model.Libro;
import com.biblioteca.Service.Biblioteca;
import com.biblioteca.UI.Menu;
import com.biblioteca.Utils.Utilidades;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        Utilidades utilidades = new Utilidades();
        Menu menu = new Menu();

        Scanner scanner = new Scanner(System.in);
       int opcion;


        do {
            opcion  = menu.mostrarMenu(scanner);
            switch (opcion){
                case 1:
                    mostrarLibros(biblioteca);
                    break;
                case 2:
                    buscarLibro(scanner, biblioteca, utilidades);
                    break;
                case 3:
                    buscarPorTitulo(scanner, biblioteca, utilidades);
                    break;
                case 4:
                    editarLibro(scanner, biblioteca, utilidades);
                    break;
                case 5:
                    eliminarLibro(scanner, biblioteca, utilidades);
                    break;
                case 6:
                    agregarLibro(scanner, biblioteca, utilidades);
                case 7:
                    System.out.println("Hasta luego");
                    break;
                case 8:
                    organizarPorTitulo(biblioteca);
                    break;
                case 9:
                    organizarPorAutor(biblioteca);
                    break;
                case 10:
                    organizarPorAño(biblioteca);
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
        while(opcion !=11);


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

    public static void organizarPorTitulo(Biblioteca biblioteca){
        System.out.println("=== Libros ordenados por titulo ===");
        biblioteca.ordenarPorTitulo();
        ArrayList<Libro> libromostrar = biblioteca.mostrarLibros();

        if(libromostrar.isEmpty()){
            System.out.println("No hay libros registrados");
        }else {
            for (Libro lib : libromostrar) {
                System.out.println(lib);
            }
        }
    }

    public static void organizarPorAutor(Biblioteca biblioteca){
        System.out.println("=== Libros ordenados por titulo ===");
        biblioteca.ordenarPorAutor();
        ArrayList<Libro> libromostrar = biblioteca.mostrarLibros();

        if(libromostrar.isEmpty()){
            System.out.println("No hay libros registrados");
        }else {
            for (Libro lib : libromostrar) {
                System.out.println(lib);
            }
        }
    }

    public static void organizarPorAño(Biblioteca biblioteca){
        System.out.println("=== Libros ordenados por titulo ===");
        biblioteca.ordenarPorAño();
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

    public static void buscarPorTitulo(Scanner scanner, Biblioteca biblioteca, Utilidades utilidades){
        System.out.println("=== Encontrar Libro por titulo ===");
        String busqueda = utilidades.leerTexto(scanner, "Ingrese titulo del libro");
        ArrayList<Libro> resultados = biblioteca.buscarPorTitulo(busqueda);

        if(resultados.isEmpty()) {
            System.out.println("No se encontro ningun libro");
        }else{
            for (Libro lib : resultados) {
                System.out.println(lib);
            }
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
        Libro libroEliminar = biblioteca.encontrarLibro(utilidades.leerEntero(scanner, "Ingrese id del libro"));

        if(libroEliminar == null){
            System.out.println("El libro no existe");
            return;
        }

        System.out.println(libroEliminar);

        String confirmacion = utilidades.leerTexto(scanner, "¿Esta seguro? (si/no)");

        if(confirmacion.equalsIgnoreCase("si")){
            biblioteca.eliminarLibro(libroEliminar);
            System.out.println("=== Libro Eliminado ===");
        }else{
            System.out.println("=== Libro No Eliminado ===");
        }
    }


}
