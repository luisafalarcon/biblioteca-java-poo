package com.biblioteca.Persistence;

import com.biblioteca.Model.Libro;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PersistenciaLibros {

    private final File archivo;

    public PersistenciaLibros(String rutaArchivo) throws IOException {
        this.archivo = new File(rutaArchivo);
        archivo.createNewFile();
    }

    public void guardar(ArrayList<Libro> libros)throws IOException  {

        try(FileWriter escritor = new FileWriter(archivo)) {

            for (Libro lib : libros) {
                escritor.write(lib.convertirATexto());
                escritor.write("\n");
            }
        }


    }

    public ArrayList<Libro> leer() {
        return null;
    }

}
