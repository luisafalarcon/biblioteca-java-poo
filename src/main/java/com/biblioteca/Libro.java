package com.biblioteca;

public class Libro {

    private int id;
    private String titulo;
    private String autor;
    private int año;

    public Libro(int id, String titulo, String autor, int año) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAño() {
        return año;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAño(int año) {
        this.año = año;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Título: " + titulo +
                ", Autor: " + autor +
                ", Año: " + año;
    }
}
