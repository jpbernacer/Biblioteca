package negocio;

public class Libro{
	private String titulo, autor, fecha_publi;
	private int numero_id;
	private boolean disponible;


//Constructores 

	public Libro(String titulo, String autor, String fecha_publi, int numero_id, boolean disponible){
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

    public boolean getDisponible(){
        return disponible;
    }

	//Para que el valor de disponible sea un String y no un booleano
	public String getDisponibleString(){
		if (disponible){
			return "disponible";
		} else {
			return "no disponible";
		}
	}

@Override
	public String toString(){
	return getTitulo() + "," + getAutor() + "," + getFecha_publi() + "," + getNumero_id() + "," + getDisponibleString();
	}
}

