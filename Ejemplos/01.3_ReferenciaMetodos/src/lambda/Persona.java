package lambda;

public record Persona(String nombre, String apellidos) {

	public String nombreCompleto() {
		return nombre + " " + apellidos;
	}
	
}
