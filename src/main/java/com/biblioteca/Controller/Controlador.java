package com.biblioteca.Controller;

import com.biblioteca.Model.Libro;
import com.biblioteca.Persistence.PersistenciaLibros;
import com.biblioteca.Service.Biblioteca;

import java.io.IOException;

public class Controlador {

    private final Biblioteca biblioteca;
    private final PersistenciaLibros persistencia;

    public Controlador (Biblioteca biblioteca, PersistenciaLibros persistencia){
        this.biblioteca = biblioteca;
        this.persistencia = persistencia;
    }

    public boolean agregarLibro(int id, String titulo, String autor, int año) throws IOException {
        Libro libro = new Libro(id, titulo, autor, año);

        boolean agregado = biblioteca.agregarLibro(libro);

        if(!agregado){

            return false;
        }
        persistencia.guardar(biblioteca.mostrarLibros());
        return true;
    }

    public boolean editarLibro(int id, String titulo, String autor, int año) throws IOException {

        boolean editado = biblioteca.editarLibro(id, titulo, autor, año);

        if(!editado){
            return false;
        }

        persistencia.guardar(biblioteca.mostrarLibros());

        return true;
    }

    public boolean eliminarLibro(int id) throws IOException {

        Libro libroEliminar = biblioteca.encontrarLibro(id);


        boolean eliminado = biblioteca.eliminarLibro(libroEliminar);

        if(!eliminado){
            return false;
        }

        persistencia.guardar(biblioteca.mostrarLibros());

        return true;
    }

    public Libro encontrarLibro(int id){

        return biblioteca.encontrarLibro(id);
    }
}
