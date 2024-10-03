package org.example;

import java.io.*;
import java.util.ArrayList;

/**
 * Clase Biblioteca: almacena una lista de objetos Libro en un ArrayList
 * @author Ana Va
 * @version 1.0
 */
public class Biblioteca {

    // Atributos
    private ArrayList <Libros> listaLibros;

    // Constructor
    public Biblioteca() {
        ArrayList lista = new ArrayList<Libros>();
        this.listaLibros = lista;
    }

    // Métodos

    /**
     * Agrega un libro a la lista de libros
     * @param libro Objeto libro
     */
    public void agregarLibro(Libros libro){
        listaLibros.add(libro);
    }

    /**
     * Muestra los datos de los libros en la lista de libros, invocando al método toString
     * de cada objeto libro. Utiliza un StringBuilder para ir añadiendo los datos de cada libro
     * @return un String con los datos de todos los libros en la Biblioteca
     */
    public String mostrarLibros(){
        StringBuilder datosLibro = new StringBuilder();
        for(Libros libro:listaLibros){
            datosLibro.append(libro.toString() + "\n");
        }
        return datosLibro.toString();
    }

    /**
     * Método que serializa la lista de libros en el archivo listaLibros.ser. Cuando acaba muestra un mensaje si se ha
     * realizado correctamente o un mensaje de error si no se ha podido completar.
     */
    public void serializarListaLibros(){
        try (FileOutputStream fileOutput = new FileOutputStream("listaLibros.ser");
             ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)) {
            for (Libros libro:listaLibros){
                objectOutput.writeObject(libro);
            }

        } catch (Exception e) {
            System.err.println("Error al almacenar la lista de libros: " + e.getMessage());
        }
        System.out.println("La lista de libros ha sido serializada en listaLibros.ser.");
    }

    /**
     * Método que deserializa el archivo listaLibros.ser. Cuando acaba, muestra los datos de los libros almacenados en
     * la biblioteca con el metodo mostrarLibros ()
     */
    public void deserializarLibro(){
        try (FileInputStream fileInput = new FileInputStream("listaLibros.ser");
             ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {

            Biblioteca biblioteca = new Biblioteca();

            while (true) {
                try {
                    // Leer y deserializar la siguiente mascota
                    Libros libro = (Libros) objectInput.readObject();
                    biblioteca.agregarLibro(libro);

                }catch (EOFException e) {
                    System.err.println("Alcanzado el final del archivo");
                    break; // Se alcanzó el final del archivo
                }
            }
            System.out.println("\n           ------  Información de los libros en la biblioteca:  ------");
            System.out.println(biblioteca.mostrarLibros());

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer el archivo listaLibros.ser: " + e.getMessage());
        }
    }
}
