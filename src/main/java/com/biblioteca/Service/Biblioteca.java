package com.biblioteca.Service;
import com.biblioteca.Comparator.ComparadorPorAño;
import com.biblioteca.Model.Libro;
import com.biblioteca.Comparator.ComparadorPorAutor;


import java.util.ArrayList;
import java.util.Collections;

public class Biblioteca {

    public Biblioteca(ArrayList<Libro> libros){
        this.libros=libros;
    }

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

    public ArrayList<Libro> buscarPorTitulo(String busqueda){
        ArrayList<Libro> encontrados = new ArrayList<>();
        for(Libro lib: libros){
            if(lib.getTitulo().toLowerCase().contains(busqueda.toLowerCase())){
                encontrados.add(lib);
            }

        }
        return encontrados;
    }

    public boolean eliminarLibro(Libro libro){
        return libros.remove(libro);
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

    public void ordenarPorTitulo() {
        Collections.sort(libros);
    }

    public void ordenarPorAutor() {
        Collections.sort(libros, new ComparadorPorAutor());
    }

    public void ordenarPorAño() {
        Collections.sort(libros, new ComparadorPorAño());
    }
}
