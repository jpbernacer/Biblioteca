/**
 * Código adaptado por Juan Pablo Bernacer del código original de Mariano
 * Escrito en Español
 * 4/12/2024
 */

package presentacion;

import negocio.Biblioteca;
import negocio.Libro;


public class InterfazUsuario {
    private static String negrita = "\u001B[1m";
    private static String normal = "\033[0m";
    private static String rojo = "\u001B[31m";
    private static String blanco = "\u001B[37m";

    /**
     * Ejecuta el comando dado por el usuario.
     * 
     * @param instruccion Un array de Strings que representa el comando y sus argumentos.
     *                    Los comandos pueden ser:
     *                    - "ayuda": Muestra la ayuda de los comandos disponibles.
     *                    - "mostrar": Muestra todos los libros disponibles en la biblioteca.
     *                    - "borrar <id>": Borra el libro con el ID especificado.
     *                    - "añadir <titulo> <autor> <fecha_publi> <disponible>": Añade un nuevo libro con los detalles especificados.
     */
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
        else if (instruccion[0].equalsIgnoreCase("añadir") && instruccion.length == 5) {
            Libro libro = new Libro(instruccion[1], instruccion[2], instruccion[3], instruccion[4]);
            biblioteca.annadir(libro);
        } 
        else {
            System.out.println(rojo + "El formato utilizado en la entrada es incorrecto" + blanco);
            ayuda();
        }
    }

    /**
     * Muestra la ayuda de los comandos disponibles.
     */
    private static void ayuda() {
        System.out.println("\n" + negrita + "DESCRIPCIÓN" + normal);
        System.out.println(
            "\tLos libros se encuentran estructurados de la siguiente forma:\n" +
            "\t- Número de identificador, Titulo, Autor, Fecha de publicación, Disponibilidad\n" +
            "\tLa aplicación ofrece las siguientes funcionalidades\n" +
            "\t- añadir [titulo] [autor] [fecha publicación] [disponibilidad]: Añade un nuevo libro a la biblioteca\n" +
            "\t- mostrar: Muestra todos los libros en la biblioteca\n" +
            "\t- borrar [número de identificado]: Borra un libro utilizando el número de identificador *\n" +
            "\t- ayuda: Muestra esta ayuda\n" 
            );
    }

    /**
     * Muestra todos los libros disponibles en la biblioteca.
     * 
     * @param biblioteca La instancia de la biblioteca de la cual se mostrarán los libros.
     */
    private static void mostrarLibros(Biblioteca biblioteca) {
        System.out.println(biblioteca.toString());
    }
}
