/**
 * Clase Biblioteca que gestiona una colección de libros.
 * Proporciona métodos para cargar libros desde un archivo, añadir nuevos libros y volcar la lista de libros a un archivo.
 * 
 * Código creado por Juan Pablo Bernacer 
 * Escrito en Español
 * 30/10/2024
 */
package negocio;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Biblioteca {
    private ArrayList<Libro> listaLibros = new ArrayList<>();

    /**
     * Constructor de la clase Biblioteca.
     * Llama al método cargarLibros para inicializar la lista de libros desde un archivo.
     */
    public Biblioteca() {
        cargarLibros();
    }

    /**
     * Método privado para cargar los libros desde un archivo CSV.
     * Lee los datos del archivo y los añade a la lista de libros.
     */
    private void cargarLibros() {
        Scanner sc = null;

        try {
            File fichero = new File("biblioteca.csv");
            fichero.createNewFile();
            sc = new Scanner(fichero);
            sc.useDelimiter(",|\n");

            while (sc.hasNext()) {
                listaLibros.add(new Libro(sc.next(), sc.next(), sc.next(), sc.next(), sc.next()));
            }

        } catch (IOException ex) {
            System.out.println("Error en la lectura del fichero de libros.");
            System.out.println("A continuación se muestra más información:");
            System.out.println(ex);
        } finally {
            if (sc != null) sc.close();
        }
    }

    /**
     * Método para añadir un libro a la lista de libros y volcar los libros existentes al archivo.
     * 
     * @param libro El libro a añadir.
     */
    public void annadir(Libro libro) {
        listaLibros.add(libro);
        volcarLibros();
    }

    /**
     * Método privado para volcar la lista de libros a un archivo CSV.
     * Escribe los datos de cada libro en el archivo.
     */
    private void volcarLibros() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("biblioteca.csv");
            for (Libro libro : listaLibros) {
                fw.write(libro.getTitulo() + "," + libro.getAutor() + "," + libro.getFecha_publi() + "," + libro.getNumero_id() + "," + libro.getDisponible() + "\n");
            }
        } catch (IOException ex) {
            System.out.println("No se ha podido añadir el nuevo libro. Error en la escritura del fichero");
            System.out.println("A continuación se muestra más información:");
            System.out.println(ex);
        } finally {
            try {
                if (fw != null) fw.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    /**
     * Método para obtener una representación en cadena de la lista de libros.
     * 
     * @return Una cadena con los datos de todos los libros.
     */
    @Override
    public String toString() {
        StringBuilder strLibros = new StringBuilder();
        for (Libro libro : listaLibros) strLibros.append(libro + "\n");
        return strLibros.toString();
    }
}
