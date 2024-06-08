package optional;

import java.util.Optional;

public record Persona(String nombre, String apellidos, int edad, Direccion direccion) {
	
	public Optional<Direccion> getDireccion() {
		return Optional.ofNullable(direccion);
	}

}
