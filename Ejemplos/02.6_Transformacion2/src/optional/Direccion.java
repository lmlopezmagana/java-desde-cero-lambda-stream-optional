package optional;

import java.util.Optional;

public record Direccion(String calle, String numero, String codigoPostal, Poblacion poblacion) {
	
	public Optional<Poblacion> getPoblacion() {
		return Optional.ofNullable(poblacion);
	}

}
