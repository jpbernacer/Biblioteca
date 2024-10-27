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
        // Se verifica que Scanner sea null como valor inicial
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
            sc.useDelimiter(", | \n");

            /* Se inicia el bucle while para cada vez que se tenga un nuevo dato por cargar 
            se añada cada dato a cada libro */

            while (sc.hasNext()){
                /* Según se van cargando cada dato ordenando, 
                se sabe que llevará un patrón específico correspondiendo con el 
                título, autor, fecha, id, disponible */
                listaLibros.add(new Libro(sc.next(), sc.next(), sc.next(), sc.next(), sc.next()));
            }

        }catch(IOException ex){
			System.out.println("Error en la lectura del fichero de libros.");
			System.out.println("A continuación se muestra más información:");
			System.out.println(ex);
		}finally{
			if (sc != null) sc.close();
		}

	}

    public void annadir(Libro libro){
        listaLibros.add(libro);
        volcarLibros();
    }

    private void volcarLibros(){
        FileWriter fw = null;
        try{
            fw = new FileWriter("biblioteca.csv");
            for(Libro libro : listaLibros){
                fw.write(libro.getTitulo() + "," + libro.getAutor() + "," + libro.getFecha_publi() + "," + libro.getNumero_id() + "," + libro.getDisponible() + "\n");
            }
        }catch(IOException ex){
            System.out.println("No se ha podido añadir el nuevo libro. Error en la escritura del fichero");
            System.out.println("A continuación se muestra más información:");
            System.out.println(ex);
        }finally{
            try{
                if (fw != null) fw.close();
            }catch(IOException ex){
                System.out.println(ex);
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder strLibros = new StringBuilder();
        for(Libro libro : listaLibros) strLibros.append(libro + "\n");
        return strLibros.toString();
    }
}
