/* Código creado por Juan Pablo Bernacer 
 * Escrito en Español
 * 30/10/2024
*/

package negocio;

/**
 * La clase Libro representa un libro en la biblioteca.
 * Contiene información sobre el título, autor, fecha de publicación, número de identificación y disponibilidad del libro.
 */
public class Libro {
    private String titulo;
    private String autor;
    private String fecha_publi;
    private String numero_id;
    private String disponible;

    /**
     * Constructor de la clase Libro.
     * 
     * @param titulo      El título del libro.
     * @param autor       El autor del libro.
     * @param fecha_publi La fecha de publicación del libro.
     * @param numero_id   El número de identificación del libro.
     * @param disponible  La disponibilidad del libro.
     */
    public Libro(String titulo, String autor, String fecha_publi, String numero_id, String disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.fecha_publi = fecha_publi;
        this.numero_id = numero_id;
        this.disponible = disponible;
    }

    /**
     * Obtiene el título del libro.
     * 
     * @return El título del libro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene el autor del libro.
     * 
     * @return El autor del libro.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Obtiene la fecha de publicación del libro.
     * 
     * @return La fecha de publicación del libro.
     */
    public String getFecha_publi() {
        return fecha_publi;
    }

    /**
     * Obtiene el número de identificación del libro.
     * 
     * @return El número de identificación del libro.
     */
    public String getNumero_id() {
        return numero_id;
    }

    /**
     * Obtiene la disponibilidad del libro.
     * 
     * @return La disponibilidad del libro.
     */
    public String getDisponible() {
        return disponible;
    }

    /**
     * Devuelve una representación en cadena de los datos del libro.
     * 
     * @return Una cadena con los datos del libro.
     */
    @Override
    public String toString() {
        return getTitulo() + "," + getAutor() + "," + getFecha_publi() + "," + getNumero_id() + "," + getDisponible();
    }
}
