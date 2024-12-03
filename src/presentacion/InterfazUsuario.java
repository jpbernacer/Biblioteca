/**
 * Código adaptado por Juan Pablo Bernacer del código original de Mariano
 * Escrito en Español
 * 30/10/2024
 */

package presentacion;

import negocio.Biblioteca;
import negocio.Libro;


public class InterfazUsuario {
    private static String negrita = "\u001B[1m";
    private static String normal = "\033[0m";
    private static String rojo = "\u001B[31m";
    private static String blanco = "\u001B[37m";

    public static void ejecutar(String[] instruccion) {
        Biblioteca biblioteca = new Biblioteca();

        if (instruccion.length == 0 || instruccion[0].equalsIgnoreCase("ayuda") && instruccion.length == 1) {
            ayuda();
        } else if (instruccion[0].equalsIgnoreCase("mostrar") && instruccion.length == 1) {
            mostrarLibros(biblioteca);
        } 
        else if (instruccion[0].equalsIgnoreCase("borrar") && instruccion.length == 2) {
            Libro libro = new Libro(Integer.parseInt(instruccion[1]));
            biblioteca.borrar(libro); 
        } 
        
        else if (instruccion[0].equalsIgnoreCase("añadir") && instruccion.length == 6) {
            Libro libro = new Libro(Integer.parseInt(instruccion[1]), instruccion[2], instruccion[3], instruccion[4], instruccion[5]);
            biblioteca.annadir(libro);
        } 
        
        else {
            System.out.println(rojo + "El formato utilizado en la entrada es incorrecto" + blanco);
            ayuda();
        }
    }

    private static void mostrarLibros(Biblioteca biblioteca) {
        System.out.println(biblioteca.toString());
    }

    private static void ayuda() {
        System.out.println("\n" + negrita + "DESCRIPCIÓN" + normal);
        System.out.println("\tEsta aplicación ofrece las siguientes funcionalidades:\n\n" +
            "\t- añadir [numero de identificador] [titulo] [autor] [fecha publicación] [disponibilidad]: Añade un nuevo libro a la biblioteca\n" +
            "\t- mostrar: Muestra todos los libros en la biblioteca\n" +
            "\t- ayuda: Muestra esta ayuda\n");
    }
}
