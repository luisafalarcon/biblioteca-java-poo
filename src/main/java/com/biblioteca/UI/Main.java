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
                    organizarPorTitulo(biblioteca);
                    break;
                case 5:
                    organizarPorAutor(biblioteca);
                    break;
                case 6:
                    organizarPorAño(biblioteca);
                    break;
                case 7:
                    agregarLibro(scanner, biblioteca, utilidades);
                    break;
                case 8:
                    editarLibro(scanner, biblioteca, utilidades);
                    break;
                case 9:
                    eliminarLibro(scanner, biblioteca, utilidades);
                    break;
                case 10:
                    System.out.println("Hasta Luego");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
        while(opcion !=10);
    }

    public static void agregarLibro(Scanner scanner, Biblioteca biblioteca, Utilidades utilidades){
        System.out.println("========== AGREGAR LIBRO ==========");
        System.out.println("Ingrese los siguientes datos:");
        int id= utilidades.leerEntero(scanner, "Ingrese el ID del libro:");
        String titulo = utilidades.leerTexto(scanner, "Ingrese el titulo del libro:");
        String autor = utilidades.leerTexto(scanner, "Ingrese el Autor del libro:");
        int año = utilidades.leerEntero(scanner, "Ingrese el Año de publicacion:");

        try{
            Libro libro = new Libro(id, titulo, autor, año);

            boolean agregado = biblioteca.agregarLibro(libro);

            if(agregado){
                System.out.println("✔ Libro agregado correctamente");
            }else{
                System.out.println("El libro ya existe");
            }
            System.out.println(biblioteca.mostrarLibros().size());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    

    public static void mostrarLibros(Biblioteca biblioteca){
        System.out.println("========== MOSTRAR LIBROS ==========");
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
        System.out.println("========== LIBROS ORDENADOS POR TITULO ==========");
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
        System.out.println("========== LIBROS ORDENADOS POR AUTOR ==========");
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
        System.out.println("========== LIBROS ORDENADOS POR AÑO ==========");
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
        System.out.println("========== BUSCAR LIBRO POR ID ==========");
        int idBuscar= utilidades.leerEntero(scanner, "Ingrese id del libro");
        Libro buscarLibro = biblioteca.encontrarLibro(idBuscar);
        if(buscarLibro != null) {
            System.out.println(buscarLibro);
        }else{
            System.out.println("No se encontró ningún libro con ese ID.");
        }
    }

    public static void buscarPorTitulo(Scanner scanner, Biblioteca biblioteca, Utilidades utilidades){
        System.out.println("========== BUSCAR LIBROS POR TITULO ==========");
        String busqueda = utilidades.leerTexto(scanner, "Ingrese titulo del libro");
        ArrayList<Libro> resultados = biblioteca.buscarPorTitulo(busqueda);

        if(resultados.isEmpty()) {
            System.out.println("No se encontro ningun libro con ese Titulo");
        }else{
            for (Libro lib : resultados) {
                System.out.println(lib);
            }
        }
    }

    public static void editarLibro(Scanner scanner, Biblioteca biblioteca, Utilidades utilidades){
        System.out.println("========== EDITAR LIBRO ==========");
        System.out.println("Ingrese los siguientes datos:");
        int idEdit= utilidades.leerEntero(scanner, "Ingrese el ID del libro:");
        String tituloEdit = utilidades.leerTexto(scanner, "Ingrese el titulo del libro:");
        String autorEdit = utilidades.leerTexto(scanner, "Ingrese el autor del libro:");
        int añoEdit = utilidades.leerEntero(scanner, "Ingrese el año de publicacion:");

        boolean editado = biblioteca.editarLibro(idEdit, tituloEdit, autorEdit,añoEdit);

        if(editado){
            System.out.println("✔ Libro editado correctamente");
        }else{
            System.out.println("El libro no existe");
        }
    }

    public static void eliminarLibro(Scanner scanner, Biblioteca biblioteca, Utilidades utilidades){
        System.out.println("========== ELIMINAR LIBRO ==========");
        Libro libroEliminar = biblioteca.encontrarLibro(utilidades.leerEntero(scanner, "Ingrese id del libro"));

        if(libroEliminar == null){
            System.out.println("El libro no existe");
            return;
        }

        System.out.println(libroEliminar);

        String confirmacion = utilidades.leerTexto(scanner, "¿Esta seguro? (si/no)");

        if(confirmacion.equalsIgnoreCase("si")){
            biblioteca.eliminarLibro(libroEliminar);
            System.out.println("=== ✔ Libro Eliminado ===");
        }else{
            System.out.println("=== Libro NO Eliminado ===");
        }
    }



}
