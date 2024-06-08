package optional;

import java.util.List;
import java.util.Optional;

public class App {

	public static void main(String[] args) {
		
		PersonaRepository repo = new PersonaRepository();
		
		List<Persona> lista = List.of(
				new Persona(1l, "Pepe", "Pérez Pérez", 25),
				new Persona(2l, "María", "García García", 23),
				new Persona(3l, "Luis", "López López", 18),
				new Persona(4l, "Marta", "Muñoz Muñoz", 34)
				);
		
		
		lista.forEach(repo::add);
		
		
		//repo.findById(1l)
		try {
			Persona p = repo.getById(5l);
			System.out.println(p);
		} catch(PersonaNotFoundException ex) {
			System.err.println(ex.getMessage());
		}
			
		Optional<Persona> optPersona = repo.findById(1l);
		
		if (optPersona.isPresent()) {
			Persona persona = optPersona.get();
			persona.setNombre("José");
			printPersona(repo.edit(persona));	
		}
		

	}
	
	public static void printPersona(Optional<Persona> p ) {
		p.ifPresentOrElse(
				System.out::println,
				() -> System.out.println("No existe una persona con este id")
				);
	}
	
}
