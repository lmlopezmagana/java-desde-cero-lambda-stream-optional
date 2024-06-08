package optional;

import java.util.Optional;

public class App {

	public static void main(String[] args) {
		
		Persona p = new Persona("Pepe", "Pérez Pérez", 25);
		
		Optional<Persona> opt = Optional.of(p);
		
		opt
			.map(v -> "%s %s".formatted(v.nombre(), v.apellidos()))
			.ifPresent(System.out::println);
		
		opt
			.filter(v -> v.edad() >= 67)
			.map(v -> "%s %s".formatted(v.nombre(), v.apellidos()))
			.ifPresentOrElse(
					System.out::println,
					() -> System.out.println("No cumple la condición especificada"));
		

	}

}
