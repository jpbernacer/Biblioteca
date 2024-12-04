/**
 * Clase Biblioteca que gestiona una colección de libros.
 * Proporciona métodos para cargar libros desde un archivo, añadir nuevos libros y volcar la lista de libros a un archivo.
 * 
 * Código creado por Juan Pablo Bernacer 
 * Escrito en Español
 * 4/12/2024
 */
package negocio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private ArrayList<Libro> listaLibros = new ArrayList<>();

    /**
     * Constructor de la clase Biblioteca.
     * Carga los libros desde el archivo "biblioteca.csv".
     */
    public Biblioteca() {
        cargarLibros();
    }

    /**
     * Carga los libros desde el archivo "biblioteca.csv".
     */
    private void cargarLibros() {
        Scanner sc = null;
        try {
            File fichero = new File("biblioteca.csv");
            fichero.createNewFile();
            sc = new Scanner(fichero);
            sc.useDelimiter(",|\n");

            while (sc.hasNext()) {
                listaLibros.add(new Libro(Integer.parseInt(sc.next()), sc.next(), sc.next(), sc.next(), sc.next()));
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
     * Añade un nuevo libro a la biblioteca y actualiza el archivo "biblioteca.csv".
     * 
     * @param libro El libro a añadir.
     */
    public void annadir(Libro libro) {
        if (!listaLibros.isEmpty()) libro.setId(listaLibros.get(listaLibros.size() - 1).getId() + 1);
        else libro.setId(1);
        listaLibros.add(libro);
        volcarLibros();
    }

    /**
     * Borra un libro de la biblioteca y actualiza el archivo "biblioteca.csv".
     * 
     * @param libro El libro a borrar.
     */
    public void borrar(Libro libro) {
        listaLibros.remove(libro);
        volcarLibros();
    }

    /**
     * Obtiene la lista de libros en la biblioteca.
     * 
     * @return Una lista de libros.
     */
    public ArrayList<Libro> getLibros() {
        return listaLibros;
    }

    /**
     * Vuelca la lista de libros al archivo "biblioteca.csv".
     */
    private void volcarLibros() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("biblioteca.csv");
            for (Libro libro : listaLibros) {
                fw.write(libro.toString() + "\n");
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
     * Devuelve una representación en cadena de la biblioteca.
     * 
     * @return Una cadena que representa la biblioteca.
     */
    @Override
    public String toString() {
        StringBuilder strLibros = new StringBuilder();
        for (Libro libro : listaLibros) strLibros.append(libro + "\n");
        return strLibros.toString();
    }
}
