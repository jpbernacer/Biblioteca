package negocio;

public class Libro {
	private String titulo, autor, fecha_publi, numero_id, disponible;

	// Constructores
	public Libro(String titulo, String autor, String fecha_publi, String numero_id, String disponible) {
		this.titulo = titulo;
		this.autor = autor;
		this.fecha_publi = fecha_publi;
		this.numero_id = numero_id;
		this.disponible = disponible;
	}

	// Getters
	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getFecha_publi() {
		return fecha_publi;
	}

	public String getNumero_id() {
		return numero_id;
	}

	public String getDisponible() {
		return disponible;
	}

	@Override
	// Método para imprimir los datos de un libro
	public String toString() {
		return getTitulo() + "," + getAutor() + "," + getFecha_publi() + "," + getNumero_id() + "," + getDisponible();
	}
}
