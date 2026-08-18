package com.biblioteca.UI;

import com.biblioteca.Controller.Controlador;
import com.biblioteca.Model.Libro;
import com.biblioteca.Persistence.PersistenciaLibros;
import com.biblioteca.Service.Biblioteca;
import com.biblioteca.Utils.Utilidades;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Utilidades utilidades = new Utilidades();
        Menu menu = new Menu();
        Biblioteca biblioteca;


        try {
            PersistenciaLibros persistencia = new PersistenciaLibros("Libros.txt");
            ArrayList<Libro> libros = persistencia.leer();
            biblioteca = new Biblioteca(libros);
            Controlador controlador = new Controlador(biblioteca, persistencia);

            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {

                opcion = menu.mostrarMenu(scanner);
                switch (opcion) {
                    case 1:
                        mostrarLibros(controlador);
                        break;
                    case 2:
                        buscarLibro(scanner, controlador, utilidades);
                        break;
                    case 3:
                        buscarPorTitulo(scanner, controlador, utilidades);
                        break;
                    case 4:
                        organizarPorTitulo(controlador);
                        break;
                    case 5:
                        organizarPorAutor(controlador);
                        break;
                    case 6:
                        organizarPorAño(controlador);
                        break;
                    case 7:
                        agregarLibro(scanner, utilidades, controlador);
                        break;
                    case 8:
                        editarLibro(scanner, utilidades, controlador);
                        break;
                    case 9:
                        eliminarLibro(scanner, controlador, utilidades);
                        break;
                    case 10:
                        System.out.println("Hasta Luego");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
            }
            while (opcion != 10);
        } catch (IOException e) {
            System.out.println("No se pudo acceder al archivo.");
        }
    }


    public static void agregarLibro(Scanner scanner, Utilidades utilidades, Controlador controlador) {
        System.out.println("========== AGREGAR LIBRO ==========");
        System.out.println("Ingrese los siguientes datos:");
        int id= utilidades.leerEntero(scanner, "Ingrese el ID del libro:");
        String titulo = utilidades.leerTexto(scanner, "Ingrese el titulo del libro:");
        String autor = utilidades.leerTexto(scanner, "Ingrese el Autor del libro:");
        int año = utilidades.leerEntero(scanner, "Ingrese el Año de publicacion:");

        try{
            boolean agregado = controlador.agregarLibro(id, titulo, autor,año);
             if(agregado){
                 System.out.println("✔ Libro agregado correctamente");
             }else{
                 System.out.println("El libro ya existe");
             }

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            System.out.println("❌ No se pudo guardar el libro.");
        }
    }

    public static void editarLibro(Scanner scanner, Utilidades utilidades, Controlador controlador) {
        System.out.println("========== EDITAR LIBRO ==========");
        System.out.println("Ingrese los siguientes datos:");
        int idEdit= utilidades.leerEntero(scanner, "Ingrese el ID del libro:");
        String tituloEdit = utilidades.leerTexto(scanner, "Ingrese el titulo del libro:");
        String autorEdit = utilidades.leerTexto(scanner, "Ingrese el autor del libro:");
        int añoEdit = utilidades.leerEntero(scanner, "Ingrese el año de publicacion:");

        try{
            boolean editado = controlador.editarLibro(idEdit, tituloEdit, autorEdit, añoEdit);

            if(editado){
                System.out.println("✔ Libro editado correctamente");
            }else{
                System.out.println("El libro No existe");
            }

        } catch (IOException e) {
            System.out.println("❌ No se pudo editar el libro.");
        }
    }

    public static void eliminarLibro(Scanner scanner, Controlador controlador, Utilidades utilidades) {
        System.out.println("========== ELIMINAR LIBRO ==========");

        int id = utilidades.leerEntero(scanner, "Ingrese id del libro");

        Libro libroEliminar = controlador.encontrarLibro(id);

        if(libroEliminar == null){
            System.out.println("El libro no existe");
            return;
        }

        System.out.println(libroEliminar);

        String confirmacion = utilidades.leerTexto(scanner, "¿Esta seguro? (si/no)");

       try{
           if(confirmacion.equalsIgnoreCase("si")){
               controlador.eliminarLibro(id);
               boolean eliminado = controlador.eliminarLibro(id);

               if (eliminado) {
                   System.out.println("=== ✔ Libro Eliminado ===");
               } else {
                   System.out.println("El libro no pudo ser eliminado.");
               }
           }else{
               System.out.println("=== Libro NO Eliminado ===");
           }
       }catch (IOException e){
           System.out.println("❌ No se pudo eliminar el libro.");
       }
    }
    

    public static void mostrarLibros(Controlador controlador){
        System.out.println("========== MOSTRAR LIBROS ==========");
        ArrayList<Libro> libromostrar = controlador.mostrarLibros();

        if(libromostrar.isEmpty()){
            System.out.println("No hay libros registrados");
        }else {
            for (Libro lib : libromostrar) {
                System.out.println(lib);
            }
        }
    }

    public static void organizarPorTitulo(Controlador controlador){
        System.out.println("========== LIBROS ORDENADOS POR TITULO ==========");
        controlador.organizarPorTitulo();
        ArrayList<Libro> libromostrar = controlador.mostrarLibros();

        if(libromostrar.isEmpty()){
            System.out.println("No hay libros registrados");
        }else {
            for (Libro lib : libromostrar) {
                System.out.println(lib);
            }
        }
    }

    public static void organizarPorAutor(Controlador controlador){
        System.out.println("========== LIBROS ORDENADOS POR AUTOR ==========");
        controlador.organizarPorAutor();
        ArrayList<Libro> libromostrar = controlador.mostrarLibros();

        if(libromostrar.isEmpty()){
            System.out.println("No hay libros registrados");
        }else {
            for (Libro lib : libromostrar) {
                System.out.println(lib);
            }
        }
    }

    public static void organizarPorAño(Controlador controlador){
        System.out.println("========== LIBROS ORDENADOS POR AÑO ==========");
        controlador.organizarPorAño();
        ArrayList<Libro> libromostrar = controlador.mostrarLibros();

        if(libromostrar.isEmpty()){
            System.out.println("No hay libros registrados");
        }else {
            for (Libro lib : libromostrar) {
                System.out.println(lib);
            }
        }
    }

    public static void buscarLibro(Scanner scanner, Controlador controlador ,Utilidades utilidades){
        System.out.println("========== BUSCAR LIBRO POR ID ==========");
        int idBuscar= utilidades.leerEntero(scanner, "Ingrese id del libro");
        Libro buscarLibro = controlador.encontrarLibro(idBuscar);
        if(buscarLibro != null) {
            System.out.println(buscarLibro);
        }else{
            System.out.println("No se encontró ningún libro con ese ID.");
        }
    }

    public static void buscarPorTitulo(Scanner scanner, Controlador controlador, Utilidades utilidades){
        System.out.println("========== BUSCAR LIBROS POR TITULO ==========");
        String busqueda = utilidades.leerTexto(scanner, "Ingrese titulo del libro");
        ArrayList<Libro> resultados = controlador.buscarPorTitulo(busqueda);

        if(resultados.isEmpty()) {
            System.out.println("No se encontro ningun libro con ese Titulo");
        }else{
            for (Libro lib : resultados) {
                System.out.println(lib);
            }
        }
    }






}
