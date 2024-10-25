
 /* 
 * Código escrito por: Juan Pablo Bernacer
 * Idioma: Español
 */

package negocio;

public class Libro{
	private String titulo, autor, fecha_publi;
	private String disponible;
	private int numero_id;


//Constructores 

	public Libro(String titulo, String autor, String fecha_publi, int numero_id, String disponible){
		this.titulo = titulo;
		this.autor = autor;
		this.fecha_publi = fecha_publi;
		this.numero_id = numero_id;
		this.disponible = disponible;
	} 

//Getters

	public String getTitulo(){
	return titulo;
	}

	public String getAutor(){
        return autor;
	}

	public String getFecha_publi(){
        return fecha_publi;
	}
	// Nos aseguramos que el valor que devuelva sea de tipo String y no un Integer, para que no haya incompatibilidades
	public String getNumero_id(){
        return String.valueOf(numero_id);
	}
	// Método para obtener valor de disponible en valor booleano

    public String getDisponible(){
        return disponible;
    }


@Override
//Método para imprimir los datos de un libro
	public String toString(){
	return getTitulo() + "," + getAutor() + "," + getFecha_publi() + "," + getNumero_id() + "," + getDisponible();
	}
}
