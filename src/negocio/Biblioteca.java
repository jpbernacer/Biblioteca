package negocio;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Biblioteca{
    private ArrayList <Libro> listaLibros = new ArrayList<>();

    public Biblioteca(){
        cargarLibros();
    }
    private void cargarLibros(){
        // Se inicia el Scanner y se verifica que sea null como valor inicial
        Scanner sc = null;

        try {
            // Se inicializa File y se le adjudica el nombre fichero.
            File fichero = new File ("biblioteca.csv");
            // Se crea primero el fichero.
            fichero.createNewFile();
            //Se inicializa el escaner para el fichero.
            sc = new Scanner(fichero);
            /* Se pone un limitador para delimitar donde empieza cada dato es decir, cada dato del libro
            En este caso buscará el patrón de una coma (,) o (|) un salto de línea (\n) */
            sc.useDelimiter(",|\n");

            /* Se inicia el bucle while para cada vez que se tenga un nuevo dato por cargar 
            se añada cada dato a cada libro */

            while (sc.hasNext()){
                /* Según se van cargando cada dato ordenando, 
                se sabe que llevará un patrón específico correspondiendo con el 
                título, autor, fecha, id, disponible */
                listaLibros.add(new Libro(sc.next(), sc.next(), sc.next(), sc.next(), sc.next()));
            }

        }catch(IOException ex){
            //Impresión de error en caso de que no se pueda cargar el fichero
			System.out.println("Error en la lectura del fichero de libros.");
			System.out.println("A continuación se muestra más información:");
			System.out.println(ex);
		}finally{
            // Si el Scanner no es null, se cierra
			if (sc != null) sc.close();
		}

	}

    public void annadir(Libro libro){
       // Método para añadir un libro a la lista de libros y volcarlos existentes al programa
        listaLibros.add(libro);
        volcarLibros();
    }

    private void volcarLibros(){
        // Inicialización de FileWriter
        FileWriter fw = null;
        try{
            // Se inicializa el FileWriter para el fichero biblioteca.csv
            fw = new FileWriter("biblioteca.csv");
            // Por cada libro en la lista de libros se añade un nuevo libro
            for(Libro libro : listaLibros){
                fw.write(libro.getTitulo() + "," + libro.getAutor() + "," + libro.getFecha_publi() + "," + libro.getNumero_id() + "," + libro.getDisponible() + "\n");
            }
        }catch(IOException ex){
            //Impresión de error en caso de que no se pueda añadir un nuevo libro
            System.out.println("No se ha podido añadir el nuevo libro. Error en la escritura del fichero");
            System.out.println("A continuación se muestra más información:");
            System.out.println(ex);
        }finally{
            try{
                // Si el FileWriter no es null, se cierra
                if (fw != null) fw.close();
            }catch(IOException ex){
                //Impresión de error en caso de que no se pueda cerrar el FileWriter
                System.out.println(ex);
            }
        }
    }

    @Override
    public String toString(){
        // Método para imprimir los datos de los libros
        // Se inicializa un StringBuilder para concatenar los datos de los libros
        StringBuilder strLibros = new StringBuilder();
        // Por cada libro en la lista de libros se añade un nuevo libro
        for(Libro libro : listaLibros) strLibros.append(libro + "\n");
        return strLibros.toString();
    }
}
