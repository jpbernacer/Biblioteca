/**
 * Clase Principal que inicia la aplicación de gestión de la biblioteca.
 * 
 * Código creado por Juan Pablo Bernacer 
 * Escrito en Español
 * 30/10/2024
 */

package aplicacion;

import presentacion.InterfazUsuario;

/**
 * La clase Principal contiene el método main que inicia la ejecución de la aplicación.
 */
public class Principal {
    /**
     * El método main es el punto de entrada de la aplicación.
     * Llama al método ejecutar de la clase InterfazUsuario para iniciar la interacción con el usuario.
     * 
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        InterfazUsuario.ejecutar(args);
    }
}
