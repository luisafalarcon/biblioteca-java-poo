package com.biblioteca.Model;

public class Libro implements Comparable<Libro> {

    private int id;
    private String titulo;
    private String autor;
    private int año;

    public Libro(int id, String titulo, String autor, int año) {
        setId(id);
        setTitulo(titulo);
        setAutor(autor);
        setAño(año);
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
        if(id <= 0){
            throw new IllegalArgumentException("El id no puede ser negativo o 0");
        }
        this.id = id;
    }

    public void setTitulo(String titulo) {
        if(titulo == null || titulo.isBlank()){
            throw new IllegalArgumentException("El titulo es obligatorio");
        }
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        if(autor == null || autor.isBlank()){
            throw new IllegalArgumentException("El autor es obligatorio");
        }
        this.autor = autor;
    }

    public void setAño(int año) {
        if(año < 0){
            throw new IllegalArgumentException("El año no puede ser negativo");
        }
        this.año = año;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Título: " + titulo +
                ", Autor: " + autor +
                ", Año: " + año;
    }

    @Override
    public int compareTo(Libro libro) {
        return this.titulo.compareTo(libro.getTitulo());
    }

    public String convertirATexto(){
        return id + ";" + titulo + ";" + autor + ";" + año;
    }

    public static Libro desdeTexto(String linea){
        String[] partes = linea.split(";");

        if (partes.length != 4) {
            throw new IllegalArgumentException("Formato inválido...");
        }

        int id = Integer.parseInt(partes[0]);
        String titulo = partes[1];
        String autor = partes[2];
        int año = Integer.parseInt(partes[3]);

        return new Libro(id,titulo, autor,año);
    }
}
