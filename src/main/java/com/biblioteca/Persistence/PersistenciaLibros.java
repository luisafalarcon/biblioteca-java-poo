package com.biblioteca.Persistence;

import com.biblioteca.Model.Libro;

import java.io.*;
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

    public ArrayList<Libro> leer() throws IOException{
        ArrayList<Libro> libros = new ArrayList<>();

        try(BufferedReader lector = new BufferedReader(new FileReader(archivo))){

            String linea;
            while((linea = lector.readLine()) != null){

                libros.add(Libro.desdeTexto(linea));
            }
        }
        return libros;
    }

}
