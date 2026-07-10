package com.biblioteca;
import com.biblioteca.Libro;


import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Libro> libros = new ArrayList<>();

    public ArrayList<Libro> mostrarLibros(){
        return libros;
    }

    public boolean agregarLibro(Libro libro){
        for(Libro lib: libros){
            if(lib.getId() == libro.getId() || lib.getTitulo().equals(libro.getTitulo())){
                return false;
            }
        }
        libros.add(libro);
        return true;
    }

    public Libro encontrarLibro(int idLibro){
        for(Libro lib: libros){
            if(lib.getId() == idLibro){
                return lib;
            }
        }
        return null;
    }

    public void eliminarLibro(int idLibro){
        libros.removeIf(lib -> lib.getId() == idLibro);

    }

    public boolean editarLibro(int id, String titulo, String autor, int año ){
        for(Libro lib: libros){
            if(lib.getId() == id){

                lib.setTitulo(titulo);
                lib.setAutor(autor);
                lib.setAño(año);

                return true;
            }
        }
        return false;
    }
}
