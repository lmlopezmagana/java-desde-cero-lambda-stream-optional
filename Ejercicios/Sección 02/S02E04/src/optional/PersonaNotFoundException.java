package optional;

public class PersonaNotFoundException extends RuntimeException {

	public PersonaNotFoundException() {
		super("No se ha encontrado la persona buscada");
		
	}

	public PersonaNotFoundException(String message) {
		super(message);
	}
	
	

}
