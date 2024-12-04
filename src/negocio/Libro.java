/* Código creado por Juan Pablo Bernacer 
 * Escrito en Español
 * 4/12/2024
*/

package negocio;

/**
 * La clase Libro representa un libro en la biblioteca.
 * Contiene información sobre el ID, título, autor, fecha de publicación y disponibilidad del libro.
 */
public class Libro {
    private Integer id;
    private String titulo;
    private String autor;
    private String fecha_publi;
    private String disponible;

    /**
     * Constructor para crear un libro con todos los atributos, incluyendo el ID.
     * 
     * @param id El ID del libro.
     * @param titulo El título del libro.
     * @param autor El autor del libro.
     * @param fecha_publi La fecha de publicación del libro.
     * @param disponible La disponibilidad del libro.
     */
    public Libro(Integer id, String titulo, String autor, String fecha_publi, String disponible) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.fecha_publi = fecha_publi;
        this.disponible = disponible;
    }

    /**
     * Constructor para crear un libro sin especificar el ID.
     * 
     * @param titulo El título del libro.
     * @param autor El autor del libro.
     * @param fecha_publi La fecha de publicación del libro.
     * @param disponible La disponibilidad del libro.
     */
    public Libro(String titulo, String autor, String fecha_publi, String disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.fecha_publi = fecha_publi;
        this.disponible = disponible;
    }

    /**
     * Constructor para crear un libro especificando solo el ID.
     * 
     * @param id El ID del libro.
     */
    public Libro(Integer id){ 
        this.id = id;
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
     * Obtiene el ID del libro.
     * 
     * @return El ID del libro.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del libro.
     * 
     * @param id El nuevo ID del libro.
     */
    public void setId(int id) {
        this.id = id;
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
     * Devuelve una representación en cadena del libro.
     * 
     * @return Una cadena que representa el libro.
     */
    @Override
    public String toString() {
        return String.valueOf(getId()) + "," + getTitulo() + "," + getAutor() + "," + getFecha_publi() + "," + getDisponible();
    }

    /**
     * Compara este libro con otro objeto para determinar si son iguales.
     * 
     * @param obj El objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        Libro libro = (Libro) obj;
        return id == libro.id;
    }
}
