package optional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PersonaRepository {
	
	private List<Persona> lista;
	
	public PersonaRepository() {
		lista = new ArrayList<>();
	}
	
	public void add(Persona p) {
		lista.add(p);
	}
	
	public List<Persona> findAll() {
		return Collections.unmodifiableList(lista);
	}
	
	public Optional<Persona> findById(long id) {
		int pos = getIndexOf(id);
		return (pos >= 0) ? Optional.of(lista.get(pos)) : Optional.empty();
	}
	
	public Optional<Persona> edit(Persona p) {
		return findById(p.getId())
				.map(persona -> {
					persona.setNombre(p.getNombre());
					persona.setApellidos(p.getApellidos());
					persona.setEdad(p.getEdad());				
					return persona;
				});
		
		
	}
		
	private int getIndexOf(long id) {
		boolean encontrado = false;
		int pos = -1;
		for(int i = 0; i < lista.size() && !encontrado; i++) {
			if (lista.get(i).getId() == id) {
				encontrado = true;
				pos = i;
			}
		}
		
		return pos;
		
	}
	

}
