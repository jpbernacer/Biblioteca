/* Código creado por Juan Pablo Bernacer 
 * Escrito en Español
 * 30/10/2024
*/

package negocio;

public class Libro {
    private Integer id;
    private String titulo;
    private String autor;
    private String fecha_publi;
    private String disponible;


    public Libro(Integer id, String titulo, String autor, String fecha_publi, String disponible) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.fecha_publi = fecha_publi;
        this.disponible = disponible;
    }

    public Libro(Integer id){ 
        this.id = id;
    }

    public Libro(String titulo, String autor, String fecha_publi, String disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.fecha_publi = fecha_publi;
        this.disponible = disponible;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getFecha_publi() {
        return fecha_publi;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDisponible() {
        return disponible;
    }

    @Override
    public String toString() {
        return String.valueOf(getId()) + "," + getTitulo() + "," + getAutor() + "," + getFecha_publi() + "," + getDisponible();
    }

    @Override
    public boolean equals(Object obj) {
        Libro libro = (Libro) obj;
        return id == libro.id;
	}
}
