package com.biblioteca.Comparator;

import java.util.Comparator;
import com.biblioteca.Model.Libro;

public class ComparadorPorAño implements Comparator<Libro> {

    @Override
    public int compare(Libro libro1, Libro libro2) {
        return Integer.compare(libro1.getAño(), libro2.getAño());
    }
}
