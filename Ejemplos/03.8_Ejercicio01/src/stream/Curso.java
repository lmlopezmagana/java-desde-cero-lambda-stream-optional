package stream;

import java.util.Objects;

public class Curso {
	
	private String nombre;
    private int duracionHoras;
    private String nombreProfesor;

    public Curso(String nombre, int duracionHoras, String nombreProfesor) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
        this.nombreProfesor = nombreProfesor;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracionHoras() {
		return duracionHoras;
	}

	public void setDuracionHoras(int duracionHoras) {
		this.duracionHoras = duracionHoras;
	}

	public String getNombreProfesor() {
		return nombreProfesor;
	}

	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(duracionHoras, nombre, nombreProfesor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return duracionHoras == other.duracionHoras && Objects.equals(nombre, other.nombre)
				&& Objects.equals(nombreProfesor, other.nombreProfesor);
	}

	@Override
	public String toString() {
		return "Curso [nombre=" + nombre + ", duracionHoras=" + duracionHoras + ", nombreProfesor=" + nombreProfesor
				+ "]";
	}


}
