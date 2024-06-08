package optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ListadoContactos {
	
	private Map<String, String> contactos = new HashMap<>();
	
	
	public void printListado() {
		for(String s : contactos.keySet()) {
			System.out.println("%s: %s".formatted(s, contactos.get(s)));
		}
	}
	
	
	public void addContacto(String nombre, String numero) {
		contactos.put(nombre, numero);
	}
	
	public Optional<String> findNumeroByNombre(String nombre) {
		return Optional.ofNullable(contactos.get(nombre));
	}
	
	public Optional<String> findNombreByNumero(String numero) {
		String result = null;
		for (Map.Entry<String, String> entry : contactos.entrySet()) {
			if (entry.getValue().equals(numero)) {
				result = entry.getKey();
			}
		}
		return Optional.ofNullable(result);
	}
	

}
