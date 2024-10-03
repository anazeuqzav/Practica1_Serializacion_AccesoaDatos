package org.example;

import java.io.Serializable;

public class Libros implements Serializable {
    // Atributos
    private String titulo;
    private String autor;
    private String isbn;
    private double precio;
    private transient double descuento;

    // Constructor
    public Libros(String titulo, String autor, String isbn, double precio, double descuento) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.precio = precio;
        this.descuento = descuento;
    }

    // Getter y setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    /**
     * Metodo toString
     * @return los atributos de cada libro en formato String
     */
    @Override
    public String toString() {
        return " ◦ Titulo: " + titulo + ", Autor: " + autor + ", ISBN: " + isbn + ", Precio: " + precio +
                ", Descuento: " + descuento;
    }
}
