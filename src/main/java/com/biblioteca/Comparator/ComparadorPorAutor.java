package com.biblioteca.Comparator;

import java.util.Comparator;
import com.biblioteca.Model.Libro;

public class ComparadorPorAutor implements Comparator<Libro> {
    @Override
    public int compare(Libro libro1, Libro libro2) {
        return libro1.getAutor().compareTo(libro2.getAutor());
    }
}
