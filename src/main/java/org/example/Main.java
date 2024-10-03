package org.example;

import java.util.ArrayList;

/**
 * Gestiona una biblioteca almecenando libros, serializando y deserializando
 * @author Ana VA
 * @version 1.0.
 */
public class Main {
    public static void main(String[] args) {

        // Crea objeto biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // Crea objetos libro para almacenar el biblioteca
        Libros libro1 = new Libros("A little life", "Hanya Yanagihara", "9781447294832", 15.90, 10);
        Libros libro2 = new Libros("Intermezzo", "Sally Rooney", "9788439744030", 21.75, 5);
        Libros libro3 = new Libros("La caida de Numenor", "JRR Tolkien", "9788445015056", 20.85, 5);

        // Agrega los libros a la biblioteca, se alamcenan en un ArrayList
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);

        // Mostrar por pantalla los libros antes de serializarlos, debe mostrar el descuento que tiene cada libro
        System.out.println("           ------  Libros en la biblioteca antes de serializar:  ------");
        System.out.println(biblioteca.mostrarLibros());

        // Serializa los libros en el archivo listaLibros.ser
        biblioteca.serializarListaLibros();

        // Deserializa los libros en nueva nueva Biblioteca y muestra el contenido de la biblioteca por pantalla.
        // El descuento que muestra debe ser 0 al ser transient
        biblioteca.deserializarLibro();

    }
}